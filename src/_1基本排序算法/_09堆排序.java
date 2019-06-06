package _1���������㷨;
import java.util.Arrays;


public class _09������ {
	/**
	 * ʱ�临�Ӷ�: O(nlogn) O(nlogn) ---ƽ��---->O(nlogn)
	 * �ռ�ռ��: O(1)
	 * �ȶ���: ���ȶ�
	 * @param args
	 */
	
	public static void main(String[] args) {
		int[] arr = {5,3,2,8,5,9,21,6};
		heapSort(arr);
		printArray(arr);
//		System.out.println(-1/2);
	}
	
	
	//������
	public static void heapSort(int[] arr) {
		//������������С�ڵ���1ʱֱ�ӷ���
		if (arr == null || arr.length < 2) {
			return;
		}
		
		//�����������鹹��ɴ󶥶�
		for (int i = 0; i < arr.length; i++) {
			heapInsert(arr, i);
		}
		
		//���Ѷ�������β������,�ѵĳ��ȼ�һ;(ÿһ�ν����ķŵ����)
		int size = arr.length;
		swap(arr, 0, --size);
		while (size > 0) {
			heapify(arr, 0, size);	//�Ѷ����ݸı����³ɶ�
			swap(arr, 0, --size);	//��������λ��
		}
	}

	//����в���һ��ֵ(ÿ�ζ����丸�ڵ�Ƚ�����ȸ��ڵ���򽻻�Ϊλ��,���븸�ڵ�Ƚ�,ֱ��С�ڸ��ڵ�)
	//�˷���Ĭ��index֮ǰ�������Ѿ��γɴ󶥶ѽṹ,��index�±��Ԫ�ز���
	public static void heapInsert(int[] arr, int index) {
		while (arr[index] > arr[(index - 1) / 2]) {
			swap(arr, index, (index - 1) / 2);
			index = (index - 1) / 2;				//-1/2 = 0
		}
	}
	
	//�ı����һ��ֵ,���³ɶ�
	public static void heapify(int[] arr, int index, int size) {
		int left = index * 2 + 1;  //���ӽڵ�
		while (left < size) {
			int largest = left + 1 < size && arr[left + 1] > arr[left] ? left + 1 : left;
			largest = arr[largest] > arr[index] ? largest : index;
			if (largest == index) {
				break;
			}
			swap(arr, largest, index);
			index = largest;
			left = index * 2 + 1;
		}
	}

	//���߷���,����
	public static void swap(int[] arr, int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}

	//���߷���,��ӡ����
	public static void printArray(int[] arr) {
		if (arr == null) {
			return;
		}
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
}
