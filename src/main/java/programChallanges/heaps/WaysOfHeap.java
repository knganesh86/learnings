package programChallanges.heaps;

public class WaysOfHeap {
	public static void main(String[] args) {
		int n=10;
		int h = 31-Integer.numberOfLeadingZeros(n);//log2(n);
		int m = 1<<h;//2^h
		int x = m-1;
		int p = n-x;
		int left = ((x-1)/2)+Math.min(n-x, (x+1)/2);
		int right = n-1-left;
		System.out.println(ways(4));
		System.out.println(right);
	}
	
	public static int ways(int n) {
		if(n==0) {
			return 0;
		}
		if(n<3) {
			return 1;
		}
		int h = 31-Integer.numberOfLeadingZeros(n);//log2(n);
		int m = 1<<h;//2^h
		int x = m-1;
		int p = n-x;
		int left = ((x-1)/2)+Math.min(n-x, (x+1)/2);
		int right = n-1-left;
		return calculate_nCr(n-1,left)*ways(left)*ways(right);
    }
	public static int calculate_nCr(int n, int r) {
		long sum =1;
		// Calculate the value of n choose r using the
        // binomial coefficient formula
        for (int i = 1; i <= r; i++) {
            sum = sum * (n - r + i) / i;
        }
        return (int)sum;
 
	}
}
