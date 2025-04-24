package com.example.testai.dto;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import com.example.testai.util.AppUtils;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Standard API response wrapper
 * Provides consistent structure for all API responses
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(Include.NON_NULL) // Only include non-null fields in JSON
public class ApiResponse<T> {
    
    private String timestamp;
    private int status;
    private String message;
    private T data;
    private Map<String, String> errors;
    
    /**
     * Initialize with current timestamp
     */
    public ApiResponse(int status, String message) {
        this.timestamp = AppUtils.formatDateTime(LocalDateTime.now());
        this.status = status;
        this.message = message;
    }
    
    /**
     * Initialize with status, message and data
     */
    public ApiResponse(int status, String message, T data) {
        this(status, message);
        this.data = data;
    }
    
    /**
     * Add an error to the errors map
     */
    public void addError(String field, String errorMessage) {
        if (errors == null) {
            errors = new HashMap<>();
        }
        errors.put(field, errorMessage);
    }
    
    /**
     * Factory method to create a success response
     */
    public static <T> ApiResponse<T> success(String message) {
        return new ApiResponse<>(200, message);
    }
    
    /**
     * Factory method to create a success response with data
     */
    public static <T> ApiResponse<T> success(String message, T data) {
        return new ApiResponse<>(200, message, data);
    }
    
    /**
     * Factory method to create a created (201) response
     */
    public static <T> ApiResponse<T> created(String message, T data) {
        return new ApiResponse<>(201, message, data);
    }
    
    /**
     * Factory method to create an error response
     */
    public static <T> ApiResponse<T> error(int status, String message) {
        return new ApiResponse<>(status, message);
    }
    
    /**
     * Factory method to create a not found (404) response
     */
    public static <T> ApiResponse<T> notFound(String message) {
        return new ApiResponse<>(404, message);
    }
    
    /**
     * Factory method to create a bad request (400) response
     */
    public static <T> ApiResponse<T> badRequest(String message) {
        return new ApiResponse<>(400, message);
    }
    
    /**
     * Factory method to create an unauthorized (401) response
     */
    public static <T> ApiResponse<T> unauthorized(String message) {
        return new ApiResponse<>(401, message);
    }
    
    /**
     * Factory method to create a forbidden (403) response
     */
    public static <T> ApiResponse<T> forbidden(String message) {
        return new ApiResponse<>(403, message);
    }
    
    /**
     * Factory method to create an internal server error (500) response
     */
    public static <T> ApiResponse<T> serverError(String message) {
        return new ApiResponse<>(500, message);
    }
}
