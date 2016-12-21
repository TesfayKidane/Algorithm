/*
 *  Write function to print the odd numbers 1 to n
 */
package algorithm.oddnumbers;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Tesfay
 */
public class OddNumbers {
    
    public static List<Integer> getOddNumbers(int x){
        if (x < 1) return null;
        
        long start = System.currentTimeMillis();
        List<Integer> odds = new ArrayList<>();
        for(int i  = 1; i <= x ; i +=2)
        {
            odds.add(i);
           // System.out.println(""+i);
        }
        System.out.println("Time elapsed : " + (System.currentTimeMillis() - start));
        return odds;
    }
    
    public static List<Integer> getOddNumbers2(int x){
        if(x < 1) return null;
        
        long start = System.currentTimeMillis();
        List<Integer> odds = new ArrayList<>();
        for(int i  = 1; i <= x ; i++)
        {
            if(i%2 != 0)
                odds.add(i);
           // System.out.println(""+i);
        }
        System.out.println("Time elapsed : " + (System.currentTimeMillis() - start));
        return odds;
    }
    public static void main(String[] args){
       // getOddNumbers(100000000); // Time elapsed : 17974
       getOddNumbers2(100000000); // Time elapsed : 17985
    }
}
