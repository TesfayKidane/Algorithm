/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.toptal;

import static com.toptal.SortableArrayBySingleSwap.solution;

/**
 *
 * @author Tesfay
 */
 
    
    class Tree
{
       
    public int x;
    public Tree l;
    public Tree r;
     public Tree(int x, Tree l, Tree r){
         this.x = x;
         this.l = l;
         this.r = r;
     }
};

public class Task {
    
    
    public static void main(String[] args) {
        int[] arr = new int[] {1,1,2,3,1,1};
        Tree tree = new Tree(5, new Tree(3, new Tree(20,
                new Tree(6, null, null), null), null), new Tree(10, new Tree(1, null, null), new Tree(15, new Tree(30, null, 
                        new Tree(9, null, null)), new Tree(8, null, null))));
        System.out.println(solution(tree));
    }
    
    public static int solution(Tree T)
    {
        return Zigzag(T, 0) - 1;
    }

    static int Zigzag(Tree t, int max)
    {
        if (t == null) return 0;

        int lh = TurnCount(t, true, 0);
        int rh = TurnCount(t, false, 0);

        max = Math.max(lh, rh);
        max = Math.max(max, Zigzag(t.l, max));
        max = Math.max(max, Zigzag(t.r, max));

        return max;
    }

    static int TurnCount(Tree node, boolean turnLeft, int turn)
    {
        if (node == null) return turn;

        turn = turnLeft
            ? TurnCount(node.l, !turnLeft, node.l == null ? turn : turn + 1)
            : TurnCount(node.r, !turnLeft, node.r == null ? turn : turn + 1);

        return turn;
    }
}
