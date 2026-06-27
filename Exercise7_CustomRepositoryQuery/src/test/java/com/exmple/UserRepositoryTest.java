package com.exmple;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class UserRepositoryTest {
    @Mock
    private UserRepository userRepository;
    public UserRepositoryTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testFindByName() {

        User user = new User();
        user.setId(1L);
        user.setName("Mervyn");
        List<User> users = Arrays.asList(user);

        when(userRepository.findByName("Mervyn")) .thenReturn(users);

        List<User> result = userRepository.findByName("Mervyn");

        assertEquals(1, result.size());
        assertEquals("Mervyn",
                result.get(0).getName());
    }
}