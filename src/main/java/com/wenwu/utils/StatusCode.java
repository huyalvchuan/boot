package com.wenwu.utils;

import org.springframework.stereotype.Component;

/**
 * Created by lvchuan on 17/6/27.
 * @ddescribe 状态码。
 */
@Component
public class StatusCode {
    public static final int SYS_UPDATE = 00000;
    public static final int SYS_NORMAL = 00001;

    public static final int USER_EXISTENCE = 10000;
    public static final int USER_NOTREGISTER = 10001;
    public static final int USER_ABNORMAL = 10002;
    public static final int USER_PASSWORD_ERROR = 10003;
    public static final int USER_LOGIN_SUCCESS =10004;
    public static final int USER_TOKEN_INVALID = 10005;

    public static final int COURSE_ADD_SUCCESS = 20000;
    public static final int COURSE_DELETE_SUCCESS = 20001;
    public static final int COURSE_CLOSE = 20002;

    public static final int ONLINE_NORMAL = 30000;
    public static final int ONLINE_FINISH = 30001;
    public static final int ONLINE_BAN_SEND = 30002;
}
