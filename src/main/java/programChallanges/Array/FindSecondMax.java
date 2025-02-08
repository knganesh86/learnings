package programChallanges.Array;
/**
 * Problem Description
You are given an integer array A. You have to find the second largest element/value in the array or report that no such element exists.


Problem Constraints
1 <= |A| <= 105

0 <= A[i] <= 109



Input Format
The first argument is an integer array A.



Output Format
Return the second largest element. If no such element exist then return -1.



Example Input
Input 1:

 A = [2, 1, 2] 
Input 2:

 A = [2]


Example Output
Output 1:

 1 
Output 2:

 -1 


Example Explanation
Explanation 1:

 First largest element = 2
 Second largest element = 1
Explanation 2:

 There is no second largest element in the array.

 * @author kngan
 *
 */
public class FindSecondMax {
	public static int solve(int[] A) {
        int max = A[0];
        int smax= Integer.MIN_VALUE;
        for(int i=1;i<A.length;i++){
            if(max<A[i]){
               max = A[i];
            }
        }
        for(int i=0;i<A.length;i++) {
        	if(A[i]<max && smax<A[i]) {
        			smax=A[i];
        		}
        }
        if(smax==Integer.MIN_VALUE)
        	return -1;
        return smax;
        
    }
	
	 public int solve2(int[] A) {
         int max = A[0];
       int smax= -1;
       for(int i=1;i<A.length;i++){
           if(max<A[i]){
              max = A[i];
           }
       }
       for(int i=0;i<A.length;i++) {
       	if(A[i]<max && smax<A[i]) {
       			smax=A[i];
       		}
       }
        
       return smax;
   }
	public static void main(String[] args) {
		int a[] = { 13, 7, 16, 18, 14, 17, 18, 8, 10 };
		System.out.println(solve(a));
	}

}
