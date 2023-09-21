package javaalgorithm.study;

import java.util.LinkedList;

//https://leetcode.com/problems/implement-stack-using-queues/
public class MyStack {
	private LinkedList<Integer> queue;

	public MyStack() {
		queue = new LinkedList<>();
	}

	public void push(int x) {
		queue.add(x);
		int size = queue.size();
		while (size > 1) {
			queue.add(queue.remove());
			size--;
		}
	}

	public int pop() {
		return queue.remove();
	}

	public int top() {
		return queue.peek();
	}

	public boolean empty() {
		return queue.isEmpty();
	}

	@Override
	public String toString() {
		return "MyStack{" +
				"queue=" + queue +
				'}';
	}
}
