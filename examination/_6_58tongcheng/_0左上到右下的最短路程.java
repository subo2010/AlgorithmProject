package _6_58tongcheng;
/*
 * ��һ������,ÿһ��λ���϶���һ����Ӧ����,�����Ͻǿ�ʼ�ƶ������½�,�ʾ���������С���Ƕ���
 * ����: 1 3 4
 * 		2 1 2
 * 		4 3 1
 * ����·��Ϊ: ��>��>��>��       1+2+1+2+1=7
 * ��˴�Ϊ7
 * 
 * ˼·:ͨ����̬�滮����,�������һ��m*n�Ķ�ά����,�򴴽�һ��m*n��DP����,dp[i][j]��������Ͻ��ߵ���λ��ʱ����̾���
 */
public class _0���ϵ����µ����·�� {
	public static void main(String[] args) {
		int[][] arr = {{1,3,4},{2,1,2},{4,3,1}};
		int num = partion(arr);
		System.out.println(num);
	}

	private static int partion(int[][] arr) {
		//basecase
		if (arr == null || arr.length==0 || arr[0].length == 0) {
			return 0;
		}
		// ����һ��dp����,����dp[i][j]�����arr[0][0]��arr[i][j]�����·��
		int[][] dp = new int[arr.length][arr[0].length];
		// ����ʼֵ
		dp[0][0] = arr[0][0];
		for (int i = 1; i < arr.length; i++) {
			dp[i][0] = arr[i][0] + dp[i-1][0];
		}
		for (int i = 1; i < arr[0].length; i++) {
			dp[0][i] = arr[0][i] + dp[0][i-1];
		}
		for (int i = 1; i < dp.length; i++) {
			for (int j = 1; j < dp.length; j++) {
				dp[i][j] = Math.min(dp[i][j-1], dp[i-1][j])+arr[i][j];
			}
		}
		return dp[arr.length-1][arr[0].length-1];
	}
}
