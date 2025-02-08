package programChallanges.dp;

public class JumbNode {
	public static int solve(int A[]) {
		
		int r=0;
		int n=A.length;
		int i=n-1;
		while(i>0) {
			if(i>1) {
				int v1=Math.abs(A[i-1]-A[i]);
				int v2= Math.abs(A[i-2]-A[i]);
				if(v1>v2) {
					r+=v2;
					i-=2;
				}
				else {
					r+=v1;
					i-=1;
				}
			}
			else if(i>0) {
				int v = Math.abs(A[i-1]-A[i]);
				r+=v;
				i-=1;
			}
		}
		return r;
	}
	public static void main(String[] args) {
		int a[]= {250, 74, 659, 931, 273, 545, 879, 924};
		System.out.println(solve(a));
	}
}
