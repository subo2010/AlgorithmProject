package ������._04������;


/**
 * �ڶ��������ҵ�һ���ڵ��ǰ���ڵ�
	
	˼·:���Է���,����һ���ڵ�,����˽ڵ�����ڵ�Ļ�����ǰ���ڵ�Ϊ�������������ҽڵ�
		����˽ڵ�û���������Ļ�-->�˽ڵ��ǲ��Ǹ��ڵ����Һ���,�������̽ڵ�Ϊ���ڵ�,����˽ڵ���丸�ڵ㶼ָ���丸�ڵ�(�������ƶ�)
		ֱ���˽ڵ�Ϊ���ڵ���Һ���,���̽ڵ�Ϊ�˸��ڵ�
	
 * @author Administrator
 *
 */
public class _02���Ҷ�������ǰ���ڵ� {
	public static void main(String[] args) {
		//����һ��������
		Node head = new Node(6);
		head.parent = null;
		head.left = new Node(3);
		head.left.parent = head;
		head.left.left = new Node(1);
		head.left.left.parent = head.left;
		head.left.left.right = new Node(2);
		head.left.left.right.parent = head.left.left;
		head.left.right = new Node(4);
		head.left.right.parent = head.left;
		head.left.right.right = new Node(5);
		head.left.right.right.parent = head.left.right;
		head.right = new Node(9);
		head.right.parent = head;
		head.right.left = new Node(8);
		head.right.left.parent = head.right;
		head.right.left.left = new Node(7);
		head.right.left.left.parent = head.right.left;
		head.right.right = new Node(10);
		head.right.right.parent = head.right;

		Node test = head.left.left;  // 1's before is null(����nullԪ�޷�����.value)
		System.out.println(test.value + " before: " + getSuccessorNode(test));
//		test = head.left.left.right;
//		System.out.println(test.value + " next: " + getSuccessorNode(test).value);
//		test = head.left;
//		System.out.println(test.value + " next: " + getSuccessorNode(test).value);
//		test = head.left.right;
//		System.out.println(test.value + " next: " + getSuccessorNode(test).value);
//		test = head.left.right.right;
//		System.out.println(test.value + " next: " + getSuccessorNode(test).value);
//		test = head;
//		System.out.println(test.value + " next: " + getSuccessorNode(test).value);
//		test = head.right.left.left;
//		System.out.println(test.value + " next: " + getSuccessorNode(test).value);
//		test = head.right.left;
//		System.out.println(test.value + " next: " + getSuccessorNode(test).value);
//		test = head.right;
//		System.out.println(test.value + " next: " + getSuccessorNode(test).value);
		test = head.right.right; // 10's next is null
		System.out.println(test.value + " before: " + getSuccessorNode(test).value);
	}
	//����Ķ�����
	public static class Node {
		public int value;
		public Node left;
		public Node right;
		public Node parent;
		public Node(int data) {
			this.value = data;
		}
	}
	
	//ͨ������һ���ڵ��������ǰ���ڵ�
	public static Node getSuccessorNode(Node node) {
		if (node == null) {
			return node;
		}
		if (node.left != null) {	//�������������Ϊ��,��������������ڵ�
			return getRightMost(node.left);
		} else {//���������Ϊ��
			Node parent = node.parent;
			while (parent != null && parent.right != node) {  //parent != null���пյ��߼� ��û�к�̵�ʱ�������parentָ���
				//����ͬʱָ���丸�ڵ�(ͬʱ������һ��)
				node = node.parent;
				parent = parent.parent;
			}
			return parent;
		}
	}

	public static Node getRightMost(Node node) {
		if (node == null) {
			return node;
		}
		while (node.right != null) {
			node = node.right;
		}
		return node;
	}
	
}
