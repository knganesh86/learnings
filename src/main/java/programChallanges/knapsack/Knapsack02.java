package programChallanges.knapsack;

public class Knapsack02 {
	 public int solve(int[] A, int[] B, int C) {
		 int n = A.length;
		 int maxval=0;
		 for(int i=0;i<n;i++) {
			 maxval+=A[i];
		 }
		 int ans[]= new int[maxval+1];
		 for(int i=1;i<maxval+1;i++) {
			 ans[i]=Integer.MAX_VALUE;
		 }
		 for(int i=0;i<n;i++) {
			 for(int j=maxval;j>=A[i];j--) {
				 	int value1= ans[j-A[i]];
				 	if(ans[j-A[i]]!=Integer.MAX_VALUE) {
				 		value1+=B[i];
				 	}
					 ans[j]= Math.min(value1, ans[j]);
			 }
		 }
		 int result =0;
		 for(int i=maxval;i>=0;i--) {
			 if(ans[i]<=C) {
				 result= i;
				 break;
			 }
		 }
		 return result;
		 
	    }
	 public static void main(String[] args) {
		 int a[] = {1, 3, 2, 4};
		 int b[] = {12, 13, 15, 19};
		 int c = 10;
		Knapsack02 k= new Knapsack02();
		System.out.println(k.solve(a, b, c));
	}
}
