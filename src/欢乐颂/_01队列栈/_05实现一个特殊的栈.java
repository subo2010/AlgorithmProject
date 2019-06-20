package ������._01����ջ;

import java.util.Stack;

/**
 * 	ʵ��һ�������ջ����ʵ��ջ�Ļ������ܵĻ����ϣ���ʵ�ַ�
	��ջ����СԪ�صĲ�����
��Ҫ��
	1��pop��push��getMin������ʱ�临�Ӷȶ���O(1)��*****
	2����Ƶ�ջ���Ϳ���ʹ���ֳɵ�ջ�ṹ��
 * 
 * ˼·:��Ȼ����O(1)�ǾͲ����������㷨����,������������ջ��ʵ��,һ������ջ,һ��minջ.����ջһ�ж�һ��
 * 		��minջÿ��push��ʱ�򶼺�ջ���Ƚ�,�����ջ��С��ѹ�뱾��,����ѹ��ջ��Ԫ��
 */
public class _05ʵ��һ�������ջ {

	public static void main(String[] args) {
		MyStack1 my = new MyStack1();
		my.push(1);
		my.push(6);
		my.push(-2);
		my.push(4);
		my.push(0);
		my.push(1);
		my.push(-8);
		System.out.println(my.getMin());
	}
}

class MyStack1{
	
	private Stack<Integer> DataStack;
	private Stack<Integer> MinStack;
	
	public MyStack1(){
		DataStack = new Stack<Integer>();
		MinStack = new Stack<Integer>();
	}
	
	public void push(int cur){
		if (DataStack.isEmpty()) {
			DataStack.push(cur);
			MinStack.push(cur);
		}
		DataStack.push(cur);
		//��ջ���Ƚ��ĸ���С,�ĸ���Сѹ���ĸ�****(minջ�в��Ǵ�ŵ���һ��Ԫ��)
		Integer min = MinStack.peek();
		cur = cur < min? cur:min;
		MinStack.push(cur);
	}
	
	public int peek(){
		return DataStack.peek();
	}
	
	public int pop(){
		MinStack.pop();
		return DataStack.pop();
	}
	
	public int getMin(){
		return MinStack.peek();
	}
}
