package Programmers.Book.chapter11;

import java.util.List;

//https://school.programmers.co.kr/learn/courses/30/lessons/42892
public class 길_찾기_게임 {

	public static void main(String[] args) {
		int[][] arr = {{5, 3}, {11, 5}, {13, 3}, {3, 5}, {6, 1}, {1, 3}, {8, 6}, {7, 2}, {2, 2}};

	}


	public int[] solution(int[][] arr) {

		return null;
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

		pre();
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
	}
}
