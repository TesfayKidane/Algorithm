/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithm.stack.matching;

import datastructure.stack.LinkedStack;
import java.util.LinkedList;
import java.util.Stack;

/**
 *
 * @author Tesfay
 */
public class HTMLMatching {
 
    public static boolean isHTMLMatched(String html){
    
        Stack<String> buffer = new LinkedStack<String>();
        
        int j = html.indexOf('<'); // find first '<' char
        
        while( j != -1){
            int k = html.indexOf('>',j+1); // find '>' char
            if(k == -1)
                return false;  //invalid tag
            String tag = html.substring(j+1,k); // strip away < , >
            
            if(!tag.startsWith("/")) // this is an opening tag
                buffer.push(tag);
            else{
                if(buffer.isEmpty()) return false;  // no tag to match
                if(!tag.substring(1).equals(buffer.pop()))
                    return false;  // mis matched tag
            }
        j = html.indexOf('<',k+1);
        }
        return buffer.isEmpty();
    }
}
