package ��ָoffer;

import org.junit.Test;

/*
 * ��һ����ά�����У�ÿ��һά����ĳ�����ͬ����ÿһ�ж����մ����ҵ�����˳������
 * ÿһ�ж����մ��ϵ��µ�����˳�����������һ������������������һ����ά�����һ��������
 * �ж��������Ƿ��и�����
 */
public class _1��ά�����еĲ��� {
	
	@Test
	public void main() {
		int[][] matr = getMatr(5,5);
		myPrint(matr);
	}
	
	
    public boolean Find(int target, int [][] array) {

    	
    	return false;
    }
    
    
	
	//��ȡһ��m��n�еľ������-----------------------------------------
	private int[][] getMatr(int m,int n) {
		int[][] matr = new int[m][n];
		for (int i = 0; i < matr.length; i++) {
			for (int j = 0; j < matr[i].length; j++) {
				matr[i][j] = n*i+(j+1);			//���ɵ���Ϊ�ڼ�����
//				matr[i][j] = (int)(Math.random()+0.7);		//ֻ����0��1�ľ���
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
