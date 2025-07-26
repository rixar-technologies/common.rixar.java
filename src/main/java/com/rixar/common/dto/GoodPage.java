package com.rixar.common.dto;

import lombok.Value;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Custom Page implementation that mimics Spring Data's Page interface
 * @param <T> Type of elements in the page
 */
@Value
public class GoodPage<T> {

    List<T> content;
    int number;            // Current page number (0-based)
    int size;              // Page size
    long totalElements;    // Total elements across all pages
    int totalPages;        // Total pages
    
    /**
     * Static factory method to create a CustomPage
     */
    public static <T> GoodPage<T> of(List<T> content, int number, int size, long totalElements) {
        int totalPages = size == 0 ? 1 : (int) Math.ceil((double) totalElements / (double) size);
        return new GoodPage<>(content, number, size, totalElements, totalPages);
    }
    
    /**
     * Maps the content of the current page to another type
     */
    public <U> GoodPage<U> map(Function<T, U> converter) {
        List<U> convertedContent = content.stream()
                .map(converter)
                .collect(Collectors.toList());
        
        return new GoodPage<>(
                convertedContent,
                this.number,
                this.size,
                this.totalElements,
                this.totalPages
        );
    }
    
    /**
     * Check if there is a next page
     */
    public boolean hasNext() {
        return getNumber() < getTotalPages() - 1;
    }
    
    /**
     * Check if there is a previous page
     */
    public boolean hasPrevious() {
        return getNumber() > 0;
    }
    
    /**
     * Check if this is the first page
     */
    public boolean isFirst() {
        return getNumber() == 0;
    }
    
    /**
     * Check if this is the last page
     */
    public boolean isLast() {
        return getNumber() == getTotalPages() - 1;
    }
    
    /**
     * Check if the page is empty
     */
    public boolean isEmpty() {
        return content.isEmpty();
    }
    
    /**
     * Get the number of elements in the current page
     */
    public int getNumberOfElements() {
        return content.size();
    }
}