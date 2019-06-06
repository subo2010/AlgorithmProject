package ������._07�ݹ�;

import java.util.LinkedList;

import org.junit.Test;

import ������._07�ݹ�._03�õ�һ��������������������.Node;
import ������._07�ݹ�._03�õ�һ��������������������.ReturnDate;

/**
* �ݹ������
 * ��Ŀ:��������,һ���ڵ����������Ҳ����������.��ô�ڵ�A�����ߵ��ڵ�B
 * 		�ڵ�A�ߵ��ڵ�B�ľ���Ϊ:A�ߵ�B���·���ϵĽڵ����,һ�Ŷ���������Զ����
 * 
 * Ҫ��:����һ����������ͷ���.���ض������е�������;
 * 
 * ���ڽ�����ж�����������:
 * 	������ֽ�:����˵����һ��ͷ�����ܻ����һ�����
 * 		1.�������������������
 * 		2.�������������������
 * 		3.��������������������²�Ľڵ㵽ͷ���ľ�������������²�Ľڵ㵽ͷ���ľ���
 * 	����������������Ҫ����Ϣ:
 * 		1.��������������
 * 		2.��������������
 * 		3.�����������
 * 		4.�����������
 * 	�ݹ麯���ռ�����Ϣ
 * 		1:��ǰ�����е�������
 * 		2.��ǰ���������
 */
public class _05�����������ڵ�������� {
	
	@Test
	public void main() {
		Tree mytree = new Tree(); 
		mytree.add(5);
		mytree.add(3);
		mytree.add(8);
		mytree.add(1);
		mytree.add(4);
		mytree.add(7);
		System.out.println(patition(mytree.head).maxLen);
	}
	
	
	//����һ������ֵ���͵���
	public class ReturnDate{
		public int maxLen;
		public int h;
		public ReturnDate(int maxLen, int h) {
			this.maxLen = maxLen;
			this.h = h;
		}
	} 
	
	public ReturnDate patition(Node head){
		//��ֹ����    //���������Է���
		if(head==null){return new ReturnDate(0, 0);}	
		
		//�ݹ麯��(�������������������ܵõ�����ֵ)----> �ݹ�ĵ��ÿ��Ե����Ǻں�
		Node left = head.left;
		ReturnDate leftReturnDate = patition(left);		//����������ֵ
		Node right = head.right;
		ReturnDate rightReturnDate = patition(right);	//����������ֵ
		
		//�õ��������ߵķ���ֵ�Ժ�ʼ�ҳ���ǰ�ڵ����Ϣ���ظ���
		
		int curh = Math.max(leftReturnDate.h, rightReturnDate.h) + 1;
		int curmaxLen = leftReturnDate.h + rightReturnDate.h + 1;
		curmaxLen = Math.max(Math.max(leftReturnDate.maxLen,rightReturnDate.maxLen), curmaxLen);
		
		//���ظ��Լ��ĸ�����
		return new ReturnDate(curmaxLen,curh);
	}
	//�������Ľڵ����
	class Node{
		int val;
		Node left = null;
		Node right = null;
		public Node(int val){
			this.val = val;
		}
	}

	//һ��������
	class Tree{
		public Node head = null;	//����һ�����Ԫ��
		
		//���Ԫ��(�㼶���)
		public void add(int item){
			Node node = new Node(item);
			if(head == null){
				head = node;
				return;
			}
			
			LinkedList<Node> list = new LinkedList<Node>(); //����һ���б����洢Ԫ��
			list.add(head);		//ÿ��׷�ӵ�����β��
			while(list.size()!=0){
				Node cur_node = list.getFirst();	//ÿ�δ�ͷ����ȡ(��ɾ��)
				list.removeFirst();
				if(cur_node.left == null){
					cur_node.left = node;
					return;
				} else {
					list.add(cur_node.left);
				}
				
				if(cur_node.right == null){
					cur_node.right = node;
					return;
				} else {
					list.add(cur_node.right);
				}
			}
		}
	}
}

