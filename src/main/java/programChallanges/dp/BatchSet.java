package programChallanges.dp;

import java.util.HashMap;
import java.util.Map.Entry;

public class BatchSet {
	public int solve(int A, int[] B, int[][] C, int D) {
		int result =0;
		int parent[] = new int[A+1];
		HashMap<Integer, Integer> sum = new HashMap<>();
		for(int i =1;i<=A;i++) {
			parent[i]=i;
			sum.put(i, B[i-1]);
		}
		for(int i=0;i<C.length;i++) {
			union(C[i][0],C[i][1], parent, sum);
		}
		for(Integer key: sum.keySet()) {
			if(sum.get(key)>=D) {
				result++;
			}
		}
		return result;
    }
	
	private void union(int i, int j, int[] parent, HashMap<Integer, Integer> sum) {
		int x = root(i, parent);
		int y = root(j, parent);
		int xValue = sum.get(x);
		int yValue = sum.get(y);
		
		if(x==y) {
			return;
		}
		else if(x>y) {
			parent[x]=y;
			sum.remove(x);
			sum.put(y, xValue+yValue);
		}
		else {
			parent[y]=x;
			sum.remove(y);
			sum.put(x, xValue+yValue);
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
		int c[][] = {{1,5},{2,3}};
		int b[]= {1,2,3,4,5};
		int a = 5;
		int d = 6;
		BatchSet bs = new BatchSet();
		System.out.println(bs.solve(a, b, c, d));
	}
}
