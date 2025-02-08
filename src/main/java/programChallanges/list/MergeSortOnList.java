package programChallanges.list;

public class MergeSortOnList {
	 public ListNode mergeTwoLists(ListNode A, ListNode B) {
	        ListNode head= null;
	        ListNode temp = null;
	        if(A.val<B.val){
	            head = A;
	            A= A.next;
	        }
	        else{
	            head = B;
	            B=B.next;
	        }
	        temp = head;
	        while(A!=null && B!=null){
	            if(A.val<B.val){
	                temp.next = A;
	                A= A.next;
	            }
	            else{
	                temp.next = B;
	                B=B.next;
	            }
	            temp = temp.next;
	        }
	        if(A!=null){
	            temp.next=A;
	        }
	        else{
	            temp.next=B;
	        }
	        return head;
	    }
	 
	 public ListNode getMiddle(ListNode A) {
	        ListNode fast=A;
	        ListNode slow=A;
	        
	        while(fast!=null && fast.next!=null && fast.next.next!=null){
	            slow = slow.next;
	            fast= fast.next.next;
	        }
	       return slow;
	    }
	 
	 public ListNode sortList(ListNode A) {
		 if(A==null || A.next ==null) {
			 return A;
		 }
		 ListNode mid = getMiddle(A);
		 ListNode H1 = A;
		 ListNode H2 = mid.next;
		 mid.next = null;
		 H1= sortList(H1);
		 H2 =sortList(H2);
		 return mergeTwoLists(H1, H2);
		 
	    }

    
    public static void main(String[] args) {
    	ListNode head =null;
    	ListNode temp=null;
    	for(int i=0;i<12;i++) {
    		int value = i;
    		if(i%3==0) {
    			value = value+(value*3);
    		}
    		if(i%2==0) {
    			value = value*value;
    		}
    		
    		ListNode t= new ListNode(value);
    		if(temp!=null) {
    			temp.next= t;
    			temp=t;
    		}
    		else {
    			temp=t;
    			head=t;
    		}
    	}
    	MergeSortOnList rl= new MergeSortOnList();
    	ListNode mergeList = rl.sortList(head);
    	while(mergeList!=null) {
    		System.out.print(mergeList.val+" ");
    		mergeList = mergeList.next;
    	}
    	
    	
	}

	
}
