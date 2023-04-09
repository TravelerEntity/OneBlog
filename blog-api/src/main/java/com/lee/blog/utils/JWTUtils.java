package com.lee.blog.utils;

import io.jsonwebtoken.Jwt;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Lee Yian on 2023/4/5 19:27
 * JWT, JSON Web Token ,认证
 * 它有三部分, 格式类似 header.payload.signature
 * header,payload 使用 base64 编码, signature 则是加密后的签名
 * 第一部分是 header, 携带 JWT 原数据, 比如签名算法或者 token 类型
 * 第二部分是 payload, 携带实际使用的数据, JWT 官方定义了一些字段, 我们也可以进行自定义
 * 第三步分是签名, 由前两部分和加密算法混合上 key 生成, 只有签名才是加密的
 * 客户端可以解密前两部分,即 header.payload,
 * 但无法解密(或者说伪造) signature, 因为客户端不知道我们的 key
 */
public class JWTUtils {
    // 密钥
    private static final String jwtKey = "#jwtSignature@leeyian#";

    /**
     * 通过 userId 创建一个 token
     * @param userId 用户 id
     * @return token
     */
    public static String createToken(Long userId){
        // 2. payload
        Map<String,Object> claims = new HashMap<>();
        claims.put("userId",userId);

        // 生成 jwt token
        JwtBuilder jwtBuilder = Jwts.builder()
                .signWith(SignatureAlgorithm.HS256, jwtKey) // 1. 签发算法，秘钥为jwtToken
                .setClaims(claims) // payload 数据，要唯一，自行设置
                .setIssuedAt(new Date()) // 设置签发时间
                .setExpiration(new Date(System.currentTimeMillis() + 24 * 60 * 60 * 1000));// 一天的有效时间
        String token = jwtBuilder.compact();
        return token;
    }

    /**
     * 验证 token 是否合法 </br>
     * 在验证 JWT 时，接收方会先对 header 和 payload 部分进行 base64 解码,
     * 然后对解码后的数据(header,payload)再次通过指定算法和 key 进行签名，得到一个新的字符串。如果这个新的字符串与接收到的 JWT 中的 signature 部分完全一致
     * ，则说明该 JWT 的确是由发送方签发的，且未被篡改过。
     * @param token token
     * @return 携带的数据，解密失败返回 null
     */
    public static Map<String, Object> checkToken(String token){
        try {
            // 解析传入 token 中的信息并混合我们的 key ，然后再重新加密，两个 token 不一致，抛出异常
            Jwt parse = Jwts.parser().setSigningKey(jwtKey).parse(token);
            return (Map<String, Object>) parse.getBody();
        }catch (Exception e){
            e.printStackTrace();
        }
        // token 不正确，返回 null
        return null;
    }

    // public static void main(String[] args) {
    //     Map<String,Object> result = checkToken("eyJhbGciOiJIUzI1NiJ9.eyJleHAiOjE2ODExMTIwNDMsInVzZXJJZCI6MTAwLCJpYXQiOjE2ODEwMjU2NDN9.7ovk-Sv58Mbr5CxB_l31WzMqVYUWE6MzpOF6zRohMos");
    //
    //     result.keySet().forEach((key)->{
    //         System.out.println(key+":"+result.get(key));
    //     });
    // }
}
