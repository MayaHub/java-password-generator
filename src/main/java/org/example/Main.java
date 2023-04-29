package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        //ask user how many passwords
        System.out.println("How many random passwords would you like to generate? ");
        int total = in.nextInt();

        //ask user how many characters
        System.out.println("How long do you need the password to be (length in characters)? ");
        int length = in.nextInt();

        //create array to store random passwords
        String[] passwords = new String[total];

        //loop through total number of passwords
        for (int i = 0; i < total; i++) {
            //generate one random password
            String randomPassword = "";
            //generate one random character
            for (int j = 0; j < length; j++) {
                //add character to password
                randomPassword += randomCharacter();
            }
            //add random password to array
            passwords[i] = randomPassword;
        }
        //print array of passwords
        printPasswords(passwords);

        //print password strength
        System.out.println(getPasswordStrength(length));
    }

    public static String getPasswordStrength(int length) {
        if (length < 5) {
            return "password strength: weak";
        } else if(length < 10) {
            return "password strength: medium";
        } else {
            return "password strength: strong";
        }
    }

    public static void printPasswords(String[] arr) {
        for(int i=0; i<arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    public static char randomCharacter() {
        //generate random number representing all possible characters in the password
        //10 digits + 26 lowercase + 26 uppercase = 62 possible characters
        int rand = (int) (Math.random()*62);

        //break up rand into intervals to represent numbers, uc letters, and lc letters
        //rand = 0-61 inclusive

        if(rand <= 9) {
            // if rand = 0-9, => number => ascii 48-57
            //number + 48 = ascii number character
            int ascii = rand + 48;
            return (char)(ascii);
        }

        else if(rand <=35) {
            //if rand = 10-35 => uppercase => ascii 65-90
            //65 - 10 = ascii uppercase character
            int ascii = rand + 55;
            return (char)(ascii);
        }

        else {
            //if rand = 36-61 => lowercase => ascii 97-122
            //97 - 36 = ascii lowercase character
            int ascii = rand + 61;
            return (char)(ascii);
        }
    }
}