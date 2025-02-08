package programChallanges.Array;

import java.util.Scanner;

public class MatrixGame {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
 
        int nRow = sc.nextInt();
        int nCol = sc.nextInt();
        int nQuery = sc.nextInt();
        int row[]= new int[nRow];
        int col[]=new int[nCol];
        for(int i=0;i<nRow;i++) {
        	row[i]=i;
        }
        for(int i=0;i<nCol;i++) {
        	col[i]=i;
        }
        for(int i=0;i<nQuery;i++) {
        	int query = sc.nextInt();
        	if(query ==1) {
        		int left = sc.nextInt();
        		int right = sc.nextInt();
        		left--;
        		right--;
        		int temp = col[left];
        		col[left]=col[right];
        		col[right]=temp;
        	}
        	if(query ==2) {
        		int left = sc.nextInt();
        		int right = sc.nextInt();
        		left--;
        		right--;
        		int temp = row[left];
        		row[left]=row[right];
        		row[right]=temp;
        	}
        	if(query ==3) {
        		int row1 = sc.nextInt();
        		int col1 = sc.nextInt();
        		int row2 = sc.nextInt();
        		int col2 = sc.nextInt(); 
        		int actualRow1 = row[row1-1];
        		int actualCol1 = col[col1-1];
        		int actualRow2 = row[row2-1];
        		int actualCol2 = col[col2-1];
        		int value1= (actualRow1*nCol)+actualCol1+1;
        		int value2= (actualRow2*nCol)+actualCol2+1;
        		System.out.println(value1|value2);
        	}
        	if(query ==4) {
        		int row1 = sc.nextInt();
        		int col1 = sc.nextInt();
        		int row2 = sc.nextInt();
        		int col2 = sc.nextInt(); 
        		int actualRow1 = row[row1-1];
        		int actualCol1 = col[col1-1];
        		int actualRow2 = row[row2-1];
        		int actualCol2 = col[col2-1];
        		int value1= (actualRow1*nCol)+actualCol1+1;
        		int value2= (actualRow2*nCol)+actualCol2+1;
        		System.out.println(value1&value2);
        	}
        }
       
	}

}
