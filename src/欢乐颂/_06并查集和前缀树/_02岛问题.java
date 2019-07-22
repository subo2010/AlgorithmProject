package ������._06���鼯��ǰ׺��;

import org.junit.Test;

/**
 * ����������漰������˼ά�����ò��鼯�����
 * ���˴������õݹ���������
 * ����:	һ��������ֻ��0��1����ֵ��ÿ��λ�ö����Ժ��Լ����ϡ��¡������ĸ�λ������(б�Ų���)�������һƬ1����һ��������ֽ���һ������
 * 		��һ���������ж��ٸ�����
 * ����:
 * 0 0 1 0 1 0
 * 1 1 1 0 1 0
 * 1 0 0 1 0 0
 * 0 0 0 0 0 0
 * �����������3����
 * 
 * ˼·:�ӵ�һ��Ԫ�ؿ�ʼ���մ����Ҵ��ϵ��µ�˳��ʼ����
 * 		��������Ԫ�ز���1������,�������1,˵���ߵ��˵���ı�Ե,Ȼ���Դ˽ڵ�Ϊ����������������ɢ,�����ɢ����Ԫ�ػ���1,�������ɢ,ֱ����ɢ����Ԫ��
 * 		������1����,����ɢ�Ĺ�����,�������ߵ����ĵ���ڵ㶼��Ϊ-1,��������ɢ�Ľ����Ϊ0ʱ˵���˵�����ɢ����,��������1
 * 		Ȼ��ӵ�һ�ν��뵺���λ�����ΰ��մ����Ҵ��ϵ��µ�˳����,�������1,�ظ��������.��������β��ʱ��������,�������ط���Ŀ
 * @author Administrator
 *
 */

public class _02������ {
	
	@Test
	public void main() {
		int[][] matr = getMatr(5,4);
		myPrint(matr);
		System.out.println("----------");
		int num = getNumIsland(matr);
		System.out.println(num);
	}
	
	//����һ����ά���鷵�ض�ά�����е��ĸ���
	private int getNumIsland(int[][] arr) {
		if (arr==null) {
			return 0;
		}
		int num = 0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				if (arr[i][j]==1) {
					num++;					//��������һ
					traverIsland(arr,i,j);	//�����˵�,�����е�������Ϊ-1
				}
			}
		}
		return num;
	}

	//��i j��λ����,��ʼ���������ұ���
	private void traverIsland(int[][] arr, int i, int j) {
		if (arr[i][j]==1) {
			arr[i][j]=-1;	//����ֵ��Ϊ-1
			//��ʼ��������������
			if (j>0) {
				traverIsland(arr, i, j-1);
			}
			if (j<arr[0].length-1) {
				traverIsland(arr, i, j+1);
			}
			if (i>0) {
				traverIsland(arr, i-1, j);
			}
			if (i<arr.length-1) {
				traverIsland(arr, i+1, j);
			}
		}
	}

	//------------------------������---------------������----------------������---------------������---------
	//��ȡһ��m��n�еľ������
	private int[][] getMatr(int m,int n) {
		int[][] matr = new int[m][n];
		for (int i = 0; i < matr.length; i++) {
			for (int j = 0; j < matr[i].length; j++) {
				matr[i][j] = (int)(Math.random()+0.5);
			}
		}
		return matr;
	}
		
	//��ӡ��ά����
	public void myPrint(int[][] arr){
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
	}
}
