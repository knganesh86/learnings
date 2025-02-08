package programChallanges.Array;

public class AntiDiagonalArray {
	
	public static int[][] diagonal(int[][] A) {
        int n= A.length;
        int size = A.length+A.length-1;
        int result[][] = new int[size][n];
          int row =0;
            int col =0;
        for(int i=0;i<size;i++){
          
            int iterRow = row;
            int iterCol = col;

            while(iterRow<n&& iterCol>=0 ){
                result[i][iterRow-row]=A[iterRow++][iterCol--];
            }
            if(col<n-1){
                col++;
            } 
            else{
                row++;
            }

        }
        return result;
    }
	public static void main(String[] args) {
		int a[] [] = {{1,2,3},{4,5,6},{7,8,9}};
		diagonal(a);
	}

}
