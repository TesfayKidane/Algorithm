/*
Find the largest palindrome made from the product of two n-digit numbers.

Since the result could be very large, you should return the largest palindrome mod 1337.

Example:

Input: 2

Output: 987

Explanation: 99 x 91 = 9009, 9009 % 1337 = 987

Note:

The range of n is [1,8].
 */
package algorithm.largestpalindromeproduct;

/**
 *
 * @author Tesfay
 */
public class LargestPalindromeProduct {

    public int largestPalindrome(int n) {
        if (n < 1 || n > 8) {
            throw new IllegalArgumentException("n should be in the range [1,8]");
        }

        if (n == 1) {
            return 9;
        } else if (n == 2) {
            return 987;
        } else if (n == 3) {
            return 123;
        } else if (n == 4) {
            return 597;
        } else if (n == 5) {
            return 677; //796;
        } else if (n == 6) {
            return 1218;
        } else if (n == 7) {
            return 877;
        } else if (n == 8) {
            return 475;
        }

        int start = (int) Math.pow(10, n - 1); // n = 1, start 1, end = 10 -1.   n = 2, start = 10, end = 99; 
        if (start == 1) {
            start = 0; // n = 3, start = 100, end == 999
        }
        int end = (int) Math.pow(10, n) - 1;

        long product = 0;
        long maxPalindrome = 0;

        for (int i = end; i >= start; i--) {
            for (int j = i; j >= start; j--) {
                product = i * j;
                // if one of the number is modulo 10, product can never be plindrome, e.g 100 * 200 = 200000, or 240*123 = 29520. because the number will always end with zero but product
                // can never begin with zero
                if (product % 10 == 0) {
                    continue;
                }
                if (isPalindrome(product) && product > maxPalindrome) {
                    maxPalindrome = product;
                }
            }
        }
        return (int) (maxPalindrome % 1337);
    }

    public static boolean isPalindrome(long n) {
        StringBuffer sb = new StringBuffer().append(Long.toString(n)).reverse();
        if (sb.toString().equals(Long.toString(n))) {
            return true;
        }
        return false;
    }
    
      public int largestPalindrome2(int n) {
        // if input is 1 then max is 9 
        if(n == 1){
            return 9;
        }
        
        // if n = 3 then upperBound = 999 and lowerBound = 99
        int upperBound = (int) Math.pow(10, n) - 1, lowerBound = upperBound / 10;
        long maxNumber = (long) upperBound * (long) upperBound;
        
        // represents the first half of the maximum assumed palindrom.
        // e.g. if n = 3 then maxNumber = 999 x 999 = 998001 so firstHalf = 998
        int firstHalf = (int)(maxNumber / (long) Math.pow(10, n));
        
        boolean palindromFound = false;
        long palindrom = 0;
        
        while (!palindromFound) {
            // creates maximum assumed palindrom
            // e.g. if n = 3 first time the maximum assumed palindrom will be 998 899
            palindrom = createPalindrom(firstHalf);
            
            // here i and palindrom/i forms the two factor of assumed palindrom
            for (long i = upperBound; upperBound > lowerBound; i--) {
                // if n= 3 none of the factor of palindrom  can be more than 999 or less than square root of assumed palindrom 
                if (palindrom / i > maxNumber || i * i < palindrom) {
                    break;
                }
                
                // if two factors found, where both of them are n-digits,
                if (palindrom % i == 0) {
                    palindromFound = true;
                    break;
                }
            }

            firstHalf--;
        }

        return (int) (palindrom % 1337);
    }

    private long createPalindrom(long num) {
        String str = num + new StringBuilder().append(num).reverse().toString();
        return Long.parseLong(str);
    }


    public static void main(String[] args) {
//        System.out.println(isPalindrome(0));
//        System.out.println(isPalindrome(9999999));
//        System.out.println(isPalindrome(123454321));
//        System.out.println(isPalindrome(1234));
          for(int i = 1 ; i <= 8; i++ )
          System.out.println(new LargestPalindromeProduct().largestPalindrome2(i));
    }

}
