package programChallanges.backtrace;

public class Suduko {
	int n=9;
	public void solveSudoku(char[][] A) {
		sudoku(A, 0, 0);
	}
	private boolean sudoku(char [][]A, int r, int c) {
		if(c==n) {
			r+=1;
			c=0;
		}
		if(r==n) {
			return true;
		}
		if(A[r][c]!='.') {
			return sudoku(A,r,c+1);
		}
		for(char i='1';i<='9';i++) {
			A[r][c]=i;
			if(check(A,r,c) && sudoku(A,r,c+1)) {
				return true;
			}
			A[r][c]='.';
		}
		return false;
	}
	private boolean check(char[][] a, int r, int c) {
		for(int i=0;i<n;i++) {
			if(c!=i && a[r][c] ==a[r][i]) {
				return false;
			}
			if(r!=i && a[r][c] ==a[i][c]) {
				return false;
			}
		}
		int u= r-(r%3);
		int v= c-(c%3);
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				int x = u+i;
				int y = v+j;
				if((x!=r || y!=c) && a[x][y]==a[r][c]) {
					return false;
				}
			}
		}
		return true;
	}
	public static void main(String[] args) {
		char c[][]= new char[9][9];
		c[0]="53..7....".toCharArray();
		c[1]="6..195...".toCharArray();
		c[2]=".98....6.".toCharArray();
		c[3]="8...6...3".toCharArray();
		c[4]="4..8.3..1".toCharArray();
		c[5]="7...2...6".toCharArray();
		c[6]=".6....28.".toCharArray();
		c[7]="...419..5".toCharArray();
		c[8]="....8..79".toCharArray();
		Suduko s = new Suduko();
		s.solveSudoku(c);
	}
	
}
