package org.example;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        System.out.println(createPassword());
    }

    public static boolean checkCharacterLength(String password){
        return password.length()>=8;
    }

    public static boolean checkContainsDigits(String password){
        for (char character : password.toCharArray()){
            if (Character.isDigit(character)){
                return true;
            }
        }
        return false;
    }

    public static boolean checkContainsUppercaseAndLowercase (String password){
        boolean hasUpperCase = false;
        boolean hasLowerCase = false;
        for (char character : password.toCharArray()){
            if (Character.isUpperCase(character)){
                hasUpperCase = true;
            } else if (Character.isLowerCase(character)) {
                hasLowerCase = true;
            }
        }
        return hasLowerCase && hasUpperCase;
    }

    public static boolean checkCommonPassword(String password){
        String[] commonPasswords = {
                "password",
                "123456",
                "qwerty",
                "abc123",
        };
        return Arrays.asList(commonPasswords).contains(password.toLowerCase());
    }

    public static boolean checkContainsSpecialCharacter(String password){
        String specialChars = "[!@#$%^&*()_+\\-=\\[\\]{};':\",.<>/?]";
        return password.matches(".*" + specialChars + ".*");
    }

    public static String createPassword(){
        Random random = new Random();

        int passwordLength = random.nextInt(6) + 7;
        String newPassword = "";

        for (int i = 1; i<= passwordLength; i++){
            if (i % 3 == 0){
                int randomNumber = random.nextInt(15) + 33;
                newPassword += String.valueOf((char) randomNumber);
            } else if (i % 4 == 0) {
                int randomNumber = random.nextInt(11) + 48;
                newPassword += String.valueOf((char) randomNumber);
            } else if (i % 2 == 0) {
                int randomNumber = random.nextInt(26) + 65;
                newPassword += String.valueOf((char) randomNumber).toLowerCase();
            }else {
                int randomNumber = random.nextInt(26) + 65;
                newPassword += String.valueOf((char) randomNumber).toUpperCase();
            }
        }
        return newPassword;
    }
}