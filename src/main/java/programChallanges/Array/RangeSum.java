package programChallanges.Array;
/**
 * Problem Description
You are given an integer array A of length N.
You are also given a 2D integer array B with dimensions M x 2, where each row denotes a [L, R] query.
For each query, you have to find the sum of all elements from L to R indices in A (1 - indexed).
More formally, find A[L] + A[L + 1] + A[L + 2] +... + A[R - 1] + A[R] for each query.



Problem Constraints
1 <= N, M <= 103
1 <= A[i] <= 105
1 <= L <= R <= N


Input Format
The first argument is the integer array A.
The second argument is the 2D integer array B.


Output Format
Return an integer array of length M where ith element is the answer for ith query in B.


Example Input
Input 1:
A = [1, 2, 3, 4, 5]
B = [[1, 4], [2, 3]]
Input 2:

A = [2, 2, 2]
B = [[1, 1], [2, 3]]


Example Output
Output 1:
[10, 5]
Output 2:

[2, 4]


Example Explanation
Explanation 1:
The sum of all elements of A[1 ... 4] = 1 + 2 + 3 + 4 = 10.
The sum of all elements of A[2 ... 3] = 2 + 3 = 5.
Explanation 2:

The sum of all elements of A[1 ... 1] = 2 = 2.
The sum of all elements of A[2 ... 3] = 2 + 2 = 4.

 * @author kngan
 *
 */
public class RangeSum {
	public int[] solve(int[] A, int[][] B) {
        int sum[] = new int[B.length];
        for(int i=0;i<B.length;i++){
            int start =B[i][0] -1;
            int end = B[i][1]-1;
            sum[i]=0;
            while(start<=end)
            {
                sum[i]+=A[start++];
            }
        }
        return sum;
    }
	
	 public static long[]  rangeSum(int[] A, int[][] B) {
	        long resultArray[] = new long[B.length];
	        long prefixArray[] = new long[A.length];
	        prefixArray[0]=A[0];
	        for(int i=1;i<A.length; i++) {
	            prefixArray[i]=prefixArray[i-1]+A[i];
	            System.out.print(prefixArray[i]+" ");
	        }
	        System.out.println("\n Result");
	        for(int j=0;j<B.length;j++){
	        	System.out.print(j+"-->");
	       	        	
	            int start = B[j][0]-1;
	            int end = B[j][1]-1;
	            if(start !=0){
	                resultArray[j]= prefixArray[end]-prefixArray[start-1];
	            } 
	            else {
	                resultArray[j]=prefixArray[end];
	            }
	            System.out.print(resultArray[j]+" ");
	        }
	        return resultArray;
	    }
	 public static void main(String[] args) {
		int A[] = {7, 3, 1, 5, 5, 5, 1, 2, 4, 5};
		int B[][] = {{7, 10},  {3, 10},  {3, 5},  {1, 10}};
		rangeSum(A, B);
				
	}
}
