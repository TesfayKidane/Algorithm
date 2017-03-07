package algorithm.kthelement;


public class KthMinElement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		KthMinElement kthMaxEle = new KthMinElement();
		int[] a = new int[] { 3, 5, 4, 6};// 0, 7, 9, 2, 8, 1 };
		
		for(int i = 0 ; i < a.length; i++){
			System.out.print(" " + a[i]);
		}
		System.out.println("");
		System.out.println(kthMaxEle.findKthMinimum(a, 3));
		
		for(int i = 0 ; i < a.length; i++){
			System.out.print(" " + a[i]);
		}
	}
	
	public int findKthMinimum(int[] nums, int k) {
		if (k < 1 || nums == null) {
			return 0;
		}
	 
		return getKth(k, nums, 0, nums.length - 1);
	}
	 
	public int getKth(int k, int[] nums, int start, int end) {
	 
		int pivot = nums[end];
	 
		int left = start;
		int right = end;
	 
		while (true) {
	 
			while (nums[left] < pivot && left < right) {
				left++;
			}
	 
			while (nums[right] >= pivot && right > left) {
				right--;
			}
	 
			if (left == right) {
				break;
			}
	 
			swap(nums, left, right);
		}
	 
		swap(nums, left, end);
	 
		if (k == left + 1) {
			return pivot;
		} else if (k < left + 1) {
			return getKth(k, nums, start, left - 1);
		} else {
			return getKth(k, nums, left + 1, end);
		}
	}
	 
	public void swap(int[] nums, int n1, int n2) {
		int tmp = nums[n1];
		nums[n1] = nums[n2];
		nums[n2] = tmp;
	}
}
