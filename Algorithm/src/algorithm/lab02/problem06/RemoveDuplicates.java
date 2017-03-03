/*
The for loop iterates through every element of the list so it takes O(n) times. Inside the for loop the containsKey() 
method of java Hashmap generally takes time complexity of O(1), because it is just a get() method that return the retrieved value. 
Therefore, by simply using Hashmap in place of List in the java implementation of the removeDups() algorithm, the time complexity is reduced to O(n).

We have written the following java code to test the running time of both approaches, and the result for an array list of 1000 elements, the algorithm 
with Hashmap elapsed m = 1324246 nano seconds, while the algorithm with List took n = 3526320 nano seconds. Which is clearly shows n is approximately equal to m*m. 

 */
package algorithm.lab02.problem06;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author Tesfay
 */
public class RemoveDuplicates {

    public HashMap<Integer, Integer> removeDups(List<Integer> list) {

        HashMap<Integer, Integer> result = new HashMap<>();

        for (Integer i : list) {
            if (!result.containsKey(i)) {
                result.put(i, 0);
            }
        }

        return result;
    }

    public List<Integer> removeDups2(List<Integer> list) {

        List<Integer> result = new ArrayList<>();

        for (Integer i : list) {
            if (!result.contains(i)) {
                result.add(i);
            }
        }

        return result;
    }
    
    public static void main(String[] args){
        
        int MAX = 1000000;
        List<Integer> random = new ArrayList<>();
        for(int i = 0 ; i < MAX; i++)
        {
            Double r = Math.random()*MAX;
            random.add(r.intValue());
        }
        
        RemoveDuplicates rd = new RemoveDuplicates();
        long start = System.nanoTime();
        rd.removeDups(random);
        System.out.println("RemoveDupls - Hashmap " + (System.nanoTime() - start));
        
        start = System.nanoTime();
        rd.removeDups2(random);
        System.out.println("RemoveDupls - List " + (System.nanoTime() - start));
    }
}
