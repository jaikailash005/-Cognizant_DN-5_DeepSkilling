package com.exmple;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class UserExceptionTest {
    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    public UserExceptionTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testUserNotFound() {

        when(userRepository.findById(1L)) .thenReturn(Optional.empty());

        assertThrows(  RuntimeException.class,() -> userService.getUserById(1L)
        );
    }
}