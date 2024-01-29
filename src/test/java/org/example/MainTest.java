package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void checkCharacterLength_whenLessThan8Characters_returnFalse() {
        String password = "abc123";
        assertFalse(Main.checkCharacterLength(password));
    }

    void checkCharacterLength_when8Characters_returnTrue() {
        String password = "abc123d4";
        assertTrue(Main.checkCharacterLength(password));
    }

    void checkCharacterLength_whenLongerThan8Characters_returnTrue() {
        String password = "abc123d4567";
        assertTrue(Main.checkCharacterLength(password));
    }

    void checkCharacterLength_whenNoCharacters_returnFalse() {
        String password = "";
        assertTrue(Main.checkCharacterLength(password));
    }

    @Test
    void checkContainsDigits_whenNoDigit_returnFalse() {
        String password = "abc";
        assertFalse(Main.checkContainsDigits(password));
    }

    @Test
    void checkContainsDigits_whenOneDigit_returnFalse() {
        String password = "ab1c";
        assertTrue(Main.checkContainsDigits(password));
    }

    @Test
    void checkContainsDigits_whenManyNumbers_returnFalse() {
        String password = "1ab2c3";
        assertTrue(Main.checkContainsDigits(password));
    }

    @Test
    void checkContainsUppercaseAndLowercase_whenPassword1_returnFalse() {
        String password = "Password1";
        assertTrue(Main.checkContainsUppercaseAndLowercase(password));
    }

    @Test
    void checkContainsUppercaseAndLowercase_whenAa345678_returnTrue() {
        String password = "Aa345678";
        assertTrue(Main.checkContainsUppercaseAndLowercase(password));
    }

    @Test
    void checkContainsUppercaseAndLowercase_when_a345678_returnTrue() {
        String password = "a345678";
        assertFalse(Main.checkContainsUppercaseAndLowercase(password));
    }

    @Test
    void checkCommonPassword_when123456_returnTrue() {
        String password = "123456";
        assertFalse(Main.checkCommonPassword(password));
    }

    @Test
    void checkCommonPassword_when_qwerty_returnTrue() {
        String password = "qwerty";
        assertFalse(Main.checkCommonPassword(password));
    }

    @Test
    void checkCommonPassword_whenStarkpass_returnFalse() {
        String password = "Starkpass";
        assertTrue(Main.checkCommonPassword(password));
    }

    @Test
    void checkContainsSpecialCharacter_when1SpecialCharacter_returnTrue() {
        String password = "abc#";
        assertTrue(Main.checkContainsSpecialCharacter(password));
    }

    @Test
    void checkContainsSpecialCharacter_whenManySpecialCharacter_returnTrue() {
        String password = "-=[";
        assertTrue(Main.checkContainsSpecialCharacter(password));
    }

    @Test
    void checkContainsSpecialCharacter_whenNoSpecialCharacter_returnTrue() {
        String password = "abc";
        assertFalse(Main.checkContainsSpecialCharacter(password));
    }

    @Test
    void createPassword_whenPasswordSafe_returnTrue(){
        String newPassword = Main.createPassword();
        assertTrue(Main.checkCharacterLength(newPassword) && Main.checkContainsDigits(newPassword) && Main.checkContainsUppercaseAndLowercase(newPassword)
                    && Main.checkCommonPassword(newPassword) && Main.checkContainsSpecialCharacter(newPassword));
    }
}