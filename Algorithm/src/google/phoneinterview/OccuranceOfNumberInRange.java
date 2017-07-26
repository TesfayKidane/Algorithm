/*
Given a method 
public int getOccurence(int x,int y); 
where y is always a single digit number. 

So find the number of occurrences of number y in the range x 
E.g. 
if x=25,y=2 
function should return 9(as 22 contains two occurrences of 2) - 2,12,20,21,22,23,24,25
 */
package google.phoneinterview;

/**
 *
 * @author Tesfay
 */
public class OccuranceOfNumberInRange {

    public static void main(String[] args) {
        System.out.println(getOccuranceOfNumberInRange(25, 2));
    }

    public static int getOccuranceOfNumberInRange(int range, int n) {
        int occurance = 0;
        for (int i = 0; i <= range; i++) {
            int p = i*10 + n;
            if (p <= range) {
                int dividen = 0;
                do {
                   dividen = p / 10;

                   if(range % 10 == n) occurance++;
                   
                   range = dividen;
                } while (range > 0);
            }
        }
        return occurance;
    }
}
