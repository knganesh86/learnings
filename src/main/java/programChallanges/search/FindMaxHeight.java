package programChallanges.search;

public class FindMaxHeight {
	 public int solve(int A) {
		 int s = 0;
		 int n =A;
		 int ans =0;
		 
		 while(s<n) {
			 int mid = (s+n)/2;
			 long val = (long)mid*(mid+1)/2;
			 if(val<=A) {
				 s=mid+1;
				 ans=mid;
			 }
			 else {
				 n=mid;
			 }
		 }
		 return ans;
	        
	    }
	 public static void main(String[] args) {
	FindMaxHeight fm = new FindMaxHeight();
	System.out.println(fm.solve(20));
	}

}
