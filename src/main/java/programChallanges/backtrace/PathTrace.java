package programChallanges.backtrace;

public class PathTrace {
	int n=0;
    int m =0;
    int s1=0;
    int s2=0;
    int e1=0;
    int e2=0;
    int ans=0;
    int cellCount=0;
    public int solve(int[][] A) {
        n= A.length;
        m = A[0].length;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(A[i][j]==1){
                    s1=i;
                    s2=j;
                }
                if(A[i][j]==2){
                    e1=i;
                    e2=j;
                }
                if(A[i][j]==0){
                    cellCount++;
                }
            }
        }
        check(s1,s2,A,0);
        return ans;
    }

    public void check(int i, int j, int a[][], int v){
        if(i<0|| j<0 || i>=n || j>=m){
            return;
        }
        if(a[i][j]==-1 || a[i][j]==-2){
            return;
        }
        if(i==e1 && j==e2){
             
            if(v==cellCount){
              ans++;
            }
            return;
        }
        if(a[i][j]==0){
            v++;
        }
        int prev = a[i][j];
        a[i][j]=-2;
        check(i-1,j,a, v);
        check(i+1,j,a,v);
        check(i,j-1,a, v);
        check(i,j+1,a,v);
        a[i][j]=prev;
    }
    public static void main(String[] args) {
		int a[][]= {{1,0},{0,2}};
		PathTrace p = new PathTrace();
		System.out.println(p.solve(a));
	}

}
