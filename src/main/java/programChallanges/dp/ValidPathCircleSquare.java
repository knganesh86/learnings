package programChallanges.dp;

public class ValidPathCircleSquare {
	public String solve(int A, int B, int C, int D, int[] E, int[] F) {
        int mat[][]= new int[A+1][B+1];
        boolean visited[][] = new boolean [A+1][B+1];
        for(int i=0;i<=A;i++){
            for(int j=0;j<=B;j++){
                mat[i][j]=1;
                for(int k=0;k<E.length;k++){
                    long val1 = (long)E[k]-i;
                    val1*=val1;
                    long val2 = (long)F[k]-j;
                    val2*=val2;
                    int value  =(int)Math.sqrt((double)val1+val2);
                    if(value<=D){
                        mat[i][j]=0;
                    }
                }
            }
        }
        if(dfs(mat, visited, 0, 0, A,B)) {
        	return "YES";
        }
        return "NO";
        
    }
	
	

	    private boolean dfs( int[][] mat, boolean visited[][], int x, int y, int dX, int dY){
	        if(dX==x && dY==y){
	            return true;
	        }
	        if(visited[x][y]){
	            return false;
	        }
	        visited[x][y]= true;
	        if(y<dY && !visited[x][y+1] && mat[x][y+1]==1)
	        {
	          if(dfs( mat, visited, x, y+1, dX, dY)){
	                    return true;
	           }
	        }
	        if(x<dX && y<dY && !visited[x+1][y+1] && mat[x+1][y+1]==1)
	        {
	          if(dfs(mat, visited, x+1, y+1, dX, dY)){
	        	  return true;
	           }
	        }
	        if(x<dX && y>0 && !visited[x+1][y-1] && mat[x+1][y-1]==1)
	        {
	          if(dfs(mat, visited, x+1, y-1, dX, dY)){
	        	  return true;
	           }
	        }
	        if(x<dX && !visited[x+1][y] && mat[x+1][y]==1)
	        {
	          if(dfs(mat, visited, x+1, y, dX, dY)){
	        	  return true;
	           }
	        }
	        if(y>0 &&!visited[x][y-1] && mat[x][y-1]==1)
	        {
	          if(dfs(mat, visited, x, y-1, dX, dY)){
	        	  return true;
	           }
	        }
	        if(x>0 &&!visited[x-1][y] && mat[x-1][y]==1)
	        {
	          if(dfs(mat, visited, x-1, y, dX, dY)){
	        	  return true;
	           }
	        }
	        
	        if(x>0 && y>0 &&!visited[x-1][y-1] && mat[x-1][y-1]==1)
	        {
	          if(dfs(mat, visited, x-1, y-1, dX, dY)){
	        	  return true;
	           }
	        }
	        
	        if(x>0 && y<dY &&!visited[x-1][y+1] && mat[x-1][y+1]==1)
	        {
	          if(dfs(mat, visited, x-1, y+1, dX, dY)){
	        	  return true;
	           }
	        }
	        return false;
	    }
	    public static void main(String[] args) {
			ValidPathCircleSquare vc = new ValidPathCircleSquare();
			int a[]= {40,6,36,38,23,54};
			int b[] = {88,14,50,10,15,5};
			System.out.println(vc.solve(58, 91, 6, 8, a, b));
		}
}
