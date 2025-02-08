package programChallanges.dp;

public class CityDistanceFloyd {
	 public int[] solve(int A, int B, int C, int[] D, int[] E, int[] F, int[] G, int[] H) {
		 int n = A+1;
		 int path[][]= new int[n][n];
		
		 for(int i=0;i<B;i++) {
			 if( path[D[i]][E[i]]>0) {
				 path[D[i]][E[i]]=Math.min(path[D[i]][E[i]], F[i]);
				 path[E[i]][D[i]]=path[D[i]][E[i]];
			 }
			 else {
				 path[D[i]][E[i]]=F[i];
				 path[E[i]][D[i]]=F[i];
			 }
		 }
		 for(int i=0;i<=A;i++) {
			 path[i][i]=0;
			 for(int j=i+1;j<=A;j++) {
				 if(path[i][j]==0) {
					 path[i][j]=Integer.MAX_VALUE;
				 }
				 if(path[j][i]==0) {
					 path[j][i]=Integer.MAX_VALUE;
				 }
			 }
		 }
		 
		 for(int k=0;k<n;k++) {
			 for(int i=0;i<n;i++) {
				for(int j=i+1;j<n;j++) {
					int value = path[i][k]+ path[k][j];
					if(path[i][k]==Integer.MAX_VALUE || path[k][j]==Integer.MAX_VALUE) {
						value=Integer.MAX_VALUE;
					}
					path[i][j] = Math.min(path[i][j], value);
					path[j][i] = Math.min(path[j][i], value);
				}
			 }
		 }
		 for(int i=0;i<path.length;i++) {
				for(int j=0;j<path.length;j++) {
					if(path[i][j]==Integer.MAX_VALUE) {
						path[i][j]=-1;
					}
				}
		 }
		 int result[]=new int[C];
		 for(int i=0;i<C;i++) {
			 result[i]=path[G[i]][H[i]];
		 }
		 return result;   
	 }
	 public static void main(String[] args) {
		int A = 22;
		int B = 28;
		int C = 3;
		int D[] = {18,10,16,4,22,17,11,4,11,10,21,8,19,16,8,7,12,21,17,1,16,10,10,4,20,12,20,16};
		int E[] = {6,1,6,2,20,2,7,4,6,4,4,5,10,15,4,3,3,6,12,22,4,7,8,4,19,2,19,4};
		int F[] = {8446,4731,8099,677,4569,2355,5308,8626,5734,21,9710,8151,2620,3453,2381,8230,5195,7766,6989,3745,8367,1434,9230,1476,4397,8237,4430,5930};
		int G[] = {14,19,14};
		int H[] = {7,15,14};
		CityDistanceFloyd cf = new CityDistanceFloyd();
		int result[]= cf.solve(A, B, C, D, E, F, G, H);
		for(int x: result) {
			System.out.print(x+" ");
		}
	}
}
