package programChallanges.search;

import java.util.Arrays;

public class AddOrNot {
	
	  public int[] solve(int[] A, int B) {
		  Arrays.sort(A);
		  int n = A.length;
		  long prefix[]=new long[n+1];
		 
		  for(int i =0;i<n;i++) {
			  prefix[i+1]+=prefix[i]+A[i];
		  }
		  int ans[]=new int[2];
		  ans[0]=-1;
		  ans[1]=-1;
		  int max=0;
		  for(int i=0;i<n;i++) {
			  int low =1; 
			  int high=i+1;
			  while(low<=high) {
				  int count=(low+high)/2;
				  long val = A[i]*count-(prefix[i+1]-prefix[i-count+1]);
				  if(val<=B) {
					max=count;
					low=count+1;
				  }
				  else {
					  high=count-1;
				  }
			  }
			  if(ans[0]<max) {
				  ans[0]=max;
				  ans[1]=A[i];
			  }
		  }
		  return ans;
	  }

	public static void main(String[] args) {
		AddOrNot an=new AddOrNot();
		int a[]= {3,1,2,2,1};
		int x[]=an.solve(a, 3);
		System.out.println(x[0]);
		System.out.println(x[1]);
	}

}
