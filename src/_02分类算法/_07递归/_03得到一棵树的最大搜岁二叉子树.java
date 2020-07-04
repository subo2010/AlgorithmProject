package _02�����㷨._07�ݹ�;

import java.util.LinkedList;

import org.junit.Test;

/*
 * �ݹ������
 * ��Ŀ:����һ����������ͷ���.���ض������е�����������
 * 
 * ���ڽ�����ж�����������:
 * 	������ֽ�:����˵����һ��ͷ�����ܻ����һ�����
 * 		1.���������������������
 * 		2.���������������������
 * 		3.�Լ�Ϊͷ�������ܾ�������������(����������������ͷΪ����,����������������ͷΪ�Һ���,�������ֵС��head.valС����������Сֵ)
 * 
 * 	���ǽ������Ǹ���ķֽ�����Ҫ������:
 * 		1.�����������������Ĵ�С
 * 		2.�����������������Ĵ�С
 * 		3.������������������ͷ(���ں�head.left�Ƚ�)
 * 		4.������������������ͷ(���ں�head.right�Ƚ�)
 * 		5.���������ֵ
 * 		6.��������Сֵ	(�����ж������)
 * 
 * 	����Ϊÿ�εݹ麯����Ҫ���صĲ���:
 * 		1.�˽ڵ�Ϊͷ���ӽڵ��������������Ĵ�С
 * 		2.�˽ڵ�Ϊͷ���ӽڵ���������������ͷ
 * 		3.�˽ڵ�Ϊͷ���������ֵ
 * 		4.�˽ڵ�Ϊͷ��������Сֵ
 */

public class _03�õ�һ�������������������� {
	@Test
	public void main() {
		Tree mytree = new Tree(); 
		mytree.add(5);
		mytree.add(3);
		mytree.add(8);
		mytree.add(1);
		mytree.add(4);
		mytree.add(7);
		mytree.add(1);

		System.out.println(patition(mytree.head).size);
	}
	
	
	//����һ������ֵ���͵���
	public class ReturnDate{
		int size;
		Node head;
		int max; 
		int min;
		public ReturnDate(int size, Node head, int max, int min) {
			this.size = size;
			this.head = head;
			this.max = max;
			this.min = min;
		}
	} 
	
	public ReturnDate patition(Node head){
		//�ݹ��ֹ����
		if (head == null) {
			return new ReturnDate(0, null, Integer.MIN_VALUE, Integer.MAX_VALUE);
		}
		
		//�ݹ麯��(�������������������ܵõ�����ֵ)----> �ݹ�ĵ��ÿ��Ե����Ǻں�
		Node left = head.left;
		ReturnDate leftReturnDate = patition(left);		//����������ֵ
		Node right = head.right;
		ReturnDate rightReturnDate = patition(right);	//����������ֵ
		
		//�õ��������ߵķ���ֵ�Ժ�ʼ�ҳ���ǰ�ڵ����Ϣ���ظ���
		//����ǵ��������(�õ���������������Ĵ�С)
		int includeItSelf = 0; //��ǰ�ڵ�Ϊƽ�������ʱ�Ĵ�С
		if (head.left == leftReturnDate.head 
				&& head.right == rightReturnDate.head
				&& leftReturnDate.max < head.value
				&& head.value < rightReturnDate.min) {
			includeItSelf = rightReturnDate.size + leftReturnDate.size + 1;
		}
		
		int p1 = leftReturnDate.size;
		int p2 = rightReturnDate.size;
		
		int maxsize = Math.max(Math.max(p1, p2), includeItSelf); //��ȡ������Ķ���������
		Node maxHead = p1 > p2 ? leftReturnDate.head : rightReturnDate.head;
		maxHead = maxsize == includeItSelf ? head : maxHead;
		int max = Math.max(head.value, Math.max(leftReturnDate.max, rightReturnDate.max));
		int min = Math.min(head.value, Math.min(leftReturnDate.min, rightReturnDate.min));
		
		return new ReturnDate(maxsize, maxHead, max, min);
	}


	//------------------------------������--------------------------------------------------------
	//�������Ľڵ����
	class Node{
		int value;
		Node left = null;
		Node right = null;
		public Node(int val){
			this.value = val;
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
