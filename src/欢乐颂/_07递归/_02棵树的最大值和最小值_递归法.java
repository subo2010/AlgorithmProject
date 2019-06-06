package ������._07�ݹ�;

import java.util.LinkedList;

import org.junit.Test;

/*
 * �ݹ������������������
 * ��Ŀ:����һ����������ͷ���.���ض������е�������Сֵ
 * 
 * ���ڽ�����ж�����������:
 * 	������ֽ�:����˵����һ��ͷ�����ܻ����һ�����
 * 		1.��Сֵ�����ֵ����������
 * 		2.��Сֵ�����ֵ����������
 * 		3.�Լ�Ϊͷ���������ֵ����Сֵ��һ��
 * 
 * 	���ǽ������Ǹ���ķֽ�����Ҫ������:
 * 		1.�����е����ֵ
 * 		2.�����е���Сֵ
 * 		3.�����е����ֵ
 * 		4.�����е���Сֵ
 * 	����Ϊÿ�εݹ麯����Ҫ���صĲ���:
 * 		1.�˽ڵ�Ϊͷ�����������ֵ
 * 		2.�˽ڵ�Ϊͷ����������Сֵ
 * 
 * 
 * ��һ��:��дһ������ֵ��
 * �ڶ���:���patition
 * 		1.д�ݹ麯���Ľ�ֹ����
 * 		2.�ֱ�õ����������������ķ���ֵ
 * 		3.ͨ�����������ķ���ֵ���õ���ǰ�ڵ�ķ���ֵ���ظ���
 */

public class _02���������ֵ����Сֵ_�ݹ鷨 {
	@Test
	public void main() {
		Tree mytree = new Tree();
		mytree.add(5);
		mytree.add(3);
		mytree.add(8);
		mytree.add(1);
		mytree.add(4);
		mytree.add(7);
		mytree.add(1);

		System.out.println(patition1(mytree.head).max);
		System.out.println(patition1(mytree.head).min);
	}

	// ����һ������ֵ���͵���
	public class ReturnDate {
		int max;
		int min;
		public ReturnDate(int max, int min) {
			this.max = max;
			this.min = min;
		}
	}

	public ReturnDate patition1(Node head) {
		if (head == null) {
			throw new RuntimeException("�����д�!");
		}
		return patition(head);
	}

	public ReturnDate patition(Node head) {
		// �ݹ��ֹ����
		if (head == null) {
			return new ReturnDate(Integer.MIN_VALUE, Integer.MAX_VALUE);
		}

		// �ݹ麯��(�������������������ܵõ�����ֵ)----> �ݹ�ĵ��ÿ��Ե����Ǻں�
		Node left = head.left;
		ReturnDate leftReturnDate = patition(left); // ����������ֵ
		Node right = head.right;
		ReturnDate rightReturnDate = patition(right); // ����������ֵ

		// �õ��������ߵķ���ֵ�Ժ�ʼ�ҳ���ǰ�ڵ����Ϣ���ظ���
		int max = Math.max(head.value,
				Math.max(leftReturnDate.max, rightReturnDate.max));
		int min = Math.min(head.value,
				Math.min(leftReturnDate.min, rightReturnDate.min));

		return new ReturnDate(max, min);
	}

	// ------------------------------������--------------------------------------------------------
	// �������Ľڵ����
	class Node {
		int value;
		Node left = null;
		Node right = null;

		public Node(int val) {
			this.value = val;
		}
	}

	// һ��������
	class Tree {
		public Node head = null; // ����һ�����Ԫ��

		// ���Ԫ��(�㼶���)
		public void add(int item) {
			Node node = new Node(item);
			if (head == null) {
				head = node;
				return;
			}

			LinkedList<Node> list = new LinkedList<Node>(); // ����һ���б����洢Ԫ��
			list.add(head); // ÿ��׷�ӵ�����β��
			while (list.size() != 0) {
				Node cur_node = list.getFirst(); // ÿ�δ�ͷ����ȡ(��ɾ��)
				list.removeFirst();
				if (cur_node.left == null) {
					cur_node.left = node;
					return;
				} else {
					list.add(cur_node.left);
				}

				if (cur_node.right == null) {
					cur_node.right = node;
					return;
				} else {
					list.add(cur_node.right);
				}
			}
		}
	}
}
