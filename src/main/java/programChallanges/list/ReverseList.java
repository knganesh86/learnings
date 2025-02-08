package programChallanges.list;

public class ReverseList {
	
	public ListNode reverseList(ListNode A, int B) {
        ListNode head = null;
        ListNode nextHead=A;
        ListNode lastTail=null;
        ListNode nextTail=null;
        int i=0;
        while(nextHead!=null){
            i++;
            if(i%B==1){
            	nextTail = nextHead;
            }
            nextHead = nextHead.next;
            if(i%B==0){
                ListNode reverseHead = reverse(nextTail, B);

                if(lastTail==null) {
                	head=reverseHead;
                }
                else {
                	lastTail.next=reverseHead;
                }
                lastTail = nextTail;
                
            }
            
        }
        return head;
    }

    private ListNode reverse(ListNode A, int count) {
        ListNode head =null;
        int i=0;
        while(A!=null && i<count){
            ListNode temp = A.next;
            A.next= head;
            head= A;
            A=temp;
            i++;
        }
        return head;
    }
    
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
    	ReverseList rl= new ReverseList();
    	ListNode reverseList = rl.reverseList(head, 5);
    	while(reverseList!=null) {
    		System.out.print(reverseList.val+" ");
    		reverseList = reverseList.next;
    	}
    	
	}

	
}
