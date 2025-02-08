package programChallanges.dp;

public class ChocoSteps {
	public int solve(int A, String B) {
		int ans[] = new int[A];
		char c[]=B.toCharArray();
		for(int i=A-1;i>0;i--) {
			if(c[i]=='C' && ans[i]>=0) {
				ans[i-1]=Math.max(1+ans[i], ans[i-1]);
			}
			if(c[i]=='B' && ans[i-1]==0) {
				ans[i-1]=-1;
			}
			if(c[i]=='E') {
				ans[i-1]= Math.max(ans[i], ans[i-1]);
			}

			if(i>2) {
				if(c[i]=='C' &&  ans[i]>=0) {
					ans[i-3]=Math.max(1+ans[i], ans[i-3]);
				}
				if(c[i]=='B' && ans[i-3]==0) {
					ans[i-3]=-1;
				}	
				if(c[i]=='E') {
					ans[i-3]= Math.max(ans[i], ans[i-1]);
				}
			}
			
		}
		return ans[0];	
	}
	public static void main(String[] args) {
		ChocoSteps c = new ChocoSteps();
		System.out.print(c.solve(10, "EEEECBCECE"));
	}

}
