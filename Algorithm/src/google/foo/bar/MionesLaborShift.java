/*
 *Write a function called answer(data, n) that takes in a list of less than 100 integers and a number n, and 
returns that same list but with all of the numbers that occur more than n times removed entirely. The returned list 
should retain the same ordering as the original list - you don't want to mix up those carefully-planned shift rotations!
For instance, if data was [5, 10, 15, 10, 7] and n was 1, answer(data, n) would return the list [5, 15, 7] because 10
occurs twice, and thus was removed from the list entirely.

[1, 1, 2, 3, 2, 3, 3], k =  2
[1, 1, 2, 2]
[1, 2]
 */
package google.foo.bar;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 *
 * @author Tesfay
 */
public class MionesLaborShift {

    public int[] answerUsingStream(int[]  data, int n) {
        
        List<Integer> result = new ArrayList<>();
        Map<Integer, Long> idGroupedByOcc = IntStream.of(data).boxed().
                collect(Collectors.toList()).stream().
                collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        for (Integer d : data) {
            if (idGroupedByOcc.get(d) <= n) {
                result.add(d);
            }
        }        
        return result.stream().mapToInt(i -> i).toArray();
    }
    public int[] answer(int[]  data, int n) {
      return null;  
    }
    public static void main(String[] args) {

        int[] ids = new int[]{1, 2, 3, 4,2,2,1};

        MionesLaborShift mls = new MionesLaborShift();
        IntStream.of(mls.answerUsingStream(ids, 1)).boxed().collect(Collectors.toList())
                .forEach(x -> System.out.println(x));

    }

}
