/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 * source : http://www.geeksforgeeks.org/greedy-algorithms-set-6-dijkstras-shortest-path-algorithm/
 */
package graph.dijkstraspt;

/**
 *
 * @author Tesfay
 */
public class Graph {

    public int numVertex;

    public Graph(int numVertex) {
        this.numVertex = numVertex;
    }

    public void dijkstraSpt(int[][] graph, int startVertex) {

        // distance[i] holds the distance ith node from the start vertex
        int[] distance = new int[numVertex];

        // sptSet[i] is set to true if the minimum distance from start vertext to the ith node is calculated and finalized
        boolean[] sptSet = new boolean[numVertex];

        // initialize distance[] and sptSet[]
        for (int i = 0; i < numVertex; i++) {
            distance[i] = Integer.MAX_VALUE;
            sptSet[i] = false;
        }

        // set the distance from the start node to itself to zero
        distance[startVertex] = 0;

        //find shortest path for all vertices except the start node for which the distance to itself is 0
        for (int count = 0; count < numVertex - 1; count++) {
            // find the node with minimum distance which is not already in sptSet[]

            int minDistanceNodeIndex = findMinDistanceNode(sptSet, distance);

            // add node with minimum distance to sptSet[];
            sptSet[minDistanceNodeIndex] = true;

            // update distance of adjucent nodes to have the smallest distance possible. 
            // ressignement for better understanding;
            int u = minDistanceNodeIndex;

            // this for loop assumes u has an edge to every other node v.
            for (int v = 0; v < numVertex; v++) {
                //
                // check if there is edge between u and v, if graph[u][v] is 0 then there is no edge
                // check if distance[u] is not INFINITE
                // check if distance[u] + graph[u][v] < distance[v]
                //
                if (!sptSet[v]
                        && graph[u][v] != 0
                        && distance[u] != Integer.MAX_VALUE
                        && distance[u] + graph[u][v] < distance[v]) {
                    distance[v] = distance[u] + graph[u][v];
                }
            }
        }
        printSolution(startVertex, distance, numVertex);

    }

    private int findMinDistanceNode(boolean[] sptSet, int[] distance) {
        int min = Integer.MAX_VALUE;
        int minIndex = -1;

        for (int v = 0; v < distance.length; v++) {
            if (!sptSet[v] && distance[v] <= min) {
                min = distance[v];
                minIndex = v;
            }
        }
        return minIndex;
    }

    private void printSolution(int startIndex, int[] distance, int numVertex) {
        for (int i = 0; i < numVertex; i++) {
            System.out.println(startIndex + " -> " + i + " = " + distance[i]);
        }
    }

    public static void main(String[] args) {
        /* Let us create the example graph discussed above */
        int graph[][] = new int[][]{{0, 4, 0, 0, 0, 0, 0, 8, 0},
        {4, 0, 8, 0, 0, 0, 0, 11, 0},
        {0, 8, 0, 7, 0, 4, 0, 0, 2},
        {0, 0, 7, 0, 9, 14, 0, 0, 0},
        {0, 0, 0, 9, 0, 10, 0, 0, 0},
        {0, 0, 4, 14, 10, 0, 2, 0, 0},
        {0, 0, 0, 0, 0, 2, 0, 1, 6},
        {8, 11, 0, 0, 0, 0, 1, 0, 7},
        {0, 0, 2, 0, 0, 0, 6, 7, 0}
        };
        Graph dSpt = new Graph(graph.length);
        dSpt.dijkstraSpt(graph, 0);
    }
}
