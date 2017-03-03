/*
Improve the BubbleSort implementation so that in the best case (which means
here that the input is already sorted), the algorithm runs in O(n) time. Explain
why your new version works --- in other words, prove that the best case
running time of your code is O(n). Call your new Java file BubbleSort1.java.

Answer 
When we pass an ascendingly sorted array (best case) to the modified sort() algorithm provided above, 
the outer loop will run only once for i = 0 because the flag sorted  will remain true for the all iterations 
of the internal loop. For this reason, the algorithm’s running time is c + dn = O(n) for some constants
c and d and array size of n. Based on our tests, the modified algorithm performed better in running time not 
only for the best case but also for the 2nd best, 3rd best etc. Out of curiosity we tested both the original 
and modified BubbleSort algorithms on the worst case by feeding them an array sorted in descending order: the 
original algorithm performed slightly better because the modified algorithm has some extra operations. 
 */
package algorithm.lab03.problem05.sort_environment.sortroutines;

import algorithm.lab03.problem05.*;
import algorithm.lab03.problem05.sort_environment.runtime.Sorter;

/**
 *
 * @author Tesfay
 */
public class BubbleSort1 extends Sorter {

    int[] arr;

    public int[] sort(int[] array) {
        this.arr = array;
        bubbleSort1();
        return arr;

    }

    private void bubbleSort1() {
        int len = arr.length;
        for (int i = 0; i < len; i++) {
            boolean sorted = true;
            for (int j = 0; j < len - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(j, j + 1);
                    sorted = false;
                }
            }

            // if no swap happend on the first iteration of the number, it means they are sorted.
            if (sorted) {
                break;
            }
        }
    }

    int[] swap(int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        return arr;

    }
}
