package day016;

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

	public class ReverseLinkedList {

		// recursion
		public ListNode reverseList(ListNode head) {
			ListNode fakeHead = new ListNode(-1);
			reverse(head, fakeHead);
			return fakeHead.next;
		}

		// reverse returns the tail of the reversed list
		private ListNode reverse(ListNode node, ListNode fakeHead) {
			if (node == null)
				return fakeHead;
			else {
				ListNode tail = reverse(node.next, fakeHead);
				tail.next = node;
				node.next = null;
				return node;
			}
		}
	}

	// iterative
	public ListNode reverseList(ListNode head) {
		ListNode fakeHead = new ListNode(-1);
		ListNode node = head;
		while (node != null) {
			ListNode nodeNext = node.next;
			node.next = fakeHead.next;
			fakeHead.next = node;
			node = nodeNext;
		}
		return fakeHead.next;
	}
}
