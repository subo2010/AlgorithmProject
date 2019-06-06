package ������._04������;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;


/**
 * ����������:�κ�һ���ڵ������������С�����������
 * 
 * ˼·:����������������,��˿���ͨ���޸����������ʵ��
 * 		1.�����������,��������Ľ��װ��������,
 * 		2.�жϼ���Ԫ���ǲ��������
 *	˼·2:�ڱ����Ǽ�¼��һ��Ԫ��,�����һ��Ԫ�ض�������һ��Ԫ���򷵻�true
 *			���򷵻�false
 *	˼·3:����һ����Сֵ,ÿ�α���ʱ�����ǰֵ����min�ͽ�min��Ϊ��ǰֵ����	
 *							�����ǰֵС��min�������������������false
 */
public class _06�ж��Ƿ�Ϊ���������� {
	
	public static void main(String[] args) {
		Tree mytree = new Tree(); 
		mytree.add(4);
		mytree.add(2);
		mytree.add(6);
		mytree.add(1);
		mytree.add(3);
		mytree.add(5);
		mytree.add(7);
		boolean b = isBalanceTree(mytree.head);
		System.out.println(b);
	}
	
	//�����Ƿ�Ϊ����������
	public static boolean isBalanceTree(Node head){
		if (head==null) {
			return true;
		}
		Stack<Node> stack = new Stack<Node>();
		List<Integer> list = new ArrayList<Integer>();	//����ʢװNode����ֵ
		Node per = null;
		while (head!=null || !stack.isEmpty()) {
			if (head!=null) {
				stack.push(head);
				head=head.left;
			} else{
				
				head = stack.pop();
				if (per!=null && per.val > head.val) {
					return false;
				}
				per = head;
				
//				list.add(head.val);
				head = head.right;
			}
		}
		
//		List listSort = ListSort(list);//���÷�����������õļ���
//		return isequal(list, listSort);	//�ж��������ϵ�˳���Ƿ���ͬ
		return true;	//�ж��������ϵ�˳���Ƿ���ͬ
	}
	
	//����һ������õļ���(ע��:������ԭ�������޸�)
	public static List ListSort(List list){
		List<Integer> mylist = new ArrayList<Integer>();
		for (int i = 0; i < list.size(); i++) {
			mylist.add((Integer) list.get(i));
		}
		Collections.sort(mylist);
		return mylist;
	}
	
	//�ж��������ϵ������Ƿ���ͬ
	public static boolean isequal(List list1,List list2){
		for (int i = 0; i < list1.size(); i++) {
			if (list1.get(i)!=list2.get(i)) {
				return false;
			}
		}
		return true;
	}
}
