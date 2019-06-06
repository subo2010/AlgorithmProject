package ������._06���鼯��ǰ׺��;

import java.util.HashMap;

import org.junit.Test;

/**
 * ǰ׺���ṹ(trie��)
	����һ����������ṹ,������Ҫ��Ϣû�д洢���ڵ���,���Ǵ洢���ڵ���ڵ��·����
	��ʼ��ʱ��ֻ��һ��ͷ�ڵ�,�����ڽ��ַ���"abc"��ӵ�ǰ׺����ʱ,���ͷ�ڵ㿪ʼ�ж�
	����ͷ�ڵ���û����Ϊa��·,���û���򴴽�һ����Ϊa��·,Ȼ�󴴽�һ���ڵ�,����a·�����ڴ˽ڵ��ж��Ƿ�����Ϊb��·,���û���򴴽���Ϊb��·,
	Ȼ���ٴ���һ���ڵ�.����˽ڵ���ж��Ƿ�����Ϊc��·,���û���򴴽���·����һ���ڵ�,������.
	�ڴ����abd��ʱ����ù�ͷ�������,����Ϊa��·.ֱ������a·�����ڵ�,�ַ�������Ϊb��·����b·������һ���ڵ�,����û����Ϊd��·,��˴���
	һ����Ϊd��·,Ȼ��������һ���ڵ�
	
	�ɴ�����֪��,��ǰ׺��ͬ���ַ������뵽ǰ׺��ʱ,���˺ܺõĸ���Ч��.
		Ӧ��:�ж�һϵ���ַ������Ƿ��������һ���ַ�����ͷ���ַ���
	����ڽڵ��ϴ洢�ַ����ڴ˴���β�Ĵ���.
		Ӧ��:�Ϳ���Ӧ�����ж�һЩ���ַ������Ƿ������һ���ַ���
	����ڽڵ��ϴ洢�ַ����ڴ˴������Ĵ���.
		Ӧ��:�ж�һϵ���ַ������ж��ٰ�������һ���ַ�����ͷ���ַ���
 * @author Administrator
 *
 */
public class _03ǰ׺�� {
	
	@Test
	public void main() {
		TrieTree trie = new TrieTree();
		trie.insert("zuoac");
		trie.insert("zuoa");
		trie.insert("zuoa");
		trie.insert("zuoab");
		trie.insert("zuoad");
		trie.delete("zuoa");
		System.out.println(trie.search("zuoa"));
		System.out.println(trie.prefixNum("zuo"));
	}
	
	
	//ǰ׺���Ľڵ�
	public class TrieNode{
		public int path;   //�ж����ַ��������˽ڵ�
		public int end;	   //�ж����ַ����Դ˽ڵ��β
		//ÿһ��·�ɵ�һ������������ַ�����,�ڶ������������Ŵ����ֵ�·�������һ���ڵ�
		public HashMap<Character, TrieNode> nexts;	//��ʾ�˽ڵ��·(��--��Ϊ�����ж���)  
		
		//��ʼ������
		public TrieNode(){
			path = 0;
			end = 0;
			nexts =new HashMap<Character, TrieNode>();
		}
	}
	
	//����ǰ׺���ṹ
	public class TrieTree{
		private TrieNode root;
		//ǰ׺����ʼ��,�õ�һ��ͷ���
		public TrieTree(){
			root = new TrieNode();
		}
		
		//ǰ׺���в���һ���ַ���
		public void insert(String str){
			if (str==null) {
				return;
			}
			char[] chs = str.toCharArray();//���ַ���ת��Ϊ�ַ�����
			TrieNode node = root; //node����ָ��ͷ�ڵ�
			for (int i = 0; i < chs.length; i++) {
				if (node.nexts.get(chs[i])==null) {	 //�˽ڵ㲻��������·
					node.nexts.put(chs[i], new TrieNode());	//����һ��·
				}
				//�����·ָ�����һ���ڵ�
				node = node.nexts.get(chs[i]);
				node.path++;	//����������һ
			}
			node.end++;	//����������ָ��β�� ��ʱend��һ
		}
		
		//ǰ׺����ɾ��һ���ַ���
		public void delete(String str){
			if (search(str)==0) {
				return;
			}
			char[] chs = str.toCharArray();//���ַ���ת��Ϊ�ַ�����
			//ԭ���������α���ȥpath--,��ʱ�����path=0ʱ,֮���·����ͨpath=0�Ľڵ㶼��������
			TrieNode node = root; //node����ָ��ͷ�ڵ�
			for (int i = 0; i < chs.length; i++) {
				if (--node.nexts.get(chs[i]).path==0) {	//�����һ���ڵ�path-1��Ϊ0.��ֱ������(����ִ����path--)
					node.nexts.put(chs[i], null);
					return;	//ֱ�����������,����
				}
				//����͵õ���һ·�Ľڵ�
				node = node.nexts.get(chs[i]);
				//node.path--;	//ǰ���Ѿ�ִ�й���
			}
			node.end--;	//�ߵ����һ���ַ���һ
		}
		
		//����ǰ׺���г��ֹ�����str,���س��ֵĳ��ֵĴ���(������ַ����߼�����,�������һ����endֵ,����������̳���null�򷵻�0)
		public int search(String str){
			if (str==null) {
				return 0;
			}
			char[] chs = str.toCharArray();//���ַ���ת��Ϊ�ַ�����
			TrieNode node = root; 		//node����ָ��ͷ�ڵ�
			for (int i = 0; i < chs.length; i++) {
				if (node.nexts.get(chs[i])==null) {	 //�˽ڵ㲻��������·
					return 0;	//û�в�������ַ�,�򷵻�0
				}
				//�����·ָ�����һ���ڵ�
				node = node.nexts.get(chs[i]);
			}
			return node.end;	//�������һ���ڵ��endֵ
		}
		
		//����ǰ׺�����ж��ٰ�����str�ַ�����ͷ���ַ���
		public int prefixNum(String str){
			if (str==null) {
				return 0;
			}
			char[] chs = str.toCharArray();//���ַ���ת��Ϊ�ַ�����
			TrieNode node = root; 		//node����ָ��ͷ�ڵ�
			for (int i = 0; i < chs.length; i++) {
				if (node.nexts.get(chs[i])==null) {	 //�˽ڵ㲻��������·
					return 0;	//û�в�������ַ�,�򷵻�0
				}
				//�����·ָ�����һ���ڵ�
				node = node.nexts.get(chs[i]);
			}
			return node.path;	//�������һ���ڵ��pathֵ
		}
	}

}
