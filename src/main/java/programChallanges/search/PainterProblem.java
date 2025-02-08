package programChallanges.search;

public class PainterProblem {
	
	private int noOfPainters(int[] a, int n, int max) {
		int painter =1;
		int time=0;
		for(int i=0;i<a.length;i++) {
			time+=a[i]*n;
			if(time>max) {
				painter++;
				time=a[i]*n;
			}
		}
		return painter;
	}
	public int paint(int A, int B, int[] C) {
		int left = Integer.MIN_VALUE;
		int right=0;
		int ans = -1;
		for(int i=0;i<C.length;i++) {
			right+= C[i]*B;
			left = Math.max(left,  C[i]*B);
		}
		while(left<=right) {
			int mid = (left+right)/2;
			int p = noOfPainters(C, B, mid);
			if(p>A) {
				left= mid+1;
			}
			else {
				
					ans = mid;

				right=mid-1;
			}
		}
		return ans;
    }
	public static void main(String[] args) {
		PainterProblem p = new PainterProblem();
		int a[] = {12, 15, 78};
		System.out.println(p.paint(3,1, a));
	}
}
