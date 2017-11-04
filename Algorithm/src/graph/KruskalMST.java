package graph;

import java.util.Arrays;

public class KruskalMST {

    // class to represent the edge between nodes
    class Edge implements Comparable<Edge>{
        int src, dst, weight;
        // comparator function used to sort edges based on their weight
        @Override
        public int compareTo(Edge otherEdge) {
            return this.weight - otherEdge.weight;
        }
    };

    // A class to represent a subset for union-find
    class subset
    {
        int parent, rank;
    };

    int numVertexs, numEdge;
    Edge[] edges;

    // create graph with vertex numVertexs and edge numEdges
    public KruskalMST(int numVertexs, int numEdges) {
        this.numVertexs = numVertexs;
        this.numEdge = numEdges;
        edges = new Edge[numEdges];
        for(int i = 0 ; i < numEdges; i++){
            edges[i] = new Edge();
        }
    }

    // A utility function to find set of an element i
    // (uses path compression technique)
    int find(subset subsets[], int i)
    {
        // find root and make root as parent of i (path compression)
        if (subsets[i].parent != i)
            subsets[i].parent = find(subsets, subsets[i].parent);

        return subsets[i].parent;
    }

    // A function that does union of two sets of x and y
    // (uses union by rank)
    void Union(subset subsets[], int x, int y)
    {
        int xroot = find(subsets, x);
        int yroot = find(subsets, y);

        // Attach smaller rank tree under root of high rank tree
        // (Union by Rank)
        if (subsets[xroot].rank < subsets[yroot].rank)
            subsets[xroot].parent = yroot;
        else if (subsets[xroot].rank > subsets[yroot].rank)
            subsets[yroot].parent = xroot;

            // If ranks are same, then make one as root and increment
            // its rank by one
        else
        {
            subsets[yroot].parent = xroot;
            subsets[xroot].rank++;
        }
    }

    public void findKruskalMST(){
        Edge[] result = new Edge[numVertexs];
        int e = 0;
        int i = 0;
        for(i = 0 ; i < numVertexs; i++){
            result[i] = new Edge();
        }

        Arrays.sort(edges);

        // Allocate memory for creating V ssubsets
        subset subsets[] = new subset[numVertexs];
        for(i=0; i<numVertexs; ++i)
            subsets[i]=new subset();

        // Create V subsets with single elements
        for (int v = 0; v < numVertexs; ++v)
        {
            subsets[v].parent = v;
            subsets[v].rank = 0;
        }

        i = 0;

        while(e < numVertexs - 1){
            Edge nextEdge = new Edge();
            nextEdge = edges[i++];

            int x = find(subsets, nextEdge.src);
            int y = find(subsets, nextEdge.dst);

            if (x != y) {
                result[e++] = nextEdge;
                Union(subsets,x,y);
            }
        }

        // print result
        for(i = 0 ; i < e; i++){
            System.out.println(result[i].src + " --- " + result[i].dst + " === " + result[i].weight);
        }
    }
    // Driver Program
    public static void main (String[] args)
    {

        /* Let us create following weighted graph
                 10
            0--------1
            |  \     |
           6|   5\   |15
            |      \ |
            2--------3
                4       */
        int V = 4;  // Number of vertices in graph
        int E = 5;  // Number of edges in graph
        KruskalMST graph = new KruskalMST(V, E);

        // add edge 0-1
        graph.edges[0].src = 0;
        graph.edges[0].dst = 1;
        graph.edges[0].weight = 10;

        // add edge 0-2
        graph.edges[1].src = 0;
        graph.edges[1].dst = 2;
        graph.edges[1].weight = 6;

        // add edge 0-3
        graph.edges[2].src = 0;
        graph.edges[2].dst = 3;
        graph.edges[2].weight = 5;

        // add edge 1-3
        graph.edges[3].src = 1;
        graph.edges[3].dst = 3;
        graph.edges[3].weight = 15;

        // add edge 2-3
        graph.edges[4].src = 2;
        graph.edges[4].dst = 3;
        graph.edges[4].weight = 4;

        graph.findKruskalMST();
     }

}
