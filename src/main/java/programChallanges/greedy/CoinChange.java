package programChallanges.greedy;

public class CoinChange {
	public int solve(int A) {
		int ans =0;
		int n=1;
		int d=1;
		while(d>0) {
			n*=5;
			d=A/n;
		}
		//System.out.println(n);
		int m=n/5;
		int temp=A;
		while(temp>0) {
			ans+=temp/m;
			temp=temp%m;
			m/=5;
		}
		return ans;
    }
	public static void main(String[] args) {
		CoinChange c = new CoinChange();
		System.out.println(c.solve(9));
	}
}
