/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithm.recursion;

import java.io.File;

/**
 * Calculates the total disk usage (in bytes) of the portion of the file system rooted
 * at the given path, while
 * @author Tesfay
 */
public class DiskUsage {
    
    public static long diskUsage(File root){
        long total = root.length();
        if(root.isDirectory()){
            for(String childname : root.list()){
                File child = new File(root, childname);
                total += diskUsage(child);
            }
        }
        
        System.out.println(total + "\t" + root);
        return total;
    }
}
