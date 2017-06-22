/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.amazon;

/**
 *
 * @author Tesfay
 */
import java.util.Stack;

public class BaseBallScore {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        BaseBallScore d = new BaseBallScore();
        System.out.println(d.baseBall(new String[]{"10", "-2", "1", "A", "4", "6", "-8", "Z", "+", "+"}));
    }

    public int baseBall(String[] arr) {
        int totalScore = 0;

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals("Z")) {
                if (!stack.empty()) {
                    stack.pop();
                }
            } else if (arr[i].equals("+")) {
                if (!stack.empty()) {
                    stack.push(2 * stack.peek());
                }
            } else if (arr[i].matches("-?\\d+(\\.\\d+)?")) {
                stack.push(Integer.parseInt(arr[i]));
            } else {
                if (!stack.empty()) {
                    stack.pop();
                    if (!stack.empty()) {
                        stack.pop();
                    }
                }
            }
        }

        while (!stack.empty()) {
            totalScore += stack.pop();
        }
        return totalScore;
    }
}
