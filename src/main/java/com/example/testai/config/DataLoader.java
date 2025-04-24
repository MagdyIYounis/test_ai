package com.example.testai.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.example.testai.model.User;
import com.example.testai.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;

/**
 * Configuration class to load initial data for development and testing.
 */
@Configuration
@Slf4j
public class DataLoader {

    /**
     * Initialize the database with sample data.
     * Only runs in "dev" profile to avoid loading test data in production.
     * 
     * @param userRepository the repository to save users
     * @return CommandLineRunner to execute during application startup
     */
    @Bean
    @Profile("dev")
    public CommandLineRunner initDatabase(UserRepository userRepository) {
        return args -> {
            log.info("Loading initial data...");
            
            // Only add if the database is empty
            if (userRepository.count() == 0) {
                createSampleUsers(userRepository);
            }
            
            log.info("Data loading complete. {} users in the database.", userRepository.count());
        };
    }
    
    /**
     * Create sample users and save them to the repository
     * 
     * @param userRepository the repository to save users
     */
    private void createSampleUsers(UserRepository userRepository) {
        // Create admin user
        User admin = new User();
        admin.setFirstName("Admin");
        admin.setLastName("User");
        admin.setEmail("admin@example.com");
        admin.setUsername("admin");
        admin.setPassword("admin123"); // In a real app, this would be encrypted
        userRepository.save(admin);
        log.info("Created admin user");
        
        // Create regular user
        User user = new User();
        user.setFirstName("John");
        user.setLastName("Doe");
        user.setEmail("john.doe@example.com");
        user.setUsername("johndoe");
        user.setPassword("password123"); // In a real app, this would be encrypted
        userRepository.save(user);
        log.info("Created regular user");
        
        // Create another user
        User anotherUser = new User();
        anotherUser.setFirstName("Jane");
        anotherUser.setLastName("Smith");
        anotherUser.setEmail("jane.smith@example.com");
        anotherUser.setUsername("janesmith");
        anotherUser.setPassword("password123"); // In a real app, this would be encrypted
        userRepository.save(anotherUser);
        log.info("Created another user");
    }
}
