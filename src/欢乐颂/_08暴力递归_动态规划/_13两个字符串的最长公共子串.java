package ������._08�����ݹ�_��̬�滮;
/*
 * ��Ŀ:�����ַ����е�������ַ��Ӵ��ĳ���-->
 * 		�ṩ���������ַ���,�����Ĺ���������,�ĳ���
 * 		����  abcbdab  bced  -->  �����������Ϊbc ���� 2
 * ˼·:��̬�滮,����dp[][]����,
 * 		1.����dp[x][y]=0����str1[x] != str2[y],dp[x][y]=k��ָ,str1��0-x��str2��0-y�����k��Ԫ�����
 * 		2.��ʼ����dp[x][0] ֻ����arr2[0]��ȵ�ʱ��Ϊ1,����ʱ��Ϊ0 ;;; dp[0][y]ͬ��
 * 		3.dp[x][y] �Ƶ�����Ϊ���str1[x]!=str2[y]��dp[x][y]=0 
 * 				str1[x]==str2[y] ����dp[x][y] = dp[x-1][y-1] + 1;
 * 		4.���󷵻�dp[x][y]��������
 * ˼·:KMP�㷨�����ж�һ���ַ������Ƿ������һ���ַ���
 */
public class _13�����ַ�����������Ӵ� {

	public static void main(String[] args) {
		String str1 = "aaffffsfabcdfasf";
		String str2 = "aaaadfsabcdfsdb";  //����abcdf
		int num = partion(str1,str2);
		System.out.println(num);
	}

	private static int partion(String str1, String str2) {
		//���ַ���ת��Ϊ�ַ�����
		char[] arr1 = str1.toCharArray();
		char[] arr2 = str2.toCharArray();
		//����dp����
		int[][] dp = new int[arr1.length][arr2.length];
		//��ʼ��
		for (int i = 0; i < dp.length; i++) 
			dp[i][0] = arr1[i] == arr2[0] ? 1 : 0;
		
		for (int i = 0; i < dp[0].length; i++) 
			dp[0][i] = arr1[0] == arr2[i] ? 1 : 0;
		
		for (int x = 1; x < dp.length; x++) {
			for (int y = 1; y < dp[0].length; y++) {
				if (arr1[x] == arr2[y]) {
					dp[x][y] = dp[x-1][y-1] + 1;
				}
			}
		}
		int ret = 0; //ȫ�����ֵ,���䷵��
		for (int i = 0; i < dp.length; i++) {
			for (int j = 0; j < dp[0].length; j++) {
				ret = Math.max(ret, dp[i][j]);
			}
		}
		return ret;
	}
}
