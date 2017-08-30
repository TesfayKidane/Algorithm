/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode.hammingdistance;

/**
 *
 * @author Tesfay
 */
public class HammingDistance {

    public int hammingDistance(int x, int y) {
        if (x == y) {
            return 0;
        }
        String xByte = Integer.toBinaryString(x);
        String yByte = Integer.toBinaryString(y);
        int xLen = xByte.length();
        int yLen = yByte.length();
        int max = xLen > yLen ? xLen : yLen;
        int min = xLen <= yLen ? xLen : yLen;
        String large = xLen > yLen ? xByte : yByte;
        String small = xLen <= yLen ? xByte : yByte;

        int count = 0;
        int end = max - min;

        for (int i = max - 1; i >= end; i--) {
            if (large.charAt(i) != small.charAt(i - (max - min))) {
                count++;
            }
        }

        for (int j = end - 1; j >= 0; j--) {
            if (large.charAt(j) == '1') {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        HammingDistance hd = new HammingDistance();
        System.out.println(Integer.toBinaryString(Integer.MAX_VALUE));
        System.out.println(Integer.toBinaryString(Integer.MIN_VALUE));
        System.out.println(hd.hammingDistance(Integer.MAX_VALUE, Integer.MIN_VALUE));
        System.out.println(hd.hammingDistance(Integer.MAX_VALUE, Integer.MAX_VALUE));
        System.out.println(hd.hammingDistance(3, 1));
    }
}
