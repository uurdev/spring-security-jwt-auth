package com.example.jwtsecurity.utils;

public class JWTSecurityUtil {
    public static final String REGISTER_URL = "/register";
    public static final String SECRET = "CustomerTask";
    public static final String TOKEN_PREFIX = "Task ";
    public static final String HEADER = "Authorization";
    public final static long EXP_TIME = 5 * 60 * 60 * 1000;
}
