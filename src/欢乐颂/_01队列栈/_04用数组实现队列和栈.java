package ������._01����ջ;


/**
 * ������ṹʵ�ִ�С�̶��Ķ��к�ջ
 * ջ(�Ƚ����)����һ��indexָ��,������Ԫ��ʱ��ӵ�indexָ���λ��,����index++
 * 		��ȥ��һ��Ԫ��ʱ,ȥ��index--������Ӧ��λ��,����index��һ  (����--index)
 * 
 * ����(�Ƚ��ȳ�),���õ�����ָ��,һ��start(ͷ��ȡֵ,��ͷ��ȡֵ,ȡ����start++,size--),
 * 		һ��end(β��׷�Ӵ���Ӵ˴����Ԫ�ز�end++,size++),һ��size������е�Ԫ�ظ���
 */
public class _04������ʵ�ֶ��к�ջ {

	public static void main(String[] args) {
		Mystack my = new Mystack(5);
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
		System.out.println(pop1+""+pop2+""+pop3+""+pop4+""+pop5);
		System.out.println("----------------------------------------");
		MyQueue queue = new MyQueue(5);
		queue.push(1);
		queue.push(2);
		queue.push(3);
		queue.push(4);
		queue.push(5);
		int po1 = queue.pop();
		int po2 = queue.pop();
		int po3 = queue.pop();
		int po4 = queue.pop();
		int po6 = queue.pop();
//		int po5 = queue.peek();
//		int po7 = queue.pop();
		System.out.println(po1+""+po2+""+po3+""+po4+""+po6);
	}
}

class Mystack {
	int [] stack;
	int index = 0;
	//��Ϊ�ǹ̶�����,��˴���ʱҪ�涨�ó���
	public Mystack(int len){
		stack = new int[len];
	}

	//ѹջ
	public void push(int cur){
		if (index > stack.length) {
			throw new RuntimeException("ջ�ڴ�����");
		}
		stack[index++] = cur;
	}
	
	//ɾ��������ջ��
	public int pop(){
		if (index <= 0) {
			throw new RuntimeException("ջ�в�����Ԫ��");
		}
		return stack[--index];
	}
	
	//����ջ��Ԫ��
	public int peek(){
		if (index <= 0) {
			throw new RuntimeException("ջ�в�����Ԫ��");
		}
		int tem = stack[--index];
		index++;
		return tem;
	}
}

class MyQueue {
	int [] queue;
	int start = 0;	//ָ���ͷ.�ڴ˴���Ԫ��
	int end = 0;	//ָ���β,�ڴ˴����Ԫ��
	int size = 0;	//������еĴ�С
	
	//��Ϊ�ǹ̶�����,��˴���ʱҪ�涨�ó���
	public MyQueue(int len){
		queue = new int[len];
	}
	
	//�����β����������
	public void push(int cur){
		if (size >= queue.length) {
			throw new RuntimeException("�����ڴ�����");
		}
		queue[end++] = cur;
		size++;
		end = (end==queue.length ? 0:end); //������˶����ͽ�������ָ��0λ��
	}

	public int peek(){
		if (size == 0) {
			throw new RuntimeException("��������Ԫ��");
		}
		return queue[start];
	}
	
	public int pop(){
		if (size == 0) {
			throw new RuntimeException("��������Ԫ��");
		}
		int tem = queue[start++];
		size--;
		start = (start==queue.length ? 0:start);
		return tem;
	}
}
