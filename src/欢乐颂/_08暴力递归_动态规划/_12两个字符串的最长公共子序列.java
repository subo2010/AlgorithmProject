package ������._08�����ݹ�_��̬�滮;

import org.junit.Test;

/*
 * ��Ŀ:�����ַ����е�������ַ�����ĳ���-->
 * 		�ṩ���������ַ���,�����Ĺ���������,�ĳ���
 * 		����  abcbdab  bced  -->  �����������Ϊbcd ���� 3
 * 
 * ˼·:1.���ȿ���ͨ���ַ�������ȥ�������ַ�����,Ȼ������ת��Ϊ��������������������
 * 	   2.����dp[str1.length+1][str2.length+1]����,����dp[x][y]�����str1ǰx��Ԫ��,��str2ǰy��Ԫ�ص������������
 * 	   3.��ʼ��,����dp[x][0] = dp[0][y] = 0 ��Ϊ������һ���ǿմ�ʱ,������������Ӵ�
 * 			dp[x][1]��str1�ĵ�x��Ԫ����str2�ĵ�1��Ԫ����ͬʱdp[x][1]=1,��֮��Ϊ1
 * 			dp[1][y]ͬ��
 * 	   4.���������dp[x][y]���������
 * 			1.��str1[x] != str2[y]ʱ����:dp[x][y] = dp[x-1][y]
 * 			2.��str1[x] != str2[y]ʱ����:dp[x][y] = dp[x][y-1]
 * 			3.��str1[x] == str2[y] ʱΪ: dp[x][y] = dp[x-1][y-1] + 1
 * 		������������������Ǹ��Ƹ�dp[x][y]
 */
public class _12�����ַ���������������� {
	
	@Test
	public void main() {
		String str1 = "ABCBDCAB";
		String str2 = "BDCABA";  //BDAB
		int maxLen = partion(str1,str2);
		System.out.println(maxLen);
	}

	private int partion(String str1, String str2) {
		//ͨ���ַ�����ȡ�ַ�����
		char[] strArr1 = str1.toCharArray();
		char[] strArr2 = str2.toCharArray();
		//����dp����
		int[][] dp = new int[strArr1.length][strArr2.length];
		//��ʼ��
		if(strArr1[0] == strArr2[0]) dp[0][0] = 1;
		for (int i = 1; i < dp.length; i++) {
			if(strArr1[i] == strArr2[0] || dp[i-1][0] == 1){
				dp[i][0] = 1;
			}
		}
		for (int i = 1; i < dp[0].length; i++) {
			if(strArr2[i] == strArr1[0] || dp[0][i-1] == 1){
				dp[0][i] = 1;
			}
		}
		for (int x = 1; x < dp.length; x++) {
			for (int y = 1; y < dp[0].length; y++) {
				if (strArr1[x] == strArr2[y]) {
					dp[x][y] = dp[x-1][y-1] + 1;
				} else{
					dp[x][y] = Math.max(dp[x-1][y], dp[x][y-1]);
				}
			}
		}
		return dp[strArr1.length-1][strArr2.length-1];
	}

}
