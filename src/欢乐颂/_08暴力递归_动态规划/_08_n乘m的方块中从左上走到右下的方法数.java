package ������._08�����ݹ�_��̬�滮;
/*
 * ��Ŀ:��һ��n*m�ľ���,�����Ͻ��ߵ����½�,Ҫ��·�����,����һ���ж������߷�
 * 
 * ˼·:����Ҫ��·�����,�Ǿ���ζ�Ŵ�һ��λ�ÿ�ʼֻ�������߻���������
 * 		1.����һ��dp���� dp[n][m] ��ʾ��0,0�����ߵ�n,m����ķ�����
 * 		2.����dp[i][0] = dp[0][j] = 1;��Ϊ��һ��ֻ�������ߵ�,��һ��ֻ�������ߵ�,���Է�����һ��
 * 		3.��������dp[x][y] ��ֻ�ܺ��dp[x-1][y]����dp[x][y-1]�߹���,���dp[x][y]=dp[x-1][y]+dp[x][y-1]
 * 		4.��󷵻�dp[n-1][m-1]
 */
import org.junit.Test;

public class _08_n��m�ķ����д������ߵ����µķ����� {
	
	@Test
	public void main() {
		int n = 3;//��ȡ����
		int m = 3;//��ȡ����
		int times = partion(n,m);
		System.out.println(times);
	}

	private int partion(int n, int m) {
		//basecase
		if (n <= 0 || m <= 0) {
			return 0;
		}
		//����pd����
		int[][] dp = new int[n][m];
		//����ʼֵ
		for (int i = 0; i < dp.length; i++) 
			dp[i][0] = 1;
		for (int i = 0; i < dp[0].length; i++) 
			dp[0][i] = 1;
		//����
		for (int x = 1; x < dp.length; x++) {
			for (int y = 1; y < dp[0].length; y++) {
				dp[x][y] = dp[x-1][y] + dp[x][y-1];
			}
		}
		return dp[n-1][m-1];
	}
}
