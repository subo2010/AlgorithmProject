package ������._08�����ݹ�_��̬�滮;
import org.junit.Test;
/*
 * ˼·:һ������ΪN��·,1~N,һ����������Mλ�ã���������P���������1λ��ֻ�����ң���Nλ��ֻ���������ʻ�������P������ͣ��Kλ���ϵ��߷��ж����֡�
 * ����n=4 m=2 p=2 k=2   1-2-3-4  ��������2λ������������2λ��,һ����2�зֱ�Ϊ 2->3->2  2->1->2
 * ˼·2:��̬�滮,������Ľ������֪��ֻҪm��pȷ���˵ݹ麯���ķ��ؽ����ȷ����,��˿���ͨ��m p��������һ����Ϊdp����
 */
public class _04���ߵĻ�����_dp {
	@Test
	public void main() {
		int n = 4; // ·�ĳ���
		int m = 2; // ��ǰλ��
		int p = 2; // �����ߵĲ���
		int k = 2; // Ŀ��λ��
		int num2 = dp(n, m, p, k);
		System.out.println(num2);
	}

	// ��̬�滮�ⷨ
	private int dp(int len, int pos, int step, int aim) {
		// basecase
		if (len < 1 || pos < 1 || pos > len || step < 0 || aim > len) {
			return 0;
		}
		//����dp����   dp[x][y] ��ָʣ��x����ʱ,��ǰλ��Ϊyʱ��ָ��λ�õķ�����
		int[][] dp = new int[step + 1][pos + 1]; 
		//��ʼ��-->��ʣ�ಽ��Ϊ0ʱ,ֻ�е�ǰλ��ΪaimʱΪ1,���඼Ϊ0
		dp[0][aim] = 1; 
		for (int i = 1; i <= step; i++) {
			for (int j = 1; j <= len; j++) { // ����������߼�
				dp[i][j] += j - 1 < 1 ? 0 : dp[i - 1][j - 1];
				dp[i][j] += j + 1 > len ? 0 : dp[i - 1][j + 1];
			}
		}
		return dp[step][pos]; // ���ط���ʣ�ಽ��Ϊpʱ,��ǰλ��Ϊm�Ŀ�����
	}
}
