package ������._08�����ݹ�_��̬�滮;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

/*
 *����Ŀ����������arr��arr�����е�ֵ��Ϊ�����Ҳ��ظ���ÿ��ֵ����һ����ֵ�Ļ��ң�ÿ����ֵ�Ļ��ҿ���ʹ�������ţ��ٸ���һ������aim����Ҫ�ҵ�Ǯ����
 * 		��Ǯ�ж����ַ�����
 * DP�������:ͨ��һ����ά����ṹdp[][]��������еĽ����,
 * 		1.����dp[x][y]��ʾʹ��ǰx��Ǯ,�ճ�yԪ���õķ�����
 * 		2.���Եó�dp[x][0]=1,��Ϊ�ճ�һ��Ǯֻ��һ�ַ���
 * 		3.��������dp[x][y] Ϊ
 * 			dp[x-1][y] ����������ǰ,���yԪ�ķ���.����
 * 			dp[x-1][y - 1 * arr[x]] ʹ��һ�Ŵ�Ǯ��,���y - 1 * arr[x]�ķ�����,���� ..
 *			����count = y/arr[x]Ϊ�������ʹ�ô�Ǯ�ĸ���
 */
public class _01��Ǯ�ķ�����_dp {
	@Test
	public void main() {
		int[] arr = {5,10,25,1};
		int aim = 15;
		int num3 = dppartion(arr,aim);
		System.out.println(num3);
	}

	//���ö�̬�滮�����������
	private int dppartion(int[] arr, int aim) {
		if (arr == null || arr.length == 0 || aim <= 0) {
			return 0;
		}
		//����dp���� dp[x][y]ʵ��ǰx��Ǯ���yԱ�Ĵ���
		int[][] dp = new int[arr.length+1][aim+1];
		//��ʼ��dp[x][0]=0,���0Ԫֻ��һ�ַ���
		for (int i = 0; i < dp.length; i++) {
			dp[i][0] = 1;
		}
		for (int x = 1; x < dp.length; x++) {
			for (int y = 1; y < dp[0].length; y++) {
				//�жϵ�ǰx��Ǯʱ,���yԱ�ķ���
				int count = y/arr[x-1]; //arr[x-1]����x��Ӳ�ҵ���ֵ,count��������õ����������
				for (int i = 0; i <= count; i++) {
					//��ʹ��i�Ŵ�Ǯ��ʱ,ǰx-1��Ӳ��Ӧ�����y- i * arr[x-1]Ԫ
					dp[x][y] += dp[x-1][y- i * arr[x-1]]; 
				}
			}
		}
		return dp[arr.length][aim];
	}
}