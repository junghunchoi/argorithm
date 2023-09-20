package java.study;

import java.util.HashMap;
import java.util.Map;

public class leet138 {
	public Node copyRandomList(Node head) {

		Map<Node, Node> map = new HashMap<>();

		Node p = head;
		while (p != null) {
			map.put(p, new Node(p.val));
			p = p.next;
		}

		Node q = head;
		while (q != null) {
			map.get(q).next = map.get(q.next);// 새로운 헤드의 next에 기존 head의 next 값을 넣는다.
			map.get(q).random = map.get(q.random);
			q = q.next;
		}

		return map.get(head);
	}


	private static class Node {
		int val;
		Node next;
		Node random;

		public Node(int val) {
			this.val = val;
			this.next = null;
			this.random = null;
		}
	}
}
