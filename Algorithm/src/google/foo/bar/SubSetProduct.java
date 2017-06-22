/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package google.foo.bar;

/**
 *
 * @author Abeni
 */
public class SubSetProduct {

    public static void main(String[] args) {
        int[] test = {3, -5, 0, 1, -2};

        SubSetProduct subSet = new SubSetProduct();
        System.out.println(subSet.answer(test));

    }

    public static String answer(int[] arr) {
        int maxProduct = Integer.MIN_VALUE;
        int[][] powerSet = powerSet(arr);
        for (int[] ints : powerSet) {
            int product = 1;
            for (int num : ints) {
                product *= num;
            }
            if (product > maxProduct) {
                maxProduct = product;
            }
        }
        return String.valueOf(maxProduct);
    }

    public static int[][] powerSet(int[] X) {

        int index = 0;
        int length = (int)Math.pow(2, X.length);
        int[][] P = new int[length][];
        int[] S = new int[0];
        P[index++] = S;
        int[] T;// = new ArrayList<>();

        while (X.length != 0) {
            int[][] tempP = new int[index][];
            int[] f = {X[0]};
            X = copyRange(X, 1, X.length);
            int innerIndex = 0;
            for (int i = 0; i < index; i++) {
                int[] x = P[i];
                T = addArrays(x, f);
                tempP[innerIndex++] = T;
            }
            for(int i = 0; i < innerIndex; i++) {
                P[index++] = tempP[i];
            }
        }
        return P;
    }
    
    public static int[] copyRange(int[] arr, int start, int end) {
        int[] retArr = new int[end - start];
        for(int i = 0; i < retArr.length; i++) {
            retArr[i] = arr[start + i];
        }
        return retArr;
    }
    
    public static int[] addArrays(int[] a, int[] b) {
        int[] c = new int[a.length + b.length];
        int index = 0;
        for(int i = 0; i < a.length; i++) {
            c[index++] = a[i];
        }
        for(int i = 0; i < b.length; i++) {
            c[index++] = b[i];
        }
        return c;
    }
}
