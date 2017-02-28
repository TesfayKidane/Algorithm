/**
 * Example : "Design an algorithm to sort a list."
 * • Question: What sort of list? An array? A linked list?
 * Answer: An array.
 * • Question: What does the array hold? Numbers? Characters? Strings?
 * Answer: Numbers.
 * • Question: And are the numbers integers?
 * Answer: Yes.
 * • Question: Where did the numbers come from? Are they IDs? Values of something?
 * Answer: They are the ages of customers.
 * • Question: And how many customers are there?
 * Answer: About a million.
 * We now have a pretty different problem: sort an array containing a million integers
 * between O and 130 (a reasonable maximum age). How do we solve this? Just create an
 * array with 130 elements and count the number of ages at each value.
 * */
package algorithm.sort.sortagelist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Tesfay
 */
public class AgeListSort {

    public List<Integer> sortAgeList(List<Integer> ages) {
        long startTime = System.currentTimeMillis();
        int[] ageCounts = new int[131]; // assumption maximum age is 130
        for (int i = 0; i <= 130; i++) {
            int ageCount = 0;
            for (Integer age : ages) {
                if (i == age) {
                    ageCount++;
                }
            }
            ageCounts[i] = ageCount;
        }

        // reconstruct the list
        ages = new ArrayList<>();
        for (int j = 0; j <= 130; j++) {
            for (int k = 0; k < ageCounts[j]; k++) {
                ages.add(j);
            }
        }
        System.out.println(String.format("Time spent for sorting 1 : %s", System.currentTimeMillis() - startTime));
        return ages;
    }

    public List<Integer> sortAgeList2(List<Integer> ages) {
        long startTime = System.currentTimeMillis();
        Collections.sort(ages);
        System.out.println(String.format("Time spent for sorting 2 : %s", System.currentTimeMillis() - startTime));
        return ages;
    }

    public List<Integer> sortAgeList3(List<Integer> ages) {
        int max = getMaxAge(ages);

        long startTime = System.currentTimeMillis();
        int[] ageCounts = new int[max + 1];
        for (int i = 0; i <= max; i++) {
            int ageCount = 0;
            for (Integer age : ages) {
                if (i == age) {
                    ageCount++;
                }
            }
            ageCounts[i] = ageCount;
        }

        // reconstruct the list
        ages = new ArrayList<>();
        for (int j = 0; j <= max; j++) {
            for (int k = 0; k < ageCounts[j]; k++) {
                ages.add(j);
            }
        }
        System.out.println(String.format("Time spent for sorting 3 : %s", System.currentTimeMillis() - startTime));
        return ages;
    }

    public List<Integer> sortAgeList4(List<Integer> ages) {
        long startTime = System.currentTimeMillis();
        int[] ageCounts = new int[131];
        Arrays.fill(ageCounts, 0);

        for (int age : ages) {
            for (int i = 0; i <= 130; i++) {
                if (i == age) {
                    ageCounts[i] += 1;
                }
            }
        }

        // reconstruct the list
        ages = new ArrayList<>();
        for (int j = 0; j <= 130; j++) {
            for (int k = 0; k < ageCounts[j]; k++) {
                ages.add(j);
            }
        }
        System.out.println(String.format("Time spent for sorting 4 : %s", System.currentTimeMillis() - startTime));
        return ages;
    }

    private int getMaxAge(List<Integer> ages) {
        int max = 0;
        for (int age : ages) {
            if (age > max) {
                max = age;
            }
        }
        return max;
    }
}
