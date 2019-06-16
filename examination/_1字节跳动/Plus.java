package _1�ֽ�����;

import java.util.*;


public class Plus {
	//���������ͷ������һ���µ�����
    public ListNode plusAB(ListNode a, ListNode b) {
        //basecase
    	if (a == null && b == null) {
    		return null;
		}
    	int anum = a == null ? 0 : a.val;
    	int bnum = b == null ? 0 : b.val;
    	ListNode head = new ListNode(anum+bnum);
    	if(a == null){
    		head.next = plusAB(null,b.next);
    	} else if(b == null){
    		head.next = plusAB(a.next,null);
    	} else {
    		head.next = plusAB(a.next,b.next);
    	}
    	return head;
    }
    
    
    //------------����-----------------
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
}
