/*
 *Balance a string with parentheses. "a(b)" -> "a(b)"; "(((((" -> ""; "(()())" -> "(()())"; ")ab(()" -> "ab()"; 
 */
package google.phoneinterview;

/**
 *
 * @author Tesfay
 */
import java.util.Arrays;
import java.util.Stack;

public class BalanceStringParentheses {
    
    public static void main(String[] args){
    
        System.out.println(balanceStringParentheses("a(b)"));
        System.out.println(balanceStringParentheses("(((("));
        System.out.println(balanceStringParentheses("(()())"));
         System.out.println(balanceStringParentheses(")ab(()"));
    }
    
    public static String balanceStringParentheses(String input){
        
        char[] inputChar = input.toCharArray();
        Stack<Integer> openingParentheses = new Stack<Integer>();
        boolean[] charToBeRemoved = new boolean[inputChar.length];
        Arrays.fill(charToBeRemoved, false);
        
        for(int i = 0 ; i < inputChar.length; i++)
        {
            if(inputChar[i] == '('){
                openingParentheses.push(i);
            }
            else if(inputChar[i] == ')'){
                if(!openingParentheses.empty())
                {
                    openingParentheses.pop();
                }
                else{
                    charToBeRemoved[i] = true;
                }
            }            
        }
        
        // if there are un matched opening parentheses remove them
      while(!openingParentheses.empty()){
          charToBeRemoved[openingParentheses.pop()] = true;
      }
      
      // now collect only the balanced chars.
      StringBuilder sb = new StringBuilder();
      for(int i = 0 ; i < inputChar.length; i++){
          if(!charToBeRemoved[i]){
          sb.append(inputChar[i]);
          }
      }
       
      return sb.toString();        
    }
}
