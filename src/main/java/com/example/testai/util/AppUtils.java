package com.example.testai.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collection;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import com.example.testai.dto.UserDTO;
import com.example.testai.model.User;

/**
 * Utility class containing helper methods used throughout the application.
 */
public class AppUtils {
    
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    
    /**
     * Private constructor to prevent instantiation of utility class
     */
    private AppUtils() {
        throw new IllegalStateException("Utility class");
    }
    
    /**
     * Generate a unique ID
     * 
     * @return String unique ID
     */
    public static String generateUniqueId() {
        return UUID.randomUUID().toString();
    }
    
    /**
     * Format LocalDateTime to string
     * 
     * @param dateTime the LocalDateTime to format
     * @return formatted date string
     */
    public static String formatDateTime(LocalDateTime dateTime) {
        if (dateTime == null) {
            return null;
        }
        return dateTime.format(DATE_FORMATTER);
    }
    
    /**
     * Parse string to LocalDateTime
     * 
     * @param dateTimeStr the string to parse
     * @return parsed LocalDateTime
     */
    public static LocalDateTime parseDateTime(String dateTimeStr) {
        if (dateTimeStr == null || dateTimeStr.isEmpty()) {
            return null;
        }
        return LocalDateTime.parse(dateTimeStr, DATE_FORMATTER);
    }
    
    /**
     * Convert a User entity to UserDTO
     * 
     * @param user the User entity
     * @return corresponding UserDTO
     */
    public static UserDTO convertToUserDTO(User user) {
        if (user == null) {
            return null;
        }
        
        return new UserDTO(
                user.getId(),
                user.getFirstName(),
                user.getLastName(),
                user.getEmail(),
                user.getUsername()
        );
    }
    
    /**
     * Convert a list of User entities to a list of UserDTOs
     * 
     * @param users collection of User entities
     * @return list of UserDTOs
     */
    public static List<UserDTO> convertToUserDTOList(Collection<User> users) {
        if (users == null) {
            return List.of();
        }
        
        return users.stream()
                .map(AppUtils::convertToUserDTO)
                .collect(Collectors.toList());
    }
    
    /**
     * Check if a string is null or empty
     * 
     * @param str the string to check
     * @return true if the string is null or empty
     */
    public static boolean isEmpty(String str) {
        return str == null || str.trim().isEmpty();
    }
    
    /**
     * Check if a collection is null or empty
     * 
     * @param collection the collection to check
     * @return true if the collection is null or empty
     */
    public static boolean isEmpty(Collection<?> collection) {
        return collection == null || collection.isEmpty();
    }
}
