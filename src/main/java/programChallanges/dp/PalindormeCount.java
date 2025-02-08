package programChallanges.dp;

public class PalindormeCount {
	  public int solve(String A) {
		  char s[]=A.toCharArray();
		  int n = s.length;
		  boolean p[][]= new boolean[n][n];
		  int count=0;
		  for(int l=1;l<=n;l++) {
			  for(int i=0;i<n;i++) {
				  int j = l+i-1;
				  if(j>=n) {
					  break;
				  }
				  if(l==1) {
					  p[i][j]= true;
				  }
				  else if(l==2) {
					  p[i][j]= s[i]==s[j];
				  }
				  else {
					  p[i][j]= (s[i]==s[j]) && p[i+1][j-1];
				  }
				  if(p[i][j]) {
					  count++;
				  }
			  }
		  }
		  return count;
	    }
	  public static void main(String[] args) {
		PalindormeCount p = new PalindormeCount();
		System.out.println(p.solve("abcb"));
	}
}
