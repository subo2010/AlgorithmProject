package _03examination._0niuke;

import java.util.Scanner;

/*
 * ��ȡ������Ϣ,ʢ�ŵ���ά������
 * ����:
 * 2
 * 3
 * 1,2,3
 * 4,5,6
 * ��һ���Ƕ�ά���������
 * �ڶ����Ƕ�ά���������
 * ��������������Ϣ
 */

public class _2����������� {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); //�ȴ�������Ϣ
		int n = sc.nextInt();  	//��ȡ����
		int m = sc.nextInt();	//��ȡ����
		int[][] arr = new int[n][m]; //������ά����
		for (int i = 0; i < arr[0].length; i++) {	//��һ�п�ʼ��ȡÿһ����Ϣ
			String line = sc.nextLine();
	        //2.���ַ����и���ַ�����
	        String[] sArr = line.split(",");   //����������ָ���,���Ըı�
	        //3.�ŵ���Ӧ�е���Ӧλ����
	        for (int j = 0; j < sArr.length; j++) {
	            arr[i][j] = Integer.parseInt(sArr[j]); // �������ַ���ת��������
	            System.out.println(arr[i][j]);
	        }
		}
	}
}
