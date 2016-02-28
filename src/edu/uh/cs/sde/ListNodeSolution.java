package edu.uh.cs.sde;

public class ListNodeSolution {

	public ListNode reverseList(ListNode head) {
		
		ListNode tmp = new ListNode(0);
		
		while(head.next!=null){
			tmp = head;
			head = head.next;
			head.next = tmp;
		}
		
		return head;
	}
}
