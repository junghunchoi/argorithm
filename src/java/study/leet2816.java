package java.study;

//https://leetcode.com/contest/weekly-contest-358/problems/double-a-number-represented-as-a-linked-list/
public class leet2816 {

	public ListNode doubleIt(ListNode head) {
		/*
		1) 2023.08.13 어떻게 푸는지 학습했다.
		2) 2023.08.25 풀어봤어도 하나도 모르냐 멍충아...
		 */
		if(head.val > 4)
			head = new ListNode(0, head);

		for (ListNode node = head; node != null; node = node.next) {
			node.val = (node.val * 2) % 10;
			if (node.next != null && node.next.val > 4) {
				node.val++;
			}
		}
		return head;

	}

	public static class ListNode {
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
}

