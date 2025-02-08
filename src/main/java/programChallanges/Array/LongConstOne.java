package programChallanges.Array;

public class LongConstOne {
	private static int solve(int[] A) {
		int n= A.length;
		int left =0;
		int right =0;
		int i =0;
		int totalOne=0;
		for(int p=0;p<n;p++) {
			if(A[p]==1) {
			totalOne++;
			}
		}
		
		while(i<n&&A[i]!=0)
		{
			left++;
			i++;
		}
		int sum=left;
		while(i<n) {
			int count =0;
			int j=i+1;
			if(A[i]==0) {
				while(j<n && A[j]!=0) {
					j++;
					right++;
				}
			}
			
			count=left+right;
			if(count<totalOne) {
				count++;
			}
			sum = Math.max(sum, count);
			i=j;
			left= right;
			right=0;
		}
		return sum;
	}
	public static void main(String[] args) {
		//int a[] = {1,0,1,1,1,1,0,0,1,1,0,1,1};
	//	int a[] = {0,1,1,1,1,0,1,1,0,1,1};
	//	int a[] = {1,1,1,0,1,1,1,1,0,1,1,0,1,1};
		//int a[] = {1,1,1,1,1,1,1,1,1,1,1,0,1,1};
	//	int a[] = {1,1,1,1,1,1,1,1,1,1,1,1,1,1};
	//	int a[] = {0,0,0,0,0,0,0,0,0,0,0};
	//	int a[] = {0,0,0,0,0,0,0,0,0,0,1};
	//	int a[] = {1,0,0,0,0,0,0,0,0,0,0};
	//	int a[] = {0,0,0,0,0,0,1,0,0,0,0};
		int a[] = {1,0,0,0,0,0,1,0,0,0,1};
		System.out.println(solve(a));
	}

}
