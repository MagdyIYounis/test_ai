package com.example.testai.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.example.testai.model.User;
import com.example.testai.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(UserController.class)
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;
    
    @MockBean
    private UserService userService;
    
    @Autowired
    private ObjectMapper objectMapper;
    
    private User user1;
    private User user2;
    
    @BeforeEach
    public void setup() {
        user1 = new User(1L, "John", "Doe", "john@example.com", "johndoe", "password");
        user2 = new User(2L, "Jane", "Smith", "jane@example.com", "janesmith", "password");
    }
    
    @Test
    public void testGetAllUsers() throws Exception {
        when(userService.getAllUsers()).thenReturn(Arrays.asList(user1, user2));
        
        mockMvc.perform(get("/api/users")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()", is(2)))
                .andExpect(jsonPath("$[0].firstName", is("John")))
                .andExpect(jsonPath("$[1].firstName", is("Jane")));
    }
    
    @Test
    public void testGetUserById() throws Exception {
        when(userService.getUserById(1L)).thenReturn(Optional.of(user1));
        
        mockMvc.perform(get("/api/users/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.firstName", is("John")))
                .andExpect(jsonPath("$.lastName", is("Doe")));
    }
    
    @Test
    public void testGetUserByIdNotFound() throws Exception {
        when(userService.getUserById(3L)).thenReturn(Optional.empty());
        
        mockMvc.perform(get("/api/users/3")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }
    
    @Test
    public void testCreateUser() throws Exception {
        when(userService.existsByUsername("johndoe")).thenReturn(false);
        when(userService.existsByEmail("john@example.com")).thenReturn(false);
        when(userService.createUser(any(User.class))).thenReturn(user1);
        
        mockMvc.perform(post("/api/users")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(user1)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.firstName", is("John")))
                .andExpect(jsonPath("$.lastName", is("Doe")));
    }
    
    @Test
    public void testCreateUserUsernameExists() throws Exception {
        when(userService.existsByUsername("johndoe")).thenReturn(true);
        
        mockMvc.perform(post("/api/users")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(user1)))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.message", is("Username already exists")));
    }
}
