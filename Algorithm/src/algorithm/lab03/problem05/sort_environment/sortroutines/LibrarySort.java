package algorithm.lab03.problem05.sort_environment.sortroutines;

import java.util.Arrays;

import algorithm.lab03.problem05.sort_environment.runtime.Sorter;
import util.Util;

/*//FROM Bender-Colton-Mosteiro's Paper on Library Sort
 * Let A be an n-element array to be sorted. These elements are inserted one at a time in random order into a
sorting array S of size (1+epsilon)n. The insertions proceed in log n rounds as follows. Each round doubles the
number of elements inserted into S and doubles the prefix of S where elements reside. Specifically, round
i ends when element 2^i is inserted and the elements are rebalanced. Before the rebalance, the 2^i elements
are in the first (1+epsilon)2^i positions. A rebalance moves them into the first (2+2epsilon)2^i positions, 
spreading the elements as evenly as possible. We call 2 + 2epsilon the spreading factor.

During the ith round, the 2^(i-1) elements in S at the beginning of the round are called support elements,
and their initial positions are called support positions. The 2^(i-1) elements inserted before the end-of-round
rebalance are called intercalated elements.

The insertion of 2^(i-1) intercalated elements within round i is performed the brute force way: search for
the target position of the element to be inserted by binary search (amongst the 2^(i-1) support positions in S),
and move elements of higher rank to make room for the new element. Not all elements of higher rank need
to be moved, only those in adjacent array positions until the nearest gap is found.
 */
/* algorithm
 *    numvals=1
 *    numslots=2
 *    
 *    for each round i
 *    	insert numvals new elements into slots 0..numslots-1
 *         to do this: for each new val, do binary search to find right place
 *                     scoot current vals to right to accommodate
 *      numslots *= 2
 *      spreadout existing elements into 0..numslots-1
 *      numvals *= 2 
 */
public class LibrarySort extends Sorter {
	private int[] retVal;
	private int[] storage;
	private int[] currPositions;
	private int[] input;
	private int rounds;
	//current position in input array as we process elements
	private int posInInputArray;
	//num vals to read on next pass
	private int numVals; 
	//num slots in use in storage array
	private int numSlots;
	//we make use of optimizations possible when epsilon=1
	//private double epsilon = 1.0;
	
	private void initialize() {
		//if input is not random, do this
		//input=RandomPermutations.permute(input);
		int n = input.length;
		retVal = new int[n];
		int newlength = 2*n;
		storage = new int[newlength];
		//highest power of 2 not greater than n
		rounds = (int)(Math.floor(Util.log2(n)));
		
		currPositions = new int[newlength];
		//insert 0th element
		currPositions[0] = 1;
		storage[0] = input[0];
		numVals = 1;
		numSlots=2;
		posInInputArray=1;
	}
	
	public int[] sort(int[] arr){
		this.input = arr;
		initialize();

		for(int r = 0; r < rounds; ++r) {
			
			insertNewElements();
			
			numSlots *= 2;
			rebalance();
			numVals *= 2;
		}
		//insert remaining elements from
		//2^rounds to 2n-1
		insertRemainingElements();
		
		//squeeze into retVal array
		compactify();
		
		return retVal;
		
		
	}
	private int nearestGap(int pos) {
		for(int i = 0; i < storage.length; ++i) {
			if(currPositions[pos+i] != 1) return pos+i;
		}
		return -1;
	}
	private void insertIntoPos(int element, int pos) {
		int posOfNextGap = nearestGap(pos);
		for(int j =posOfNextGap; j> pos; j--){
			
			storage[j]= storage[j-1];
			currPositions[j]=1;
		}
		//now position at pos is open
		storage[pos]=element;
		currPositions[pos]=1;
	}
	private void insertRemainingElements() {
		for(int i= posInInputArray; i < input.length; ++i){
			int pos = binarySearchStorage(0,numSlots-1, input[i]);
			insertIntoPos(input[i],pos);
		}
		
				
	}

	private void insertNewElements() {
		
		for(int i= posInInputArray; i < 2*posInInputArray; ++i){
			int pos = binarySearchStorage(0,numSlots-1, input[i]);
			insertIntoPos(input[i],pos);
		}
		
		posInInputArray = 2*posInInputArray;
	}
	private int nearest(int y) {
		if(currPositions[y] ==1) return y;
		for(int i = 0; i < (storage.length>>1); ++i){
			if(currPositions[y-i]==1) return y-i;
			if(currPositions[y+i]==1) return y+i;
		}
		return -1;
	}
	//return position in which element should be inserted
	private int binarySearchStorage(int lower, int upper, int element) {
		if(lower > upper) {
			if(currPositions[upper] != 1) return upper;
			else return lower;
		}
		int midOrig = (upper+lower)/2;
		int mid = nearest(midOrig);
		if(storage[mid] == element ){
			return mid;
		}
		if(element < storage[mid] && mid==0){
			return mid;
		}
		else if(element < storage[mid] && mid >0){
			return binarySearchStorage(lower,midOrig-1,element);
		}
		return binarySearchStorage(midOrig+1,upper,element);
	}
	private void rebalance() {
		int currpos = numSlots-2;
		//place all values on even-numbered slots
		for(int i = (numSlots)-1; i >=0; i--){
			if(currPositions[i]==1) {
				storage[currpos] = storage[i];
				currpos -= 2;
			}
		}
		//update currPositions array to reflect new state
		for(int j=0; j < numSlots; ++j) {
			if((j&1)==0) currPositions[j]=1;
			else currPositions[j]=0;
		}
	}
	private void compactify() {
		int j = 0;
		for(int i = 0; i < storage.length; ++i) {
			if(currPositions[i] == 1) {
				retVal[j++]=storage[i];
			}
		}
	}
	

	
	public static void main(String[] args) {
		LibrarySort ls = new LibrarySort();
		int[] arr = {1,11,5,4, 3,6,7};
		int[] result = ls.sort(arr);
		System.out.println(Arrays.toString(result));
		/*
		System.out.println(1<<2);
		for(int i = 0; i < 10;++i){
			System.out.println(i & 1);
		}*/
	}
}
