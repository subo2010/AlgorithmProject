package ������._01����ջ;

import java.util.Stack;

/**
 * 	ջʵ�ֶ���   �Ļ�Ҳ����Ҫ����ջ���ܹ�ʵ��һ������,һ��push��.һ��pop��
 * 	�洢ʱ�����ݴ�ŵ�pushջ��,��ȡ��ʱ��push���е�����һ��ȡ������pop��
 * 	��ɺ󷵻�pop�ѶѶ���Ԫ��,���º��ڽ�popջ�е�Ԫ�ض�����pushջ
 * 	(ע��:1.��pop������Ԫ���ǲ��������浹Ԫ��  2.ÿ��push����help���е�Ԫ��һ��Ҫ����)
 * 
 *
 */
public class _07ջ�ṹʵ�ֶ��� {
	public static void main(String[] args) {
		MyQueue2 my = new MyQueue2();
		my.push(1);
		my.push(2);
		my.push(3);
		my.push(4);
		my.push(5);
		int pop1 = my.pop();
		int pop2 = my.pop();
		int pop3 = my.pop();
		int pop4 = my.pop();
		int pop5 = my.peek();
		int pop6 = my.pop();
//		int pop7 = my.pop();
		System.out.println(pop1+" "+pop2+" "+pop3+" "+pop4+" "+pop5);
	}
}

class MyQueue2{
	Stack<Integer> pushStack;	//���ڴ洢Ԫ��
	Stack<Integer> popStack;	//��ȡԪ�ص�ʱ�����ݵ�������
	
	public MyQueue2(){
		pushStack = new Stack<Integer>();
		popStack = new Stack<Integer>();
	}
	
	//���������Ԫ��
	public void push(int cur){
		pushStack.push(cur);
	}
	
	//������ɾ��Ԫ��
	public int pop(){
		if (pushStack.isEmpty()) {
			throw new RuntimeException("the queue is empty");
		}
		swap(); //��pushջ�е�Ԫ�ص���popջ
		int tem = popStack.pop();	//ȡ��popջ��ջ��Ԫ��
		swap(); //��popջ�е�Ԫ���ٵ���pushջ
		return tem;
	}
	
	//ȥ������ͷ��Ԫ��
	public int peek(){
		if (pushStack.isEmpty()) {
			throw new RuntimeException("the queue is empty");
		}
		swap(); //��pushջ�е�Ԫ�ص���popջ
		int tem = popStack.peek();	//ȡ��popջ��ջ��Ԫ��
		swap(); //��popջ�е�Ԫ���ٵ���pushջ
		return tem;
	}
	
	//�����ݴ�һ��ջ������һ��ջ(��һ���ǿ�ջ������һ����ն)
	public void swap(){	
		if (pushStack.isEmpty() && popStack.isEmpty()) {
			return;
		} else if (pushStack.isEmpty() && !popStack.isEmpty()) {
			while (!popStack.isEmpty()){
				pushStack.push(popStack.pop());
			}
		} else if(!pushStack.isEmpty() && popStack.isEmpty()) {
			while (!pushStack.isEmpty()){
				popStack.push(pushStack.pop());
			}
		}
	}
}
