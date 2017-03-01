/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithm.lab02.problem05;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Tesfay
 */
public class SubSetSumBruteForce {

    public SubSetSumBruteForce() {
    }

    public List<List<Integer>> powerset(List<Integer> set) {
        List<List<Integer>> powerset = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        List<Integer> target;

        powerset.add(subset);
        System.out.println("All subsets : ");
        for (Integer element : set) {
            List<List<Integer>> powersetPart = new ArrayList<>();
            for (List<Integer> t : powerset) {
                target = new ArrayList<>();
                target.addAll(t);
                if (!target.contains(element)) {
                    target.add(element);
                }
                target.stream().forEach(x -> System.out.print(" | " + x));
                System.out.println("");
                powersetPart.add(target);
            }
            powerset.addAll(powersetPart);
        }
        System.out.println("Total number of subsets : " + powerset.size());
        return powerset;
    }
    public List<Integer> subsetsum(List<Integer> S, int k) {

        for (List<Integer> target : powerset(S)) {
            int sum = 0;
            if(target.stream().map((i) -> i).reduce(sum, Integer::sum) == k)
                return target;
        }
        return null;
    }

    public static void main(String[] args) {
        Integer[] S = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        int k = 9;
        SubSetSumBruteForce ssBF = new SubSetSumBruteForce();
        List<Integer> result = ssBF.subsetsum(Arrays.asList(S), k);
        if (result != null) {
            System.out.println("Target subset with sum = 9 found => ");
            result.stream().forEach(x -> System.out.print(" | " + x));
            System.out.println("");
        }
    }
}
