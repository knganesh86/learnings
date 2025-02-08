package programChallanges.dp;

public class LongestCommonSubSequence {
	 public int solve(String A, String B) {
		 int n = A.length();
		 int m = B.length();
		 int ans[][]= new int[n][m];
		 for(int i=0;i<n;i++) {
			 for(int j=0;j<m;j++) {
				 ans[i][j]=-1;
			 }
		 }
		 char str1[]= A.toCharArray();
		 char str2[]=B.toCharArray();
		 return lcs(str1,str2, ans, n-1, m-1);
	    }

	private int lcs(char[] str1, char[] str2, int[][] ans, int i, int j) {
		if(i<0 || j<0) {
			return 0;
		}
		if (ans[i][j] == -1) {
			if (str1[i] == str2[j]) {
				ans[i][j] = 1 + lcs(str1, str2, ans, i - 1, j - 1);
			} else {
				ans[i][j] = Math.max(lcs(str1, str2, ans, i - 1, j), lcs(str1, str2, ans, i, j - 1));
			}
		}
		return ans[i][j];
		
	}
	public static void main(String[] args) {
		LongestCommonSubSequence lcs = new LongestCommonSubSequence();
		System.out.println(lcs.solve("abbcdgf", "bbadcgf"));
	}
}
