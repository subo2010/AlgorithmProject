package _02�����㷨._04������;

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
 *							�����ǰֵС��min˵�����������������false
 */
public class _06�ж��Ƿ�Ϊ���������� {
	
	public static void main(String[] args) {
		Tree mytree = new Tree(); 
		mytree.add(4);
		mytree.add(2);
		mytree.add(6);
		mytree.add(1);
		mytree.add(9);
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
		int min = Integer.MIN_VALUE; //�����ж��Ƿ�Ϊ����
		Stack<Node> stack = new Stack<Node>();
		while (head!=null || !stack.isEmpty()) {
			if (head!=null) {
				stack.push(head);
				head=head.left;
			} else{
				head = stack.pop();
				if (head.val > min) {
					min = head.val;
				} else {
					return false;	//�ж��������ϵ�˳���Ƿ���ͬ
				}
//				System.out.println(head.val);
				head = head.right;
			}
		}
		return true;	//�ж��������ϵ�˳���Ƿ���ͬ
	}
	
	
}
