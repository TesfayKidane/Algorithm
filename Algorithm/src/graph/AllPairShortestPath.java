/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 * source : http://www.geeksforgeeks.org/dynamic-programming-set-16-floyd-warshall-algorithm/
 */
package graph;

/**
 *
 * @author Tesfay
 */
public class AllPairShortestPath {
    
    public static final int INFINITE  = Integer.MAX_VALUE;
    
    public void floydWarshall(int[][] graph, int numVertex){
    
        // initialize the solution same as the input graph
        int[][] solution = new int[numVertex][numVertex];
        for(int i = 0 ; i < numVertex; i++){
            for(int j = 0; j < numVertex; j++){
                solution[i][j] = graph[i][j];
            }
        }
    
        // pick every node k as intermidate, and update distance between node u and v if it shorter to pass via k. 
        for(int k = 0 ; k < numVertex; k++){
            
            // pick every node u as source
            for(int u = 0 ; u < numVertex; u++ ){
                
                // pick every node v as destination
                for(int v = 0 ; v < numVertex; v++){
                    if(solution[u][k] != INFINITE && 
                       solution[k][v] != INFINITE &&
                       solution[u][k] + solution[k][v] < solution[u][v]){
                        solution[u][v] = solution[u][k] + solution[k][v];
                    }
                }
            }
        }
        
        printSolution(solution);
    }

    private void printSolution(int[][] solution) {
        for(int u = 0 ; u < solution.length; u++){
            for(int v = 0 ; v < solution.length; v++){
                System.out.print(solution[u][v] + " ");
            }
            System.out.println("");
        }
    }   
         // Driver program to test above function
    public static void main (String[] args)
    {
        /* Let us create the following weighted graph
           10
        (0)------->(3)
        |         /|\
        5 |          |
        |          | 1
        \|/         |
        (1)------->(2)
           3           */
        int graph[][] = { {0,   5,  INFINITE, 10},
                          {INFINITE, 0,   3, INFINITE},
                          {INFINITE, INFINITE, 0,   1},
                          {INFINITE, INFINITE, INFINITE, 0}
                        };
        AllPairShortestPath a = new AllPairShortestPath();
 
        // Print the solution
        a.floydWarshall(graph,graph.length);
    }    
}
