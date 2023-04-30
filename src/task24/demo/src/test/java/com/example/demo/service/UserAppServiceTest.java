package com.example.demo.service;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.junit.jupiter.api.Assertions;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {
        UserAppService.class
})
public class UserAppServiceTest {
    @MockBean
    private UserRepository userRepository;

    @MockBean
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserAppService userAppService;

    @Test
    public void signUp() {
        // given
        User user = getUser();
        Mockito.when(passwordEncoder.encode(user.getPassword()))
                .thenReturn("$2a$10$hLEzS57tadhTHBuPNHb9WOL2GffURFv49BVfNA1Fr0x5enpcXKSbi");
        Mockito.when(userRepository.save(user)).thenReturn(user);

        //when
        User get = userAppService.singUp(user);

        // then
        Mockito.verify(userRepository, Mockito.times(1)).save(user);
        Assertions.assertEquals(user, get);
    }

    private User getUser() {
        User user = new User();

        user.setUsername("antik");
        user.setPassword("antik");
        user.setRole("USER_ROLE");
        user.setId(1L);

        return user;
    }
}
