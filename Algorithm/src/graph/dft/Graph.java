/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graph.dft;

import java.util.Iterator;
import java.util.LinkedList;

/**
 *
 * @author Tesfay
 */
public class Graph {
    
    int numVertex;
    LinkedList<Integer> adj[] ;
    
    public Graph(int numVertex){
        this.numVertex = numVertex;
        adj = new LinkedList[numVertex];
        
        for(int i = 0 ; i < adj.length; i++){
            adj[i] = new LinkedList();
        }
    }
    
    public void addEdge(int v, int w){
        adj[v].add(w);
    }
    
    public void printDFS(int startVertex){
        // initialize visited of all nodes to false
        boolean[] visited = new boolean[numVertex];        
        DFSUtil(startVertex, visited);
        
    }

    // recursive util function that goes to depth first and print
    private void DFSUtil(int currentVertex, boolean[] visited) {
        
        // set current node as visited
        visited[currentVertex] = true;

        // print current node
        System.out.println(currentVertex);
        // get all adjucent nodes of current node
        
        Iterator<Integer> iterator = adj[currentVertex].listIterator();
        while(iterator.hasNext()){
            int next = iterator.next();
            if(!visited[next]){
                DFSUtil(next, visited);
            }
        }        
    }   
    
    public static void main(String[] args){
    
        Graph g = new Graph(4);
        
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);
        
        g.printDFS(2);
    }
}
