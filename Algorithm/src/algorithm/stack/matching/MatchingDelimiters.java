/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithm.stack.matching;

import datastructure.stack.LinkedStack;
import java.util.Stack;

/**
 *
 * @author Tesfay
 */
public class MatchingDelimiters {
 
    public static boolean isMatched(String expression){
        
        String opening = "([{";
        String closing = ")]}";
        Stack<Character> stack = new LinkedStack<Character>();
        for(char c : expression.toCharArray()){
            if(opening.indexOf(c) != -1)
                stack.push(c);
            else if(closing.indexOf(c) != -1 )
                if(stack.isEmpty()) return false;
                else if(closing.indexOf(c) != opening.indexOf(stack.pop()))
                    return false;
        }
        return stack.isEmpty();
    }
}
