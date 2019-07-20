package ������._10�����㷨;

import org.junit.Test;
/*
����Ŀ����
����	��˵��������̫��ʷѧ��Josephus�й����¹��£���������ռ���������غ�39����̫����Josephus ���������Ѷ㵽һ�����У�
	39����̫����Ը��Ҳ��Ҫ������ץ�������Ǿ�����һ����ɱ��ʽ��41�����ų�һ��ԲȦ���ɵ�һ���˿�ʼ������������3���˾���ɱ��
	Ȼ��������һ�������±�1��������3��������ɱ������������ȥ��ֱ��ʣ�����һ����ʱ���Ǹ��˿�������ѡ���Լ������ˡ������������Լɪ�����⡣
	�������õ��������������ýṹ������������ɱ���̡�
�����룺һ�����ε��������ͷ�ڵ�head�ͱ�����ֵm��
�����أ�������������Ľڵ㣬������ڵ��Լ���ɻ��ε������������ڵ㶼ɾ����
�����ס���
�����������Ľڵ���ΪN������ʱ�临�Ӷ�ΪO(N)ʱ�����ԭ�����Ҫ�󣬸���ôʵ�֣�
��˼·����
	˼·1������������ͣתȦ��
	����˼·����֪����Ϊ������n������ֵm�����ʣ��1���ڵ㡣
		��ô����Ѱ��ɱ��һ���ڵ�ǰ�������ĸ����ڵ�ı����ɱ��һ���ڵ����������ĸ����ڵ�ı��֮��Ĺ�ϵ��
		Ҳ����˵���Եõ�ɱ��һ���ڵ�ǰ����ڵ�ı�Ź�ϵ
		��ô���ʣ�µĽڵ㼴Ϊ��ʼ���Ϊ4�Ľڵ㡣
�����й�ʽ���£�old = (new + m - 1) % n + 1
 �������У�new Ϊ�����еĽڵ��ţ�
���������� m Ϊ����ֵ��
   ��������  n Ϊ������δ��ɾ���Ľڵ����������ʼΪ5��һ�κ�Ϊ4�����κ�Ϊ3�����κ�Ϊ2����
���������� oldΪ��һ�α��ڵ����š�
 */
public class _06���ε������Լɪ������ {
	
	@Test
	public void main() {
		MyNode head = new MyNode(1);
		head.next = new MyNode(2);
		head.next.next = new MyNode(3);
		head.next.next.next = new MyNode(4);
		head.next.next.next.next = new MyNode(5);
		head.next.next.next.next.next = new MyNode(6);
		head.next.next.next.next.next.next = head;
		
		MyNode head1 = new MyNode(1);
		head1.next = new MyNode(2);
		head1.next.next = new MyNode(3);
		head1.next.next.next = new MyNode(4);
		head1.next.next.next.next = new MyNode(5);
		head1.next.next.next.next.next = new MyNode(6);
		head1.next.next.next.next.next.next = head1;
		int m = 3;
		//ͨ������˼·����
		MyNode node = getLastLive(head,m);
		System.out.println(node.value);
		//ͨ������˼·����
		MyNode node1 = getLastLive_jinjie(head1,m);
		System.out.println(node1.value);
		//�ؼ�����,����һ������,��������m,������������
		//System.out.println(getLive(6, m));
	}
	
	//���׽ⷨ
	private MyNode getLastLive_jinjie(MyNode head, int m) {
		//basecase
		if (head==null || m <= 0) {
			throw new RuntimeException("�������");
		}
		//�õ�����ĳ���
		MyNode cur = head.next;
		int size = 1;
		while(cur != head){
			cur = cur.next;
			size++;
		}

		//ͨ�����ú����õ������Ԫ�صĳ�ʼ���
		int target = getLive(size,m);
		//ͨ�����ı���ҵ���Ԫ�ز�����
		while(--target != 0){
			head = head.next;
		}
		head.next=head; //�����Լ���װ��һ����������
		return head;
	}
	
	//ͨ��������ʼ�ڵ�ĸ�����M���������Ķ���Ϊ�ڼ���
	private int getLive(int size, int m) {
		if (size == 1) {
			return 1;
		}
		return (getLive(size - 1, m) + m - 1) % size + 1;
	}

	//��ͨ�ⷨ--�������һ������Ԫ��
	private MyNode getLastLive(MyNode head, int m) {
		//basecase
		if (head==null || m <= 0) {
			throw new RuntimeException("�������");
		}
		if (m == 1) { //���m=1ֱ�ӷ������һ���ڵ�
			MyNode cur = head;
			while(cur.next != head){
				cur = cur.next;
			}
			return cur;
		}
		while(true){
			for (int i = 1; i < m-1; i++) { //ÿ�ν�Ҫ�ҵ�Ҫɾ����ǰһ��λ��
				head = head.next;
			}
			MyNode cur = head;//������һ��Ԫ�ؾ���Ҫɾ����Ԫ��
			if (cur == cur.next) {
				break;
			}
			head.next = head.next.next;	//ֱ�ӽ�������һ��Ԫ��ɾ��
			head = head.next;
		}
		return head;
	}

	//-----------------------------------------------------------------------------------
	class MyNode{
		public int value;	//Ԫ�ص�ֵ
		public MyNode next;	//Ԫ�ص�ָ��
		public MyNode(int elem){
			this.value = elem;
		}
	}
}


