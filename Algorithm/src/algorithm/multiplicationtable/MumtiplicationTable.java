/*
 * Print out the grade-school multiplication table up to 12x12
 */
package algorithm.multiplicationtable;

/**
 *
 * @author Tesfay
 */
public class MumtiplicationTable {
   
    public static void printMultiplationTable(int x){
        
        for(int k  =1; k<=x ; k++) {
            System.out.print("\t"+k);
        }
        System.out.println("");
        
        for(int i = 1 ; i <= x ; i++){
            System.out.print(i);
            for(int j = 1 ; j <= x ; j++){
                System.out.print("\t"+(i*j));
            }
            System.out.println();
        }
    }
    
    public static void main(String[] args){
        
        printMultiplationTable(12);
    }
}
