package programChallanges.Array;
/**
 * Problem Description
Given an array A of size N. You need to find the sum of Maximum and Minimum element in the given array.


Problem Constraints
1 <= N <= 105
-109 <= A[i] <= 109


Input Format
First argument A is an integer array.


Output Format
Return the sum of maximum and minimum element of the array


Example Input
Input 1:

A = [-2, 1, -4, 5, 3]
Input 2:

A = [1, 3, 4, 1]


Example Output
Output 1:

1
Output 2:

5


Example Explanation
Explanation 1:

Maximum Element is 5 and Minimum element is -4. (5 + (-4)) = 1. 
Explanation 2:

Maximum Element is 4 and Minimum element is 1. (4 + 1) = 5.
 * @author kngan
 *
 */
public class SumOfMaxMin {
	public int solve(int[] A) {
        int max = A[0];
        int min =A[0];
        for(int i=1;i<A.length;i++){
            if(max<A[i]){
                max=A[i];
            }
            if(min>A[i]){
                min=A[i];
            }

        }
        return max+min;
    }

}
