package day011;

//Definition for singly-linked list.
class ListNode {
	int val;
	ListNode next;

	ListNode() {
	}

	ListNode(int val) {
		this.val = val;
	}

	ListNode(int val, ListNode next) {
		this.val = val;
		this.next = next;
	}
}

public class RemoveNthNodeFromEndOfList {

	// fast and slow pointer
	public ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode fakeHead = new ListNode(-1);
		fakeHead.next = head;
		ListNode fast = fakeHead;
		ListNode slow = fakeHead;
		for (int i = 0; i < n; i++) {
			fast = fast.next;
		}
		while (fast.next != null) {
			slow = slow.next;
			fast = fast.next;
		}
		slow.next = slow.next.next;
		return fakeHead.next;
	}

	public ListNode removeNthFromEndLength(ListNode head, int n) {
		int len = 0;
		ListNode tmp = head;
		while (tmp != null) {
			tmp = tmp.next;
			len++;
		}
		int toDelete = len - n;
		ListNode fakeHead = new ListNode(-1);
		ListNode parent = fakeHead;
		parent.next = head;
		while (toDelete > 0) {
			parent = parent.next;
			toDelete--;
		}
		parent.next = parent.next.next;
		return fakeHead.next;
	}
}
