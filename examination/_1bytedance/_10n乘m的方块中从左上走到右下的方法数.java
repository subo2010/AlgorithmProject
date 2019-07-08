package _1byt edance;

import java.util.Scanner;

import org.junit.Test;

public class _10n��m�ķ����д������ߵ����µķ����� {
	
	@Test
	public void main() {
		Scanner in = new Scanner(System.in);
		String line = in.nextLine();
		String[] strArr = line.split(" ");
		int n = Integer.parseInt(strArr[0]);//��ȡ����
		int m = Integer.parseInt(strArr[1]);//��ȡ����
		if (n <= 0 || m <= 0) {
			System.out.println("��������!!");
			return;
		}
		int[][] dp = new int[n][m];//����һ��dp����
		for (int i = 0; i < dp.length; i++) {  //��ÿһ�еĵ�һ��������Ϊ1
			dp[i][0] = 1;
		}
		for (int i = 0; i < dp[0].length; i++) { //��ÿһ�еĵ�һ������Ϊ1
			dp[0][i] = 1;
		}
		for (int i = 1; i < dp.length; i++) {
			for (int j = 1; j < dp[0].length; j++) {
				dp[i][j] = dp[i-1][j] + dp[i][j-1];
			}
		}
		System.out.println(dp[n-1][m-1]);
	}
}
