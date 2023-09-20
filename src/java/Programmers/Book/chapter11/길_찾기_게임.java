package java.Programmers.Book.chapter11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//https://school.programmers.co.kr/learn/courses/30/lessons/42892
public class 길_찾기_게임 {

	public static void main(String[] args) {
		길_찾기_게임 con = new 길_찾기_게임();

		int[][] arr = {{5, 3}, {11, 5}, {13, 3}, {3, 5}, {6, 1}, {1, 3}, {8, 6}, {7, 2}, {2, 2}}; // x,y축

		con.solution(arr);

	}


	public int[][] solution(int[][] nodeInfo) {

		Node[] nodes = new Node[nodeInfo.length];

		for (int i = 0; i < nodes.length; i++) {
			nodes[i] = new Node(i + 1, nodeInfo[i][0], nodeInfo[i][1]);
		}


		Arrays.sort(nodes, (a, b) -> b.y - a.y);

		Node root = constructTree(nodes);



		List<Integer> preorder = new ArrayList<>();
		pre(root, preorder);

		List<Integer> postorder = new ArrayList<>();
		post(root, postorder);

		return new int[][]{
				preorder.stream().mapToInt(Integer::intValue).toArray(),
				postorder.stream().mapToInt(Integer::intValue).toArray(),
		};
	}

	private Node constructTree(Node[] nodes) {
		Node root = nodes[0];

		for (int i = 1; i < nodes.length; i++) {
			insert(root,nodes[i]);
		}

		return root;
	}

	private void insert(Node root, Node node) {
		if(root.x<node.x) root.left = node;
		else root.right = node;
	}

	//전위 순회 함수
	private void pre(Node node, List<Integer> visits) {
		if(node==null) return;

		visits.add(node.value);
		pre(node.left, visits);
		pre(node.right, visits);
	}

	//후위 순회 함수
	private void post(Node node, List<Integer> visits) {
		if(node==null) return;

		visits.add(node.value);
		post(node.left, visits);
		post(node.right, visits);

	}



	private static class Node{
		public final int value;
		public final int x;
		public final int y;

		public Node left;
		public Node right;

		public Node(int value, int x, int y) {
			this.value = value;
			this.x = x;
			this.y = y;
		}

		@Override
		public String toString() {
			return "Node{" +
					"value=" + value +
					", x=" + x +
					", y=" + y +
					", left=" + left +
					", right=" + right +
					'}';
		}
	}
}


