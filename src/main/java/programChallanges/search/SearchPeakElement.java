package programChallanges.search;

public class SearchPeakElement {
	public int solve(int[] A) {
		int n = A.length;
		int l = 0;
		int r = n-1;
		int mid =r;
		while(l<=r) {
		
			if((mid==0 || A[mid-1]<A[mid])&& (mid==n-1|| A[mid]>A[mid+1])) {
				break;
			}
			if(mid>0 &&A[mid]<A[mid-1]) {
				r = mid-1;
					
			}
			else {
				l=mid+1;
					
			}
		}
		return A[mid];
    }
	public static void main(String[] args) {
		SearchPeakElement se = new SearchPeakElement();
		int a[]= {4,2};
		System.out.println(se.solve(a));
	}
}
