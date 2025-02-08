package programChallanges.dp;

public class FloydWarshallAlg {
	 public int[][] solve(int[][] A) {
		 int n = A.length;
		 int result[][]= new int[n][n];
		 for(int i=0;i<n;i++) {
			 for(int j=0;j<n;j++) {
				 if(A[i][j]==-1) {
					 result[i][j]=Integer.MAX_VALUE;
				 }
				 else {
					 result[i][j]=A[i][j];
				 }
			 }
		 }
		 for(int k=0;k<n;k++) {
			 for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					int value = result[i][k]+ result[k][j];
					if(result[i][k]==Integer.MAX_VALUE || result[k][j]==Integer.MAX_VALUE) {
						value=Integer.MAX_VALUE;
					}
					result[i][j] = Math.min(result[i][j], value);
				}
			 }
		 }
		 for(int i=0;i<result.length;i++) {
				for(int j=0;j<result.length;j++) {
					if(result[i][j]==Integer.MAX_VALUE) {
						result[i][j]=-1;
					}
				}
		 }
		 return result;
	    }
	 public static void main(String[] args) {
			int a[][]= //{{0,50,39},{-1,0,1},{-1,10,0}};
					{{0,5,-1,10},{-1,0,3,-1},{-1,-1,0,1},{-1,-1,-1,0}};
			FloydWarshallAlg fwa = new FloydWarshallAlg();
			int result[][]=fwa.solve(a);
			for(int i=0;i<result.length;i++) {
				for(int j=0;j<result.length;j++) {
					System.out.print(result[i][j]+" ");
				}
				System.out.println();
			}
	}//[0 5 8 9 ] [-1 0 3 4 ] [-1 -1 0 1 ] [-1 -1 -1 0 ]
}
