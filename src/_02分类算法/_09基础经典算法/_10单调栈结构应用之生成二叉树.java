package _02�����㷨._09���������㷨;

import java.util.Stack;

import org.junit.Test;

/**
 * ��Ŀ:����������Ľڵ�Ϊ:
 * 	public class Node{
		public int value;
		public Node left;
		public Node right;
		
		public Node(int value){
			this.value = value;
		}
	}
	һ�������MaxTree��������:
		�������û���ظ�Ԫ��,MaxTree��һ�ζ�����,�����ÿһ��ֵ��Ӧ�������Ľڵ�,
		����MaxTree���������ڻ�������ÿһ�����������ֵ��������ͷ 
	Ҫ��:����һ��û���ظ�Ԫ�ص�����arr,д����������������ĺ���getMaxTree,��������ͷ
	    ����ʱ�临�Ӷ�ΪO(n)

	˼·1:��ĿҪ���������һ������ѽṹ�Ķ�����,�����ѵĹ���������O(N)
	˼·2:���õ���ջ�ṹ����ɽ������װ��Ϊ�������Ľڵ�,Ȼ���ڷŵ�һ��������,���е���ջ����
		�ҵ�û�ͽڵ����������һ�����Լ����Ľڵ�:
			������Ҷ�Ϊnull,����Ϊͷ���
			���a����ֻ����һ��bia��Ľڵ�b,����a��Ϊb�ĺ���
			���a���Ҵ�������b�ڵ�c,����a��Ϊb,c�н�С���Ǹ�Ԫ�صĺ���
	
 * @author Administrator
 *
 */
public class _10����ջ�ṹӦ��֮���ɶ����� {

	@Test
	public void main() {
		int[] arr = generateRandomArray(7, 10);
//		int[] arr = {7,1,3,4,6,2,8};
		
		//˼·1;ͨ���ѽṹ��ʵ��
		Node head = getMaxTreeByHeap(arr);
		Node head1 = getMaxTreeByStack(arr);
		
		printTree(head);
		printTree(head1);
		//��ӡ������
	}
	
	//˼·2:ͨ������ջ�����
	private Node getMaxTreeByStack(int[] arr) {
		Node[] nodeArr = new Node[arr.length];
		for (int i = 0; i < nodeArr.length; i++) {
			nodeArr[i] = new Node(arr[i]);	//��ÿһ��Ԫ�ذ�װ�ɽڵ��ŵ�������
		}
		Stack<Integer> stack = new Stack<Integer>();	//����һ������ջ(�򸽽���ֵ-->ԭ��Ӵ�С(�׵���)
		//��ÿ��Ԫ�ض����Է���ջ��
		for (int i = 0; i < nodeArr.length; i++) {
			//��ջ��Ԫ��С��Ҫ�����Ԫ��ʱ��ջ����
			while (!stack.isEmpty()&&nodeArr[stack.peek()].value < nodeArr[i].value) {
				//������ǰԪ�ز���ʼ��¼
				Node cur = nodeArr[stack.pop()];
				//����յĻ�,˵������ֻ��һ��,������Ϊ��
				if (stack.isEmpty()) {	
					if (nodeArr[i].left == null) {
						nodeArr[i].left = cur;
					} else{
						nodeArr[i].right = cur;
					}
					break;
				}
				//����Ļ��жϱȽ�С���Ǹ�,ָ��Ϊ��
				Node minNode = nodeArr[i].value< nodeArr[stack.peek()].value ? nodeArr[i]:nodeArr[stack.peek()];
				if (minNode.left == null) {
					minNode.left = cur;
				} else{
					minNode.right = cur;
				}
			}
			//ѹ��Ԫ��
			stack.push(i);
		}
		//����Ԫ�ض�����ѹ���ʼ����Ԫ��
		while(!stack.isEmpty()){
			//������ǰԪ�ز���ʼ��¼(���е���������Ϊ����Ϊ��)
			Node cur = nodeArr[stack.pop()];
			//����յĻ�,˵���������Ҷ�û��,������ͷ���
			if (stack.isEmpty()) {	
				return cur;
			} else{
				if (nodeArr[stack.peek()].left == null) {
					nodeArr[stack.peek()].left = cur;
				} else{
					nodeArr[stack.peek()].right = cur;
				}
			}
		}
		return null;
	}

	
	//˼·1;����һ������,��װ��һ������ѷ���ͷ��
	private Node getMaxTreeByHeap(int[] arr) {
		//BaseCase
		if (arr==null || arr.length == 0) {
			return null;
		}
		//ʵ�ֽ��ѵĹ���
		for (int i = 0; i < arr.length; i++) {
			int index = i;
			while (arr[index] > arr[(index-1)/2]) {   //����ұȸ��ڵ���򽻻�λ��     (index-1)/2��ӦΪindex�ĸ��ڵ�
				swap(arr,index,(index-1)/2); //��������Ԫ��
				index = (index-1)/2;
			}
		}
		
		printArr(arr);
		//���������Ѿ���Ϊ�������˴α�����˳��,Ȼ���������� (�������нڵ�i�����ӽڵ�Ϊ2i+1 �Һ��ӽڵ�Ϊ2i+2)

		Node head = new Node(arr[0]);
		getTree(head, 0, arr);
		
		return head;
	}

