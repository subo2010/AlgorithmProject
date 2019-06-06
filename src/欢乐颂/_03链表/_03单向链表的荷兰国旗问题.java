package ������._03����;

/**
 * ����Ŀ�� ����һ�����������ͷ�ڵ�head���ڵ��ֵ���������ͣ��ٸ���һ��
	�� ��pivot��
	ʵ��һ����������ĺ��������������Ϊ�󲿷ֶ���ֵС�� pivot
	�Ľڵ㣬�м䲿�ֶ���ֵ����pivot�Ľڵ㣬�Ҳ��ֶ���ֵ���� pivot�Ľڵ㡣
	�����Ҫ���⣬�Ե�����Ľڵ�˳��û�и����Ҫ��
	 ���磺����9->0->4->5->1��pivot=3�� 
	 ���������������1->0->4->9->5��Ҳ������0->1->9->5->4��
	 ��֮���� ���󲿷ֶ���С��3�Ľڵ㣬�м䲿�ֶ��ǵ���3�Ľڵ㣨�������������Ϊ�գ����Ҳ��ֶ��Ǵ���3�Ľڵ㼴�ɡ�
	 ��ĳ�����ڲ��Ľڵ�˳����Ҫ��(��Ҫ���ȶ���)
	
	��������Ŀ���� ��ԭ�����Ҫ��֮����������������Ҫ��
	�����С����������ֵ��ڲ�Ҳ��˳��Ҫ��Ҫ��ÿ������Ľڵ�����ҵ�˳����ԭ�����нڵ���Ⱥ����һ�¡� 
	���磺����9->0->4->5->1��pivot=3��
	�������������0->1->9->4->5�� 
	������ԭ����Ҫ���ͬʱ���󲿷ֽڵ������Ϊ0��1����ԭ������Ҳ ���ȳ���0�������1���м䲿���ڱ�����Ϊ�գ�����
	���ۣ��Ҳ��ֽڵ� ������Ϊ9��4��5����ԭ������Ҳ���ȳ���9��Ȼ�����4��������5��
	���������ΪN��ʱ�临�Ӷ���ﵽO(N)������ռ临�Ӷ���ﵽO(1)��
	
	��Ŀһ˼·:�õ�����ĳ���,������һ��������,�ڵ����͵�����,��ÿһ������Ԫ�ط���������
			���պ���������������鴦��,������õ�����Ԫ��,��������
	
	��������˼·:��������ָ��ֱ�Ϊless mid �� high ����ָ��ֱ�����б�ʹ
			lessָ���һ��ֵС��pivot�Ľڵ�
			midָ���һ��ֵ����pivot�Ľڵ�
			highָ���һ��ֵ����pivot�Ľڵ�
			Ȼ�����δ��Լ�ָ����������±���,���lessָ��Ľڵ����һ���ڵ�ֵС�ڵ���less.��nextָ��ָ����.��������
			���midָ��Ľڵ����һ���ڵ�ֵ����mid.��nextָ��ָ����.��������
			���highָ��Ľڵ����һ���ڵ�ֵ���ڵ���high.��nextָ��ָ����.��������
			Ȼ����������������(ע�����е�������ܻ�Ϊ��,��������ֱ����nextָ��)
 * @author Administrator
 *
 */
public class _03��������ĺ����������� {
	
	public static void main(String[] args) {
		Node head1 = new Node(7);
		head1.next = new Node(9);
		head1.next.next = new Node(1);
		head1.next.next.next = new Node(8);
		head1.next.next.next.next = new Node(5);
		head1.next.next.next.next.next = new Node(2);
		head1.next.next.next.next.next.next = new Node(5);
		//��ӡ����Ԫ��
		printLinkedList(head1);
//		head1 = listPartition1(head1, 5);
		head1 = listPartition2(head1, 5);
		printLinkedList(head1);
	}
	
