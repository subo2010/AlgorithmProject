package _02�����㷨._08�����ݹ�_��̬�滮;

import org.junit.Test;

/*
 * ����:������һ���ַ���,������������ظ������еĸ���
 * 
 *  ����: 4 5 6 7 4 3   --> ����ظ��Ӵ�Ϊ 4 5 6 7 3 -->����Ϊ5
 *  
 *  ˼·:����dp˼ά�����������;dp[arr.length]����һ�����Գ�����ͬ���ȵ�dp����
 *  	1.����dp[x]��־���±�Ϊ0~x��β���Ӵ�������ظ���Ԫ�ظ���
 *  	2.��ʼ����dp[0] = 1,��Ϊֻ��һ��Ԫ��
 *  	3.���������dp[x] ���֮ǰ���ֹ�Ԫ��,arr[x] ����dp[x] = dp[x-1]
 *  				���֮ǰû�г��ֹ�Ԫ��,arr[x] ����dp[x] = dp[x-1]+1;
 *  	4.���dp[arr.length-1]��Ϊ����
 *  
 *  ˼·2:��������Set������ʵ��,ʱ�临�Ӷ�Ϊn
 */
public class _14����ظ������еĸ��� {
	
	@Test
	public void main() {
		int[] arr = {4,5,6,7,4,3,6,8}; //456738
		int size = partion(arr);
		System.out.println(size);
	}

	//������ظ������г���
	private int partion(int[] arr) {
		//basecase
		if (arr == null || arr.length == 0) {
			return 0;
		}
	
		//����dp����
		int[] dp = new int[arr.length];
		//��ʼ��
		dp[0] = 1;
		for (int i = 1; i < dp.length; i++) {
			if (isContain(arr,i)) { //�ж�arr��iԪ���Ƿ���֮ǰ���ֹ�(������ֹ�)
				dp[i] = dp[i-1];
			} else{
				dp[i] = dp[i-1] +1;
			}
		}
		return dp[arr.length-1];
	}

	//�����ж�i֮ǰ��û��arr[i]���ֹ�
	private boolean isContain(int[] arr, int i) {
		for (int j = 0; j < i; j++) {
			if (arr[j] == arr[i]) {
				return true;
			}
		}
		return false;
	}

}
