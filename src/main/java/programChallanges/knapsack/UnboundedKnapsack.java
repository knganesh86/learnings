package programChallanges.knapsack;

public class UnboundedKnapsack {
	 public int solve(int A, int[] B, int[] C) {
		 int ans[] = new int[A+1];
		 for(int i=1;i<=A;i++) {
			 for(int j=0;j<B.length;j++) {
				 if(i>=C[j]) {
					 ans[i]= Math.max(ans[i], B[j]+ans[i-C[j]]);
				 }
			 }
		 }
		 return ans[A];
	    }
	 public static void main(String[] args) {
		 int a[] = {5};
		 int b[] = {10};
		 int c = 10;
		 UnboundedKnapsack k= new UnboundedKnapsack();
		System.out.println(k.solve(c, a, b));
	}
}
