package programChallanges.list;

public class ReverseMerge {
	public ListNode reorderList(ListNode A) {
		if(A==null || A.next==null) {
			return A;
		}
		ListNode midElement = getMiddle(A);
		ListNode reverseList = reverse(midElement.next);
		midElement.next = null;
		mergeTwoList(A, reverseList);
		return A;
    }
	
	 private void mergeTwoList(ListNode a, ListNode b) {
		while(a!=null&& b!=null) {
			ListNode tempA= a.next;
			ListNode tempB= b.next;
			a.next=b;
			b.next=tempA;
			a = tempA;
			b= tempB;
		}
		
	}

	private ListNode reverse(ListNode A) {
	        ListNode head =null;
	        while(A!=null){
	            ListNode temp = A.next;
	            A.next= head;
	            head= A;
	            A=temp;
	          
	        }
	        return head;
	    }
	 
	 private ListNode getMiddle(ListNode A) {
	        ListNode fast=A;
	        ListNode slow=A;
	        
	        while(fast!=null && fast.next!=null && fast.next.next!=null){
	            slow = slow.next;
	            fast= fast.next.next;
	        }
	       return slow;
	    }
	    
	    public static void main(String[] args) {
	    	ListNode head =null;
	    	ListNode temp=null;
	    	for(int i=0;i<9;i++) {
	    		ListNode t= new ListNode(i+1);
	    		if(temp!=null) {
	    			temp.next= t;
	    			temp=t;
	    		}
	    		else {
	    			temp=t;
	    			head=t;
	    		}
	    	}
	    	ReverseMerge rl= new ReverseMerge();
	    	ListNode reverseList = rl.reorderList(head);
	    	while(reverseList!=null) {
	    		System.out.print(reverseList.val+" ");
	    		reverseList = reverseList.next;
	    	}
	    	
		}

}
