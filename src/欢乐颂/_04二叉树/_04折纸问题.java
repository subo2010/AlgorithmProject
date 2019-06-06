package ������._04������;

import java.util.LinkedList;
import java.util.Queue;

import org.junit.Test;


/**
 * ��ֽ����
	����Ŀ�� ���һ��ֽ�����ŷ��������ϣ�Ȼ���ֽ�����±����Ϸ�����1�Σ�ѹ���ۺۺ�չ����
	��ʱ �ۺ��ǰ���ȥ�ģ����ۺ�ͻ��ķ���ָ��ֽ���ı��档�����ֽ�����±����Ϸ���������2 �Σ�
	ѹ���ۺۺ�չ������ʱ�������ۺۣ����ϵ������������ۺۡ����ۺۺ����ۺۡ�
	����һ ���������N������ֽ�������±����Ϸ���������N�Σ�
	����ϵ��´�ӡ�����ۺ۵ķ��� 
	���磺 N=1ʱ����ӡ�� down 
		 N=2ʱ����ӡ�� down down up
		 
	˼·:�ɽ�������ת��ΪΪ���������������
		�й��ɿ��Եó������۵�3��,����Ϊ
					down
 *		down					up
 *down			up		 down		up
 *����������Ľ����Ϊ����
 *1.���ȹ���һ���������ڵ�,�ڵ��value�洢down��up
 *2.����ͷ���Ϊdown.����һ���ڵ���������ӽڵ�,������Ϊdown,����Ϊup
 *3.��ֽ�Ĵ���,���Ǵ˶������ĸ߶�
 */
public class _04��ֽ���� {
	
	@Test
	public void main() {
		int N = 4;
		printAllFolds(N);
		System.out.println();
		printAllFolds1(N);
	}
	
	//��ӡn��Ķ�����
	private void printAllFolds1(int n) {
		//����һ��n��Ķ�����,����ͷ���
		Node head = createTree(n);
		inOrder(head);		
	}
	
	//�������
	public void inOrder(Node head){
		if (head!=null) {
			inOrder(head.left);
			System.out.print(head.value+" ");
			inOrder(head.right);
		}
	}
	
	//����һ��n��Ķ�����,����ͷ���
	private Node createTree(int n) {
		if (n==0) {
			return null;
		}
		
		Node head = new Node("down");	//����һ��ͷ�ڵ�
		//������������һ����ű���ڵ�.��һ�������һ��ڵ�
		Queue<Node> curQueue = new LinkedList<Node>();	//��ŵ�ǰ�е�Ԫ��
		Queue<Node> nextQueue = new LinkedList<Node>();	//�����һ�е�Ԫ��
		curQueue.add(head);
		int count = 1;
		while(count<n) {
			while(!curQueue.isEmpty()){
				Node cur = curQueue.poll();
				cur.left = new Node("down");
				cur.right = new Node("up");
				nextQueue.add(cur.left);
				nextQueue.add(cur.right);
			}
			count++;
			curQueue.addAll(nextQueue);	//��nextQueue�����е�Ԫ�طŵ�curQueue��
			nextQueue.clear();
		}
		return head;
	}

	//�Զ���������ڵ�
	private class Node{
		public String value;
		public Node left;
		public Node right;
		public Node(String value){
			this.value=value;
		}
	}
	
//--------------------------------------------����2---------------------------------------------

	public void printAllFolds(int N) {
		printProcess(1, N, true);
	}

	public void printProcess(int i, int N, boolean down) {
		if (i > N) {
			return;
		}
		printProcess(i + 1, N, true);
		System.out.print(down ? "down " : "up " +" ");
		printProcess(i + 1, N, false);
	}

	
}
