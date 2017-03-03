/*
Recall that in BubbleSort, at the end of the first pass through the outer loop,
the largest element of the array is in its final sorted position. After the next
pass, the next largest element is in its final sorted position. After the ith pass
(i=0,1,2,…), the largest, second largest,…, i+1st largest elements are in their
final sorted position. Use this observation to cut the running time of
BubbleSort in half. Implement your solution in code, and prove that you have
improved the running time in this way. Call your new Java file, which
contains the improvements from this problem and the previous problem,
BubbleSort2.java.
 */
package algorithm.lab03.problem05.sort_environment.sortroutines;

import algorithm.lab03.problem05.*;
import algorithm.lab03.problem05.sort_environment.runtime.Sorter;

/**
 *
 * @author Tesfay
 */
public class BubbleSort2 extends Sorter{

    int[] arr;

    public int[] sort(int[] array) {
        this.arr = array;
        bubbleSort2();
        return arr;

    }

    private void bubbleSort2() {
        int len = arr.length;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(j, j + 1);
                }
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
