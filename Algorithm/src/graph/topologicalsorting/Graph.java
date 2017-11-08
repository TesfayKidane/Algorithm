package graph.topologicalsorting;

import java.util.LinkedList;
import java.util.*;
/**
 * Tesfay
 * 11/2017
 *
 **/

public class Graph {


    int V; // number of vertex
    LinkedList<Integer>[] adj ;

    Graph(int V){
        this.V = V;
        adj = new LinkedList[V];
        for(int i = 0 ; i < V; i++){
            adj[i] = new LinkedList();
        }
    }

    public void addEdge(int v, int w){
        adj[v].add(w);
    }

    public void topologicalSort(){

        // visited nodes
        boolean[] visited = new boolean[V];
        for(int i = 0; i < V; i++){
            visited[i] = false;
        }
        // topology order
        Stack stack = new Stack();

        // call topological sorting for every node
        for(int i = 0 ; i < V; i++){
            if(!visited[i])
                topologicalUtil(i, visited, stack);
        }

        // pop nodes from stack and print
        while(!stack.isEmpty()){
            System.out.println(stack.pop());
        }
    }

    private void topologicalUtil(int v, boolean[] visited, Stack stack) {

        visited[v] = true;

        Iterator<Integer> iterator = adj[v].listIterator();
        while(iterator.hasNext()){
            int n = iterator.next();
            if (!visited[n])
                topologicalUtil(n,visited,stack);
        }

        // push to stack
        stack.push(v);
    }

    public static void main(String[] args){
        Graph g = new Graph(6);
        g.addEdge(5, 2);
        g.addEdge(5, 0);
        g.addEdge(4, 0);
        g.addEdge(4, 1);
        g.addEdge(2, 3);
        g.addEdge(3, 1);

        System.out.println("Following is a Topological " +
                "sort of the given graph");
        g.topologicalSort();
    }


}
