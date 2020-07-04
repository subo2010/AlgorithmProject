package _03examination._1bytedance;

import java.util.Comparator;
import java.util.PriorityQueue;

import org.junit.Test;

/*
 * ˼·:
 * ��һ�����Ѵ�ű���λ��С������ڣ���Ԫ�أ�
 * ��һ����С�Ѵ�ű���λ���󣨻���ڣ���Ԫ�ء�
 * ����ؼ��ķ�����insert()��ÿ��Ҫ����һ��Ԫ��ʱ�������ж����������������ѻ�����С�ѣ�
 * ���������Ѻ���С�ѣ�ʹ�����Ѻ���С����Ԫ�صĸ���֮�����1��������λ���������ѻ���С�ѵĶѶ�Ԫ�ء�
 * �����Ѻ���С����Ԫ�ظ�����ͬ���������Ϊ1��ʱ��Ԫ�ظ�������Ǹ��ѵĶѶ�Ԫ�ؼ�Ϊ��λ����
 * �������Ԫ�ظ�����ͬ����ô��λ�����������Ѻ���С�ѵĶѶ�Ԫ�ص�ֵȡƽ����
 * 
 */
public class _15���öѽṹ��ʵ����λ���Ĳ��� {
	
	@Test
	public static void main(String[] args) {
		int[] arr = {1,2,3,4};
		double mid = partion(arr);
		System.out.println(mid);
	}

	private static double partion(int[] arr) {
		if(arr == null || arr.length == 0){
			return -1;
		}
		PriorityQueue<Integer> minHeap = new  PriorityQueue<Integer>(20); //�����λ�����Ԫ��
		PriorityQueue<Integer> maxHeap = new  PriorityQueue<Integer>(20,new Comparator<Integer>() {
			public int compare(Integer o1, Integer o2) {
				return o2-o1;
			}
		});
		//ά�������ѵĴ�С��������1(һֱʹmaxHeap��size����minHeap)
		//��������Ԫ�����ʱ,�²����value,���������minHeap�����ֵ���������뵽minHeap��
		//���Ұ�minHeap����Сֵ�ƶ���maxHeap��������뵽maxHeap
		for (int i = 0; i < arr.length; i++) {
			if (maxHeap.size() == minHeap.size()) {
	             if (minHeap.peek() != null && arr[i] > minHeap.peek()) {
	            	 minHeap.offer(arr[i]);
	                 maxHeap.offer(minHeap.poll());
	             } else {
	                 maxHeap.offer(arr[i]);
	             }
	         } else {
	             if (arr[i] < maxHeap.peek()) {
	            	 maxHeap.offer(arr[i]);
	                 minHeap.offer(maxHeap.poll());
	             } else {
	                 minHeap.offer(arr[i]);
	             }
	         }
		}
		if (maxHeap.isEmpty()) {
		     return -1; 
		}
		if (maxHeap.size() == minHeap.size()) {
			int num1 = minHeap.peek();
			int num2 = maxHeap.peek();
		     return (double)(num1 + num2)/2;
		} else {
		     return maxHeap.peek();
		}
	}
	
	
}
