package programChallanges.search;

public class SpecialInteger {
	public int solve(int[] A, int B) {
		int l=0;
		int r=A.length;
		int ans=0;
		long prefix[]=new long[r];
		 prefix[0]=A[0];
		for(int i =1;i<r;i++) {
			prefix[i]=prefix[i-1]+A[i];
		}
		while(l<=r) {
			int mid= (l+r)/2;
			if(check(mid, prefix, B)) {
				ans=mid;
				l=mid+1;
			}
			else {
				r=mid-1;
			}
		}
		return ans;
    }

	private boolean check(int mid, long[] prefix, int B) {
		if(mid==prefix.length) {
			return prefix[mid-1]<B;
		}
		for(int i=mid;i<prefix.length;i++) {
			if(prefix[i]-prefix[i-mid]>B) {
				return false;
			}
		}
		return true;
	}
	public static void main(String[] args) {
		SpecialInteger si = new SpecialInteger();
		int a[]= {1,1000000000};
		System.out.println(si.solve(a, 1000000000));
	}
}
