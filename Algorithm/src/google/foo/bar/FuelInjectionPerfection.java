/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package google.foo.bar;

import java.math.BigInteger;

/**
 *
 * @author Tesfay
 */
public class FuelInjectionPerfection {

    public static int answer(String n) {
        BigInteger num = new BigInteger(n);
        int count = 0;
        while (!num.equals(BigInteger.ONE)) {
            if (num.mod(BigInteger.valueOf(2)).equals(BigInteger.ZERO)) {
                num = num.divide(BigInteger.valueOf(2));
            } else {
                if (num.subtract(BigInteger.ONE).mod(BigInteger.valueOf(4)).equals(BigInteger.ZERO)
                        || num.equals(BigInteger.valueOf(3))) {
                    num = num.subtract(BigInteger.ONE);
                } else {
                    num = num.add(BigInteger.ONE);
                }
            }
            count++;
        }
        return count;
    }
}