	//����һ:���б����Ϊ����,�������ƴ��Ϊ����--------------------------------------------
	public static Node listPartition1(Node head, int pivot) {
		//û�нڵ����ֻ��һ���ڵ�
		if (head == null || head.next==null) {
			return head;
		}
		Node cur = head;
		int i = 0;
		while (cur != null) {
			i++;
			cur = cur.next;
		}
		Node[] arr = new Node[i];
		i = 0;
		cur = head;
		for (i = 0; i < arr.length; i++) {
			arr[i] = cur;
			cur = cur.next;
		}
		//����partition������������
		arrPartition(arr, pivot);
		//������õ���������������
		for (i = 1; i < arr.length; i++) {
			arr[i - 1].next = arr[i];
		}
		arr[i - 1].next = null;
		return arr[0];
	}
	//������������(����)
	public static void arrPartition(Node[] arr, int pivot) {
		int index = 0;
		int left = -1;
		int right = arr.length;
		while (index != right) {
			if (arr[index].value < pivot) {
				swap(arr, ++left, index++);
			} else if (arr[index].value > pivot) {
				swap(arr, --right, index);
			} else {
				index++;
			}
		}
	}
	
	
	//������:����Ϊ����������ʵ��--------------------------------------------
	public static Node listPartition2(Node head, int pivot) {
		//�ֱ������������ͷָ���βָ��
		Node sH = null; // small head
		Node sT = null; // small tail
		Node eH = null; // equal head
		Node eT = null; // equal tail
		Node bH = null; // big head
		Node bT = null; // big tail
		//Ϊ�˱���nextָ�������
		Node next = null; 
		//��ÿһ���ڵ㶼���������������
		while (head != null) {
			//��������Ϊ��ֻ��headֵһ���ڵ���ӵ���ָ����,�����head.next = null;
			//ȥ��head���������.next = head.next;��Ϊ��Ѱ�ҵ���һ��
			next = head.next;
			head.next = null;
			if (head.value < pivot) {
				if (sH == null) {
					sH = head;
					sT = head;
				} else {
					sT.next = head;
					sT = head;
				}
			} else if (head.value == pivot) {
				if (eH == null) {
					eH = head;
					eT = head;
				} else {
					eT.next = head;
					eT = head;
				}
			} else {
				if (bH == null) {
					bH = head;
					bT = head;
				} else {
					bT.next = head;
					bT = head;
				}
			}
			head = next;
		}
		//�����нڵ㶼������Ϻ�������������ƴ��
		// small and equal reconnect
		if (sT != null) {	//˵��С�ڶ�����Ԫ��
			sT.next = eH;	//��С�ڶ��е�β�����ӵ��ڶ��е�ͷ��
			eT = eT == null ? sT : eT;	//������ڶ���û��Ԫ�ؾͽ����ڶ��е�β����ΪС�ڶ��е�β��
		}
		// all reconnect
		if (eT != null) {	//������ڶ��е�β����Ԫ��,�򽫵��ڶ��е�β������ڶ��е�ͷ��������
			eT.next = bH;
		}
		//���С�ڶ�������Ԫ����С�ڶ��е�ͷ������,�����жϵ��ڶ��������Ԫ�صĻ����ص��ڶ��е�ͷ��,���򷵻ش��ڶ��е�ͷ��
		return sH != null ? sH : eH != null ? eH : bH;
	}
	
	
	//������------������------������------������------������------������------������------������------������------������------
	//�б���Ԫ��
	public static void swap(Node[] arr, int a, int b) {
		Node tmp = arr[a];
		arr[a] = arr[b];
		arr[b] = tmp;
	}
	
	public static class Node {
		public int value;
		public Node next;

		public Node(int data) {
			this.value = data;
		}
	}
	//���߷���
	public static void printLinkedList(Node node) {
		System.out.print("Linked List: ");
		while (node != null) {
			System.out.print(node.value + " ");
			node = node.next;
		}
		System.out.println();
	}
}
