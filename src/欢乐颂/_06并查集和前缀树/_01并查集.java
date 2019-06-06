package ������._06���鼯��ǰ׺��;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.junit.Test;

/**
 * ���鼯���Խ��������:
 * 		1.�����ж�������Ԫ���Ƿ�����ͬһ����
 * 		2.������Ԫ�����ڵļ��Ϻϲ���һ������
 * 	����:���뽫����Ԫ���ڳ�ʼ����ʱ��ȫ������,�����ܶ�̬�����Ԫ��
 * 
 * 	ԭ��:ʹ��һ����������Ľṹ��ʵ��,��������ͷ�ڵ��Father��ָ����ָ���Լ���,��ͷ����Fatherָ�붼ָ������Լ�����һ���ڵ�
 * 		ÿһ�����ϵ�ͷ��������Ϊ�˼��ϵĴ���ڵ�
 * 		����1:����ͨ���ж������ڵ����ڼ��ϵĴ���ڵ��Ƿ���ͬ,���ж����������Ƿ���ͬһ����
 * 		����2:������Ԫ�����ڵļ��Ϻϲ���һ������;���Խ��ڵ����ٵ��Ǹ����ϵĴ���ڵ����ӵ���һ�����ϴ���ڵ���±���
 * 		-->��������ʵ�������������ܶ�������,�����ж��������Ƿ����ĳԪ������ҪO(n)�ĸ��Ӷ�,�����ʵ����ʹ��HashMap�ṹ��ģ������
 * 		-->Ϊ�˽����Ż��������¸Ľ�,��ʼ��ʱ��ÿ��Ԫ�ر����װ��һ������,ÿ���ڲ�ѯԪ�ص����ڴ���ڵ��ʱ�򶼽���ѯ·���е�
 * 			���нڵ�ֱ�����ӵ�����ڵ���
 * 
 * ʱ�临�Ӷȷ���:����ԭʼ��������ΪN ,�򵱲�ѯ�ͺϲ��ķ�����Ӿ�������ڵ���Nʱ  ,��ÿ�ε���������������ʱ�临�ӶȽӽ���O(1)
 * @author Administrator
 *
 */
public class _01���鼯 {
	
	@Test
	public void main() {

		List<Node> list = new ArrayList<Node>();
		Node node1 = new Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node(3);
		Node node4 = new Node(4);
		Node node5 = new Node(5);
		list.add(node1);
		list.add(node2);
		list.add(node3);
		list.add(node4);
		list.add(node5);
		
		//�������鼯
		UnionFindSet unionSet = new UnionFindSet(list);
		
		System.out.println(unionSet.isSameSet(node1, node2));
		unionSet.union(node1, node2);
		System.out.println(unionSet.isSameSet(node1, node2));
		System.out.println("�ܽ��������ݿ�Ĺ��ӿ�");
	}
	
	//����Node����
	public class Node{
		//node�������ó��κ���ϲ��������
		int value;
		public Node(int value){
			this.value=value;
		}
	}
	
	//�������鼯�ṹ
	public class UnionFindSet{
		HashMap<Node, Node> fatherMap;	//��һ��������ڵ�,�ڶ����������丸�ڵ�
		HashMap<Node, Integer> sizeMap;	//���ڴ洢�˽ڵ����ڼ����а����Ľڵ���
		
		public UnionFindSet(List<Node> list){	//ֻ�ṩ�вι���,��ʼ��ʱ���뽫���в�������
			fatherMap = new HashMap<Node,Node>();
			sizeMap = new HashMap<Node,Integer>();
			//��ÿһ���ڵ㴴����һ�������ļ���
			for (Node node : list) {
				fatherMap.put(node, node);
				sizeMap.put(node, 1);
			}
		}
		
		//���Ҹ����ڵ�����Ӧ�Ĵ���ڵ�,�������Ż�(·�����нڵ㶼ָ�����ڵ�)
		public Node findHead(Node node){
			//�ҵ����ϴ���ڵ�
			Node father = fatherMap.get(node);//�õ��˽ڵ�ĸ��ڵ�
			while (father != fatherMap.get(father)) {
				father = fatherMap.get(father);
			}
			//����;�Ľڵ㶼ָ������
			while (node != fatherMap.get(node)){
				fatherMap.put(node, father);
				node = fatherMap.get(node);
			}
			return father;
		}
		
		//�ж������ڵ��Ƿ�����ͬһ������
		public boolean isSameSet(Node a,Node b){
			return findHead(a)==findHead(b);
		}
		
		//�������ڵ����ڵļ��Ϻϲ���ͬһ������
		public void union(Node a,Node b){
			if (a==null||b==null) {
				return;
			}
			Node ahead = findHead(a);
			Node bhead = findHead(b);
			//�������Ԫ�ز�����һ����������кϲ�
			if (ahead!=bhead) {
				int asize = sizeMap.get(a);	//���ϴ��ڵĽڵ���ֻ��¼�ڴ���ڵ���
				int bsize = sizeMap.get(b);
				if (asize<bsize) {
					fatherMap.put(ahead, bhead);	//��a��ӵ�b��
					sizeMap.put(bhead, asize + bsize);	//�޸Ĵ���ڵ���нڵ���
				} else {
					fatherMap.put(bhead, ahead);	//��b��ӵ�a��
					sizeMap.put(ahead, asize + bsize);
				}
			}
		}
		
	}
}
