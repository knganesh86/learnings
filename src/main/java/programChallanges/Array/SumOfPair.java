package programChallanges.Array;
/**
 * Problem Description
Given an array A and an integer B. A pair(i, j) in the array is a good pair if i != j and (A[i] + A[j] == B). Check if any good pair exist or not.



Problem Constraints
1 <= A.size() <= 104

1 <= A[i] <= 109

1 <= B <= 109



Input Format
First argument is an integer array A.

Second argument is an integer B.



Output Format
Return 1 if good pair exist otherwise return 0.



Example Input
Input 1:

A = [1,2,3,4]
B = 7
Input 2:

A = [1,2,4]
B = 4
Input 3:

A = [1,2,2]
B = 4


Example Output
Output 1:

1
Output 2:

0
Output 3:

1


Example Explanation
Explanation 1:

 (i,j) = (3,4)
Explanation 2:

No pair has sum equal to 4.
Explanation 3:

 (i,j) = (2,3)
 * @author kngan
 *
 */
public class SumOfPair {
	
	 public int solve(int[] A, int B) {
	        for(int i=0;i<A.length-1;i++){
	            for(int j=i+1;j<A.length;j++) {
	                if(A[i]+A[j]==B){
	                    return 1;
	                }

	            }
	        }
	        return 0;
	    }
	 
	 public int solve2(int[] A, int B) {
		  int n = A.length;
	        int i=0;
	        int j=n-1;
	        int count=0;
	        while(i<j){
	            int value=A[i]+A[j];
	            if(value==B){
	               
	                int c1=0;
	                int c2=0;
	                int ci =i;
	                int cj =j;
	                if(A[i]!=A[j]) {
	                while(i<j&&A[i]==A[ci]){
	                    i++;
	                    c1++;
	                }
	                
	                while(ci<=j&&A[j]==A[cj]){
	                    j--;
	                    c2++;
	                }
	                
	                count+=(c1*c2);
	                }
	                else {
	                	int v = j-i+1;
	                	int c= v * (v-1)/2;
	                	 count+=c;
	                	 j=i-1;
	                }
	                count%=1000000007;
	            }
	            else if(value>B){
	                j--;
	            }
	            else{
	                i++;
	            }
	        }
	        return count;
	 }
	 public static void main(String[] args) {
		 SumOfPair s = new SumOfPair();
		 int a[]= {2,4,4,5,6,8,10};
		 System.out.println(s.solve2(a, 8));
	}

}
