package programChallanges.knapsack;

public class BirthdayPartyUBKnapsack {
	 public int solve(final int[] A, final int[] B, final int[] C) {
		 int max=0;
		 for(int a:A) {
			 max= Math.max(a, max);
		 }
		 int ans[] = new int[max+1];
		 for(int i=1;i<=max;i++) {
			 ans[i]=Integer.MAX_VALUE;
		 }
		 for(int i=1;i<=max;i++) {
			 for(int j=0;j<B.length;j++) {
				 if(i>=B[j]) {
					 int value = Integer.MAX_VALUE;
					 if(ans[i-B[j]]!=Integer.MAX_VALUE) {
						 value = C[j]+ans[i-B[j]];
					 }
					 ans[i]= Math.min(ans[i],value);
				 }
			 }
		 }
		 int result = 0;
		 for(int i=0;i<A.length;i++) {
			 result+=ans[A[i]];
		 }
		 return result;
	    }
	 public static void main(String[] args) {
		 int a[] = {2,3,1,5,4};
		 int b[] = {3,2,4,1};
		 int c[] = {1,2,5,10};
		 BirthdayPartyUBKnapsack k= new BirthdayPartyUBKnapsack();
		System.out.println(k.solve(a, b,c));
	}
}
