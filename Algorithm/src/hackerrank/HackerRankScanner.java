/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hackerrank;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Tesfay
 */
public class HackerRankScanner {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String myString = scanner.nextLine();        //int myInt = scanner.nextInt();
        scanner.close();


        String[] inputStrings = myString.split("\\s+");
           
        int pos = 0;
        try {
            pos = Integer.parseInt(inputStrings[inputStrings.length - 1]) - 1 ;

        } catch (Exception e) {
            e.printStackTrace();
        }

        if (pos > inputStrings.length || pos < 0) {
            System.out.println("You entered wrong number, please try again");
            return;
        }

        String reversed = reverse(inputStrings[pos]);

        inputStrings[pos] = reversed;

        for (int i = 0; i < inputStrings.length; i++) {
            System.out.print(inputStrings[i] + " ");
        }
    }

    public static String reverse(String s) {

        int length = s.length(), last = length - 1;
        char[] chars = s.toCharArray();

        for (int i = 0; i < length / 2; i++) {
            char c = chars[last - i];
            chars[last - i] = chars[i];
            chars[i] = c;
        }

        return String.copyValueOf(chars);
    }
}
