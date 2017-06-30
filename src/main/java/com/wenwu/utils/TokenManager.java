package com.wenwu.utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by lvchuan on 17/6/27.
 */
@Component(value = "TokenManager")
public class TokenManager {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Value("${token.timeout}")
    private String timeout;
    public String produceToken(Long userID) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        long time = System.currentTimeMillis();
        String key = userID + Long.toString(time);
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        md5.update(key.getBytes("UTF-8"));
        BigInteger bi = new BigInteger(1, md5.digest());
        String token = bi.toString(16);
        stringRedisTemplate.opsForValue().set(token, String.valueOf(userID),  Integer.valueOf(timeout));
        logger.info("userID:"+userID+"login");
        return token;
    }
    public Long checkToken(String token) {
        long userID = Long.parseLong(stringRedisTemplate.opsForValue().get(token).trim());
        if (userID == 0) {
            return userID;
        }
        else {
            stringRedisTemplate.opsForValue().set(token, String.valueOf(userID), Integer.valueOf(timeout));
        }
        return userID;
    }
    public String deleteToken(String token) {
        stringRedisTemplate.delete(token);
        return null;
    }

}
