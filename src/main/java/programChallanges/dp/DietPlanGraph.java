package programChallanges.dp;

import java.util.HashSet;
import java.util.Set;

public class DietPlanGraph {
	boolean isInvalid = false;
    public int solve(int A, int[][] B, int [][]C) {
		int parent[] = new int[A+1];
		byte type[] = new byte[A+1];
		
		for(int i =1;i<=A;i++) {
			parent[i]=i;
			type[i]=0;
		}
		for(int i=0;i<B.length;i++) {
			union(B[i][0],B[i][1], parent, type, (byte) 1);
		}
		for(int i=0;i<C.length;i++) {
			union(C[i][0],C[i][1], parent, type, (byte) 2);
		}
		if(isInvalid) {
			return 0;
		}
		
			Set<Integer> group = new HashSet<>();
			for(int i=1;i<=A;i++) {
				group.add(root(i, parent));
			}
			return (int)fastPower(2l, group.size(), 1000000007l);
	
    }
	
	private void union(int i, int j, int[] parent, byte[] type, byte value) {
		int x = root(i, parent);
		int y = root(j, parent);
		if(type[i]==0) {
			type[i]=value;
		}
		else if(type[i]!=value){
			isInvalid = true;
		}
		if(type[j]==0) {
			type[j]=value;
		}
		else if(type[j]!=value){
			isInvalid = true;
		}
		if(x==y) {
			return;
		}
		else if(x>y) {
			parent[x]=y;
		}
		else {
			parent[y]=x;
		}
		
	}

	public long fastPower(long a, long b, long m){
        if(b==0){
            return 1;
        }
        if(b%2==0){
            return fastPower((a*a)%m, b/2,m);
        }
        else{
            return (a*fastPower((a*a)%m, b/2,m))%m;
        }
    }
	private int root(int node, int[] parent) {
		if(node == parent[node]) {
			return node;
		}
		parent[node]= root(parent[node], parent);
		return parent[node];
	}
	public static void main(String[] args) {
		DietPlanGraph dp = new DietPlanGraph();
		int a[][] = {{1,2},{6,3}};
		int b[][]= {{4,5}};
		System.out.println(dp.solve(6, a, b));
	}
}
