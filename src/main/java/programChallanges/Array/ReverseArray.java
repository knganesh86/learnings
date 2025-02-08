package programChallanges.Array;

import java.util.Arrays;
/**
 * Problem Description
You are given a constant array A.

You are required to return another array which is the reversed form of the input array.



Problem Constraints
1 <= A.size() <= 10000

1 <= A[i] <= 10000



Input Format
First argument is a constant array A.



Output Format
Return an integer array.



Example Input
Input 1:

A = [1,2,3,2,1]
Input 2:

A = [1,1,10]


Example Output
Output 1:

 [1,2,3,2,1] 
Output 2:

 [10,1,1] 


Example Explanation
Explanation 1:

Reversed form of input array is same as original array
Explanation 2:

Clearly, Reverse of [1,1,10] is [10,1,1]
 * @author kngan
 *
 */
public class ReverseArray {
	
	 // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public static int[] solve(final int[] A) {
    	int B[] = new int[A.length];
    	for(int i=0;i<=A.length/2;i++) {
    		B[i]=A[A.length-1-i];
    		B[A.length-1-i]=A[i];
    	}
    	return B;
        
    }
    public static void main(String[] args) {
		int a[] = {1,2,3,4,5,6,7,8};
		Arrays.stream(solve(a)).forEach(System.out::println);
	
	}

}
