package programChallanges.dp;

public class NearestOne {
	
	public int[][] solve(int[][] A) {
		int n = A.length;
		int m = A[0].length;
		int result1[][]=new int[n][m];
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				result1[i][j]= 10000;
			}
		}
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(A[i][j]==1) {
					result1[i][j]=0;
				}
				else {
					int value1=10000;
					int value2=10000;
					if(i!=0) {
						value1=result1[i-1][j];
					}
					if(j!=0) {
						value2=result1[i][j-1];
					}
					result1[i][j]= 1+Math.min(value1, value2);
					
				}
			}
		}
		for(int i=n-1;i>=0;i--) {
			for(int j=m-1;j>=0;j--) {
				if(A[i][j]!=1) {
					int value1=10000;
					int value2=10000;
					if(i!=n-1) {
						value1=result1[i+1][j];
					}
					if(j!=m-1) {
						value2=result1[i][j+1];
					}
					result1[i][j]= Math.min(result1[i][j], 1+Math.min(value1, value2));
					
				}
			}
		}
		return result1;
    }
	public static void main(String[] args) {
		NearestOne no= new NearestOne();
		int a[][]= {{1,0,0,0},{0,0,0,0},{0,0,0,0},{0,0,0,0}};
		int result[][]= no.solve(a);
		for(int i=0;i<result.length;i++) {
			for(int j=0;j<result[0].length;j++) {
				System.out.print(result[i][j]+" ");
			}
			System.out.println();
		}
	}

}
