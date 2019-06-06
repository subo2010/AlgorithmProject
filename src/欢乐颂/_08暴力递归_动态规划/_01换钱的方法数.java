package ������._08�����ݹ�_��̬�滮;

import org.junit.Test;

/*
 * ����Ŀ����������arr��arr�����е�ֵ��Ϊ�����Ҳ��ظ���ÿ��ֵ����һ����ֵ�Ļ��ң�ÿ����ֵ�Ļ��ҿ���ʹ�������ţ��ٸ���һ������aim����Ҫ�ҵ�Ǯ����
 * 		��Ǯ�ж����ַ�����
 *��������arr=[5,10,25,1]��aim=0��
 *		���0Ԫ�ķ�����1�֣�����������ֵ�Ļ��Ҷ����á����Է���1��
 *	arr=[5,10,25,1]��aim=15��
 *		���15Ԫ�ķ�����6�֣��ֱ�Ϊ3��5Ԫ��1��10Ԫ+1��5Ԫ��1��10Ԫ+5��1Ԫ��10��1Ԫ+1��5Ԫ��2��5Ԫ+5��1Ԫ��15��1Ԫ�����Է���6��
 *	arr=[3,5]��aim=2��
 *		�κη������޷����2Ԫ�����Է���0��
 *
 * �����ݹ�ⷨ:��[5,10,25,1]��aim=15��Ϊ����ö��
 * 			ʹ��0��5: 10,25,1 ���  15 �ķ�����Ϊ - a
 * 			ʹ��1��5: 10,25,1 ���  10 �ķ�����Ϊ - b
 * 			ʹ��2��5: 10,25,1 ���  5  �ķ�����Ϊ - c
 * 			ʹ��3��5: 10,25,1 ���  0  �ķ�����Ϊ - d
 * 		Ȼ�����ν� a b c d ������.
 */
public class _01��Ǯ�ķ����� {

	@Test
	public void main() {
		int[] arr = {5,10,25,1};
		int arm = 15;
		int num1 = baoli(arr,arm);
		System.out.println(arm);
	}

	//�����ⷨ
	private int baoli(int[] arr, int arm) {
		if (arr == null || arr.length == 0) {
			return 0;
		}
		
		return baoliPartion(arr,0,arm);
	}
	
	/*
	 * �����ݹ����
	 * arr:��ԭʼ����,����
	 * index:��ָ��indexλ�ÿ�ʼ�����ǰ����������
	 * arm :����Ҫƴ����Ŀ��Ǯ��
	 * ����ֵʱ������
	 */
	private int baoliPartion(int[] arr, int index, int arm) {
		int res = 0; //���巵�ؽ��
		if (index == arr.length) {
			return res = arm == 0 ? 1 : 0;
		}
		for (int i = 0; arr[index] * i < arm; i++) { //���μ����һ��λ��Ϊ��ֵͬʱ���صķ������ĺ�
			res += baoliPartion(arr, index + 1, arm - arr[index] * i);
		}
		return res;
	}
}
