package programChallanges.list;

public class SwapList {
	
	 public static void main(String[] args) {
	    	ListNode head =null;
	    	ListNode temp=null;
	    	for(int i=0;i<10;i++) {
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
	    	SwapList rl= new SwapList();
	    	ListNode reverseList = rl.swapList(head);
	    	while(reverseList!=null) {
	    		System.out.print(reverseList.val+" ");
	    		reverseList = reverseList.next;
	    	}
	    	
		}

	private ListNode swapList(ListNode head) {
		ListNode aNode = head;
		ListNode newHead = null;
		ListNode temp=null;
		while(aNode!=null&& aNode.next!=null){
			if(aNode == head) {
				newHead = aNode.next;
			}
			if(temp!=null) {
				temp.next= aNode.next;
			}
			temp = aNode;
			aNode = aNode.next.next;
			temp.next.next= temp;			
		}
		if(aNode!=null) {
			temp.next= aNode;
		}
		else {
			temp.next= null;
		}
		return newHead;
	}

}
