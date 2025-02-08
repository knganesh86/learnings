package programChallanges.search;

public class SearchUniqueElement {
	public int solve(int[] A) {
		int n = A.length;
		int l = 0;
		int r = n-1;
		while(l<=r) {
			int mid =(l+r)/2;
			if((mid==0 || A[mid-1]!=A[mid])&& (mid==n-1|| A[mid]!=A[mid+1])) {
				return A[mid];
			}
			if(mid!=0 &&A[mid]==A[mid-1]) {
				if(mid%2==0) {
					r = mid-1;
				}
				else {
					l=mid+1;
				}
			}
			else {
				if(mid%2==0) {
					l=mid+1;
				}
				else {
					r = mid-1;
				}
			}
		}
		return -1;
    }
	public static void main(String[] args) {
		SearchUniqueElement se = new SearchUniqueElement();
		int a[]= {1,2,2};
		System.out.println(se.solve(a));
	}
}
