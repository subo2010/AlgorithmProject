package _02�����㷨._08�����ݹ�_��̬�滮;
import org.junit.Test;
/*
 * ��Ŀ:��һ��n*m�ľ���,�����Ͻ��ߵ����½�,���·�������,������С��·����
 * ˼·:����Ҫ��·�����,�Ǿ���ζ�Ŵ�һ��λ�ÿ�ʼֻ�������߻���������
 * 		1.����һ��dp���� dp[n][m] ��ʾ��0,0�����ߵ�n,m�������С·��
 * 		2.����dp[i][0]��һ�е�ֵ,dp[i][0] = dp[0][0]+dp[1][0]+..+dp[i][0],Ϊ·���ϵ�Ԫ�����
 * 		3.����dp[0][j]��һ�е�ֵ,ͬ��Ϊ��һ���Ͼ���Ԫ��ֵ���
 * 		3.��������dp[x][y] ��ֻ�ܺ��dp[x-1][y]����dp[x][y-1]�߹���,���dp[x][y]=Math.min(dp[x-1][y],dp[x][y-1])+arr[x][y]
 * 		4.��󷵻�dp[n-1][m-1]
 */

public class _09_n��m�ķ����е���С·���� {
	
	@Test
	public void main() {
//		int[][] arr = getMatr(4, 4);
		int[][] arr = {{1,3,5,9},{8,1,3,4},{5,0,6,1},{8,8,4,0}};
		myPrint(arr);
		int num = partion(arr);
		System.out.println(num);
	}

	private int partion(int[][] arr) {
		//basecase
		if (arr == null ||arr.length == 0 ||arr[0].length == 0) {
			return 0;
		}
		//����dp����-->dp[x][y]�����0,0����x,y����С·����
		int[][] dp = new int[arr.length][arr[0].length];
		//����ʼֵ
		dp[0][0] = arr[0][0];
		for (int i = 1; i < dp.length; i++) {
			dp[i][0] = dp[i-1][0]+arr[i][0];
		}
		for (int j = 1; j < dp[0].length; j++) {
			dp[0][j] = dp[0][j-1]+arr[0][j];
		}
		//����
		for (int x = 1; x < dp.length; x++) {
			for (int y = 1; y < dp[0].length; y++) {
				dp[x][y] = Math.min(dp[x-1][y] , dp[x][y-1])+arr[x][y];
			}
		}
		return dp[arr.length-1][arr[0].length-1];
	}
	
	
	
	
	//----------------------------------------------------------------------------------------------
	//��ȡһ��m��n�еľ������
	private static int[][] getMatr(int m,int n) {
		int[][] matr = new int[m][n];
		for (int i = 0; i < matr.length; i++) {
			for (int j = 0; j < matr[i].length; j++) {
				matr[i][j] = n*i+(j+1);			//���ɵ���Ϊ�ڼ�����
//					matr[i][j] = (int)(Math.random()+0.7);		//ֻ����0��1�ľ���
			}
		}
		return matr;
	}
		
	//��ӡ��ά����
	public static void myPrint(int[][] arr){
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
	}
}
