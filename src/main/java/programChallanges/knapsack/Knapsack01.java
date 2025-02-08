package programChallanges.knapsack;

public class Knapsack01 {
	 public int solve(int[] A, int[] B, int C) {
		 int n = A.length;
		 int ans[][]= new int[n+1][C+1];
		 for(int i=0;i<=n;i++) {
			 for(int j=0;j<=C;j++) {
				 if(i==0 || j==0) {
					 ans[i][j]=0;
				 }
				 else {
					 if(j<B[i-1]) {
						 ans[i][j]=ans[i-1][j];
					 }
					 else {
						 ans[i][j]= Math.max(A[i-1]+ans[i-1][j-B[i-1]], ans[i-1][j]);
					 }
				 }
			 }
		 }
		 String a;
		 return ans[n][C];
		 
	    }
	 public static void main(String[] args) {
		 int a[] = {60, 100, 120};
		 int b[] = {10, 20, 30};
		 int c = 8;
		Knapsack01 k= new Knapsack01();
		System.out.println(k.solve(a, b, c));
	}
}
