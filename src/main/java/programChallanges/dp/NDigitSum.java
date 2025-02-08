package programChallanges.dp;

public class NDigitSum {
	 public int solve(int A, int B) {
		 long ans[][]=new long[A+1][B+1];
		 for(int i=1;i<=A;i++) {
			 for(int j=1;j<=B;j++) {
				 if(i==1) {
					 if(j<=9) {
						 ans[i][j]=1;
					 }
					 else {
						 ans[i][j]=0;
					 }
				 }
				 else {
					 for(int k=0;k<=9;k++) {
						 if(j>=k) {
							 ans[i][j]+=ans[i-1][j-k];
							 ans[i][j]+=1000000007;
							 ans[i][j]%=1000000007;
						 }
					 }
				 }
			 }
		 }
		 return (int)ans[A][B];	    
		}
	 public static void main(String[] args) {
		NDigitSum ns= new NDigitSum();
		System.out.println(ns.solve(1, 3));
	}
}
