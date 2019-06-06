package ������._04������;

import java.util.LinkedList;

/**
 * ƽ�������:�κ�һ���ڵ���������߶�����С�������߶�������һ
 * 
 * ������:ÿһ���ӽڵ㶼��ƽ����,����������ƽ����(���Ҫ�����нڵ�)
 * ����:���������ĳһ���ڵ�����Ҫ�ռ�����Ϣ��:
 * 									1.�����Ƿ�ƽ��	(��ƽ�����Ͳ���)
 * 									2.�����Ƿ�ƽ��  (��ƽ�����Ͳ���)
 *									3.�����߶�	(���Ҷ�ƽ�ж����Ҹ߶�)
 *									4.�����߶�
 *			���ڵĿ�����:1.������ƽ��---->���� false
 *					  2.������ƽ��---->����fasle
 *					  3.��������������ƽ���Ҹ߶Ȳ����1---->����fasle
 *					  4.����---->����true
 *			���:�����ڵ��õݹ�ʱ����ֵ����Ϣ��,�����Ƿ�ƽ��ʹ����߶�
 */
public class _05�ж��Ƿ�Ϊƽ������� {
	
	public static void main(String[] args) {
		Tree mytree = new Tree(); 
		mytree.add(1);
		mytree.add(1);
		mytree.add(1);
		mytree.add(1);
//		mytree.add(1);
//		mytree.add(1);
//		mytree.add(1);
//		mytree.add(1);
		System.out.println(patition(mytree.head).isB);
	}
	//����һ������ֵ���͵���
	public static class ReturnDate{
		public boolean isB;
		public int h;
		public ReturnDate(boolean isB, int h) {
			this.isB = isB;
			this.h = h;
		}
	} 
	
	public static ReturnDate patition(Node head){
		if(head==null){return new ReturnDate(true, 0);}	//���������Է���
		
		//�����ܹ��յ������ķ���ֵ
		ReturnDate leftDate = patition(head.left);
		if (!leftDate.isB) {	//������Ϊƽ��ֱ�ӷ���false
			return new ReturnDate(false, 0);
		}
		//������ͬ���߼�
		ReturnDate rightDate = patition(head.right);
		if (!rightDate.isB) {	//������Ϊƽ��ֱ�ӷ���false
			return new ReturnDate(false, 0);
		}
		//�ߵ��ⲽ˵��������������ƽ��.�ж������������ĸ߶Ȳ��Ƿ����1
		if (Math.abs(leftDate.h-rightDate.h)>1) {
			return new ReturnDate(false, 0);
		}
		//�ߵ���˵�������鶼ƽ���Ҹ߶Ȳ�С��2,Ӧ�÷���true�����ĸ߶�
		return new ReturnDate(true, Math.max(leftDate.h, rightDate.h)+1);
	}
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