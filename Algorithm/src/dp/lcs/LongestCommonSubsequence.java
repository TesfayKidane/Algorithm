package dp.lcs;
/*Tesfay
* 11/2017
* source : http://www.geeksforgeeks.org/longest-common-subsequence
* */

public class LongestCommonSubsequence {

    public static void main(String[] args){
        String s1 = "AGGTAB";
        String s2 = "GXTXAYB";

        char[] X = s1.toCharArray();
        char[] Y = s2.toCharArray();
        int m = X.length;
        int n = Y.length;

        int lcs = lcsBruteForce(X, Y, m, n);  // time complexity of O(2^n)
        System.out.println("The longest common subsequence between " + s1 + " and " + s2 + " has a length of " + lcs);

        int lcs2 = lcsDPTabulation(X, Y, m, n);  // time complexity of O(nm)
        System.out.println("The longest common subsequence between " + s1 + " and " + s2 + " has a length of " + lcs2);
    }

    private static int lcsDPTabulation(char[] X, char[] Y, int m, int n) {

        int[][] lcsTable = new int[m+1][n+1];

        for(int i = 0 ; i <= m ; i++){

            for(int j = 0 ; j <= n; j++){
                if(i ==0 || j == 0)
                {
                    lcsTable[i][j] = 0 ;
                }
                else if(X[i-1] == Y[j-1]){
                    lcsTable[i][j] = 1 + lcsTable[i-1][j-1];
                }
                else{
                    lcsTable[i][j] = Math.max(lcsTable[i][j-1], lcsTable[i-1][j]);
                }
            }
        }
    return lcsTable[m][n];
    }
    private static int lcsBruteForce(char[] X, char[] Y, int m, int n) {

        if(n == 0 || m == 0)
            return 0;
        if(X[m-1] == Y[n-1])
            return 1 + lcsBruteForce(X, Y, m-1, n-1);
        else
            return Math.max(lcsBruteForce(X,Y,m-1, n), lcsBruteForce(X,Y,m,n-1));
    }

}
