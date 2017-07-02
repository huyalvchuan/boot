package com.wenwu.utils;


import org.apache.log4j.Logger;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by lvchuan on 17/4/1.
 */
@Component(value = "WeChat")
public class WeChat {
    @Value("${wx.appid}")
    private String appid;
    @Value("${wx.secretkey}")
    private String secret;
    Logger logger=Logger.getLogger(this.getClass());
    public JSONObject getOpenid(String code) throws Exception {
        String url="https://api.weixin.qq.com/sns/oauth2/access_token?appid="+appid+"&secret="+secret+"&code="+code+"&grant_type=authorization_code";
        String jsontext=NetClient.net(url, null, null);
        System.out.println("获取的信息"+jsontext);
        JSONObject jsonObject=new JSONObject(jsontext);
        return jsonObject;
    }
    public JSONObject getInfo(String openid, String token) throws Exception {
        String url="https://api.weixin.qq.com/sns/userinfo?access_token="+token+"&openid="+openid+"&lang=zh_CN";
        String jsontext=NetClient.net(url, null, null);
        logger.info(jsontext);
        JSONObject jsonObject=new JSONObject(jsontext);
        return jsonObject;
    }
}
