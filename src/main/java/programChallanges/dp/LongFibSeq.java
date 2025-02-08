package programChallanges.dp;

import java.util.HashMap;

public class LongFibSeq {
	 public int solve(int[] A) {
		// Initialize the unordered map
		    HashMap<Integer,Integer>m = new HashMap<>();
		    int N = A.length, res = 0;
		 
		    // Initialize dp table
		    int[][] dp = new int[N][N];
		 
		    // Iterate till N
		    for (int j = 0; j < N; ++j)
		    {
		      m.put(A[j], j);
		      for (int i = 0; i < j; ++i)
		      {
		 
		        // Check if the current integer
		        // forms a fibonacci sequence
		        int k = m.containsKey(A[j] - A[i])? m.get(A[j] - A[i]):-1;
		 
		        // Update the dp table
		        dp[i][j] = (A[j] - A[i] < A[i] && k >= 0)
		          ? dp[k][i] + 1
		          : 2;
		        res = Math.max(res, dp[i][j]);
		      }
		    }
		 
		    // Return the answer
		    return res > 2 ? res : 0;
	    }
	 public static void main(String[] args) {
		int a[]= {1, 3, 7, 11, 12, 14, 18};
		LongFibSeq l = new LongFibSeq();
		System.out.println(l.solve(a));
	}

}
