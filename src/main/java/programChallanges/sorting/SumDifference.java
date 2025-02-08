package programChallanges.sorting;

import java.util.Arrays;

public class SumDifference {
	public int solve(int[] A) {
	     
	        //int result[] = sortArray(A);
	        Arrays.sort(A);
	       long maxSum =0l;
	        long minSum =0l;
	        for(int i=0;i<A.length;i++){
	            maxSum+= ((long)A[i]*(fastPower(2l,(long)i, 1000000007l)))%1000000007l;
	             minSum+= ((long)A[i]*(fastPower(2l,(long)A.length-i-1, 1000000007l)))%1000000007l;
	            maxSum%=1000000007;
	           
	           
	           minSum%=1000000007;
	        }
	        
	        return (int)(maxSum-minSum);
	    }
	
	    public long fastPower(long a, long b, long m){
	        if(b==0){
	            return 1;
	        }
	        if(b%2==0){
	            return fastPower((a*a)%m, b/2,m);
	        }
	        else{
	            return (a*fastPower((a*a)%m, b/2,m))%m;
	        }
	    }
	
}

