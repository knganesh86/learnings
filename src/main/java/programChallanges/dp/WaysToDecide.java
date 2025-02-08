package programChallanges.dp;

public class WaysToDecide {
	
	 public int numDecodings(String A) {
		 if(A.isEmpty()) {
			 return 0;
		 }
		 if(A.charAt(0)=='0') {
			 return 0;
		 }
		 int dp[]= new int[A.length()+1];
		 dp[0] =1;
		 dp[1]=1;
		 for(int i=2;i<=A.length();i++) {
			 char c = A.charAt(i-1);
			 char p = A.charAt(i-2);
			 if(c=='0') {
				 dp[i-1]=dp[i-2];
			 }
			 if(c>='1' && c<='9') {
				 dp[i]=dp[i-1];
			 }
			 if(p=='1') {
				 if(dp[i-1]==dp[i-2]) {
				 dp[i] = (dp[i]+dp[i-1])%1000000007;
				 }
				 else {
					 dp[i] = (dp[i]+dp[i-2])%1000000007;
				 }
			 }
			 if(p=='2' && c<='6'){
				 if(dp[i-1]==dp[i-2]) {
					 dp[i] = (dp[i]+dp[i-1])%1000000007;
					 }
					 else {
						 dp[i] = (dp[i]+dp[i-2])%1000000007;
					 }
			 }
		 }
		 return dp[A.length()];
	 }

	  public int numDecodings1(String A) {
		  
		  int prevNum = 0;
		  long prevCalc = 1l;
		  long prevPrevCalc= 1l;
		  for(int i=0;i<A.length();i++) {
			  int num =A.charAt(i)-48;
			  if(num==0) {
				  prevNum=num;
				  prevCalc = prevPrevCalc;
				  continue;
			  }
			  int withPrevValue = (prevNum*10)+num;
			  if(prevNum !=0 && withPrevValue<=26) {
				  long value = prevCalc-prevPrevCalc;
				  if(value==0l) {
					  value =prevCalc;
				  }
				  else {
					  value = prevPrevCalc;
				  }
				  prevPrevCalc=prevCalc;
				  prevCalc+=value;
				  
			  }
			  else {
				  prevPrevCalc=prevCalc;
			  }
			  prevNum = num;
			  System.out.println(prevCalc);
		  }
		  prevCalc%=1000000007;
		  if(prevCalc<0) {
			  prevCalc+=1000000007;
		  }
		  return (int)prevCalc;
	    }
	  public static void main(String[] args) {
		WaysToDecide w = new WaysToDecide();
		System.out.println("ans"+w.numDecodings("875361268549483279131"));
	}
	  
}
