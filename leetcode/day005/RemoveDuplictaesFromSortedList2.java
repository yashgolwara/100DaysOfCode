package day005;

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

public class RemoveDuplictaesFromSortedList2 {
	public ListNode deleteDuplicates(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}

		ListNode t = new ListNode(0);
		t.next = head;

		ListNode p = t;
		while (p.next != null && p.next.next != null) {
			if (p.next.val == p.next.next.val) {
				int dup = p.next.val;
				while (p.next != null && p.next.val == dup) {
					p.next = p.next.next;
				}
			} else {
				p = p.next;
			}

		}

		return t.next;

	}
}