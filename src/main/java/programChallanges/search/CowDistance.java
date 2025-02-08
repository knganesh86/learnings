package programChallanges.search;

import java.util.Arrays;

public class CowDistance {
	public int solve(int[] A, int B) {
		Arrays.sort(A);
		int l =1;
		int n = A.length;
		int r = A[n-1]-A[0];
		int ans =0;
		while(l<=r) {
			int mid = (l+r)/2;
			if(check(A, mid,B)) {
				ans=mid;
				l=mid+1;
				
			}
			else {
				r=mid-1;
			}
		}
		return ans;
		
    }

	private boolean check(int[] a, int mid, int b) {
		int lp=a[0];
		int c=1;
		for(int i=1;i<a.length;i++) {
			if(a[i]-lp>=mid) {
				c++;
				lp=a[i];
				if(c==b) {
					return true;
				}
			}
		}
		return false;
	}
	public static void main(String[] args) {
		CowDistance c= new CowDistance();
		int a[]= {5,17,100,11};
		System.out.println(c.solve(a, 2));
		
	}
}
