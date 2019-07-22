package ������._01����ջ;

import org.junit.Test;

/**
��Ŀ:
 	����һ�����飬���������֮����������������ֵ.
Ҫ��:ʱ�临�Ӷ�O(N)����Ҫ�����÷ǻ��ڱȽϵ�����(����ʹ�������㷨)
˼·:������������鳤��ΪN,�򴴽�N+1��Ͱ,�ҵ���N��������Сֵ�����ֵ�ֱ�ŵ���һ�������һ��Ͱ��
	Ȼ����Сֵ�����ֵ����ֳ�N+1��,ÿ�ηֱ��Ӧһ��Ͱ,Ȼ�������ÿ��Ԫ�طֱ�ŵ���Ӧ��Ͱ��
	�����б�Ȼ����һ��Ͱ�ǿյ�(----),��Ϳ��Ա�֤,��һ��Ͱ�ڲ�����������������,Ȼ�����ÿ��Ͱ
	��ÿ��Ͱ�����ֵ������ǿ�Ͱ����Сֵ����,���Ĳ���Ƿ��ص��ڴ�����ֵ
(ÿ��Ͱֵ����������,�Ƿ���ֵ,���ֵ,��Сֵ)
 * @author Administrator
 */
public class _03������������ֵ {
	
	@Test
	public  void main() {
		int[] arr = {1 ,2, 6, 9};
		int max = getSortMax(arr);	 
		System.out.println(max);
	}
	

	private int getSortMax(int[] arr) {
		if (arr == null || arr.length < 2) {
			return 0;
		}
		
		int N = arr.length;  //�õ�����ĳ���
		
		//����N+1��Ͱ  (��������ΪN+1������)---> ����±�ΪN
		boolean[] hasNum = new boolean[N+1]; //��ʼ����Ϊfalse
		int[] buketMax = new int[N+1];
		int[] buketMin = new int[N+1];
		
		//�õ������е����ֵ����Сֵ
		int max = Integer.MIN_VALUE;
		for (int i=0 ;i < arr.length;i++) {
			max = arr[i] > max? arr[i] : max;
		}
		int min = Integer.MAX_VALUE;
		for (int i=0 ;i < arr.length;i++) {
			min = arr[i] < min? arr[i] : min;
		}
		
		//������ֵ����Сֵ���˵��ֻ��һ����,�ʷ���0
		if (min == max) {
			return 0;
		}
		
		//�����ֵ����Сֵ�ֱ�����һ��Ͱ�����һ��Ͱ
		hasNum[0] = true;
		hasNum[N] = true;
		buketMax[0] = min; 
		buketMin[0] = min; 
		buketMax[N] = max; 
		buketMin[N] = max; 
		
		
		//����ͨ�����÷�����ÿ��Ԫ�ط��뵽��Ӧ��Ͱ
		for (int i=0 ;i < arr.length;i++) {
			//���ظ�Ԫ������Ӧ��Ͱ
			int index = getIndex(arr[i],min,max,N);   //������
			//����Ԫ�طŵ��ض���Ͱ��
			addBuket(index,arr[i],hasNum,buketMax,buketMin);
		}
		
		//�������е�Ͱ��ÿһ���˷ǿ�Ͱ����Сֵ�����ǿ�Ͱ�����ֵ����,���Ĳ���Ƿ��ش�
		int result=0;
		for(int i=0;i<N+1;i++){
			//��һ��Ͱ��ֻȡ�������ֵ
			if (i==0) {
				max = buketMax[0];
			} else if(hasNum[i]) {	
			//Ȼ����ȥѰ��������һ���ǿյ�Ͱ,ȡ��������Сֵ,����һ��Ͱ�����ֵ���Ƚ�,Ȼ����ȡ�����Ͱ�е����ֵ������һ�αȽ�
				min = buketMin[i];
				result = Math.max( result, (min-max));
				max = buketMax[i];
			} 
		}
		return result;
	}

	//��ȡÿ��Ԫ�ض�Ӧ��Ͱ�±�
	private int getIndex(int num, int min,int max, int N) {
		int part = (int)(max-min)/N; 	//����ÿһ��ĳ���
		return (int)((num - min)/part); //����λ�ڵڼ���λ��
	}

	//�������е�ÿһ�����ŵ���Ӧ��Ͱ��
	private void addBuket(int index, int cur, boolean[] hasNum, int[] buketMax,
			int[] buketMin) {
		if (!hasNum[index]) {
			hasNum[index] = true;
			buketMax[index] = cur;
			buketMin[index] = cur;
		} else {
			buketMax[index] = Math.max(cur , buketMax[index]);
			buketMin[index] = Math.min(cur , buketMin[index]);
		}
	}
	
}
