package programChallanges.search;

public class MatrixSearch {
	public int searchMatrix(int[][] A, int B) {
		int n = A.length;
		int m = A[0].length;
		int tl = n*m;
		int s = 0;
		while(s<tl) {
			int mid = (s+tl)/2;
			int r = mid/m;
			int c = mid%m;
			if(A[r][c]==B) {
				return 1;
			}
			if(A[r][c]<B) {
				s =mid+1;
			}
			else {
				tl=mid;
			}
		}
		return 0;
    }
	public static void main(String[] args) {
		MatrixSearch ms = new MatrixSearch();
		int a[][]= {{1,3,5},
				{10,11,16},
				{23,30,34}
					};
		System.out.println(ms.searchMatrix(a, 23));
	}
}
