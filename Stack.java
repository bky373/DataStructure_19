package DataStructure;

import java.util.EmptyStackException;

public class Stack<T> {
	class Node<T> {
		private T data;
		private Node<T> next;

		Node(T data) {
			this.data = data;
		}
	}

	private Node<T> top;

	public T pop() {
		if (top == null) {
			throw new EmptyStackException();
		}
		T item = top.data;
		top = top.next;

		return item;
	}

	public void push(T item) {
		Node<T> t = new Node<T>(item);
		t.next = top; // 기존 top과 t를 연결(*수평적으로 생각)
		top = t; // top 재배치
	}

	public T peek() {
		if (top == null) {
			throw new EmptyStackException();
		}
		return top.data;
	}

	public boolean isEmpty() {
		return top == null;
	}
}
