package ������._04������;


/**
 * 
 * ��֪һ����ȫ������������ڵ�ĸ���
 * 
 * Ҫ��ʱ�临�Ӷ�**����**O(N),����NΪ������Ľڵ����
 * 
 * ˼·:���ڸ߶�Ϊh����������.��ڵ�����Ϊ2^h-1
 * 		1.�ж��������ĸ߶Ⱥ��������ĸ߶��Ƿ���ͬ(��Ϊ����������,����ͨ�������������ʵ��)
 * 		2.-->������,˵��������һ����������,ֱ�ӵ��ù�ʽ���Եõ��������Ľڵ���,Ȼ���ٽ�head��Ϊ�ҽڵ�
 * 		3.-->��������,��һ��������������������1,˵��������һ����������,ֱ�ӵ��ù�ʽ���Եõ��������Ľڵ���,Ȼ���ٽ�head��Ϊ��ڵ�
 */
public class _08����ȫ�������ڵ��� {
	
	public static void main(String[] args) {
		Tree mytree = new Tree(); 
		mytree.add(1);
		mytree.add(2);
		mytree.add(3);
		mytree.add(4);
		mytree.add(5);
		mytree.add(6);
		mytree.add(7);
		mytree.add(8);
		mytree.add(9);
		mytree.add(10);
		int size = getSize(mytree.head);
		System.out.println(size);
//		System.out.println(getHight(mytree.head));
	}
	
	//��ȡ�˶������Ľڵ���
	private static int getSize(Node head) {
		if (head==null) {	return 0;	}	//�սڵ�Ϊ0
		if (head.left==null&&head.right==null) {	return 1;	} //ֻ��head�ڵ�Ϊ1
		if (head.left!=null&&head.right==null) {	return 2;	} //ֻ����ڵ�Ϊ2
		
		int lefth = getHight(head.left);
		int righth = getHight(head.right);
		
		if (lefth==righth) {
			return (int)(Math.pow(2, lefth))+ getSize(head.right);
		}else {
			return (int)(Math.pow(2, righth))+ getSize(head.left);
		}
	}
	
	//����ȫ�������л�ȡһ�����ĸ߶�(ֱ���������)
	private static int getHight(Node head) {
		int resut = 0;
		while(head!=null){
			resut++;
			head=head.left;
		}
		return resut;
	}

	
}
