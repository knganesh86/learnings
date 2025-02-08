package programChallanges.numberSeries;
/**
 * Problem Description
You will be given an integer n. You need to return the count of prime numbers less than or equal to n.


Problem Constraints
0 <= n <= 10^3


Input Format
Single input parameter n in function.


Output Format
Return the count of prime numbers less than or equal to n.


Example Input
Input 1: 19
Input 2: 1


Example Output
Output 1: 8
Output 2: 0


Example Explanation
Explanation 1: Primes <= 19 are 2, 3, 5, 7, 11, 13, 17, 19
Explanation 2: There are no primes <= 1 

 * @author kngan
 *
 */
public class CountOfPrime {
	public int solve(int A) {
        int count =0;
        boolean isPrime = true;
        for(int i=2;i<=A;i++){
            isPrime = true;
            for(int j=2;j*j<=i;j++){
                if(i%j==0){
                    isPrime = false;
                    break;
                }
            }
            if(isPrime){
                count++;
            }

        }
        return count;
    }

}
