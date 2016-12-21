/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithm.generics;

import javafx.util.Pair;

/**
 *
 * @author Tesfay
 */
public class CompareTypes {
    public static <K, V> boolean compare(Pair<K,V> p1, Pair<K,V> p2){
        return p1.getKey().equals(p2.getKey()) && p1.getValue().equals(p2.getValue());
    }

    public static void main(String[] args){
        
        Pair<Integer, String> p1 = new Pair<>(1,"Tesfay");
        Pair<Integer, String> p2 = new Pair<>(2,"Gege");

        System.out.println(CompareTypes.<Integer, String>compare(p1, p2));  // It's not necessary to explicity declare the types as the compile can use type inference to decide which types are used.
        System.out.println(CompareTypes.compare(p1, p2)); // This works using Type inference
    }
}
