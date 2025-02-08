package programChallanges.Array;
/**
 * Problem Description
Given an integer array A of size N and an integer B, you have to return the same array after rotating it B times towards the right.


Problem Constraints
1 <= N <= 105
1 <= A[i] <=109
1 <= B <= 109


Input Format
The first argument given is the integer array A.
The second argument given is the integer B.


Output Format
Return the array A after rotating it B times to the right


Example Input
Input 1:

A = [1, 2, 3, 4]
B = 2
Input 2:

A = [2, 5, 6]
B = 1


Example Output
Output 1:

[3, 4, 1, 2]
Output 2:

[6, 2, 5]


Example Explanation
Explanation 1:

Rotate towards the right 2 times - [1, 2, 3, 4] => [4, 1, 2, 3] => [3, 4, 1, 2]
Explanation 2:

Rotate towards the right 1 time - [2, 5, 6] => [6, 2, 5]
 * @author kngan
 *
 */
public class RotateArray {
	 public int[] solve(int[] A, int B) {
	        B=B%A.length;
	        rotate(A,0,A.length-1);
	        rotate(A,0,B-1);
	        rotate(A,B,A.length-1);
	        return A;
	    }

	    public void rotate(int[] A, int B, int C) {
	        int start = B;
	        int end =C;
	        while(start<end){
	            int temp = A[start];
	            A[start] = A[end];
	            A[end] = temp;
	            start++;
	            end--;
	        }       
	    }

}
