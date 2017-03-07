import java.util.Arrays;

public class QuickSortArray {
	public static void main(String[] args) {

		int[] a = new int[] { 3, 5, 4, 6, 0, 7, 9, 2, 8, 1 };
		QuickSortArray quickSort = new QuickSortArray();
		for (int i = 0; i < a.length; i++) {
			System.out.print(" " + a[i]);
		}

		System.out.println();
		int r[] = quickSort.quickSort(a);
		for (int i = 0; i < r.length; i++) {
			System.out.print(" " + r[i]);
		}

	}

	public int[] quickSort(int[] s) {

		System.out.println("Self Call");
		for (int i = 0; i < s.length; i++) {
			System.out.print(" " + s[i]);
		}
		System.out.println("");
		int sLen = s.length;

		if (sLen < 2) // if array contains 1 or less element, it's sorted inherently. 
			return s;

		int lIndex = 0, eIndex = 0, gIndex = 0;

		int pivot = s[0];

		int[] l = new int[sLen];
		int[] e = new int[sLen];
		int[] g = new int[sLen];

		// divide
		for (int i = 0; i < sLen; i++) {
			if (s[i] < pivot) {
				l[lIndex] = s[i];
				lIndex++;

			} else if (s[i] > pivot) {
				g[gIndex] = s[i];
				gIndex++;
			} else {
				e[eIndex] = s[i];
				eIndex++;
			}
		}

		// conqure		
		l = quickSort(Arrays.copyOf(l, lIndex));
		e = quickSort(Arrays.copyOf(e, eIndex));
		g = quickSort(Arrays.copyOf(g, gIndex));

		System.out.println("Cominer call");

		// combine
		int[] result = Arrays.copyOf(l, l.length + e.length + g.length);
		System.arraycopy(e, 0, result, l.length, e.length);
		System.arraycopy(g, 0, result, l.length + e.length, g.length);
		
		return result;
	}
}
