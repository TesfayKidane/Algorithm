/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithm.sort.bubblesort;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author Tesfay
 */
public class Driver {

    public static void main(String[] args) {

        int MAX = 100;
        Integer[] random = new Integer[MAX];
        Integer[] random3 = new Integer[MAX];
        for (int i = 0; i < MAX; i++) {
            Double r = Math.random() * MAX;
            random[i] = r.intValue();
            random3[i] = MAX - i;
        }
        System.out.println("Inputs : ");
        System.out.print("random : ");
        Arrays.asList(random).stream().forEach(x -> System.out.print(" , " + x));
        System.out.print("\nrandom3 : ");
        Arrays.asList(random3).stream().forEach(x -> System.out.print(" , " + x));
        //copy array 
        Integer[] random2 = Arrays.copyOf(random, MAX);
        Integer[] random4 = Arrays.copyOf(random3, MAX);
        Integer[] random5 = Arrays.copyOf(random, MAX);
        Integer[] random6 = Arrays.copyOf(random, MAX);

        BubbleSort bs = new BubbleSort();
        long start = System.nanoTime();
//        bs.sort(random);
//        System.out.print("\nBubbleSort : input random, output : ");
//        Arrays.asList(random).stream().forEach(x -> System.out.print(" , " + x));
//        System.out.println("\nBubbleSort time : " + (System.nanoTime() - start));
//
//        BubbleSort1 bs1 = new BubbleSort1();
//        start = System.nanoTime();
//        bs1.sort(random2);
//        System.out.print("\nBubbleSort1 : input random, output : ");
//        Arrays.asList(random2).stream().forEach(x -> System.out.print(" , " + x));
//        System.out.println("\nBubbleSort1 time : " + (System.nanoTime() - start));
//
//        System.out.println("Compare BubbleSort and BubleSort1 on best case input, i.e when the input array is already sorted");
//
//        // Integer[] randomSorted = new Integer[MAX];
//        // Arrays.asList(random).stream().sorted().collect(Collectors.toList()).toArray(randomSorted);
//        start = System.nanoTime();
//        bs.sort(random);
//        System.out.println("BubbleSort time : " + (System.nanoTime() - start));
//
//        start = System.nanoTime();
//        bs1.sort(random2);
//        System.out.println("BubbleSort1 time : " + (System.nanoTime() - start));
//
//        System.out.println("Compare BubbleSort and BubleSort1 on worst case input, i.e when the input array is already sorted in reverse order");
//
//        start = System.nanoTime();
//        bs.sort(random3);
//        System.out.println("BubbleSort time : " + (System.nanoTime() - start));
//
//        start = System.nanoTime();
//        bs1.sort(random4);
//        System.out.println("BubbleSort1 time : " + (System.nanoTime() - start));

        System.out.println("Compare BubbleSort and BubleSort2 on worst case input, and show BubbleSort2 is designed to cut running time by half");

        System.out.print("\nBubbleSort input : ");
        Arrays.asList(random5).stream().forEach(x -> System.out.print(" , " + x));
        start = System.nanoTime();
        bs.sort(random5);
        System.out.println("\nBubbleSort time : " + (System.nanoTime() - start));
        System.out.print("BubbleSort output : ");
        Arrays.asList(random5).stream().forEach(x -> System.out.print(" , " + x));

        BubbleSort2 bs2 = new BubbleSort2();
        System.out.print("\nBubbleSort2 input : ");
        Arrays.asList(random6).stream().forEach(x -> System.out.print(" , " + x));
        start = System.nanoTime();
        bs2.sort(random6);
        System.out.println("\nBubbleSort2 time : " + (System.nanoTime() - start));
        System.out.print("BubbleSort2 output : ");
        Arrays.asList(random6).stream().forEach(x -> System.out.print(" , " + x));
    }
}
