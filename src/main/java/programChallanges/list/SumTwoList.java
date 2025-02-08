package programChallanges.list;

public class SumTwoList {
	public static void main(String[] args) {
		ListNode a = new ListNode(9);
		a.next=new ListNode(9);
		ListNode b = new ListNode(1);
		b.next = new ListNode(9);
		ListNode x= sum(a,b);
		while(x!=null) {
    		System.out.print(x.val+" ");
    		x = x.next;
    	}
	}

	private static ListNode sum(ListNode a, ListNode b) {
		ListNode head = null;
		ListNode pointer = null;
		int carry =0;
		while(a!=null||b!=null || carry!=0) {
			if(a!=null) {
				carry+=a.val;
				a=a.next;
			}
			if(b!=null) {
				carry+=b.val;
				b=b.next;
			}
			ListNode newNode = new ListNode(carry%10);
			carry /=10;
			if(pointer==null) {
				head= newNode;
			}
			else {
				pointer.next = newNode;
			}
			pointer = newNode;
		}
		return head;
	}
}
