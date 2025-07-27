package com.rixar.common.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.rixar.common.codes.RespCode;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@Builder
public class ListApiResponse<T> {

    @JsonIgnore
    private Class<T> type;

    private int respCode;

    private String message;

    private Object totals;

    private int currentPageElements;
    private int pageSize;
    private int totalPagesCount;
    private Long totalElements;
    private int currentPageNo;

    @JsonProperty("nextPageNo")
    public int getNextPageNo() {
        return currentPageNo+1;
    }

    private List<T> items;


    public ListApiResponse(Class<T> type, String description, List<T> respBody) {
        this.type = type;
        this.items = respBody;
        this.message = description;
        this.currentPageElements = respBody.size();
        this.respCode = RespCode.OK.code;
    }

    public ListApiResponse(Class<T> type, String description, List<T> respBody, int currentPage, int totalPages, Long totalElements, int pageSize) {
        this.type = type;
        this.items = respBody;
        this.message = description;
        this.currentPageElements = respBody.size();

        this.currentPageNo = currentPage;
        this.totalPagesCount = totalPages;
        this.totalElements = totalElements;
        this.pageSize = pageSize;
        this.respCode = RespCode.OK.code;
    }

    public ListApiResponse(Class<T> type, String description, GoodPage<T> page) {
        this.type = type;
        this.items = page.getContent();
        this.message = description;
        this.currentPageElements = page.getContent().size();

        this.currentPageNo = page.getNumber();
        this.totalPagesCount = page.getTotalPages();
        this.totalElements = page.getTotalElements();
        this.pageSize = page.getSize();
        this.respCode = RespCode.OK.code;
    }





}
