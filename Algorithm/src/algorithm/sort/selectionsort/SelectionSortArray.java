package algorithm.sort.selectionsort;


public class SelectionSortArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = new int[]{4,2,5,6};
		
		for(int i = 0 ; i < a.length; i++) System.out.print(" " + a[i]);
		SelectionSortArray ss = new SelectionSortArray();
		ss.selectionSort(a);
		System.out.println("");
		for(int i = 0 ; i < a.length; i++) System.out.print(" " + a[i]);
	}

	public void selectionSort(int[] s) {
		int end = s.length-1;
		for (int i = 0; i <= end; ++i) {
			int minPos = getMinPosition(s, i, end);
			
			swap(s, i, minPos);
		}

	}

	private void swap(int[] s, int i, int minPos) {
		// TODO Auto-generated method stub
		int temp = s[i];
		s[i] = s[minPos];
		s[minPos] = temp;
	}

	private int getMinPosition(int[] a, int bottom, int end) {
		// TODO Auto-generated method stub
		int min = a[bottom];
		int minPosition = bottom;

		for (int i = bottom + 1; i <= end; ++i) {
			if (a[i] < min) {
				min = a[i];
				minPosition = i;
			}

		}

		return minPosition;
	}

}
