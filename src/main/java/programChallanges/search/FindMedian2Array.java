package programChallanges.search;

import java.util.Arrays;
import java.util.List;

public class FindMedian2Array {
	public double findMedianSortedArrays(final List<Integer> a, final List<Integer> b) {
		int n = a.size();
		int m = b.size();
		if (n > m)
			return findMedianSortedArrays(b, a); // Swapping to make A smaller

		int start = 0;
		int end = n;
		int realmidinmergedarray = (n + m + 1) / 2;

		while (start <= end) {
			int mid = (start + end) / 2;
			int leftAsize = mid;
			int leftBsize = realmidinmergedarray - mid;
			int leftA = (leftAsize > 0) ? a.get(leftAsize - 1) : Integer.MIN_VALUE; // checking overflow
																					// of indices
			int leftB = (leftBsize > 0) ? b.get(leftBsize - 1) : Integer.MIN_VALUE;
			int rightA = (leftAsize < n) ? a.get(leftAsize) : Integer.MAX_VALUE;
			int rightB = (leftBsize < m) ? b.get(leftBsize) : Integer.MAX_VALUE;

			// if correct partition is done
			if (leftA <= rightB && leftB <= rightA) {
				if ((m + n) % 2 == 0)
					return (Math.max(leftA, leftB) + Math.min(rightA, rightB)) / 2.0;
				return Math.max(leftA, leftB);
			} else if (leftA > rightB) {
				end = mid - 1;
			} else
				start = mid + 1;
		}
		return 0.0;
	}
	public static void main(String[] args) {
		Integer a[]= {4};
		Integer b[] = {1,2,3};
		FindMedian2Array fa = new FindMedian2Array();
		List<Integer> list1 = Arrays.asList(a);
		List<Integer> list2 = Arrays.asList(b);
		System.out.println(fa.findMedianSortedArrays(list1, list2));
	}

}
