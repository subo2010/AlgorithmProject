package ������._09���������㷨;

import java.util.LinkedList;
import java.util.Stack;

import org.junit.Test;

/**
 * ����ջ���������ԭʼ������:��һ������������п����ҵ�ÿһ�������������һ���ȱ����(С)����;
 * ����: ����{2,7,4,3,9}  Ԫ��4�����һ�����������7,������������9
 * ˼·: Ӧ���������,���һ��ջ�ṹ(�Ƚ����),ջ�׵�ջ������ά��Ԫ��*�Ӵ�С*
 * 		�������һ��Ԫ�ص�ʱ�����ջ��,ÿһ�����Ԫ�ض���ջ�����Ƚ�,
	 * 		���С��ջ��Ԫ��.����Υ��ջ�׵�ջ������Ԫ�شӴ�С��ԭ��,�ͽ���Ԫ��ѹջ.
	 * 		������ִ�Ԫ��a����ջ��Ԫ��v,��ʼ��¼,����ջ��Ԫ��v,v��������������������Ԫ��,�Ҳ������Ԫ��Ϊa
	 * 		ѭ�������case,ֱ��������a���Ԫ�ػ���ջ����,��a����ջ��
 * 			�������ջ��Ԫ��������Ԫ����ͬ��С,�򽫴�Ԫ���±�����Ƕ�Ԫ�ص��±�һ�������ʽ��ŵ�һ������
 * 		�����������Ԫ���Ժ�,��ʼ��ջ�����ⵯ��Ԫ��,��ջ��Ԫ�ص���������������ֵΪ�����Ԫ��(��������һ��Ԫ����Ϊ��)
 * 		����������Ԫ��Ϊ��,
 */
public class _09����ջ�ṹ {
	
	@Test
	public void main() {
		int[] arr = {2,7,4,3,4,9};
		
		//��ӡÿ��Ԫ������������һ����������
		Monotstack(arr);
	}

	private void Monotstack(int[] arr) {
		
		//����һ��ջ�ṹ (����ά������һ������ṹ,��ͬ��Ԫ�ؿ���������)
		Stack<LinkedList<Integer>> stack = new Stack<LinkedList<Integer>>();
		//�������е�Ԫ����ӵ�ջ�ṹ
		for (int i = 0; i < arr.length; i++) {
			while(!stack.isEmpty()&&arr[stack.peek().getLast()] < arr[i]){
				//һֱ���ⵯ
				LinkedList<Integer> list = stack.pop();//�õ�ջ���±������
				while(!list.isEmpty()) {
					int last = arr[list.pollLast()];
					int zuo = stack.isEmpty() ? 10000: arr[stack.peek().getLast()];
					int you = arr[i];
 					System.out.println("Ԫ��"+last+"--> ��:"+ zuo +"��:"+ you);
				}
			}
			
			if (!stack.isEmpty()&&arr[stack.peek().getLast()] == arr[i]) {
				//��ͬԪ��
				stack.peek().addLast(i);
			} else {
				//ֱ��ѹջ
				LinkedList<Integer> linked = new LinkedList<Integer>();
				linked.add(i);
				stack.push(linked);
			}
		}
		
		while (!stack.isEmpty()) {
			LinkedList<Integer> list = stack.pop();//�õ�ջ���±������
			while(!list.isEmpty()) {
				int last = arr[list.pollLast()];
				int zuo = stack.isEmpty() ? 10000: arr[stack.peek().getLast()];
				int you = 10000;
					System.out.println("Ԫ��"+last+"--> ��:"+ zuo +"��:"+ you);
			}
		}
	}
}
