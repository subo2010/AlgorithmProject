package _1bytedance;
import org.junit.Test;
/*
 * ��Ŀ:���������ʾ����,ÿ���ڵ��ʾһλ��,��ͷ��㿪ʼ��ʾ��λ,��дһ������,�������������,���������ʽ����
 */
public class Plus {

	@Test
	public void mian() {
		
		ListNode node1 = new ListNode(9);
		node1.next = new ListNode(2);
		node1.next.next = new ListNode(3);

		ListNode node2 = new ListNode(4);
		node2.next = new ListNode(1);
		node2.next.next = new ListNode(3);
		node2.next.next.next = new ListNode(2);
		node2.next.next.next.next = new ListNode(2);
		ListNode plusAB = plusAB(node1, node2);
		jianshi(plusAB);
		printNode(plusAB);

	}

	// ���������ͷ������һ���µ�����
	public ListNode plusAB(ListNode a, ListNode b) {
		// basecase
		if (a == null && b == null) {
			return null;
		}
		int anum = a == null ? 0 : a.val;
		int bnum = b == null ? 0 : b.val;
		ListNode head = new ListNode(anum + bnum);
		if (a == null) {
			head.next = plusAB(null, b.next);
		} else if (b == null) {
			head.next = plusAB(a.next, null);
		} else {
			head.next = plusAB(a.next, b.next);
		}
		return head;
	}

	// �������10�Ļ�,����ǰ��һλ
	private void jianshi(ListNode head) {
		if (head == null) {
			return;
		}
		ListNode cur = head;
		while (cur != null) {
			if (cur.val >= 10) {
				cur.val -= 10;
				cur = cur.next;
				cur.val += 1;
			} else {
				cur = cur.next;
			}
		}
	}

	// ------------����-----------------
	public class ListNode {
		int val;
		ListNode next = null;

		ListNode(int val) {
			this.val = val;
		}
	}

	private void printNode(ListNode plusAB) {
		// TODO Auto-generated method stub
		if (plusAB != null) {
			System.out.print(plusAB.val + " ");
			printNode(plusAB.next);
		}
	}
}
