package _02�����㷨._03����;

import java.util.HashMap;

/**
 * ����Ŀ�� һ�����������ڵ����������£�
	public class Node { 
		public int value; 
		public Node next;
		public	Node rand;
		public Node(int data) { 
			this.value = data; 
		}
	}
	
	Node���е�value�ǽڵ�ֵ��nextָ���������������nextָ�������һ ������ָ����һ���ڵ㣬
	randָ����Node����������ָ�룬���ָ�����ָ�������е�����һ���ڵ㣬Ҳ����ָ��null�� 
	����һ����Node�ڵ�������ɵ��޻��������ͷ�ڵ�head����ʵ��һ�� �������������������нṹ�ĸ��ƣ������ظ��Ƶ��������ͷ�ڵ㡣 
	��������Ŀ����
	��ʹ�ö�������ݽṹ��ֻ�����޼�������������ʱ�临�Ӷ�Ϊ O(N)�����ԭ����Ҫʵ�ֵĺ���
	
	˼·1:���������δ�ŵ�һ��HashMap��,KeyΪ�ڵ㱾��,ValueΪ���Ʋ������½ڵ�,
		Ҳ����ÿһ��ԭ�ڵ㶼��Ӧ��һ���½ڵ�,Ȼ���½ڵ����һ��nextָ��ָ����ԭ�ڵ�nextָ������Ӧ��valueֵ
		��:map.get(cur).next = map.get(cur.next);
		Ȼ����randָ��ͬ��ִ��  map.get(cur).rand = map.get(cur.rand); 
		��󷵻�ͷ�������Ӧ��valueֵ
	
	����˼·2:�����н�ÿ��Ԫ�ظ���һ�ݷŵ��Լ���nextָ����,Ȼ����ͨ��nextָ��������һ��Ԫ��,
			�����൱��ÿһ��ָ�����һ��Ԫ�ؾ����Լ��ĸ���Ԫ��
			��һ���ڵ���Դ�ڵ�,�ڶ����ڵ����临�ƽڵ�,Դ�ڵ��randָ��ڵ����һ���ڵ�,�����临�ƽڵ�rand��ָ��Ľڵ�
			ͨ�����ַ�ʽ�ҵ����и��ƽڵ��randָ��Ľڵ�,Ȼ����������Ϊ��λ�����ƽڵ���nextָ�봮������
 * @author Administrator
 */
public class _04�������ָ��ڵ������ {
	public static void main(String[] args) {
		Node head = null;
		Node res1 = null;
		Node res2 = null;

		//��������
		head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		head.next.next.next = new Node(4);
		head.next.next.next.next = new Node(5);
		head.next.next.next.next.next = new Node(6);
		//����randָ��
		head.rand = head.next.next.next.next.next; // 1 -> 6
		head.next.rand = head.next.next.next.next.next; // 2 -> 6
		head.next.next.rand = head.next.next.next.next; // 3 -> 5
		head.next.next.next.rand = head.next.next; // 4 -> 3
		head.next.next.next.next.rand = null; // 5 -> null
		head.next.next.next.next.next.rand = head.next.next.next; // 6 -> 4

//		printRandLinkedList(head);
//		res1 = copyListWithRand1(head);
//		printRandLinkedList(res1);
		
		res2 = copyListWithRand2(head);
		printRandLinkedList(res2);
		printRandLinkedList(head);
		System.out.println("=========================");

	}
	public static class Node {
		public int value;
		public Node next;
		public Node rand;

		public Node(int data) {
			this.value = data;
		}
	}
	
	//����һ
	public static Node copyListWithRand1(Node head) {
		//����һ��HashMap�ĸ����ṹ
		HashMap<Node, Node> map = new HashMap<Node, Node>();
		//head�ڵ���ָ��Ľڵ㲻�ܱ���Ϊ���滹Ҫ�õ�,���Բ���ֱ��head = head.next;
		//����һ��cur����ʱָ��
		Node cur = head;
		while (cur != null) {
			//��ÿһ���ڵ�����Ӧ�ĸ��ƽڵ�ŵ�map��
			map.put(cur, new Node(cur.value));
			cur = cur.next;
		}
		cur = head;
		while (cur != null) {
			//�ֱ��ÿ�����ƽڵ����nextָ���randָ��
			map.get(cur).next = map.get(cur.next);
			map.get(cur).rand = map.get(cur.rand);
			cur = cur.next;
		}
		//���ظ����б��ͷ���
		return map.get(head);
	}

	//������
	public static Node copyListWithRand2(Node head) {
		if (head == null) {
			return null;
		}
		Node cur = head;
		Node next = null;
		// ��ÿһ��Ԫ�صĸ���Ԫ�������Լ�����
		while (cur != null) {
			next = cur.next;
			cur.next = new Node(cur.value);
			cur.next.next = next;
			cur = next;
		}
		
		cur = head;
		Node curCopy = null;
		// Ϊÿһ�����ƽڵ�Ѱ���Լ�randָ��Ľڵ�
		while (cur != null) {
			next = cur.next.next; //ÿ��������
			curCopy = cur.next;
			curCopy.rand = cur.rand != null ? cur.rand.next : null;
			cur = next;
		}
		
		cur = head;
		Node res = head.next;//���ƽڵ��ͷ���
		// �����еĸ��ƽڵ���next��������
		while (cur != null) {
			next = cur.next.next;
			curCopy = cur.next;
			cur.next = next;
			curCopy.next = next != null ? next.next : null;
			cur = next;
		}
		return res;
	}

	//������------������------������------������------������------������------������------������------������------
	public static void printRandLinkedList(Node head) {
		Node cur = head;
		System.out.print("order: ");
		while (cur != null) {
			System.out.print(cur.value + " ");
			cur = cur.next;
		}
		System.out.println();
		cur = head;
		System.out.print("rand:  ");
		while (cur != null) {
			System.out.print(cur.rand == null ? "- " : cur.rand.value + " ");
			cur = cur.next;
		}
		System.out.println();
	}
}
