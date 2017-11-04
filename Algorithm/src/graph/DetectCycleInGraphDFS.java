/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 * Source (C++) : http://www.geeksforgeeks.org/detect-cycle-in-a-graph/
 */
package graph;

import java.util.Iterator;
import java.util.LinkedList;

/**
 *
 * @author Tesfay
 */
public class DetectCycleInGraphDFS {
    
    int numVertex;
    LinkedList<Integer>[] adj;
    public DetectCycleInGraphDFS(int numVertex){
        this.numVertex = numVertex;
      adj = new LinkedList[numVertex];
      for(int i = 0 ; i < adj.length; i++){
          adj[i] = new LinkedList<>();
      }
    }
    
    public void addEdge(int u, int w){
        adj[u].add(w);
    }
    
    public boolean isCyclic(){
        boolean[] visited = new boolean[numVertex];
        boolean[] recursionStack = new boolean[numVertex];
        
        for(int i = 0 ; i < numVertex; i++){
            if(isCyclicUtil(i,visited,recursionStack))
                return true;
        }
        return false;
    }
    private boolean isCyclicUtil(int v, boolean[] visited, boolean[] recursionStack) {
       
        if(!visited[v]){
                visited[v] = true;
                recursionStack[v] = true;
                // check if any of the adjacent nodes create cycle
                Iterator<Integer> iterator = adj[v].listIterator();
                while(iterator.hasNext()){
                    int next = iterator.next();
                    if(!visited[next] && isCyclicUtil(next, visited, recursionStack))
                        return true;
                    else if(recursionStack[v])
                        return true;
                }
        }
        recursionStack[v] = false;
        return false;
    }
    
    
    public static void main(String[] args){
    
        DetectCycleInGraphDFS g = new DetectCycleInGraphDFS(4);
        
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);
        
        System.out.println(g.isCyclic());
    }
  
}
