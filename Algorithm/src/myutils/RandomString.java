/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myutils;

import java.util.Random;

/**
 *
 * @author Tesfay
 */
public class RandomString {

    public static String randomString(int length) {
       return randomString(length, "AaBbCcDdEeFfGgHhIiJjKkLlMmNnOoPpQqRrSsTtUuVvWwXxYyZz");
    }

    public static String randomString(int length, String alphabet) {
        Random random = new Random();
        int alphabetLength = alphabet.length();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < length; i++) {
            stringBuilder.append(alphabet.charAt(random.nextInt(alphabetLength)));
        }
        return stringBuilder.toString();
    }
}
