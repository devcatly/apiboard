package com.apiboard.repository.learning;

import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.assertj.core.api.Assertions.*;
public class PasswordEncoderTest {


    PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();

    @Test
    void encodeWithBcryptTest() {
        //giveb
        String password = "password";

        //whmn
        String encodedPassword = passwordEncoder.encode(password);

        //then
        assertThat(encodedPassword).contains("bcrypy");
    }

    @Test
    void matchTest(){
        //given
        String password = "password";
        String encodeedPassword = passwordEncoder.encode(password);

        //when
        boolean isMatch = passwordEncoder.matches(password, encodeedPassword);

        //then
        assertThat(isMatch).isTrue();

    }



}