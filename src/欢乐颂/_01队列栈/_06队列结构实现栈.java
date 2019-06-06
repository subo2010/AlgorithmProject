package ������._01����ջ;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.DelayQueue;

/**
 * 	�����������ȳ��ṹ,ջ���������ں�
 * ���ö�����ʵ��ջ�ṹ��Ҫ������������,һ��data����,һ��help����
 * ������ʱ�����Ǹ���data������push(������n��Ԫ��),Ȼ����ȡ�Ķ���ֻ��ȡ��
 * ���ȷŽ�ȥ��Ԫ��,��ջ�Ĺ�����ȡ���շŽ�ȥ��Ԫ��,���,�����¶����е�n-1����ȡ���ŵ�help������
 * Ȼ���ٽ�data�����е����һ�����ݷ���,һ����ɺ�,��help��data���е���������
 * 
 *
 */
public class _06���нṹʵ��ջ {

	public static void main(String[] args) {
		MyQueue1 qu = new MyQueue1();
		qu.push(1);
		qu.push(2);
		qu.push(3);
		qu.push(4);
		qu.push(5);
		int pop = qu.pop();
		int pop2 = qu.pop();
		int pop3 = qu.pop();
		int pop4 = qu.pop();
		int pop5 = qu.pop();
		System.out.println(pop+" "+pop2+" "+pop3+" "+pop4+" "+pop5);
	}
}

class MyQueue1{
	Queue<Integer> dataQueue;
	Queue<Integer> helpQueue;
	public MyQueue1(){
		dataQueue = new LinkedList<Integer>();
		helpQueue = new LinkedList<Integer>();
	}
	
	public void push(int cur){
		dataQueue.add(cur);
	}
	
	public int pop(){
		if (dataQueue.isEmpty()) {
			throw new RuntimeException("�����ǿյ�");
		}
		while (dataQueue.size() != 1) {
			helpQueue.add(dataQueue.poll());
		}
		int tem = dataQueue.poll();
		swap();
		return tem;
	}
	
	public int peek(){
		if (dataQueue.isEmpty()) {
			throw new RuntimeException("�����ǿյ�");
		}
		while (dataQueue.size() != 1) {
			helpQueue.add(dataQueue.poll());
		}
		int tem = dataQueue.poll();
		helpQueue.add(tem);
		swap();
		return tem;
	}
	
	private void swap() {
		Queue<Integer> tem = new DelayQueue();
		tem = dataQueue;
		dataQueue = helpQueue;
		helpQueue = tem;
	}
}