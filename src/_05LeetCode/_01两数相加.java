package _05LeetCode;

import _00��������._07��������;
import org.junit.Test;

/*
��ĿҪ��:
��������?�ǿ� ������������ʾ�����Ǹ������������У����Ǹ��Ե�λ���ǰ���?����?�ķ�ʽ�洢�ģ��������ǵ�ÿ���ڵ�ֻ
�ܴ洢?һλ?���֡���������ǽ��������������������᷵��һ���µ���������ʾ���ǵĺ͡�
�����Լ���������� 0 ֮�⣬���������������� 0?��ͷ��

ע:��Ϊ����������޳�,��˲��ܽ���ת��Ϊint����,��Ϊ���ܻ����Խ���쳣
*/
public class _01������� {

    //����ڵ�
    class ListNode {
        public int val;    //Ԫ�ص�ֵ
        public ListNode next;    //Ԫ�ص�ָ��

        public ListNode(int elem) {
            this.val = elem;
        }
    }

    //�����ӡ����ķ���
    private void printLinkList(ListNode head) {
        if (head == null) {
            return;
        }
        System.out.print(head.val + "-");
        printLinkList(head.next);
    }

    @Test
    public void main() {
        //������������
        ListNode list1 = new ListNode(2);
        list1.next = new ListNode(4);
        list1.next.next = new ListNode(3);
        printLinkList(list1);
        System.out.println();

        ListNode list2 = new ListNode(5);
        list2.next = new ListNode(6);
        list2.next.next = new ListNode(4);
        printLinkList(list2);
        System.out.println();

        printLinkList(addTwoNumbers(list1, list2));
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
       // ������Ŀ¼
        ListNode root = new ListNode(0);
        ListNode curNode = root;
        int carry = 0;
        while (l1 != null || l2 != null || carry !=0) {
            int var1 = l1 == null? 0 : l1.val;
            int var2 = l2 == null? 0 : l2.val;
            curNode.next = new ListNode((var1 + var2 + carry)%10);
            curNode = curNode.next;
            carry = (var1 + var2 + carry)>=10? 1 : 0;
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        return root.next;
    }
}