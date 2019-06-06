package ������._09���������㷨;

import java.util.Comparator;
import java.util.PriorityQueue;

import org.junit.Test;

/**
 * BFPRT�㷨Ҫ�����ԭʼ������:���ٵ���һ�����������п��ٵõ���KС(��)����
 * ˼·1:��Ҫ��һ�����������еõ���K�����,����topK����Ĵ�һȺ���в��ǰK�����,��˿�����һ����СΪk�Ķ���ʵ��
 * 		ʱ�临�Ӷ�ΪO(nlogK)
 * 
 * ˼·2:�������ÿ��ŵ�partition��������,���ú����������������,ÿ�����ѡһ����,�������ķ�����,���ڵķ��м�,С�ڵķ�����
 * 		����жϵ��������±��k�Ĵ�С��ϵ   ---> ʱ�临�Ӷ�������O(n)
 * 
 * ˼·3:����BFPRT�㷨�����
 * 	1)�Ƚ�n����û5����һ����л��� O(1)
 * 	2)��ÿ���5������������		O(n)
 * 	3)�õ�ÿ�����λ�����γɵ�����  O(n)
 * 	4)�õݹ�ķ�ʽ�õ��������λ����ɵ��������е���Ϊ��T(n/5)
 *  5)��4)�õ���������˼·2�еı����ݹ�,�������л���,ѡ��һ���ֽ��еݹ�T(7n/10)
 * 
 * @author Administrator
 *
 */
public class _06_BFPRT�㷨 {

	@Test
	public void main() {
//		int[] arr = { 6, 9, 1, 3, 1, 2, 2, 5, 6, 3, 5, 9, 7, 2, 5, 6, 9 };
//		sorted : { 1, 1, 1, 1, 2, 2, 2, 3, 3, 5, 5, 5, 6, 6, 6, 7, 9, 9, 9 }
//		printArray(getMinKNumsByHeap(arr, 10));
//		System.out.println(getMinKNumsByBFPRT(arr, 4));
		
		int[] arr = { 1,2,3,4,5,6,7 };
		int min1 = getMinKNumsByBFPRT(arr, 6);
		System.out.println(min1);
		int min2 = getMinKNumsByHeap(arr, 3);
		System.out.println(min2);
	}

	//��arr�����л�õ�iС����(�����һС��������С����)
	private int getMinKNumsByHeap(int[] arr, int size) {
		//basecase
		if (size>arr.length||size<=0) {
			throw new RuntimeException("�������i�����㷶Χ!!");
		}
		
		//��ΪҪ�õ���С�ĵ�k����,���Ҫ����һ���󶥶�  (Ĭ���Ǵ�����С����,���������Ҫ��дComparator)
		PriorityQueue<Integer> heap = new PriorityQueue(1, new Comparator<Integer>() {
			public int compare(Integer o1, Integer o2) {
				return o2-o1;
			}
		});
		
		//���Ƚ�arr��ǰi����װ���󶥶���,�γ�һ���ݻ�Ϊi�Ĵ󶥶�
		for (int j = 0; j < size; j++) {
			heap.add(arr[j]);
		}
		
		//����arr�е�ʣ��Ԫ��,���Ԫ�رȶѶ�С����ջ������,��������
		for (int i = size; i < arr.length; i++) {
			if (heap.peek()>arr[i]) {
				heap.poll();
				heap.add(arr[i]);
			}
		}
		return heap.peek();
	}
	
	//ͨ��BFPRT�㷨�����---------------BFPRT-------------BFPRT-------------BFPRT-------------------
	public int getMinKNumsByBFPRT(int[] arr, int K) {
		
		return select(arr, 0, arr.length - 1, K - 1);
	}

	//������BFPRT����,���뼯��arr,�����в��ҵ���ʼ����ͽ�������,�����±�Ϊi��λ��
	//��arr�����е�begin�±굽end�±��ҵ���iС����
	public int select(int[] arr, int begin, int end, int i) {
		if (begin == end) {
			return arr[begin];
		}
		
		//������λ�������е���λ��
		int pivot = medianOfMedians(arr, begin, end);
		
		//���õõ�����λ������partiton���̷��ص��ڴ������±�(--pivotRange[0]�±����߽�--)
		int[] pivotRange = partition(arr, begin, end, pivot);
		//���iλ�ڵ�����������Ӧ���±����ʾ��K���ֵ���Ǵ�ֵ
		if (i >= pivotRange[0] && i <= pivotRange[1]) {
			return arr[i];
		} else if (i < pivotRange[0]) {  //���������ݹ����
			return select(arr, begin, pivotRange[0] - 1, i);
		} else {
			return select(arr, pivotRange[1] + 1, end, i);
		}
	}

	//�����λ�����鲢�ҷ���������λ��
	public int medianOfMedians(int[] arr, int begin, int end) {
		int num = end - begin + 1;
		int offset = num % 5 == 0 ? 0 : 1;
		//����һ����λ������
		int[] mArr = new int[num / 5 + offset];
		
		//��ÿһ�����λ���ŵ�����
		for (int i = 0; i < mArr.length; i++) {
			int beginI = begin + i * 5;	//��С��Ŀ�ʼ�±�
			int endI = beginI + 4;		//��С��Ľ����±�
			insertionSort(arr, beginI, endI);//���������㷨��������
			int sum = end + begin;
			int mid = (sum / 2) + (sum % 2);//�����м��±�
			mArr[i] = arr[mid];		//����λ�����λ��������
		}
		
		//�ݹ����(�緽��),�ڴ˷�Χ�ڵõ��м����Ǹ���(����Ϊ��)
		return select(mArr, 0, mArr.length - 1, mArr.length / 2); 
	}
	
	public void insertionSort(int[] arr, int begin, int end) {
		for (int i = begin + 1; i != end + 1; i++) {
			for (int j = i; j != begin; j--) {
				if (arr[j - 1] > arr[j]) {
					swap(arr, j - 1, j);
				} else {
					break;
				}
			}
		}
	}

	//���ŵ�partiton����,���ǻ����pivotValueֵ���±�
	public int[] partition(int[] arr, int begin, int end, int pivotValue) {
		int small = begin - 1;
		int cur = begin;
		int big = end + 1;
		while (cur != big) {
			if (arr[cur] < pivotValue) {
				swap(arr, ++small, cur++);
			} else if (arr[cur] > pivotValue) {
				swap(arr, cur, --big);
			} else {
				cur++;
			}
		}
		int[] range = new int[2];
		range[0] = small + 1;
		range[1] = big - 1;
		return range;
	}

	public void swap(int[] arr, int index1, int index2) {
		int tmp = arr[index1];
		arr[index1] = arr[index2];
		arr[index2] = tmp;
	}
}
