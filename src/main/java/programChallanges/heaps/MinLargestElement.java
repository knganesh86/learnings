package programChallanges.heaps;

public class MinLargestElement {
	class Node{
		int incValue;
		int nextValue;
		Node(int value){
			 incValue = value;
			 nextValue=value+value;
		}
	}
	class Heap{
		Node arr[];
		int n=0;
		Heap(int size){
			arr= new Node[size];
		}
		public void insert(Node value) {
			if(value==null) {
				return;
			}
			arr[n]=value;
			int i =n;
			n++;
			while(i>0) {
				int p = (i-1)/2;
				if(arr[p].nextValue>arr[i].nextValue) {
					Node temp = arr[p];
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
			int ans = arr[0].nextValue;
			arr[0].nextValue=arr[0].nextValue+arr[0].incValue;
			
			int i=0;
			while(i<n) {
				int left=2*i+1;
				int right= left+1;
				if(right<n) {
					if(arr[left].nextValue<=arr[i].nextValue && arr[left].nextValue<=arr[right].nextValue) {
						Node temp = arr[left];
						arr[left]=arr[i];
						arr[i]=temp;
						i=left;
					}
					else if(arr[right].nextValue<=arr[i].nextValue && arr[right].nextValue<=arr[left].nextValue) {
						Node temp = arr[right];
						arr[right]=arr[i];
						arr[i]=temp;
						i=right;
					}
					else {
						break;
					}
					
				}
				else if(left<n && arr[left].nextValue<=arr[i].nextValue) {
					Node temp = arr[left];
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
	 public int solve(int[] A, int B) {
		 int max = A[0];
		 Heap h = new Heap(A.length);
	        for(int a:A){
	            h.insert(new Node(a));
	            max= Math.max(max, a);
	        }
	        for(int i=0;i<B;i++) {
	        	  max=Math.max(max, h.getMin());
	        }
	        return max;
	    }
	 public static void main(String[] args) {
		MinLargestElement ml = new MinLargestElement();
		int a[]= {5,1,4,2};
		System.out.println(ml.solve(a, 11));
	}
}
