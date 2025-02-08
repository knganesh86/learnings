package programChallanges.dp;

public class CoinProblem {
	
	 public int coinchange2(int[] A, int B) {
	        int ans[]= new int[B+1];
	        ans[0]=1;
	        for(int i=0;i<A.length;i++){
	            for(int j=A[i];j<=B;j++){
	                    ans[j]+=ans[j-A[i]];
	                    ans[j]%=1000007;
	            }
	        }
	        return ans[B];
	    }
	 
	 public static void main(String[] args) {
		CoinProblem c = new CoinProblem();
		int a[]= {1,2,3};
		
		System.out.println(c.coinchange2(a, 3));
	}

}
