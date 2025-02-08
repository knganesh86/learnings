package programChallanges.heaps;

import java.util.ArrayList;

public class ConnectRope {

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
	public int solve(ArrayList<Integer> A) {
		Heap h = new Heap(A.size());
		for(int a:A) {
			h.insert(a);
		}
		int ans =0;
		while(h.getSize()>0) {
			int x = h.getMin();
			int y=h.getMin();
			
			int newRope = x+y;
			System.out.println(x+" + " +y +" = "+newRope);
			System.out.println("heapSize"+ h.getSize());
			if(h.getSize()>0) {
				h.insert(newRope);
			}
			ans+=newRope;
			
		}
		return ans;
    }
	public static void main(String[] args) throws Exception {
		//6,19,9,14,17,16,7,2,14,4,3
		ArrayList<Integer> a = new ArrayList<>();
		a.add(6);
		a.add(19);
		a.add(9);
		a.add(14);
		a.add(17);
		a.add(16);
		a.add(7);
		a.add(2);
		a.add(14);
		a.add(4);
		a.add(3);
	//	a.add(2);
		ConnectRope c = new ConnectRope();
		
		System.out.println(c.solve(a));
	}
}
