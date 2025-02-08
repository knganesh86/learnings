package programChallanges.dp;

public class StringMatchingDistance {
	 public int minDistance(String A, String B) {
		 char str1[]=A.toCharArray();
		 char str2[]=B.toCharArray();
		 int ans[][]= new int[str1.length][str2.length];
		 return findDistance(str1, str2, str1.length-1, str2.length-1, ans);
	    }

	private int findDistance(char[] str1, char[] str2, int i, int j, int[][] ans) {

		if(i<0 && j<0) {
			return 0;
		}
		else if (i<0) {
			return j+1;
		}
		else if(j<0){
			return i+1;
		}
		else {
			if(ans[i][j]==0) {
	
				if(str1[i]==str2[j]) {
					ans[i][j]=	findDistance(str1, str2, i-1, j-1, ans);
				}
				else {
				
					ans[i][j]= 1+Math.min(findDistance(str1, str2, i-1, j, ans), 
								Math.min(findDistance(str1, str2, i, j-1, ans), 
										findDistance(str1, str2, i-1, j-1, ans)));
				}
			}
			return ans[i][j];
		}		
	}
	public static void main(String[] args) {
		StringMatchingDistance stm = new StringMatchingDistance();
		System.out.println(stm.minDistance("Anshuman", "Antihuman"));
	}
}
