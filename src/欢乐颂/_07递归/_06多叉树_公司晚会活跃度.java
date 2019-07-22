package ������._07�ݹ�;

import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

/**
* �ݹ������
 * ��Ŀ������һ����˾�����¼���ϵ��һ�ö�����������˾Ҫ�ٰ���ᣬ
	  	����Ϊ��֯���Ѿ������˴�ҵ�����һ��Ա����ֱ���ϼ�������������Ա���϶���������
	  	ÿ��Ա������һ����Ծ�ȵ�ֵ������˭���������Ա�������뺯����ô�������������Ծ��
	  	�������Ļ�Ծֵ��	
 * Ҫ��:����һ���������ͷ���.���ض������е�����Ծֵ;
 * 
 * ���ڽ�����ж�����������:
 * 	������ֽ�:����˵����һ��ͷ�����ܻ����һ�����
 * 		1.ͷ�����,���ͷ�ڵ����Ļ������ӽڵ㶼����,����Ծֵ��ͷ�����������ӽڵ㲻���Ļ�Ծֵ
 * 		2.ͷ��㲻��,�ӽڵ��п����� Ҳ�п��ܲ���,���ж�ÿ���ӽڵ����벻���Ǹ���Ծֵ����,ѡ��ߵ��Ǹ���ÿ���ӽڵ��ۼ�����
 * 	����������������Ҫ����Ϣ:
 * 		1.��ǰ�ڵ����Ļ�Ծ��
 * 		2.��ǰ�ڵ㲻���Ļ�Ծ��
 * 	�ݹ麯���ռ�����Ϣ
 * 		1.��ǰ�ڵ����Ļ�Ծ��
 * 		2.��ǰ�ڵ㲻���Ļ�Ծ��
 */
public class _06�����_��˾����Ծ�� {
	
	@Test
	public void main() {
		Node head = new Node(6); 
		head.list.add(new Node(3));
		head.list.add(new Node(3));
		head.list.add(new Node(2));
		head.list.add(new Node(4));
		System.out.println(Math.max(patition(head).bu_lai_huo, patition(head).lai_huo));
	}
	
	
	//����һ������ֵ���͵���
	public class ReturnDate{
		public int lai_huo;
		public int bu_lai_huo;
		public ReturnDate(int lai_huo, int bu_lai_huo) {
			this.lai_huo = lai_huo;
			this.bu_lai_huo = bu_lai_huo;
		}
	} 
	
	public ReturnDate patition(Node head){
		//��ֹ����    //���������Է���
		if(head==null){return new ReturnDate(0, 0);}
		
		int cur_lai_huo = head.value;
		int cur_bu_lai_huo = 0;
		
		//�ݹ麯��(���������ﵽ����ֵ�õ�����ֵ)----> �ݹ�ĵ��ÿ��Ե����Ǻں�
		for (int i = 0; i < head.list.size(); i++) {
			Node node = head.list.get(i);
			ReturnDate returnDate = patition(node);
			//���ӽڵ����Ƶ�����ǰ�ڵ�,��������
			cur_lai_huo += returnDate.bu_lai_huo;	//�쵼���Ļ������϶�������,��˼������Ƕ������Ļ�Ծֵ
			cur_bu_lai_huo += Math.max(returnDate.lai_huo, returnDate.bu_lai_huo);//�쵼����������������,Ҳ���ܲ���
		}
		//���ظ��Լ��ĸ�����
		return new ReturnDate(cur_lai_huo,cur_bu_lai_huo);
	}
	
	//�������Ľڵ����
	class Node{
		int value;
		List<Node> list = null;
		public Node(int value){
			this.value = value;
			this.list = new LinkedList<Node>();
		}
	}
}

