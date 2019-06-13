package _0��������;

import org.junit.Test;

public class _07���������ֱ�۴�ӡ {
	@Test
	public void main() {
		//������������
		MyNode head = new MyNode(1);
		head.next = new MyNode(2);
		head.next.next = new MyNode(3);
		head.next.next.next = new MyNode(4);
		head.next.next.next.next = new MyNode(5);
		head.next.next.next.next.next = new MyNode(6);
		//��ӡ����
		printLinkList(head);
	}

	//��ӡ���������һ������
	private void printLinkList(MyNode head) {
		if (head == null) {
			return;
		}
		System.out.print(head.value+"-");
		printLinkList(head.next);
	}
	
	//����ڵ�
	class MyNode{
		public int value;	//Ԫ�ص�ֵ
		public MyNode next;	//Ԫ�ص�ָ��
		public MyNode(int elem){
			this.value = elem;
		}
	}
	
}