	//����һ���ڵ�������ڵ��±��ж�����û�����Һ���,����еĻ��ͼ���
	public void getTree(Node cur,int index,int[] arr){
		if (index>=arr.length) {
			return;
		}
		//˵������ڵ�
		if (2*index+1 < arr.length) { 
			cur.left = new Node(arr[2*index+1]);
		}
		getTree(cur.left, 2*index+1, arr);
		
		//˵�����ҽڵ�
		if (2*index+2 < arr.length) { 
			cur.right = new Node(arr[2*index+2]);
		}
		getTree(cur.right, 2*index+2, arr);
	}
	



	//����������Ľڵ�Ϊ
	public class Node{
		public int value;
		public Node left;
		public Node right;
		public Node(int value){
			this.value = value;
		}
	}
	
	
	//-----------------���߷���-------------------------------
	
	//���ɳ�����������鳤��size ÿ��Ԫ�ص�ֵΪ [-value , value]������
	public static int[] generateRandomArray(int size , int value){
		//���ɳ������������ ���ȴ���[0 , size]
		//int[] arr = new int[(int)((size + 1) * Math.random())];
		int[] arr = new int[size];//ָ������
		
		for(int i =0;i < arr.length; i++){
			arr[i] = (int)((value + 1) * Math.random());
		}
		return arr;
	}
	//��ӡ����ķ���
	private void printArr(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]+" ");
			
		}
		System.out.println();
	}
	//����Ԫ�ص�λ��
	private void swap(int[] arr, int index, int i) {
		int temp = arr[index];
		arr[index] = arr[i];
		arr[i] = temp;
	}
	//ֱ�۴�ӡ������
	public static void printTree(Node head) {
		System.out.println("Binary Tree:");
		printInOrder(head, 0, "H", 17);
		System.out.println();
	}

	public static void printInOrder(Node head, int height, String to, int len) {
		if (head == null) {
			return;
		}
		printInOrder(head.right, height + 1, "v", len);
		String val = to + head.value + to;
		int lenM = val.length();
		int lenL = (len - lenM) / 2;
		int lenR = len - lenM - lenL;
		val = getSpace(lenL) + val + getSpace(lenR);
		System.out.println(getSpace(height * len) + val);
		printInOrder(head.left, height + 1, "^", len);
	}

	public static String getSpace(int num) {
		String space = " ";
		StringBuffer buf = new StringBuffer("");
		for (int i = 0; i < num; i++) {
			buf.append(space);
		}
		return buf.toString();
	}
}
