package com.switchfully.codecoach.domain.models.users;

import org.apache.tomcat.jni.Address;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {


    @Test
    void givenNullUserFirstName_whenCreatingUser_thenThrowIllegalArgumentException(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> new User(null, "nitro", "jeannie@nitro.io", "BE123" ));
    }
    @Test
    void givenNullUserLastName_whenCreatingUser_thenThrowIllegalArgumentException(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> new User("nitro", null, "jeannie@nitro.io", "BE123" ));

    }
    @Test
    void givenNullUserEmail_whenCreatingUser_thenThrowIllegalArgumentException(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> new User("nitro", "nitro", null, "BE123" ));

    }


}