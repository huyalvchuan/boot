package com.wenwu.config;
import com.wenwu.utils.ResponseData;
import com.wenwu.utils.TokenManager;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.json.JSONObject;
import org.omg.CORBA.portable.InputStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.jws.Oneway;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;

;import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@Aspect
@Configuration
public class SysAop {
    @Autowired TokenManager tokenManager;
    @Autowired ResponseData responseData;
    Logger logger = LoggerFactory.getLogger(this.getClass());
    @Pointcut("execution(* com.wenwu.web.*Controller.*(..))")
    public void excudeService() {
    }
    @Around("excudeService()")
    public Object doAround(ProceedingJoinPoint pjp) throws Throwable {
        RequestAttributes ra = RequestContextHolder.getRequestAttributes();
        ServletRequestAttributes sra = (ServletRequestAttributes) ra;
        HttpServletRequest request = sra.getRequest();
        String url = request.getRequestURL().toString();
        String method = request.getMethod();
        String uri = request.getRequestURI();
        String queryString = request.getQueryString();
        logger.info(url+"method"+method+"queryString"+queryString);
        Object result = pjp.proceed();
        JSONObject json = myRequestWapper(request);
        if(json.get("token") != null) {
            if(tokenManager.checkToken(json.get("token").toString()) == null) {
                return responseData.setMsgcode(10005).setMsg("token失效").setData(null);
            } else {
                request.setAttribute("userID", tokenManager.checkToken(json.get("token").toString()));
            }
        }
        return null;
    }

    JSONObject myRequestWapper(HttpServletRequest request) throws IOException {
        ServletInputStream strem = request.getInputStream();
        if(strem ==null)
            return null;
        StringBuilder builder = new StringBuilder();
        BufferedReader reader = null;
        reader = new BufferedReader(new InputStreamReader(strem));
        char[] charBuffer = new char[128];
        int bytesRead = -1;
        while ((bytesRead=reader.read(charBuffer))>0) {
            builder.append(charBuffer, 0, bytesRead);
        }
        String result = builder.toString();
        if(result == null || result.equals(""))
            return null;
        else
            return new JSONObject(result);
    }


}

class TestModel {
    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    int age;
}