package δ���;

import java.util.LinkedList;

import org.junit.Test;
/*
 * ҳ���û��㷨FIFO*
 * ��Ŀ:��Ʋ�ʵ�������ʹ�ã�FIFO����������ݽṹ����Ӧ��֧�����²�����get �� put��
	get(key) - ����������ڻ����У����ȡ����ֵ�����������������򷵻� -1��
	put(key, value) - ����������ڣ��������ֵ,�������,��ԭ����ֵɾ��Ȼ�������ֵ��
	������ﵽ������ʱ����Ӧ���ڲ�����ֵ֮ǰ��ʹ��������ֵ��Ч��
      ���ף�
	���Ƿ������ O(1) ʱ�临�Ӷ���ִ���������*
 
 ˼·:����һ��˫�������HashMap�Ľṹ��ʵ��,ͨ��HashMap�ṹ���ж�,�������Ƿ���Key
 	(��������hashmap������ÿ��key�������ж�Ӧ��λ��)
 	get()����:ͨ��HashMap���жϽں���֪����ڴ�Key,�������,ֱ�ӷ��������Ӧλ�õ�Ԫ��
 			�����ڵĻ�����-1
 	put()����:ͨ��HashMap���жϽں���֪����ڴ�Key,�������,��ͨ��HashMap�õ��ڶ����е�λ��,����Ӧλ�õ�Ԫ��ɾ��,Ȼ����ò����ڵķ���.
 			���������,(�ж��Ƿ񵽴���capacity)���û�е��ｫKey��Value���뵽HashMap��
 			Ȼ��Key���뵽�����β��.
 			�����put()ʱ�ﵽ��capacity

 */
public class _06ҳ�滺���㷨FIFO {

	@Test
	public void main() {
		LinkedList<Integer> list = new LinkedList<Integer>();
		list.addFirst(1);
		list.addFirst(2);
		list.addFirst(3);
		list.addFirst(4);
		list.remove(0); //Ĭ�ϴ�ͷ��β����
		System.out.println(list.get(0));
		System.out.println(list.get(1));
		System.out.println(list.get(2));
//		System.out.println(list.get(3));
	}
	//�������
	class LFUCache {

	    public LFUCache(int capacity) {
	        
	    }
	    
	    public int get(int key) {
	        return 1;
	    }
	    
	    public void put(int key, int value) {
	        
	    }
	}
}
