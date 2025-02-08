package programChallanges.Array;

public class MatrixSpiral {
	 public int[][] generateMatrix(int A) {
	        int row =0;
	        int col =0;
	        int k=A;
	        int result[][]= new int[k][k];
	        int resultCount =1;
	        while(k>1){
	        for(int i=0;i<k-1;i++){
	        	result[row][col]= resultCount++;
	            col++;
	        }
	        for(int i=0;i<k-1;i++){
	        	result[row][col]= resultCount++;
	            row++;
	        }
	        for(int i=0;i<k-1;i++){
	        	result[row][col]= resultCount++;;
	            col--;
	        }
	        for(int i=0;i<k-1;i++){
	        	result[row][col]= resultCount++;
	            row--;
	        }
	        row++;
	        col++;
	        k=k-2;
	        }
	        if(k==1) {
	        	result[row][col]= resultCount;
	        }
	        return result;
	    }	  
	    
	    public static void main(String[] args) {
			MatrixSpiral a = new MatrixSpiral();
			a.generateMatrix(1);
		}

}
