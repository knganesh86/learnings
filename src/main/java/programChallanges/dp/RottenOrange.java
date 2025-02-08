package programChallanges.dp;

import java.util.ArrayDeque;

public class RottenOrange {
	class Pair{
		int i;
		int j;
		Pair(int i, int j){
			this.i=i;
			this.j=j;
		}
	}
	  public int solve(int[][] A) {
		  int r= A.length;
		  int c = A[0].length;
		  ArrayDeque<Pair> queue = new ArrayDeque<>();
		  int distance[][]=new int[r][c];
		  for(int i=0;i<r;i++) {
			  for(int j =0;j<c;j++) {
				  if(A[i][j]==2) {
					  distance[i][j]= 0;
					  queue.add(new Pair(i,j));
				  }
				  else {
					  distance[i][j]= Integer.MAX_VALUE;
				  }
			  }
		  }
		  while(!queue.isEmpty()) {
			  Pair p =queue.poll();
			  
			  if(p.i>0 && distance[p.i-1][p.j]==Integer.MAX_VALUE && A[p.i-1][p.j]==1) {
				  queue.add(new Pair(p.i-1, p.j));
				  distance[p.i-1][p.j]=distance[p.i][p.j]+1;
			  }
			  if(p.j>0 && distance[p.i][p.j-1]==Integer.MAX_VALUE && A[p.i][p.j-1]==1) {
				  queue.add(new Pair(p.i, p.j-1));
				  distance[p.i][p.j-1]=distance[p.i][p.j]+1;
			  }
			  if(p.i<r-1 && distance[p.i+1][p.j]==Integer.MAX_VALUE && A[p.i+1][p.j]==1) {
				  queue.add(new Pair(p.i+1, p.j));
				  distance[p.i+1][p.j]=distance[p.i][p.j]+1;
			  }
			  if(p.j<c-1 && distance[p.i][p.j+1]==Integer.MAX_VALUE && A[p.i][p.j+1]==1) {
				  queue.add(new Pair(p.i, p.j+1));
				  distance[p.i][p.j+1]=distance[p.i][p.j]+1;
			  }
		  }
		  int result=0;
		  for(int i=0;i<r;i++) {
			  for(int j =0;j<c;j++) {
				  if(A[i][j]==1 && distance[i][j]==Integer.MAX_VALUE) {
					  return -1;
				  }
				  if(distance[i][j]!=Integer.MAX_VALUE) {
					  result = Math.max(result, distance[i][j]);
				  }
			  }
		  }
		  return result;
		  
	    }
	  public static void main(String[] args) {
		int a[][]= {{2,1,1},{0,1,1},{1,0,1}};
		RottenOrange r = new RottenOrange();
		System.out.println(r.solve(a));
	}
}
