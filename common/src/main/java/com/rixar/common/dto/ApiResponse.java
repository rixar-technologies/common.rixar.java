package com.rixar.common.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.rixar.common.codes.RespCode;
import com.rixar.common.utils.JHelper;
import lombok.*;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"RespStatus", "respCode", "message", "respBody"})
public class ApiResponse<T> {

    private int respCode;

    private T respBody;

    private String title;

    private String message;

    private String description;

    @JsonIgnore
    Object metaData;

    @JsonIgnore
    public static <T> ApiResponse<T> success(String message) {
        return success(null, message);
    }

    public static <T> ApiResponse<T> success(T responseBody, String message) {
        ApiResponse<T> apiResponse = new ApiResponse<>();
        apiResponse.setRespCode(RespCode.OK.getCode());
        apiResponse.setRespBody(responseBody);
        apiResponse.setMessage(message);
        return apiResponse;
    }

    public static <T> ApiResponse<T> success(String message, int respCode) {
        ApiResponse<T> apiResponse = new ApiResponse<>();
        apiResponse.setRespCode(respCode);
        apiResponse.setMessage(message);
        apiResponse.setRespBody(null);
        return apiResponse;
    }

    public static <T> ApiResponse<T> success(T responseBody, String title, String message) {
        
        ApiResponse<T> apiResponse = new ApiResponse<>();
        apiResponse.setRespCode(RespCode.OK.getCode());
        apiResponse.setRespBody(responseBody);
        apiResponse.setMessage(message);
        apiResponse.setTitle(title);
        return apiResponse;
    }

    public static <T> ApiResponse<T> success(T responseBody, RespCode respCode, String message) {

        

        ApiResponse<T> apiResponse = new ApiResponse<>();
        apiResponse.setRespCode(respCode.getCode());
        apiResponse.setRespBody(responseBody);
        apiResponse.setMessage(message);
        return apiResponse;
    }


    @JsonIgnore
    public static <T> ApiResponse<T> failure(String message) {
        

        return failure(null, message);
    }

    @JsonIgnore
    public static <T> ApiResponse<T> failure(String title, String message) {
        

        ApiResponse<T> ApiResponse = new ApiResponse<>();
        ApiResponse.setRespCode(RespCode.UNKNOWN_ERROR.getCode());
        ApiResponse.setRespBody(null);
        ApiResponse.setTitle(title);
        ApiResponse.setMessage(message);
        return ApiResponse;
    }

    @JsonIgnore
    public static <T> ApiResponse<T> failure(T responseBody, String message) {
        

        ApiResponse<T> ApiResponse = new ApiResponse<>();
        ApiResponse.setRespCode(RespCode.UNKNOWN_ERROR.getCode());
        ApiResponse.setRespBody(responseBody);
        ApiResponse.setMessage(message);
        return ApiResponse;
    }

    @JsonIgnore
    public static <T> ApiResponse<T> failure(String message, RespCode errorCode) {
        

        ApiResponse<T> ApiResponse = new ApiResponse<>();
        ApiResponse.setRespCode(errorCode.getCode());
        ApiResponse.setMessage(message);
        return ApiResponse;
    }

    @JsonIgnore
    public static <T> ApiResponse<T> failure(String message, int errorCode) {
        

        ApiResponse<T> ApiResponse = new ApiResponse<>();
        ApiResponse.setRespCode(errorCode);
        ApiResponse.setMessage(message);
        return ApiResponse;
    }

    @JsonIgnore
    public static <T> ApiResponse<T> failure(String title, String message, RespCode errorCode) {
        

        ApiResponse<T> ApiResponse = new ApiResponse<>();
        ApiResponse.setRespCode(errorCode.getCode());
        ApiResponse.setTitle(title);
        ApiResponse.setMessage(message);
        return ApiResponse;
    }


    @JsonIgnore
    public static <T> ApiResponse<T> notFound(String message) {
        ApiResponse<T> ApiResponse = new ApiResponse<>();
        ApiResponse.setRespCode(RespCode.RECORD_DOES_NOT_EXIST.getCode());
        ApiResponse.setRespBody(null);
        ApiResponse.setTitle("Record Not Found");
        ApiResponse.setMessage(message);
        return ApiResponse;
    }

    @JsonIgnore
    public static <T> ApiResponse<T> invalid(String message) {
        

        ApiResponse<T> ApiResponse = new ApiResponse<>();
        ApiResponse.setRespCode(RespCode.INVALID_INPUT_VALUE.getCode());
        ApiResponse.setRespBody(null);
        ApiResponse.setTitle("Incorrect Information Provided");
        ApiResponse.setMessage(message);
        return ApiResponse;
    }

    public boolean isSuccess() {
        return this.getRespCode() == RespCode.OK.getCode();
    }

    @JsonIgnore
    public boolean hasFailed() {
        return !this.isSuccess();
    }

    @Setter
    @Getter
    @Builder
    public static class AppAction {
        String code;
        String title;
        String narration;
        boolean isAutomatic;
        Object metaData;
    }

    public String toString(){
        return JHelper.toJson(this);
    }


}
