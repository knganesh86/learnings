package programChallanges.dp;

public class PossibleBinaryTree {
/**
 * 2+1+2 = 5

4
5+2+2+5=14


1,2,5,14,42,132

5
14+5+4+5+14=42

6
42+14+10+10+14+42

132+42+28+25+
 */
	public int numTrees(int A) {
		long[] ans = new long[A+1];
		ans[0]=1;
		ans[1]=1;
		for(int i=2;i<=A;i++) {
			for(int j=0;j<i/2;j++) {
				ans[i]+=ans[j]*ans[i-j-1]*2;
			}
			if((i&1)==1) {
				ans[i]+=ans[i/2]*ans[i-(i/2)-1];
			}
		}
		
		return (int)ans[A];
    }
	public static void main(String[] args) {
		PossibleBinaryTree p =new PossibleBinaryTree();
		System.out.println(p.numTrees(18));
	}
}
