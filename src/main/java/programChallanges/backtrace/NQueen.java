package programChallanges.backtrace;

import java.util.ArrayList;

public class NQueen {
	public ArrayList<ArrayList<String>> solveNQueens(int A) {
		ArrayList<ArrayList<String>> ans = new ArrayList<ArrayList<String>>();
		int col[] = new int[A];
		for(int i=0;i<A;i++) {
			col[i]=-1;
		}
		nSquare(0,A,col, ans);
		
		return ans;
	}

	private void nSquare(int r, int n, int[] col, ArrayList<ArrayList<String>> ans) {
		
		if(r==n) {
			convertColToOutPut(col, ans);
			return ;
		}
		for(int c=0;c<n;c++) {
			if(isValid(col,r,c))
			{
				col[r]=c;
				nSquare(r+1, n, col, ans);
				col[r]=-1;
			}			
		}
	}

	private void convertColToOutPut(int[] col, ArrayList<ArrayList<String>> ans) {
		ArrayList<String> list = new ArrayList<String>();
		ans.add(list);
		for(int i=0;i<col.length;i++) {
			StringBuilder s = new StringBuilder();
			for(int j=0;j<col[i];j++) {
				s.append(".");
			}
			s.append("Q");
			for(int j=col[i]+1;j<col.length;j++) {
				s.append(".");
			}
			list.add(s.toString());
		}
		
	}

	private boolean isValid(int[] col, int r, int c) {
		for(int i=0;i<r;i++) {
			int j=col[i];
			if(j==c || ((i-r)==(j-c)) || ((i+j)==(r+c))) {
				return false;
			}
		}
		return true;
	}
	public static void main(String[] args) {
		NQueen n = new NQueen();
		n.solveNQueens(2);
				
	}
}
