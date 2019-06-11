package ������._08�����ݹ�_��̬�滮;

import java.util.HashMap;
import java.util.Map;

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
 * 
 * �Ż�����:(���仯����:�ӻ���)
 * 	����ı����ݹ鷨���˺ö���Ч����,��������5Ԫ��0��10Ԫ  Ҫ��25��1���5Ԫ�ķ�����
 * 							�ڼ���0��5Ԫ��1��10Ԫ  ҲҪ��25��1���5Ԫ�ķ����� ���ƻ���
 * 	��˻��������ظ�����,���ǾͿ������һ���Ż��Ĳ���,ÿ�μ�����һ�����֮���Ұ����浺һ��������,��ÿ�μ����ʱ����ȥ��һ��,����оͲ��ü���ֱ�ӵõ�
 * 	���û���ڽ��м���,����,�����뵽����    
 * 	ע:���ڴ����޺�Ч������:������ĳһ״̬������ô�����û�й�ϵ,
 * 		��������:����5Ԫ��0��10Ԫ  ��  0��5Ԫ��1��10Ԫ ��Ҫ��25��1���5Ԫ�ķ�������������������ǰ���״̬
 * 
 * DP�ⷨ:����ֻҪ��index��aim�����������̶���,���ķ���ֵ��ȷ����;
 * 		���ͨ�������������ǿ��Խ���һ����ά����(��DP����)-->index��Χ��[0,n] aim��Χ��[0,aim]; (ͨ�����Ӳ����ı仯��Χ���Եõ�dp����)
 * 		��ȷ����Ҫ���λ��;���������ά����������ͨ���ݹ�Ľ�ֹ�����ó�,һЩ����,Ȼ��ͨ���߼��Ƶ��������λ��
 * 		
 * 
 */ 
public class _02��Ǯ�ķ����� {

	@Test
	public void main() {
		int[] arr = {5,10,25,1};
		int aim = 15;
		int num1 = baoli(arr,aim);
		int num2 = baoliyouhua(arr,aim);
		int num3 = pd(arr,aim);
		System.out.println(num1);
		System.out.println(num2);
		System.out.println(num3);
	}
	
	//�ݹ�ⷨ
	private int pd(int[] arr, int aim) {
		if (arr == null || arr.length == 0 || aim < 0) {
			return 0;
		}
		//����dp����
		int[][] dp = new int[arr.length][aim+1]; //��һ��������ʾ��indexλ����,�ڶ���������ƴ����aim,dp�дԷ����ǽ��
		//����֪�����ӵ�dp(����������λ�þ��ܵõ���ֵ)
		//��aimΪ0ʱindexΪ����ֻ��һ�ֽ��->���
		for (int i = 0; i < arr.length; i++) {
			dp[i][0] = 1;
		}
		//ֻ�õ�һ�����,����ƴ����Щaim,����ֻ��һ�ֽ��->���
		for (int i = 1; arr[0] * i <= aim; i++) {
			dp[0][arr[0] * i] = 1;
		}
		for (int i = 1; i < arr.length; i++) {
			for (int j = 1; j <= aim; j++) {
				dp[i][j] = dp[i-1][j];
				dp[i][j] += j - arr[i] >= 0?dp[i][j-arr[i]] : 0 ;
			}
		}
		return dp[arr.length -1][aim];
	}

	//�Ż������ⷨ
	private int baoliyouhua(int[] arr, int aim) {
		//�����basecase
		if (arr == null || arr.length == 0) {
			return 0;
		}
		return baoliyouhuaPartion(arr,0,aim);	//���õݹ鷽������
	}
	
	// �Ż������ݹ����
	private int baoliyouhuaPartion(int[] arr, int index, int aim) {
		int res = 0; //�������ؽ��
		//KeyΪ"index_aim"(���������������Ը�״̬) ValueΪindex��aim�Ƿ��صķ�����
		Map<String, Integer> map = new HashMap<String, Integer>();//����һ��map��������
		if (index == arr.length) {
			return res = aim == 0 ? 1 : 0;
		}
		
		for (int i = 0; arr[index] * i <= aim; i++) {
			String key = String.valueOf(index+1) +"_"+ String.valueOf(aim - arr[index] * i); //��һ��Ҫ���ֵ
			if (map.containsKey(key)) {	//����Ѿ�������ֱ��ȥ��
				res += map.get(key);
			}else{						//�����������������Ӵ�map��
				res += baoliPartion(arr, index + 1, aim - arr[index] * i); 
				map.put(key, res);
			}
		}
		return res;
	}

	//�����ⷨ
	private int baoli(int[] arr, int aim) {
		//�����basecase
		if (arr == null || arr.length == 0) {
			return 0;
		}
		return baoliPartion(arr,0,aim);	//���õݹ鷽������
	}
	
	/*
	 * �����ݹ����
	 * arr:��ԭʼ����,����
	 * index:��ָ��indexλ�ÿ�ʼ�����ǰ����������
	 * arm :����Ҫƴ����Ŀ��Ǯ��
	 * ����ֵʱ������
	 */
	private int baoliPartion(int[] arr, int index, int aim) {
		int res = 0; //�������ؽ��
		//�����������,��index=arr.length�Ǵ���û��Ǯʱ�����(index=arr.length-1����ֻ�����һ��Ǯʱ)
		//����������û��Ǯ��ʱ��,Ŀ��aimΪ0,������ҵ���һ����Ч�Ļ���
		if (index == arr.length) {		//aim=0 ����˷�������; aim!=0 ����˷���������
			return res = aim == 0 ? 1 : 0;
		}
		 //���μ����һ�����ʹ�ò�ͬ��ʱ,ʣ����صķ������ĺ�(ֻҪ��ǰ���*ʹ�õĸ���С�ڵ����ܽ��Ϳ��Լ���)
		for (int i = 0; arr[index] * i <= aim; i++) {
			res += baoliPartion(arr, index + 1, aim - arr[index] * i);  //�����������ۼ�
		}
		return res;
	}
}
