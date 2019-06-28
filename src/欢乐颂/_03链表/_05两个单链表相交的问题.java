package ������._03����;

/**
 * ����Ŀ�� �ڱ����У�����������л���Ҳ�����޻���
 * ���������������ͷ�ڵ� head1��head2����������������ཻ��Ҳ���ܲ��ཻ��
 * ��ʵ��һ�������� ������������ཻ���뷵���ཻ�ĵ�һ���ڵ㣻������ཻ������null ���ɡ�
 *  Ҫ���������1�ĳ���ΪN������2�ĳ���ΪM��ʱ�临�Ӷ���ﵽ O(N+M)��
 *  ����ռ临�Ӷ���ﵽO(1)��
 *  
 *  ˼·:1.�����ж�һ��������û�л�,����л��Ļ����ص�һ���뻷�Ľڵ�
 *  	���ַ�ʽ�����:��һ���ǽ������η���HashSet������,ÿ�η���ǰ�鿴�Ƿ��������а�������˵���л�,��һ���ڵ��Ϊ�˽ڵ�(�˷�����Ҫ���⸨���ռ�)
 *  		�ڶ��ַ���:�ǿ���ָ�뷨,����һ����ָ��(����������)��һ����ָ��(һ����һ��),�����ָ���ߵ�ͷ˵���޻�,����֮ǰ������ָ������˵�����ڻ�,
 *  		��������ʱ��,��ָ��ָ��headλ��ת��Ϊ��ָ��,��ָ�벻��,�����ڴ������ĵ�����뻷��
 *  	2.�ж����������Ƿ����ཻ,����Ҫ֪�����Ǹ����Ƿ��л�
 *  		���1:����A�л�,����B�޻�-----���Ȼ���ཻ
 *  		���2:����A�޻�,����B�޻�-----���ܻ��ཻ
 *  		���3:����A�л�,����B�л�-----���ܻ��ཻ(�ཻ�ҽ����ڻ���)
 *  		���3:����A�л�,����B�л�-----���ܻ��ཻ(�ཻ�ҽ����ڻ���)
 * @author Administrator
 */
public class _05�����������ཻ������ {
	public static void main(String[] args) {
		// 1->2->3->4->5->6->7->null
		Node head1 = new Node(1);
		head1.next = new Node(2);
		head1.next.next = new Node(3);
		head1.next.next.next = new Node(4);
		head1.next.next.next.next = new Node(5);
		head1.next.next.next.next.next = new Node(6);
		head1.next.next.next.next.next.next = new Node(7);

		// 0->9->8->6->7->null
		Node head2 = new Node(0);
		head2.next = new Node(9);
		head2.next.next = new Node(8);
		head2.next.next.next = head1.next.next.next.next.next; // 8->6
		
		System.out.println(getIntersectNode(head1, head2).value);

		// 1->2->3->4->5->6->7->4...
		head1 = new Node(1);
		head1.next = new Node(2);
		head1.next.next = new Node(3);
		head1.next.next.next = new Node(4);
		head1.next.next.next.next = new Node(5);
		head1.next.next.next.next.next = new Node(6);
		head1.next.next.next.next.next.next = new Node(7);
		head1.next.next.next.next.next.next = head1.next.next.next; // 7->4

		// 0->9->8->2...
		head2 = new Node(0);
		head2.next = new Node(9);
		head2.next.next = new Node(8);
		head2.next.next.next = head1.next; // 8->2
		
		System.out.println(getIntersectNode(head1, head2).value);

		// 0->9->8->6->7->4->5->6..
		head2 = new Node(0);
		head2.next = new Node(9);
		head2.next.next = new Node(8);
		head2.next.next.next = head1.next.next.next.next.next; // 8->6
		
		System.out.println(getIntersectNode(head1, head2).value);

	}
	
	//��ȡ����������ཻ���,������ཻ�򷵻�null
	public static Node getIntersectNode(Node head1, Node head2) {
		if (head1 == null || head2 == null) {
			return null;
		}
		//�ֱ��ж����������Ƿ��л�,�������뻷�ڵ�
		Node loop1 = getLoopNode(head1);
		Node loop2 = getLoopNode(head2);
		if (loop1 == null && loop2 == null) {
			//�����޻�������ཻ���
			return noLoop(head1, head2);
		}
		if (loop1 != null && loop2 != null) {
			//�����л�������ཻ���
			return bothLoop(head1, loop1, head2, loop2);
		}
		return null;
	}
	
