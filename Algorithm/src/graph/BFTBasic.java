/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 * Source : http://www.geeksforgeeks.org/breadth-first-traversal-for-a-graph/
 */
package graph;

import java.util.Iterator;
import java.util.LinkedList;

/**
 *
 * @author Tesfay
 */
public class BFTBasic {
    
    int numVertex; 
    LinkedList<Integer> adj[]; // list of adjuscent nodes for each vertex
    
    public BFTBasic(int numVertex){
        this.numVertex = numVertex;        
        this.adj = new LinkedList[numVertex];
        
        // initialize adjucent nodes
        for(int i = 0 ; i < adj.length; i++){
            adj[i] = new LinkedList();
        }
    }
    
    // method to add Edge between nodes
    public void addEdge(int v, int w){
        adj[v].add(w);
    }
    
    // method to traverse in BFS way and print elements.
    public void printBFT(int startVertex){
        
        // first set all nodes to not visited
        boolean visited[] = new boolean[numVertex];
        
        // create a queue to keep track of visited nodes and their adjucent nodes
        LinkedList<Integer> queue = new LinkedList<>();
        
        // set the start node to visted
        visited[startVertex] = true;
        // enqueue current node to queue
        queue.add(startVertex);
                
        // go through the queue, dequeue, print and add it's adjucent nodes the queueu.
        while(!queue.isEmpty())
        {
             // dequeu node from queue
            startVertex = queue.poll();
            System.out.println(startVertex);
            
            // get all adjustent nodes of current node
            Iterator<Integer> iterator = adj[startVertex].listIterator();
            while(iterator.hasNext()){
                int next = iterator.next();
                if(!visited[next]){
                    visited[next] = true;
                    queue.add(next);
                }
            }        
        }     
    }
    
    public static void main(String[] args){
    
        BFTBasic g = new BFTBasic(4);
        
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);
        
        g.printBFT(2);
    }
    
}
