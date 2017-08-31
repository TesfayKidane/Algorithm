/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithm.subsetsum;

/**
 *
 * @author Tesfay
 */
public class SubsetSum {
// inputs
// s            - set vector
// t            - tuplet vector
// t_size       - tuplet size so far
// sum          - sum so far
// ite          - nodes count
// target_sum   - sum to be found

    static int total_nodes;

    private static void printSubset(int A[], int size) {
        for (int i = 0; i < size; i++) {
            System.out.print(" | " + A[i]);
        }
        System.out.print("\n");
    }

    private static int[] subsetsum(int s[], int t[],
             int t_size,
            int sum, int ite,
            int target_sum) {
        total_nodes++;
        if (target_sum == sum) {
            // We found subset
            printSubset(t, t_size);
            // Exclude previously added item and consider next candidate
            subsetsum(s, t, t_size-1, sum - s[ite], ite + 1, target_sum);
            return t;
        } else {
            // generate nodes along the breadth
            for (int i = ite; i < s.length; i++) {
                t[t_size] = s[i];
                // consider next level node (along depth)
                subsetsum(s, t, t_size + 1, sum + s[i], i + 1, target_sum);
            }
        }
        return null;
    }

// Wrapper to print subsets that sum to target_sum
// input is weights vector and target_sum
    private static void generateSubsets(int s[], int size, int target_sum) {
        int[] t = new int[size];

        subsetsum(s, t, 0, 0, 0, target_sum);

    }

    public static void main(String[] args) {
        int weights[] = {15, 22, 14, 26, 32, 9, 16, 8,0}; //{10, 7, 5, 18, 12, 20, 15};
        int size = weights.length;

        generateSubsets(weights, size, 0);
        //printf("Nodes generated %d\n", total_nodes);
        //return 0;
    }
}