	//�ֱ��ж����������Ƿ��л�,�������뻷�ڵ�,����޻��򷵻�null
	public static Node getLoopNode(Node head) {
		if (head == null || head.next == null || head.next.next == null) {
			return null;
		}
		//����������ò����ҵ��뻷��
		Node n1 = head.next; 		// n1 -> ��ָ������ʼ�ڵ�
		Node n2 = head.next.next; 	// n2 -> ��ָ������ʼ�ڵ�
		while (n1 != n2) { 			//����ָ������ʱ����ѭ��
			if (n2.next == null || n2.next.next == null) {
				return null;		//��ָ���ߵ�ͷ,����null
			}
			n2 = n2.next.next;
			n1 = n1.next;
		}
		//�������ָ��ָ��head
		n2 = head; 	// n2 -> walk again from head
		while (n1 != n2) { //�ٴ�������Ϊ�뻷��
			n1 = n1.next;
			n2 = n2.next;
		}
		return n1;
	}
	
	//�ж�����û�л��������Ƿ��ཻ
	public static Node noLoop(Node head1, Node head2) {
		if (head1 == null || head2 == null) {
			return null;
		}
		Node cur1 = head1;
		Node cur2 = head2;
		//ͳ������������֮��
		int n = 0;
		while (cur1.next != null) {
			n++;
			cur1 = cur1.next;
		}
		while (cur2.next != null) {
			n--;
			cur2 = cur2.next;
		}
		//������������ཻ�Ļ��϶��ǴӺ����ཻ,���β�ڵ�һ����ͬ,�����ͬ˵�����ֱཻ�ӷ���null
		if (cur1 != cur2) {
			return null;
		}
		//��β�ڵ���ͬ��˵��һ����β�ڵ��֮ǰ�ཻ
		//�ҳ��ϳ����Ǹ�����Ϊcur1
		cur1 = n > 0 ? head1 : head2;
		cur2 = cur1 == head1 ? head2 : head1;
		//ȡ����ֵ
		n = Math.abs(n);
		//��ͷ����ʼ��ȥ���������Ĳ���
		while (n != 0) {
			n--;
			cur1 = cur1.next;
		}
		//Ȼ��ͬʱһ����������,��һ�������Ľڵ�����ཻ��
		while (cur1 != cur2) {
			cur1 = cur1.next;
			cur2 = cur2.next;
		}
		return cur1;
	}
	
	//�ж������л��������Ƿ��ཻ
	public static Node bothLoop(Node head1, Node loop1, Node head2, Node loop2) {
		Node cur1 = null;
		Node cur2 = null;
		if (loop1 == loop2) {	//����Ϊһ��,˵���ڻ����ཻ,���ཻ�ڻ���һ��
			//���ж��޻������б�������ͬ(ֻ����������Ϊloop������null)
			cur1 = head1;
			cur2 = head2;
			int n = 0;
			while (cur1 != loop1) {
				n++;
				cur1 = cur1.next;
			}
			while (cur2 != loop2) {
				n--;
				cur2 = cur2.next;
			}
			cur1 = n > 0 ? head1 : head2;
			cur2 = cur1 == head1 ? head2 : head1;
			n = Math.abs(n);
			while (n != 0) {
				n--;
				cur1 = cur1.next;
			}
			while (cur1 != cur2) {
				cur1 = cur1.next;
				cur2 = cur2.next;
			}
			return cur1;
		} else {		//˵���ཻ�ڻ�������
			cur1 = loop1.next;
			while (cur1 != loop1) {	//��cur1 == loop1ʱ����ѭ��,˵�������껷һ��
				if (cur1 == loop2) {
					return loop1;
				}
				cur1 = cur1.next;
			}
			//����������϶�û�з���loop2˵����������û���ཻ
			return null;
		}
	}
	
	public static class Node {
		public int value;
		public Node next;

		public Node(int data) {
			this.value = data;
		}
	}
}
