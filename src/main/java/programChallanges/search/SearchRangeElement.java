package programChallanges.search;

public class SearchRangeElement {
	public int[] solve(int[] A, int B) {
		int n = A.length;
		int l = 0;
		int r = n-1;
		int result [] = new int[2];
		while(l<=r) {
			int mid =(l+r)/2;
			if(A[mid]==B) {
				if(mid==0 || A[mid-1]!=A[mid]) {
					result[0]=mid;
				}
				else {
					int le=mid;
					while(l<=le) {
						int m=(l+le)/2;
						if(A[m]==B && (m==0 ||  A[m-1]!=A[m])) {
							result[0]=m;
							break;
						}
						if(A[m]<B) {
							l=m+1;
						}
						else {
							le=m-1;
						}
					}
				}
				if(mid==n-1 || A[mid+1]!=A[mid]) {
					result[1]=mid;
				}
				else {
					int rs=mid;
					while(rs<=r) {
						int m=(rs+r)/2;
						if(A[m]==B &&(m==n-1 || A[m+1]!=A[m])) {
							result[1]=m;
							break;
						}
						if(A[m]<=B) {
							rs=m+1;
						}
						else {
							r=m-1;
						}
					}
				}
				return result;
			}
			if(A[mid]>B) {
				
					r = mid-1;
				
			}
			else {
				
					l=mid+1;
				
			}
		}
		result[0]=-1;
		result[1]=-1;
		return result;
    }
	public static void main(String[] args) {
		SearchRangeElement se = new SearchRangeElement();
		int a[]= { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 8, 8, 8, 8, 8, 8, 8, 8, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10};
		int r[]=se.solve(a,10);
		System.out.println(r[0]);
		System.out.println(r[1]);
	}
}
