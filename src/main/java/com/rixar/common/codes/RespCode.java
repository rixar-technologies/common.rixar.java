package com.rixar.common.codes;

public enum RespCode {

   //Auth Codes and tokens
   OK(2000,200),
   OK_WITH_TOKEN(2002,200),  // Automatically logged in

   //Auth Codes and tokens
   UNAUTHENTICATED(4001,200),  // No credentials or Invalid credentials.
   EXCEPTION_ON_AUTHENTICATION(200,200),
   FORBIDDEN(4003,200),  // Valid credentials but not enough privileges to perform an action on a resource

   USER_DOES_NOT_EXIST(4004,200),
   USER_BLOCKED_TEMP(4005,200),
   USER_BLOCKED_PERMANENTLY(4005,200),

   NEW_SESSION_REQUIRED(4006,200),
   LOGIN_TO_CONTINUE(4007,200),


   WRONG_PASSWORD(4011,200),
   INVALID_PASSWORD(4012,200),
   INVALID_TOKEN(4013,200),
   INVALID_CREDENTIALS(4014,200),
   USER_ALREADY_EXISTS_ON_REGISTRATION(4015,200),
   ILLEGAL_ACCESS(4016,200),
   USER_NOT_VERIFIED(4018,200),
   PASSWORD_NOT_SET(4020,200),

   //User Inputs
   INVALID_INPUT_VALUE(4040,200),

   //Server
   GENERAL_ERROR(5000,200),
   UNKNOWN_ERROR(5001,200),
   INVALID_SERVER_CONFIGURATION(5002,200),

   //Database Operations
   DATABASE_EXCEPTION(8000,200),
   DATABASE_READ_EXCEPTION(8001,200),
   DATABASE_WRITE_EXCEPTION(8002,200),
   RECORD_DOES_NOT_EXIST(8004,200),
   DUPLICATION_REFERENCE(8005,200),

   //Business Operations
   BUSINESS_DOES_NOT_EXIST(9000,200),
   BUSINESS_NOT_ACTIVATED(9001,200),
   BUSINESS_LICENCE_EXPIRED(9003,200),
   BUSINESS_BRANCH_DOES_NOT_EXIST(9004,200);

   public final int code;
   public final int httpCode;

   RespCode(int code, int httpCode) {
      this.code = code;
      this.httpCode = httpCode;
   }

   public int getCode() {
      return this.code;
   }

   public int getHttpCode() {
      return this.httpCode;
   }


}