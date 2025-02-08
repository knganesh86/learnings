package programChallanges;

public class ConsecutiveSum {
	public int solve(int A) {
		//((2 * A/k) - k - 1)/2
		int count=0;
//		for(int k=1;k<=2*A;k++) {
//			long v =((2*A/k)-k-1);
//			if(v>0 && v%2==0) {
//				count++;
//			}
//		}
		int k=1;
		long v = (long)A-(k*(k-1)/2);
		while(v>0) {
			if(v%k==0) {
				count++;
			}
			k++;
			v = (long)A-(k*(k-1)/2);
		}
		
		return count;
	}
	public static void main(String[] args) {
		ConsecutiveSum s = new ConsecutiveSum();
		System.out.println(s.solve(1));
	}

}
