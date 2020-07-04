package _02�����㷨._10��������;

import org.junit.Test;

/*
 * ��Ŀ:����һ��int[]����,Ȼ���������,�����µ�����
 * 		ע:�ṩһ����ƽ���㷨,Ҫ��ÿһ�����г��ֵĸ�����ͬ
 * 
 * ˼·:�˴����õ���,Knuthϴ���㷨,���ܱ���ÿһ��λ�ó���ÿһ�����ĸ�����ͬ,Ҳ����ÿһ������,�䵽����λ�õĸ�����ͬ
 */
public class _08Knuthϴ���㷨 {

	@Test
	public void main() {
		int[] arr = {1,2,3,4,5};
		int[] arr1 = partion(arr);
		for (int i : arr1) {
			System.out.print(i +" ");
		}
	}

	//���ϴ��
	private int[] partion(int[] arr) {

		for (int i = arr.length-1; i >= 0; i--) {
			swap(arr,i,(int)(Math.random() * (i + 1)));
		}
		return arr;
	}

	private void swap(int[] arr, int i, int j) {
		int tem = arr[i];
		arr[i] = arr[j];
		arr[j] = tem;
	}

}
