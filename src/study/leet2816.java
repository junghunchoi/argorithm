package study;

//https://leetcode.com/contest/weekly-contest-358/problems/double-a-number-represented-as-a-linked-list/
public class leet2816 {

	public ListNode doubleIt(ListNode head) {

		/*
		배운거
		1) 링크드리스트 순회하는 방법
		2) 조건에 따라 개별적으로 쪼게는 방법을 생각해야한다.

		1) 2023.08.13 어떻게 푸는지 학습했다. 1
		 */


		if(head.val > 4)
			head = new ListNode(0, head);

		for (ListNode node = head; node != null; node = node.next) {
			node.val = (node.val * 2) % 10;
			System.out.println(node.val);
			if (node.next != null && node.next.val > 4) {
				System.out.println("ifin");
				node.val++;
			}
		}

		return head;
	}



	public class ListNode {
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

