package ������._02��ά����;

import org.junit.Test;

/**
 *  ����Ŀ�� ����һ�����Ͷ�ά����matrix����Ѹþ��������˳ʱ����ת90�ȵ����ӡ�
	��Ҫ�� ����ռ临�Ӷ�ΪO(m*n)��
	����:   1  2  3  4
		   5  6  7  8
		   9  10 11 12
		   13 14 15 16
	
	ת��Ϊ:	13 9  5 1
		    14 10 6 2
		    15 11 7 3
		    16 12 8 4
 * @author Administrator
 *
 *˼·:�����˼·��Ȼ�ǽ�����ϸ��ת��Ϊ��۲���,������治ͬ��������û��ָ������ʱ�����εľ���,��˵����������εľ���ʱ,90����ת�Ժ�Ķ�ά������
 *	ԭ��������ݽṹ��ͬ,��˴�����Ҫ�Ŀռ临�Ӷ�Ϊ(m*n) --> ����m��n�ֱ�Ϊ���εĸߺͿ�
 *	����Ľ���˼·�ͻ��������ͬ
 *	�����ĸ�ָ��:p1=0����ʼ��λ��,p2=0����ʼ��λ��,p3=...��������λ��,p4=...��������λ��
 *	��һ��ѭ�����ڴ�ӡ�����Ԫ��,�ֱ���1->4,4->16,16->13,13->1
 *	Ȼ������2��3���������˼·������
 *	��������������ʱ��������ڲ���ӡ
 */
public class _02��������ת���� {
	
	@Test
	public void main() {
		int[][] matr = getMatr(2,4);
		myPrint(matr);
		System.out.println("------------------------");
		int[][] matr1 = rotateMatr(matr);
		myPrint(matr1);
		
	}
	
	private int[][] rotateMatr(int[][] arr) {
		int[][] arr1 = new int[arr[0].length][arr.length]; //����һ��ת�ƺ�ľ����������
		int p1 = 0;
		int p2 = 0;
		int p3 = arr.length-1;		//���� - 1 (��Ϊ��0��ʼ����)
		int p4 = arr[0].length-1;	//���� - 1
		while(p2<=p4 && p1<=p3){
			//ѭ���ƶ�������һȦ
			for (int i = 0; i < p4-p2; i++) {
				swap(arr,arr1, p1, p2+i, p2+i, p3);
			}
			for (int i = 0; i < p3-p1; i++) {
				swap(arr,arr1, p3-i, p2, p2, p1+i);
			}
			for (int i = 0; i < p4-p2; i++) {
				swap(arr,arr1, p3, p4-i, p4-i, p1); 
			}
			for (int i = 0; i < p3-p1; i++) {
				swap(arr,arr1, p1+i, p4, p4, p3-i);
			}
			p1++;
			p2++;
			p3--;
			p4--;
		}
		
		return arr1;
	}
	
	//��ά����Ľ���
	private void swap(int[][] arr , int[][] arr1 ,int p1,int p2,int p3,int p4){
		arr1[p3][p4] = arr[p1][p2];
	}

	//��ȡһ��m��n�еľ������
	private int[][] getMatr(int m,int n) {
		int[][] matr = new int[m][n];
		for (int i = 0; i < matr.length; i++) {
			for (int j = 0; j < matr[i].length; j++) {
				matr[i][j] = n*i+(j+1);
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
