package list.linkedList.implementation;

public class LinkedList {
	// ù ��° ��带 ����Ű�� �ʵ�
	private Node head;
	private Node tail;
	private int size = 0;
	private class Node{
		//  �����Ͱ� ����� �ʵ�
		private Object data;
		// ���� ��带 ����Ű�� �ʵ�
		private Node next;
		// ��� ������
		public Node(Object input) {
			this.data = input;
			this.next = null;
		}
		// ����� ������ ���� ����ؼ� Ȯ���غ� �� �ִ� ���
		public String toString() {
			return String.valueOf(this.data);
		}
	}
	public void addFirst(Object input) {
		// ��带 �����մϴ�.
		Node newNode = new Node(input);
		// ���ο� ����� ���� ���� ��带 �����մϴ�.
		newNode.next = head;
		// ���� ���ο� ��带 �����մϴ�.
		head = newNode;
		size++;
		if(head.next == null) {
			tail = head;
		}
	}
	public void addLast(Object input) {
		// ��带 �����մϴ�.
		Node newNode = new Node(input);
		// ����Ʈ�� ��尡 ���ٸ� ù��° ��带 �߰��ϴ� �޼ҵ带 ����մϴ�.
		if(size == 0) {
			addFirst(input);
		} else {
			// ������ ����� ���� ���� ������ ��带 �����մϴ�.
			tail.next = newNode;
			// ������ ��带 �����մϴ�.
			tail = newNode;
			size++;
		}
	}
	Node node(int index) {
		Node x = head;
		for(int i=0; i<index; i++)
			x = x.next;
		return x;
	}
	public void add(int k, Object input) {
		// ���� k�� 0�̶�� ù��° ��忡 �߰��ϴ� ���̱� ������ addFirst�� ����մϴ�.
		if( k == 0 ) {
			addFirst(input);
		} else {
			// k-1��° temp1�� �����մϴ�.
			Node temp1 = node(k-1);
			// k��° ��带 temp2�� �����մϴ�.
			Node temp2 = temp1.next;
			// ���ο� ��带 �����մϴ�.
			Node newNode = new Node(input);
			// temp1�� ���� ���� ���ο� ��带 �����մϴ�.
			temp1.next = newNode;
			// ���ο� ����� ���� ���� temp2�� �����մϴ�.
			newNode.next = temp2;
			size++;
			// ���ο� ����� ���� ��尡 ���ٸ� ���ο� ��尡 ������ ����̱� ������ tail�� �����մϴ�.
			if(newNode.next == null)
				tail = newNode;
		}
	}
	public Object removeFirst() {
		// ù��° ��带 temp�� �����ϰ� head�� ���� �ι�° ���� �����մϴ�.
		Node temp = head;
		head = temp.next;
		// �����͸� �����ϱ� ���� ������ ���� �ӽ� ������ ����ϴ�.
		Object returnData = temp.data;
		temp = null;
		size--;
		return returnData;
	}
	public Object remove(int k) {
		if(k==0) return removeFirst();
		// k-1��° ��带 temp�� ������ �����մϴ�.
		Node temp = node(k-1);
		// ���� ��带 todoDeleted�� ����� �Ӵϴ�.
		// ���� ��带 ���� �����ϸ� ���� �� ���� ���� �� ��带 ������ �� �����ϴ�. 
		Node todoDeleted = temp.next;
		// ���� �� ����� ���� ���� ���� �� ��带 �����մϴ�.
		temp.next = temp.next.next;
		// ������ �����͸� �����ϱ� ���ؼ� returnData�� �����͸� �����մϴ�.
		Object returnData = todoDeleted.data;
		if(todoDeleted == tail) {
			tail = temp;
		}
		// temp.next�� �����մϴ�.
		todoDeleted = null;
		size--;
		return returnData;
	}
	public int size() {
		return size;
	}
	public Object get(int k) {
		Node temp = node(k);
		return temp.data;
	}
	public int indexOf(Object data) {
		// Ž�� ����� �Ǵ� ��带 temp�� �����մϴ�.
		Node temp = head;
		// Ž�� ����� ���° ������Ʈ�� �ִ����� �ǹ��ϴ� ������ index�� ����մϴ�.
		int index = 0;
		// Ž�� ���� Ž�� ����� ������ ���մϴ�.
		while(temp.data != data) {
			temp = temp.next;
			index++;
			// temp�� ���� null�̶�� ���� �� �̻� Ž�� ����� ���ٴ� ���� �ǹ��մϴ�.
			if (temp == null) return -1;
		}
		// Ž�� ����� ã�Ҵٸ� ����� �ε��� ���� �����մϴ�.
		return index;
	}
	public String toString() {
		// ��尡 ���ٸ� []�� �����մϴ�.
		if(head == null) return "[]";
		// Ž���� �����մϴ�.
		Node temp = head;
		String str = "[";
		// ���� ��尡 ���� ������ �ݺ����� �����մϴ�.
		// ������ ���� ���� ��尡 ���� ������ �Ʒ� ������ ������ ���� ���ܵ˴ϴ�.
		while(temp.next != null) {
			str += temp.data + ",";
			temp = temp.next;
		}
		// ������ ��带 ��°���� ���Խ�ŵ�ϴ�.
		str += temp.data;
		return str+"]";
	}
	public ListIterator listIterator() {
		return new ListIterator();
	}
	public class ListIterator{
		private Node next;
		private Node lastReturned;
		private int nextIndex;
		
		ListIterator(){
			next = head;
		}
		public Object next() {
			lastReturned = next;
			next = next.next;
			nextIndex++;
			return lastReturned.data;
		}
		public boolean hasNext() {
			return nextIndex < size();
		}
		public void add(Object input) {
			Node newNode = new Node(input);
			if(lastReturned == null) {
				head = newNode;
				newNode.next = next;
			} else {
				lastReturned.next = newNode;
				newNode.next = next;
			}
			lastReturned = newNode;
			nextIndex++;
			size++;
		}
		public void remove() {
			if(nextIndex == 0) {
				throw new IllegalStateException();	
			}
			LinkedList.this.remove(nextIndex-1);
			nextIndex--;
		}
	}
}
