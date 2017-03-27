/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithm.pairsum;

/**
 *
 * @author Tesfay
 */
public class PairSum {

    public Pair getPairSum(int[] a, int sum) {
        Pair p = new Pair();
        p.setHasPairSum(false);
        if (a.length < 2 || a[0] > sum) {
            return p;
        }
        int j = a.length - 1;
        int i = 0;
        while (i < j) {
            int temp = a[i] + a[j];
            if (temp == sum) {
                p.setX(a[i]);
                p.setY(a[j]);
                p.setHasPairSum(true);
                return p;
            } else if (temp < sum) {
                i++;
            } else {
                j--;
            }
        }
        return p;
    }

    public static void main(String[] args) {

        int[] a = new int[]{-2, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        PairSum ps = new PairSum();
        System.out.println(ps.getPairSum(a, 10).toString());
        System.out.println(ps.getPairSum(a, 9).toString());
        System.out.println(ps.getPairSum(a, 12).toString());
        System.out.println(ps.getPairSum(a, -1).toString());
        System.out.println(ps.getPairSum(a, 20).toString());
    }

    public class Pair {

        public boolean isHasPairSum() {
            return hasPairSum;
        }

        public void setHasPairSum(boolean hasPairSum) {
            this.hasPairSum = hasPairSum;
        }

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }
        boolean hasPairSum;
        int x, y;

        public Pair() {
        }

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "Pair{" + "hasPairSum=" + hasPairSum + ", x=" + x + ", y=" + y + '}';
        }
    }
}
