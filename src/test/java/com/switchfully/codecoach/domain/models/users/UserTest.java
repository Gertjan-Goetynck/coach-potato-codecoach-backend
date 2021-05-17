package com.switchfully.codecoach.domain.models.users;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class UserTest {


    @Test
    void givenNullUserFirstName_whenCreatingUser_thenThrowIllegalArgumentException(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> new User(null, "nitro", "jeannie@nitro.io", "BE123"));
    }
    @Test
    void givenNullUserLastName_whenCreatingUser_thenThrowIllegalArgumentException(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> new User("nitro", null, "jeannie@nitro.io", "BE123"));
    }
    @Test
    void givenNullUserEmail_whenCreatingUser_thenThrowIllegalArgumentException(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> new User("nitro", "nitro", null, "BE123"));
    }
    @Test
    void givenNullUserPassword_whenCreatingUser_thenThrowIllegalArgumentException(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> new User("nitro", "nitro", "jeannie@nitro.io", null));
    }
    @Test
    void givenBlankUserFirstName_whenCreatingUser_thenThrowIllegalArgumentException(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> new User("   ", "nitro", "jeannie@nitro.io", "BE123"));
    }
    @Test
    void givenBlankUserLastName_whenCreatingUser_thenThrowIllegalArgumentException(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> new User("nitro", "  ", "jeannie@nitro.io", "BE123"));
    }
    @Test
    void givenBlankUserEmail_whenCreatingUser_thenThrowIllegalArgumentException(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> new User("nitro", "nitro", "   ", "BE123"));
    }
    @Test
    void givenBlankUserPassword_whenCreatingUser_thenThrowIllegalArgumentException(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> new User("nitro", "nitro", "jeannie@nitro.io", "  "));
    }
    @Test
    void givenEmptyUserFirstName_whenCreatingUser_thenThrowIllegalArgumentException(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> new User("", "nitro", "jeannie@nitro.io", "BE123"));
    }
    @Test
    void givenEmptyUserLastName_whenCreatingUser_thenThrowIllegalArgumentException(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> new User("nitro", "", "jeannie@nitro.io", "BE123"));
    }
    @Test
    void givenEmptyUserEmail_whenCreatingUser_thenThrowIllegalArgumentException(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> new User("nitro", "nitro", "", "BE123"));
    }
    @Test
    void givenEmptyUserPassword_whenCreatingUser_thenThrowIllegalArgumentException(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> new User("nitro", "nitro", "jeannie@nitro.io", ""));
    }
}