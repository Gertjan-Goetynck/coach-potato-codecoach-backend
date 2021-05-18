package com.switchfully.codecoach.domain.models.users;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class UserTest {


    @Test
    void givenNullUserFirstName_whenCreatingUser_thenThrowIllegalArgumentException(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> new User(null, "nitro", "jeannie@nitro.io", "BE123", "https://placedog.net/500"));
    }
    @Test
    void givenNullUserLastName_whenCreatingUser_thenThrowIllegalArgumentException(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> new User("nitro", null, "jeannie@nitro.io", "BE123", "https://placedog.net/500"));
    }
    @Test
    void givenNullUserEmail_whenCreatingUser_thenThrowIllegalArgumentException(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> new User("nitro", "nitro", null, "BE123", "https://placedog.net/500"));
    }
    @Test
    void givenNullUserPassword_whenCreatingUser_thenThrowIllegalArgumentException(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> new User("nitro", "nitro", "jeannie@nitro.io", null, "https://placedog.net/500"));
    }
    @Test
    void givenBlankUserFirstName_whenCreatingUser_thenThrowIllegalArgumentException(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> new User("   ", "nitro", "jeannie@nitro.io", "BE123", "https://placedog.net/500"));
    }
    @Test
    void givenBlankUserLastName_whenCreatingUser_thenThrowIllegalArgumentException(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> new User("nitro", "  ", "jeannie@nitro.io", "BE123", "https://placedog.net/500"));
    }
    @Test
    void givenBlankUserEmail_whenCreatingUser_thenThrowIllegalArgumentException(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> new User("nitro", "nitro", "   ", "BE123", "https://placedog.net/500"));
    }
    @Test
    void givenBlankUserPassword_whenCreatingUser_thenThrowIllegalArgumentException(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> new User("nitro", "nitro", "jeannie@nitro.io", "  ", "https://placedog.net/500"));
    }
    @Test
    void givenEmptyUserFirstName_whenCreatingUser_thenThrowIllegalArgumentException(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> new User("", "nitro", "jeannie@nitro.io", "BE123", "https://placedog.net/500"));
    }
    @Test
    void givenEmptyUserLastName_whenCreatingUser_thenThrowIllegalArgumentException(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> new User("nitro", "", "jeannie@nitro.io", "BE123", "https://placedog.net/500"));
    }
    @Test
    void givenEmptyUserEmail_whenCreatingUser_thenThrowIllegalArgumentException(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> new User("nitro", "nitro", "", "BE123", "https://placedog.net/500"));
    }
    @Test
    void givenEmptyUserPassword_whenCreatingUser_thenThrowIllegalArgumentException(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> new User("nitro", "nitro", "jeannie@nitro.io", "", "https://placedog.net/500"));
    }
}
