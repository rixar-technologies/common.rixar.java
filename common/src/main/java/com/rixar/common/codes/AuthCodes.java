package com.rixar.common.codes;

public class AuthCodes {

    public static final int UNAUTHENTICATED = 9001;  // No credentials or Invalid credentials.
    public static final int EXCEPTION_ON_AUTHENTICATION= 9002;
    public static final int UNAUTHORIZED = 9003; // Valid credentials but not enough privileges to perform an action on a resource

    public static final int USER_DOES_NOT_EXIST = 9004;
    public static final int USER_BLOCKED_TEMP= 9005;
    public static final int USER_BLOCKED_PERMANENTLY= 9005;

    //Passwords and tokens
    public static final int WRONG_PASSWORD = 9011;
    public static final int INVALID_PASSWORD = 9012;
    public static final int INVALID_TOKEN = 9013;
    public static final int INVALID_CREDENTIALS= 9014;

}


