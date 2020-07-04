package _02�����㷨._03����;

import java.util.Stack;

/*
 �ж�һ�������Ƿ�Ϊ���Ľṹ(���ַ�ʽ)
	����Ŀ�� ����һ�������ͷ�ڵ�head�����жϸ������Ƿ�Ϊ���Ľṹ�� 
		���磺 1->2->1������true�� 
			 1->2->2->1������true��
			 15->6->15������true��
			 1->2->3������false��
	���ף� ���������ΪN��ʱ�临�ӶȴﵽO(N)������ռ临�ӶȴﵽO(1)
	
	˼·1:(�ռ临�Ӷ�n)�������ͷ������ηŵ�ջ��,�����,ÿ�δ�ջ��ȡ��һ��Ԫ�غ�����Ƚ�,�������ȷ���false
		������򷵻�true
	˼·2:һ����ָ��һ����ָ��,�ҵ�������е�
 */
public class _02�ж������Ƿ�Ϊ���� {
	
	public static class Node {
		public int value;
		public Node next;

		public Node(int data) {
			this.value = data;
		}
	}

	//����һ:��ҪO(n)�Ķ���ռ�
	public static boolean isPalindrome1(Node head) {
		//����һ��ջ����
		Stack<Node> stack = new Stack<Node>();
		Node cur = head;	//headָ�벻�ܱ���Ϊ���滹Ҫ�õ�
		//�������е�����Ԫ�ض�װ��ջ��
		while (cur != null) {
			stack.push(cur);
			cur = cur.next;
		}
		//��ջ�е�Ԫ�������ó����������Ԫ�ضԱ�,������ڲ�ͬ���������ǻ���
		while (head != null) {
			if (head.value != stack.pop().value) {
				return false;
			}
			head = head.next;
		}
		return true;
	}

	//������:��Ҫn/2�Ķ���ռ�
	public static boolean isPalindrome2(Node head) {
		//û��Ԫ�غ�ֻ��һ��Ԫ��ʱֱ�ӷ���true
		if (head == null || head.next == null) {
			return true;
		}
		
		//����һ����ָ��curһ����ָ��right,��cur�ߵ�ͷʱright���ô����м��λ��(Ȼ��ֻ���Ұ벿��ѹ��ջ��,��Լһ��Ŀռ�)
		Node right = head.next; //��ָ����ǰһ��123->3  1234->3
		Node cur = head;		//��ָ�������
		while (cur.next != null && cur.next.next != null) {
			right = right.next;
			cur = cur.next.next;
		}
		//����ջ,���Ұ벿��װ��ȥ
		Stack<Node> stack = new Stack<Node>();
		while (right != null) {
			stack.push(right);
			right = right.next;
		}
		while (!stack.isEmpty()) {
			if (head.value != stack.pop().value) {
				return false;
			}
			head = head.next;
		}
		return true;
	}

	//������:��ҪO(1)�Ķ���ռ�
	public static boolean isPalindrome3(Node head) {
		if (head == null || head.next == null) {
			return true;
		}
		Node n1 = head; 	//��ָ����ǰһ��123->2  1234->2
		Node n2 = head;
		while (n2.next != null && n2.next.next != null) { // find mid node
			n1 = n1.next; 		// n1 -> mid
			n2 = n2.next.next; 	// n2 -> end
		}
		n2 = n1.next; // n2 -> right part first node
		n1.next = null; // mid.next -> null
		Node n3 = null;
		while (n2 != null) { // right part convert
			n3 = n2.next; // n3 -> save next node
			n2.next = n1; // next of right node convert
			n1 = n2; // n1 move
			n2 = n3; // n2 move
		}
		n3 = n1; // n3 -> save last node
		n2 = head;// n2 -> left first node
		boolean res = true;
		while (n1 != null && n2 != null) { // check palindrome
			if (n1.value != n2.value) {
				res = false;
				break;
			}
			n1 = n1.next; // left to mid
			n2 = n2.next; // right to mid
		}
		n1 = n3.next;
		n3.next = null;
		while (n1 != null) { // recover list
			n2 = n1.next;
			n1.next = n3;
			n3 = n1;
			n1 = n2;
		}
		return res;
	}
	
	
	//��ӡ�б�Ԫ�صĹ�����
	public static void printLinkedList(Node node) {
		System.out.print("Linked List: ");
		while (node != null) {
			System.out.print(node.value + " ");
			node = node.next;
		}
		System.out.println();
	}

	public static void main(String[] args) {

		Node head = null;
		printLinkedList(head);
		System.out.print(isPalindrome1(head) + " | ");
		System.out.print(isPalindrome2(head) + " | ");
		System.out.println(isPalindrome3(head) + " | ");
		printLinkedList(head);
		System.out.println("=========================");

		head = new Node(1);
		printLinkedList(head);
		System.out.print(isPalindrome1(head) + " | ");
		System.out.print(isPalindrome2(head) + " | ");
		System.out.println(isPalindrome3(head) + " | ");
		printLinkedList(head);
		System.out.println("=========================");

		head = new Node(1);
		head.next = new Node(2);
		printLinkedList(head);
		System.out.print(isPalindrome1(head) + " | ");
		System.out.print(isPalindrome2(head) + " | ");
		System.out.println(isPalindrome3(head) + " | ");
		printLinkedList(head);
		System.out.println("=========================");

		head = new Node(1);
		head.next = new Node(1);
		printLinkedList(head);
		System.out.print(isPalindrome1(head) + " | ");
		System.out.print(isPalindrome2(head) + " | ");
		System.out.println(isPalindrome3(head) + " | ");
		printLinkedList(head);
		System.out.println("=========================");

		head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		printLinkedList(head);
		System.out.print(isPalindrome1(head) + " | ");
		System.out.print(isPalindrome2(head) + " | ");
		System.out.println(isPalindrome3(head) + " | ");
		printLinkedList(head);
		System.out.println("=========================");

		head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(1);
		printLinkedList(head);
		System.out.print(isPalindrome1(head) + " | ");
		System.out.print(isPalindrome2(head) + " | ");
		System.out.println(isPalindrome3(head) + " | ");
		printLinkedList(head);
		System.out.println("=========================");

		head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		head.next.next.next = new Node(1);
		printLinkedList(head);
		System.out.print(isPalindrome1(head) + " | ");
		System.out.print(isPalindrome2(head) + " | ");
		System.out.println(isPalindrome3(head) + " | ");
		printLinkedList(head);
		System.out.println("=========================");

		head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(2);
		head.next.next.next = new Node(1);
		printLinkedList(head);
		System.out.print(isPalindrome1(head) + " | ");
		System.out.print(isPalindrome2(head) + " | ");
		System.out.println(isPalindrome3(head) + " | ");
		printLinkedList(head);
		System.out.println("=========================");

		head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		head.next.next.next = new Node(2);
		head.next.next.next.next = new Node(1);
		printLinkedList(head);
		System.out.print(isPalindrome1(head) + " | ");
		System.out.print(isPalindrome2(head) + " | ");
		System.out.println(isPalindrome3(head) + " | ");
		printLinkedList(head);
		System.out.println("=========================");

	}
}


//������-----������-------������------������------������---------������------------������-------------������-------������---

