package algorithm.sort.insertionsort;


public class InsertionSortArray {

	public static void main(String[] args) {
		int[] a = new int[] { 5, 0, 2, 6, 1 };

		InsertionSortArray is = new InsertionSortArray();
		is.printArray(a);
		is.insertionSort(a);
	}

	public void printArray(int[] a) {
		for (int i = 0; i < a.length; i++)
			System.out.print(" " + a[i]);
		System.out.println("");

	}

	private void insertionSort(int[] a) {

		int temp = 0;
		int j = 0;
		for (int i = 0; i < a.length; i++) {
			temp = a[i];
			j = i;

			while (j > 0 && temp < a[j - 1]) {
				a[j] = a[j - 1];
				j--;
				// print on every swap
				printArray(a);
			}

			a[j] = temp;
			printArray(a);

		}

	}

}
