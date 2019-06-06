package ������._04������;

import org.junit.Test;

import ������._04������._00ֱ�۴�ӡ������.Node;



/**
 * morris����:ԭ�����ǿ���ʵ����O(logN)��ʱ�临�Ӷ���ʵ�ֶ�ȡΪO(1)�ռ临�Ӷ�
 * morris������ԭ��:
 * 	1.��ǰ�ڵ��Ϊcur,���cur������,cur�����ƶ�(cur=cur.right)
 * 	2.���cur������.�ҵ�cur�����������ҵĽڵ�,��Ϊmostright
 * 		1>���mostright��rightָ��ָ���,����ָ��cur,Ȼ��cur�����ƶ�
 * 		2>���mostright��rightָ��ָ��cur,����ָ�ؿ�
 * 		3>Ȼ��cur�����ƶ�
 * 
 */
public class _09��������Morris���� {
	@Test
	public void main() {
		Node head = new Node(1);
		head.left = new Node(2);
		head.right = new Node(3);
		head.left.left = new Node(4);
		head.right.right = new Node(5);
		printTree(head);
		morrisIn(head);	//����morris������������
	}
	
	//��������Ľ��
	private void morrisIn(Node head) {
		if (head == null) {
			return;
		}
		Node cur = head;
		Node mostRight = null;
		while(cur != null){
			mostRight = cur.left;
			if (mostRight != null) {
				while(mostRight.right != null && mostRight.right != cur){
					mostRight = mostRight.right;
				}
				if (mostRight.right == null) {
					mostRight.right = cur;
					cur = cur.left;
					continue;
				} else{
					mostRight.right = null;
				}
			}
			System.out.print(cur.value + " ");
			cur = cur.right;
		}
		System.out.print(cur.value + " ");
	}


	//-----------������-----------������-----------������-----------������-----------������-----------
	public class Node {
		public int value;
		public Node left;
		public Node right;
		public Node(int data) {
			this.value = data;
		}
	}
	
	public void printTree(Node head) {
		System.out.println("Binary Tree:");
		printInOrder(head, 0, "H", 17);
		System.out.println();
	}

	public void printInOrder(Node head, int height, String to, int len) {
		if (head == null) {
			return;
		}
		printInOrder(head.right, height + 1, "v", len);
		String val = to + head.value + to;
		int lenM = val.length();
		int lenL = (len - lenM) / 2;
		int lenR = len - lenM - lenL;
		val = getSpace(lenL) + val + getSpace(lenR);
		System.out.println(getSpace(height * len) + val);
		printInOrder(head.left, height + 1, "^", len);
	}

	public  String getSpace(int num) {
		String space = " ";
		StringBuffer buf = new StringBuffer("");
		for (int i = 0; i < num; i++) {
			buf.append(space);
		}
		return buf.toString();
	}
}
