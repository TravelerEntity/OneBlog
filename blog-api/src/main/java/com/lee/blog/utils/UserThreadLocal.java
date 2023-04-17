package com.lee.blog.utils;

import com.lee.blog.dao.pojo.SysUser;

/**
 * Created by Lee Yian on 2023/4/16 11:21
 * ThreadLocal 内部维护了一个Map，以线程对象为key，以对应的值为value。
 * 比如 ThreadLocalMap<Thread, Object>
 * 线程自身作为 key，而我们需要在线程内全局共享的变量作为 Value
 */
public class UserThreadLocal {
    // 私有化构造方法
    private UserThreadLocal(){}

    private static final ThreadLocal<SysUser> LOCAL = new ThreadLocal<>();

    public static void put(SysUser sysUser){
        LOCAL.set(sysUser);
    }

    public static SysUser get() {
        return LOCAL.get();
    }



    /**
     * 使用完后，一定不要忘记清除我们保存的对象，否则会有内存泄露的风险
     * 因为，每个线程都会持有一个 ThreadLocalMap 对象，
     * 而 map 的 key 是弱引用，value 是强引用
     * 当线程结束时，会被 gc 清理（线程对象没来， key 也就没了）
     * 而当 key 被 gc 清理之后，value 就再也无法获取，被留在内存中了
     * 最后越积越多，内存泄露
     */
    public static void remove(){
        LOCAL.remove();
    }
}
