package com.lee.blog.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.lee.blog.dao.mapper.CommentMapper;
import com.lee.blog.dao.pojo.Comment;
import com.lee.blog.dao.pojo.R;
import com.lee.blog.dao.pojo.SysUser;
import com.lee.blog.dao.pojo.vo.CommentParam;
import com.lee.blog.dao.pojo.vo.CommentVo;
import com.lee.blog.dao.pojo.vo.UserVo;
import com.lee.blog.service.CommentService;
import com.lee.blog.service.SysUserService;
import com.lee.blog.utils.UserThreadLocal;
import lombok.extern.slf4j.Slf4j;
import org.joda.time.DateTime;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lee Yian on 2023/4/17 19:44
 */
@Slf4j
@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    CommentMapper commentMapper;

    @Autowired
    SysUserService sysUserService;
    @Override
    public R findCommentsByArticleId(Long articleId) {
        /*
            查询评论列表
            我们需要返回：id, user, content, children, createDate, level, toUser
            1. 先查询评论，
            2. 获取再根据的 author id 查询用户，parentId 查询父评论
         */
        LambdaQueryWrapper<Comment> wrapper = new LambdaQueryWrapper<>();
        // 限定文章 id 条件 和 level
        wrapper.eq(Comment::getArticleId,articleId).eq(Comment::getLevel,1);
        wrapper.orderByDesc(Comment::getCreateDate);


        List<Comment> commentList= commentMapper.selectList(wrapper);

        List<CommentVo> commentVoList = copyList(commentList);

        return R.success(commentVoList);
    }

    @Override
    public R comment(CommentParam commentParam) {
        /*
            1. 评论功能主要需要，评论者 id，评论内容，被评论的文章
                评论者 id 可以从 ThreadLocal 中取，因为评论强制要求登录，而只要登录，用户信息就存在于 ThreadLocal 中
            2. 通过 commentParam 构建与数据库交互的 Comment 对象
                2.1 补全 level 属性
         */
        SysUser user = UserThreadLocal.get();
        Comment comment = new Comment();
        // 复制同名属性
        BeanUtils.copyProperties(commentParam,comment);

        // 手动补全属性
        comment.setAuthorId(user.getId());
        comment.setCreateDate(System.currentTimeMillis());
        // 如果不存在 parentId，说明是一级评论（对文章的评论）
        if(commentParam.getParentId() == null){
            // 一级评论的 level
            comment.setLevel(1);
            // 初始化一下两个为空的 id 为 -1，避免数据库跑异常
            comment.setParentId(-1L);
            comment.setToUid(-1L);
        } else {
            // 正常设置 level 和 toUserId
            comment.setLevel(2);
            comment.setToUid(commentParam.getToUserId());
        }

        log.info(comment.toString());
        log.info(commentParam.toString());

        // 持久化
        this.commentMapper.insert(comment);
        return R.success(null);
    }

    /**
     * 遍历所有的 commentList，转为 CommentVoList
     * @param commentList commentList
     * @return List<CommentVo>
     */
    private List<CommentVo> copyList(List<Comment> commentList) {
        List<CommentVo> commentVoList = new ArrayList<>();
        commentList.forEach( comment -> {
            commentVoList.add( copyOne(comment) );
        });
        return commentVoList;
    }

    /**
     * 将 Comment 转为 CommentVo
     * @param comment comment
     * @return CommentVo
     */
    private CommentVo copyOne(Comment comment) {
        CommentVo commentVo = new CommentVo();
        // 自动复制相同的属性
        BeanUtils.copyProperties(comment,commentVo);
        // 1. 将时间戳转为字符串时间，hh 代表 12 小时制，HH 代表 24 小时制，用错了会导致 13 小时的时差哦
        commentVo.setCreateDate(new DateTime(comment.getCreateDate() ).toString("yyyy-MM-dd HH:mm") );

        // 2. 查询用户信息
        UserVo userVo = sysUserService.findUserVoById(comment.getAuthorId());
        commentVo.setAuthor(userVo);

        // 3. 查询子评论
        Integer level = comment.getLevel();
        // 3.1 只有当级别为 1（不为子评论）的时候，才查询它的子评论。不然它会把自己调死
        if (1 == level){
            Long parentId = comment.getId();
            List<CommentVo> childrenComment = this.findCommentsByParentId(parentId);
            commentVo.setChildren(childrenComment);
        }
        // 4. 只有当 level > 1 （为子评论）时，才执行查询被评论的用户信息
        if (level > 1){
            // 4. 查询被评论的对象信息
            UserVo beenCommentedUserVo = this.sysUserService.findUserVoById(comment.getAuthorId());
            commentVo.setToUser(beenCommentedUserVo);
        }
        return commentVo;
    }

    /**
     * 通过 parent id 查询 commentVoList
     * @param parentId parentId
     * @return commentVoList
     */
    private List<CommentVo> findCommentsByParentId(Long parentId) {
        LambdaQueryWrapper<Comment> wrapper = new LambdaQueryWrapper<>();
        // 必须限定查询 level，不然每次拿到 level 为 1 的评论，然后又会重复调用直到 stackOverFlow
        wrapper.eq(Comment::getParentId, parentId).eq(Comment::getLevel, 2);

        List<Comment> commentList= commentMapper.selectList(wrapper);

        return this.copyList(commentList);
    }
}
