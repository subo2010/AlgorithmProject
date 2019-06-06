package ������._04������;

import java.util.LinkedList;
import java.util.Queue;


/**
 * ��ȫ������:��������������Ϊh������ h ���⣬�������� (1��h-1)�Ľ�������ﵽ���������� h�����еĽ�㶼���������������
 * 		1.���������ղ�α���,����ÿ���ڵ���������(��������)
 * 		-->1.�˽ڵ����ҽڵ㶼��-->��������
 * 		-->2.�˽ڵ����ҽڵ�û����ڵ�-->����false
 * 		-->3.�˽ڵ�����ڵ�û���ҽڵ�-->����������ΪҶ�ڵ�
 * 		-->4.�˽ڵ�û�����ҽڵ�(Ҷ�ڵ�)-->����������ΪҶ�ڵ�
 */
public class _07�ж��Ƿ�Ϊ��ȫ������ {
	public static void main(String[] args) {
//		Tree mytree = new Tree(); 
//		mytree.add(4);
//		mytree.add(2);
//		mytree.add(6);
//		mytree.add(1);
//		mytree.add(3);
//		mytree.add(5);
//		mytree.add(7);
//		boolean b = isCompleteTree(mytree.head);
		Node head = new Node(1);
		head.left = new Node(2);
		head.right = new Node(3);
		head.left.left = new Node(4);
		head.right.right = new Node(5);
		printTree(head);
		boolean b = isCompleteTree(head);
		System.out.println(b);
		
		head = new Node(100);
		head.left = new Node(21);
		head.right = new Node(-42);
		printTree(head);
		boolean b1 = isCompleteTree(head);
		System.out.println(b1);
	}
	
	//�ж��Ƿ�Ϊ��ȫ������(���ò�α���ʵ��)
	private static boolean isCompleteTree(Node head) {
		if (head==null) {
			return true;
		}
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(head);
		boolean flag=false; //�ж��Ƿ����������3��4
		while (!queue.isEmpty()) {
			head = queue.poll();
			{//�ֲ�������а��������ж��߼�
//				System.out.print(head.val+" ");
				if (head.right!=null&&head.left!=null&&!flag) {
				} else if (head.right!=null&&head.left==null&&!flag) {
					return false;
				} else {
					flag = true;
				}
				if (flag) {
					if (head.right!=null||head.left!=null) {
						return false;
					}
				}
			}
			if (head.left!=null) {
				queue.add(head.left);
			}
			if (head.right!=null) {
				queue.add(head.right);
			}
		}
		return true;
	}
	
	// for test -- print tree  ----���ߴ�ӡ��------���ߴ�ӡ��------���ߴ�ӡ��------���ߴ�ӡ��------���ߴ�ӡ��------
		public static class Node {
			public int val;
			public Node left;
			public Node right;

			public Node(int data) {
				this.val = data;
			}
		}
		
		public static void printTree(Node head) {
			System.out.println("Binary Tree:");
			printInOrder(head, 0, "H", 17);
			System.out.println();
		}

		public static void printInOrder(Node head, int height, String to, int len) {
			if (head == null) {
				return;
			}
			printInOrder(head.right, height + 1, "v", len);
			String val = to + head.val + to;
			int lenM = val.length();
			int lenL = (len - lenM) / 2;
			int lenR = len - lenM - lenL;
			val = getSpace(lenL) + val + getSpace(lenR);
			System.out.println(getSpace(height * len) + val);
			printInOrder(head.left, height + 1, "^", len);
		}

		public static String getSpace(int num) {
			String space = " ";
			StringBuffer buf = new StringBuffer("");
			for (int i = 0; i < num; i++) {
				buf.append(space);
			}
			return buf.toString();
		}
		
}
