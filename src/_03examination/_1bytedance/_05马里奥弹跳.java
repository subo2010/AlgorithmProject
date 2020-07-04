package _03examination._1bytedance;

import org.junit.Test;

/*
 * ��Ŀ:�����ͨ�����������յ�,����һ������{10,0,2,1,1,0,1,�յ�},������ǰ�����������,ÿ��λ�õ��������嵯���������
 * 		��������ʼ��λ��index,�㷵���������յ����С��������.
 * 		ע��:Ϊ0��λ��Ϊ����,���������������˵��ʧ��,�򷵻�-1
 * �����ݹ�:�õ�index�����ж�,indexλ���Ƿ�Ϊ0,����Ǿͷ���-1,Ȼ�󿴴�index���ܲ���ֱ�������յ�,�����,�ͷ��� 1,��������յ㷵��0
 * 		Ȼ���ж����������Ǹ�λ��,���õݹ麯��ʵ��,��󷵻�,��С�ĵ�������
 * ���仯����:
 */
public class _05����µ��� {
	
	@Test
	public void main() {
		int[] arr = {10,0,2,1,1,0,1};
		int index = 3; //���ĸ�λ��,�±�Ϊ3��λ��
		int[] help = new int[arr.length]; //���仯�����Ļ�������
		int step = getStepNum(arr , index);
		System.out.println(step);
	}

	private static int getStepNum(int[] arr, int index) {
		int[] help = new int[arr.length]; //��������Ǹ�λ�ñ�������
		return parttion(arr,help,index);
	}

	private static int parttion(int[] arr, int[] help, int index) {
		//basecase
		if (arr[index] == -1) return -1;
		if (index == arr.length) return 0;
		if (index + arr[index] >= arr.length) return 1;
		
		int minStep = Integer.MAX_VALUE;//ȫ����Сֵ
		for (int i = -arr[index]; i <= arr[index]; i++) { //�ܹ���Ծ�ķ�Χ
			//�����ǰλ��û������������û��Խ��,�������
			if (index+i >= 0 && index+i < arr.length && help[index+i] == 0) { 
				help[index+i] = 1;//��ʾ��ǰλ������
				int tempStep = parttion(arr, help, index+i);
				if (tempStep != -1) { //ֻ�е���һ��λ�ò�������,���ǲ���
					minStep = Math.min(minStep, tempStep + 1);
				}
			}
		}
		int result = minStep == Integer.MAX_VALUE ? -1: minStep;
		return result;
	}

}
