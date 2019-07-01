package _1bytedance;

import org.junit.Test;

/*
 * ��Ŀ:�����ͨ�����������յ�,����һ������{10,0,2,1,1,0,1,�յ�},������ǰ�����������,ÿ��λ�õ��������嵯���������
 * 		��������ʼ��λ��index,�㷵���������յ����С��������.
 * 		ע��:Ϊ0��λ��Ϊ����,���������������˵��ʧ��,�򷵻�-1
 * �����ݹ�:�õ�index�����ж�,indexλ���Ƿ�Ϊ0,����Ǿͷ���-1,Ȼ�󿴴�index���ܲ���ֱ�������յ�,�����,�ͷ���-1,��������յ㷵��0
 * 		Ȼ���ж����������ĸ�λ��,���õݹ麯��ʵ��,��󷵻�,��С�ĵ�������
 * ���仯����:
 */
public class _05����µ��� {
	
	@Test
	public void main() {
		int[] arr = {10,0,2,1,1,0,1};
		int index = 3; //���ĸ�λ��,�±�Ϊ3��λ��
		int[] help = new int[arr.length]; //���仯�����Ļ�������
		int step = getStepJY(arr , help, index);
		System.out.println(step);
	}

	private int getStep(int[] arr, int index) {
		if (arr[index] == 0 || index < 0 || index > arr.length) {
			return -1;
		}
		if (index == arr.length) return 0;  			//�����յ�
		if (index+arr[index] >= arr.length) return 1; 	//�����λ����������Ծ���յ�,��1�ξ��ܳɹ�
		
		int minStep = Integer.MAX_VALUE;  //����һ��ȫ����Сֵ,������������С�Ĳ���
		for (int i = -arr[index]; i <= arr[index]; i++) {  			//������ǰ��Ҳ����������
			if (index+i >= 0 && index+i < arr.length && i != 0) {	//ֻҪû������,�����Լ��ĵط��������
				int tempNum = getStep(arr,index+i);//�¸�λ�÷��صĲ���
				if (tempNum != -1) {
					minStep = Math.min(minStep, tempNum+1);
				}
			}
		}
		int result = minStep==Integer.MAX_VALUE?-1:minStep;
		return result;
	}
	
	private int getStepJY(int[] arr, int[] help, int index) {
		if (arr[index] == 0 || index < 0 || index > arr.length) {
			return -1;
		}
		if (index == arr.length) return 0;  			//�����յ�
		if (index+arr[index] >= arr.length) return 1; 	//�����λ����������Ծ���յ�,��1�ξ��ܳɹ�
		
		int minStep = Integer.MAX_VALUE;  //����һ��ȫ����Сֵ,������������С�Ĳ���
		for (int i = -arr[index]; i <= arr[index]; i++) {  			//������ǰ��Ҳ����������
			if (index+i >= 0 && index+i < arr.length && i != 0) {	//ֻҪû������,�����Լ��ĵط��������
				//�жϻ����Ƿ����
				if (help[index+i] == 0) {
					int tempNum = getStep(arr,index+i);//�¸�λ�÷��صĲ���
					help[index+i] = tempNum;
				} else{
					int tempNum = help[index+i];
					if (tempNum != -1) {
						minStep = Math.min(minStep, tempNum+1);
					}
				}
			}
		}
		int result = minStep==Integer.MAX_VALUE?-1:minStep;
		return result;
	}
	
	
	private int getStepDP(int[] arr, int index) {
		if (arr[index] == 0 || index < 0 || index > arr.length) {
			return -1;
		}
		if (index == arr.length) return 0;  			//�����յ�
		if (index+arr[index] >= arr.length) return 1; 	//�����λ����������Ծ���յ�,��1�ξ��ܳɹ�
		
		int minStep = Integer.MAX_VALUE;  //����һ��ȫ����Сֵ,������������С�Ĳ���
		for (int i = -arr[index]; i <= arr[index]; i++) {  			//������ǰ��Ҳ����������
			if (index+i >= 0 && index+i < arr.length && i != 0) {	//ֻҪû������,�����Լ��ĵط��������
				int tempNum = getStep(arr,index+i);//�¸�λ�÷��صĲ���
				if (tempNum != -1) {
					minStep = Math.min(minStep, tempNum+1);
				}
			}
		}
		int result = minStep==Integer.MAX_VALUE?-1:minStep;
		return result;
	}

}
