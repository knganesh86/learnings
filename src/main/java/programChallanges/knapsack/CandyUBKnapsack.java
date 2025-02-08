package programChallanges.knapsack;

public class CandyUBKnapsack {
	 public int solve(int A[], int[] B, int[] C, int D) {
		 int ans[] = new int[D+1];
		 for(int i=1;i<=D;i++) {
			 for(int j=0;j<B.length;j++) {
				 if(i>=C[j]) {
					 ans[i]= Math.max(ans[i], (B[j]*A[j])+ans[i-C[j]]);
				 }
			 }
		 }
		 return ans[D];
	    }
	 public static void main(String[] args) {
		 int a[]= {1,2,3};
		 int b[] = {2,2,10};
		 int c[] = {2,3,9};
		 int d = 8;
		 CandyUBKnapsack k= new CandyUBKnapsack();
		System.out.println(k.solve(a, b,c,d));
	}
}
