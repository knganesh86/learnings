package programChallanges.greedy;

import java.util.ArrayList;
import java.util.Collections;

public class FreeCars {
	class Car implements Comparable<Car>{
		int time;
		int amount;
		Car(int time, int amount){
			this.time = time;
			this.amount=amount;
		}
		@Override
		public int compareTo(Car o) {
			return this.time-o.time;
		}		
	}
	
	class Heap{
		int arr[];
		int n=0;
		Heap(int size){
			arr= new int[size];
		}
		public void insert(int value) {
			arr[n]=value;
			int i =n;
			n++;
			while(i>0) {
				int p = (i-1)/2;
				if(arr[p]>arr[i]) {
					int temp = arr[p];
					arr[p]=arr[i];
					arr[i]=temp;
					i=p;
				}
				else {
					break;
				}
			}
		}
		public int viewMin() {
			return arr[0];
		}
		
		public int getMin() {
			if(n==0) {
				return -1;
			}
			int ans = arr[0];
			arr[0]=arr[n-1];
			n--;
			int i=0;
			while(i<n) {
				int left=2*i+1;
				int right= left+1;
				if(right<n) {
					if(arr[left]<=arr[i] && arr[left]<=arr[right]) {
						int temp = arr[left];
						arr[left]=arr[i];
						arr[i]=temp;
						i=left;
					}
					else if(arr[right]<=arr[i] && arr[right]<=arr[left]) {
						int temp = arr[right];
						arr[right]=arr[i];
						arr[i]=temp;
						i=right;
					}
					else {
						break;
					}
					
				}
				else if(left<n && arr[left]<=arr[i]) {
					int temp = arr[left];
					arr[left]=arr[i];
					arr[i]=temp;
					i=left;
				}
				else {
					break;
				}
			}
			return ans;
		}	
		public int getSize() {
			return n;
		}
	}
	public int solve(int[] A, int[] B) {
		ArrayList<Car> list = new ArrayList<>();
	       for(int i=0;i<A.length;i++) {
	    	  list.add(new Car(A[i],B[i])); 
	       }
	       Collections.sort(list);
	       int t =0;
	       Heap h = new Heap(A.length);
	       for(Car a: list) {
	    	  if(a.time>t) {
	    		  h.insert(a.amount);
	    		  t++;
	    	  }
	    	  else {
	    		  if(a.amount>h.viewMin()) {
	    			  h.getMin();
	    			  h.insert(a.amount);
	    		  }
	    	  }
	       }
	       int ans =0;
	       while(h.getSize()>0) {
	    	   ans+=h.getMin();
	       }
	       return ans;
    }
	public static void main(String[] args) {
		FreeCars f = new FreeCars();
		int a[]= {3, 8, 7, 5};
		int b[]= {3, 1, 7, 19};
		System.out.println(f.solve(a,b));
	}
	
	

}
