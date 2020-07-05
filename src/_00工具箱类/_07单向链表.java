package _00��������;

import org.junit.Test;

public class _07�������� {
	@Test
	public void main() {
		//������������
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		head.next.next.next.next.next = new ListNode(6);
		//��ӡ����
		printLinkList(head);
	}

	private void printLinkList(ListNode head) {
		if (head == null) {
			return;
		}
		System.out.print(head.val+"-");
		printLinkList(head.next);
	}
	
	//����ڵ�
	class ListNode{
		public int val;	//Ԫ�ص�ֵ
		public ListNode next;	//Ԫ�ص�ָ��
		public ListNode(int elem){
			this.val = elem;
		}
	}
}
