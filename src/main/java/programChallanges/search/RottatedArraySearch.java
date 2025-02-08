package programChallanges.search;

public class RottatedArraySearch {

	 public int search(final int[] A, int B) {
		 int idx = getLargestElementIdx(A);
		 if(B<A[0]) {
			 return search(A, idx+1, A.length-1, B);
		 }
		 else {
			 return search(A, 0, idx, B);
		 }
	    }
	private int getLargestElementIdx(int A[]) {
		int n = A.length;
		int l = 0;
		int r = n-1;
		int mid = 0;
		while(l<=r) {
			mid = l+(r-l)/2;
			if(l==r) {
				break;
			}
			if(mid==0 && A[mid]>A[mid+1]) {
				break;
			}
			if(mid<r && mid>0 && A[mid]>A[mid-1]&& A[mid]>A[mid+1]) {
				break;
			}
			if(A[l]>A[mid]) {
				r=mid-1;
			}
			else {
				l=mid+1;
			}
		}
		return mid;
	}
	private int search(int a[], int l, int r, int e) {
		if(l>r) {
			return -1;
		}
		int mid = l+(r-l)/2;
		if(a[mid]==e) {
			return mid;
		}
		else if(a[mid]>e) {
			return search(a, l,mid-1, e);
		}
		else {
			return search(a, mid+1,r, e);
		}
	}
	
	
	public static void main(String[] args) {
		RottatedArraySearch r = new RottatedArraySearch();
		int a[]= {11,22,33,44, 7, 8, 9};
		System.out.println(r.search(a,10));
	}
}
