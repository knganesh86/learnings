package programChallanges.knapsack;

import java.util.ArrayList;
import java.util.Collections;

public class FractionalKnapsack {
	public static class Pair implements Comparable<Pair>{
		int price;
		int weight;
		
		Pair(int price,int weight){
			this.price=price;
			this.weight=weight;
		}

		@Override
		public int compareTo(Pair o) {
			Double value1 = this.price*1.0/this.weight;
			Double value2 = o.price*1.0/o.weight;
			return value2.compareTo(value1);
		}
	}
	public int solve(int[] A, int[] B, int C) {
		ArrayList<Pair> list = new ArrayList<Pair>();
		int ans=0;
		for(int i=0;i<A.length;i++) {
			Pair p = new Pair(A[i],B[i]);
			list.add(p);
		}
		Collections.sort(list);
		double sum=0.0;
		for(Pair p:list) {
			if(p.weight<=C) {
				sum+=p.price;
				C-=p.weight;
			}
			else {
				Double unit = p.price*(1.0*C/p.weight);
				C=0;
				sum+=unit;
				break;
			}
		}
		sum*=100;
		ans=(int)Math.floor(sum);
		return ans;
    }
	public static void main(String[] args) {
		int a[]= {3};
		int b[]= {20};
		FractionalKnapsack f = new FractionalKnapsack();
		System.out.println(f.solve(a, b, 17));
	}
	
}
