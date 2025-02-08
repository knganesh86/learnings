package programChallanges.dp;

public class RegularExpressionMatch {
	 public int isMatch(final String A, final String B) {
		 char str1[]=A.toCharArray();
		 char str2[]=B.toCharArray();
		 byte ans[][]= new byte[str1.length][str2.length];
		 return isMatch(str1, str2, str1.length-1, str2.length-1, ans)?1:0;
	    }

	private boolean isMatch(char[] str1, char[] str2, int i, int j, byte[][] ans) {

		if(i<0 && j<0) {
			return true;
		}
		else if (i<0) {
			while(j>=0 &&str2[j]=='*') {
				j--;
			}
			if(j<0) {
				return true;
			}
			return false;
		}
		else if(j<0){
			return false;
		}
		else {
			boolean result = false;
			if(ans[i][j]==0) {
	
				if(str1[i]==str2[j]) {
					result = isMatch(str1, str2, i-1, j-1, ans);
				}
				else {
				
					if(str2[j]=='*') {
					result= isMatch(str1, str2, i, j-1, ans) || // repalce no char 
								isMatch(str1, str2, i-1, j, ans);//replace one char
					}
					else if(str2[j]=='?') {
						result = isMatch(str1, str2, i-1, j-1, ans);
					}
					else {
						result = false;
					}
				}
				if(result) {
					ans[i][j]=1;
				}
				else {
					ans[i][j]=2;
				}
			}
			return ans[i][j]==1;
		}		
	}
	public static void main(String[] args) {
		RegularExpressionMatch stm = new RegularExpressionMatch();
		System.out.println(stm.isMatch("acc", "ab*"));
	}
}
