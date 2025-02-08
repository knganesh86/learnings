package programChallanges.search;

import java.util.Arrays;

public class LowerUpperBound {
	public static int getMinDiff(int a[], int b){
		int left = 0;
		int right = a.length;
		int lower =a[0];
		int upper =a[right-1];
		
		while(left<=right && lower<=b && upper>=b) {
			int mid = (left+right)/2;
			if(a[mid]==b) {
				return 0;
			}
			else if(a[mid]<b){
				lower= a[mid];
				left=mid+1;
			}
			else {
				upper=a[mid];
				right=mid-1;
			}
		}
		return Math.min(Math.abs(upper-b), Math.abs(b-lower));
	}
	public int solve(int A, int B, int[][] C) {
		for(int i=0;i<A;i++) {
			Arrays.sort(C[i]);
		}
		int min = Integer.MAX_VALUE;
		for(int i=0;i<A-1;i++) {
			for(int j=0;j<B;j++) {
				min = Math.min(min, getMinDiff(C[i+1],C[i][j]));
			}
		}
		return min;
    }
	public static void main(String[] args) {
		int a[]= {1,5,10,17,22,30, 45};
		//printLowerUpperBound(a,1);
	}

}
