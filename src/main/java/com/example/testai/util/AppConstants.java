package com.example.testai.util;

/**
 * Application-wide constants
 */
public final class AppConstants {
    
    // API Endpoints
    public static final String API_BASE_PATH = "/api";
    public static final String API_VERSION = "/v1";
    public static final String API_USERS = "/users";
    
    // Default pagination settings
    public static final String DEFAULT_PAGE_NUMBER = "0";
    public static final String DEFAULT_PAGE_SIZE = "10";
    public static final String DEFAULT_SORT_BY = "id";
    public static final String DEFAULT_SORT_DIRECTION = "asc";
    
    // Response messages
    public static final String SUCCESS = "Success";
    public static final String CREATED = "Created successfully";
    public static final String UPDATED = "Updated successfully";
    public static final String DELETED = "Deleted successfully";
    public static final String NOT_FOUND = "Resource not found";
    public static final String BAD_REQUEST = "Bad request";
    public static final String UNAUTHORIZED = "Unauthorized";
    public static final String FORBIDDEN = "Forbidden";
    public static final String SERVER_ERROR = "Internal server error";
    
    // Validation messages
    public static final String VALIDATION_REQUIRED = "This field is required";
    public static final String VALIDATION_EMAIL_FORMAT = "Invalid email format";
    public static final String VALIDATION_USERNAME_FORMAT = "Username can only contain letters, numbers, and underscores";
    public static final String VALIDATION_PASSWORD_WEAK = "Password must be at least 8 characters long and include at least one uppercase letter, one lowercase letter, one number, and one special character";
    
    // User messages
    public static final String USER_NOT_FOUND = "User not found with ID: ";
    public static final String USERNAME_TAKEN = "Username already exists";
    public static final String EMAIL_TAKEN = "Email already exists";
    
    // Date formats
    public static final String DATE_FORMAT = "yyyy-MM-dd";
    public static final String DATETIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
    
    // Private constructor to prevent instantiation
    private AppConstants() {
        throw new IllegalStateException("Utility class");
    }
}
