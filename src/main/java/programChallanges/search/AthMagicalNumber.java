package programChallanges.search;

public class AthMagicalNumber {
	public int solve(int A, int B, int C) {
		long left =1;
		int ans = Math.min(B, C);
		long right = A*ans;
		
		while(left<=right) {
			long mid = (left+right)/2;
			int count = getMagicalCount(B,C,mid);
			if(count==A) {
				 
				ans = (int)(mid%1000000007);
				right = mid-1;
			}
			else if(count>A) {
				right = mid-1;
			}
			else {
				left = mid+1;
			}
		}
		return ans;
    }

	private int getMagicalCount(int b, int c, long mid) {
		int lcm = getLcm(b,c);
		int ans =(int)mid/b;
		ans+=(int)(mid/c);
		ans-=(int) (mid/lcm);
		return ans;
	}

	private int getLcm(int b, int c) {
		int d1 = Math.max(c, b);
		int d2 = Math.min(c, b);
		while(d1%d2!=0) {
			int rem = d1%d2;
			d1 = d2;
			d2 = rem;
		}
		return b*c/d2;
	}
	public static void main(String[] args) {
		AthMagicalNumber a = new AthMagicalNumber();
		System.out.println(a.solve(20,4,4));
	}

}
