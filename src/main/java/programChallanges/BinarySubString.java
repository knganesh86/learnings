package programChallanges;

/**
 * Given a string A, A is made up of 0's and 1's. Break A into substrings such that , all broken substrings have equal number of 1's and 0's.

Find and return maximum number of substrings in which A can be broken.


Input Format

The only argument given is string A.
Output Format

Find and return maximum number of substrings in which A can be broken.
Constraints

1 <= length of A <= 10^5
A will always have equal number of 0's and 1's
For Example

Input 1:
    A = "011100"
Output 1:
    2
Explanation 1:
    "01" + "1100"

Input 2:
    A = "00011011"
Output 2:
    1
Explanation 2:
    "00011011"
 * @author kamar
 *
 */
public class BinarySubString {
	
	public int solve(String A) {
		int balancer =0;
		int count =0;
		for(int i=0;i<A.length();i++) {
			char c = A.charAt(i);
			if(c=='0') {
				balancer--;
			}
			else if(c=='1') {
				balancer++;
			}
			if(balancer==0){
				count++;
			}
		}
		return count;
	}
	public static void main(String[] args) {
		BinarySubString s = new BinarySubString();
		System.out.println(s.solve("011100"));
		System.out.println(s.solve("00011011"));
	}

}
