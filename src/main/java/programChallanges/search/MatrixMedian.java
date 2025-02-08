package programChallanges.search;

public class MatrixMedian {
	public int findMedian(int[][] A) {
		int l=0;
		int r=0;
		int n = A.length;
		int m = A[0].length;
		int mid = ((n*m)+1)/2;
		int req= mid;
		for(int i =0;i<n;i++) {
			r= Math.max(r, A[i][m-1]);
		}
		int ans =-1;
		while(l<=r) {
			mid=(l+r)/2;
			int count=0;
			for(int i=0;i<n;i++) {
				count+=getCount(A[i], mid);
			}
			if(count>=req) {
				ans=mid;
				r=mid-1;
			}
			else {
				l=mid+1;
			}
		}
		return ans;
		
    }

	private int getCount(int[] A, int x) {
		int i=0;
		int j = A.length-1;
		int ans=-1;
		while(i<=j) {
			int m=(i+j)/2;
			if(A[m]>x) {
				ans=m;
				j=m-1;
				
			}
			else {
				i=m+1;
			}
		}
		if(ans==-1) {
			return A.length;
		}
		return ans;
	}
	public static void main(String[] args) {
		MatrixMedian ms = new MatrixMedian();
		int a[][]= {{1,7,20,78}};
//				{2,6,9},
//				{3,6,9}
//					};
		System.out.println(ms.findMedian(a));
	}
}
