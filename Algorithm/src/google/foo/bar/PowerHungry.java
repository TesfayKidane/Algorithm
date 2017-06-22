/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package google.foo.bar;

/**
 *
 * @author Tesfay
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PowerHungry {

    public static void main(String[] args) {
        List<Integer> test = new ArrayList<>();
        test.addAll(Arrays.asList(new Integer[]{3, -5, 0, 1, -2}));

        PowerHungry subSet = new PowerHungry();
        System.out.println(subSet.answer(test));

    }

    public int answer(List<Integer> arr) {
        int maxProduct = Integer.MIN_VALUE;
        List<List<Integer>> powerSet = powerSet(arr);
        for (List<Integer> ints : powerSet) {
            int product = 1;
            for (Integer num : ints) {
                product *= num;
            }
            if (product > maxProduct) {
                maxProduct = product;
            }
        }
        return maxProduct;
    }

    public static List<List<Integer>> powerSet(List<Integer> X) {

        List<List<Integer>> P = new ArrayList<>();
        List<Integer> S = new ArrayList<>();
        P.add(S);
        List<Integer> T = new ArrayList<>();

        while (!X.isEmpty()) {
            List<List<Integer>> tempP = new ArrayList<>();
            Integer f = X.remove(0);
            for (int i = 0; i < P.size(); i++) {
                List<Integer> x = P.get(i);
                T = new ArrayList<>(x);
                T.add(f);
                tempP.add(T);
            }
            P.addAll(tempP);
        }
        return P;
    }
}
