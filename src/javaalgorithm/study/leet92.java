package javaalgorithm.study;

public class leet92 {
	public static void main(String[] args) {
		leet92 con = new leet92();

		con.reverseBetween(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5,null ))))), 2, 4);
	}
	public ListNode reverseBetween(ListNode head, int left, int right) {
		if(head == null) return null;
		ListNode dummy = new ListNode(0);
		dummy.next = head; // 첫노드 다음부터 head가 들어감

		ListNode pre = dummy; //첫노드 포함 전체노드


		for (int i = 0; i < left - 1; i++){ //
			pre = pre.next;

		}

		ListNode start = pre.next;
		ListNode then = start.next;

		for (int i = 0; i < right-left; i++) {
			start.next = then.next;
			then.next = pre.next;
			pre.next = then;
			then = start.next;
		}

		return dummy.next;
	}

	public static class ListNode {
		int val;
		ListNode next;
		ListNode() {}
		ListNode(int val) { this.val = val; }
		ListNode(int val, ListNode next) { this.val = val; this.next = next; }

		@Override
		public String toString() {
			return "ListNode{" +
					"val=" + val +
					", next=" + next +
					'}';
		}
	}

}




