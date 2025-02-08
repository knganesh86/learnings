package programChallanges.dp;

import java.util.HashSet;
import java.util.Objects;

public class KnightChess {
		class Pair{
			int x;
			int y;
			Pair(int x, int y){
				this.x = x;
				this.y =y;
			}
			@Override
			public int hashCode() {
				final int prime = 31;
				int result = 1;
				result = prime * result + Objects.hash(x, y);
				return result;
			}
			@Override
			public boolean equals(Object obj) {
				if (this == obj)
					return true;
				if (obj == null)
					return false;
				if (getClass() != obj.getClass())
					return false;
				Pair other = (Pair) obj;
				return x == other.x && y == other.y;
			}
			public String toString() {
				return this.x+" "+ this.y;
			}
			
		}
	  public int knight(int A, int B, int C, int D, int E, int F) {
		  boolean visited[][]= new boolean [A][B];
		  
		  HashSet<Pair> pList = new HashSet<Pair>();
		  pList.add(new Pair(C-1,D-1));
		  int length =0;
		  while(!pList.isEmpty()) {
			  HashSet<Pair> childList = new HashSet<Pair>();
			  for(Pair p: pList) {
				  visited[p.x][p.y]= true;
				  if(p.x==E-1 && p.y==F-1) {
					  return length;
				  }
				  childList.addAll(getChildPair(p, visited));
			  }
			  pList = childList;
			  length++;
			  System.out.println("increased");
		  }
		
		  return -1;
	    }
	private HashSet<Pair> getChildPair(Pair p, boolean[][] visited) {
		HashSet<Pair> nextNodes = new HashSet<>();
		int r = visited.length;
		int c = visited[0].length;
		int x = p.x;
		int y = p.y;
		if(x+1<r) {
			if(y+2<c && !visited[x+1][y+2]) {
				nextNodes.add(new Pair(x+1, y+2));
			}
			if(y-2>=0 && !visited[x+1][y-2]) {
				nextNodes.add(new Pair(x+1, y-2));
			}
		}
		if(x-1>=0) {
			if(y+2<c && !visited[x-1][y+2]) {
				nextNodes.add(new Pair(x-1, y+2));
			}
			if(y-2>=0 && !visited[x-1][y-2]) {
				nextNodes.add(new Pair(x-1, y-2));
			}
		}
		if(x+2<r) {
			if(y+1<c && !visited[x+2][y+1]) {
				nextNodes.add(new Pair(x+2, y+1));
			}
			if(y-1>=0 && !visited[x+2][y-1]) {
				nextNodes.add(new Pair(x+2, y-1));
			}
		}
		if(x-2>=0) {
			if(y+1<c && !visited[x-2][y+1]) {
				nextNodes.add(new Pair(x-2, y+1));
			}
			if(y-1>=0 && !visited[x-2][y-1]) {
				nextNodes.add(new Pair(x-2, y-1));
			}
		}
		System.out.println("next nodes " +nextNodes);
		return nextNodes;
	}
	public static void main(String[] args) {
		KnightChess kc = new KnightChess();
		System.out.println(kc.knight(7,13, 2, 8, 3, 4));
	}

}
