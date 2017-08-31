package algorithm.goldbach;

import java.math.BigInteger;

import myutils.Prime;

public class Goldbach {
	/**
	 * Assuming a Halting Calculator exists,  the following
	 * method can be used to decide Goldbach's Conjecture.
	 * 
	 * The return value of this method is the first even number
	 * found, > 2, with the property that it is not the sum of two primes.
	 * 
	 * To adhere to the requirement that Halting Problems work
	 * on normal Java programs, we have provided a BigInteger argument x --
	 * but x is not needed in the computation.
	 */
	public BigInteger decideGoldbach(BigInteger x) {
		int even = 4;
		boolean sumFound = false;
		while(true) {	
			for(int k = 2; k < even && !sumFound; ++k) {
				for(int m = 2; m < even; ++m) {
					if(Prime.isPrime(k) && Prime.isPrime(m) && k + m == even) {
						sumFound = true;
						System.out.println(even + " = " + m + " + " + k);
					}
				}
			}
			//counterexample found
			if(!sumFound) {
				return BigInteger.valueOf(even);
			}
			else {
				sumFound = false;
				even += 2;
				//exit after 1000 tries -- comment this out 
				//to get the real program
				if(even > 2000) return BigInteger.valueOf(-1);
			}
		}
	}
	
	public static void main(String[] args) {
		Goldbach g = new Goldbach();
		BigInteger result = g.decideGoldbach(BigInteger.ONE);
		System.out.println("\nThe Result: " + result.toString());
	}
	
}
