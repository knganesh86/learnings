package programChallanges.heaps;

import java.util.ArrayList;

import programChallanges.list.ListNode;

public class MergeKList {
	class Heap{
		ListNode arr[];
		int n=0;
		Heap(int size){
			arr= new ListNode[size];
		}
		public void insert(ListNode value) {
			if(value==null) {
				return;
			}
			arr[n]=value;
			int i =n;
			n++;
			while(i>0) {
				int p = (i-1)/2;
				if(arr[p].val>arr[i].val) {
					ListNode temp = arr[p];
					arr[p]=arr[i];
					arr[i]=temp;
					i=p;
				}
				else {
					break;
				}
			}
		}
		
		public ListNode getMin() {
			if(n==0) {
				return null;
			}
			ListNode ans = arr[0];
			arr[0]=arr[0].next;
			if(arr[0]==null) {
				arr[0]=arr[n-1];
				n--;
			}
			int i=0;
			while(i<n) {
				int left=2*i+1;
				int right= left+1;
				if(right<n) {
					if(arr[left].val<=arr[i].val && arr[left].val<=arr[right].val) {
						ListNode temp = arr[left];
						arr[left]=arr[i];
						arr[i]=temp;
						i=left;
					}
					else if(arr[right].val<=arr[i].val && arr[right].val<=arr[left].val) {
						ListNode temp = arr[right];
						arr[right]=arr[i];
						arr[i]=temp;
						i=right;
					}
					else {
						break;
					}
					
				}
				else if(left<n && arr[left].val<=arr[i].val) {
					ListNode temp = arr[left];
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
	public ListNode mergeKLists(ArrayList<ListNode> a) {
		Heap h = new Heap(a.size());
		for(ListNode aList :a) {
			h.insert(aList);
		}
		ListNode head = null;
		ListNode temp = null;
		while(h.getSize()>0) {
			ListNode next = h.getMin();
			if(temp==null) {
				head=next;
				temp = next;
			}
			else {
				temp.next=next;
				temp = temp.next;
			}
		}
		return head;
	}
	
	public static void main(String[] args) {
    	ListNode head =null;
    	ListNode temp=null;
    	ArrayList<ListNode> list = new ArrayList<>();
    	for(int i=0;i<15;i+=2) {
    		int value = i;
    		   		
    		ListNode t= new ListNode(value);
    		if(temp!=null) {
    			temp.next= t;
    			temp=t;
    		}
    		else {
    			temp=t;
    			list.add(t);
    		}
    	}
    	temp = null;
    	for(int i=0;i<25;i+=3) {
    		int value = i*i;
    		    		
    		ListNode t= new ListNode(value);
    		if(temp!=null) {
    			temp.next= t;
    			temp=t;
    		}
    		else {
    			temp=t;
    			list.add(t);
    		}
    	}
    	temp = null;
    	for(int i=1;i<15;i+=5) {
    		int value = i+i;
    		    		
    		ListNode t= new ListNode(value);
    		if(temp!=null) {
    			temp.next= t;
    			temp=t;
    		}
    		else {
    			temp=t;
    			list.add(t);
    		}
    	}
    	MergeKList m = new MergeKList();
    	ListNode mergeList = m.mergeKLists(list);
    	while(mergeList!=null) {
    		System.out.print(mergeList.val+" ");
    		mergeList = mergeList.next;
    	}
    	
    	
	}
}
