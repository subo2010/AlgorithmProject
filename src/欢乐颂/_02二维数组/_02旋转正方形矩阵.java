package ������._02��ά����;

/**
 *  ����Ŀ�� ����һ�����������ξ���matrix����Ѹþ��������˳ʱ����ת90�ȵ����ӡ�
	��Ҫ�� ����ռ临�Ӷ�ΪO(1)��
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
 *˼·:�����˼·��Ȼ�ǽ�����ϸ��ת��Ϊ��۲���(��Ϊ��Ҫ��ռ临�Ӷ�Ϊ1��˲����Խ��������ռ�)
 *	�����ĸ�ָ��:p1=0����ʼ��λ��,p2=0����ʼ��λ��,p3=...��������λ��,p4=...��������λ��
 *	��һ��ѭ�����ڴ�ӡ�����Ԫ��,�ֱ���1->4,4->16,16->13,13->1
 *	Ȼ������2��3���������˼·������
 *	��������������ʱ��������ڲ���ӡ
 */
public class _02��ת�����ξ��� {
	
	public static void main(String[] args) {
		int[][] matr = getMatr(5,5);
		myPrint(matr);
		System.out.println("----------------");
		rotateMatr(matr);
		myPrint(matr);
		
	}
	
	private static void rotateMatr(int[][] arr) {
		int p1 = 0;
		int p2 = 0;
		int p3 = arr.length-1;		//����
		int p4 = arr[0].length-1;	//����
		
		while(p2<p4){
			//ѭ���ƶ�������һȦ
			for (int i = 0; i < p4-p2; i++) {
				swap(arr, p3, p4-i, p3-i, p2);
				swap(arr, p1+i, p4, p3, p4-i);
				swap(arr, p1, p2+i, p1+i, p4);   
			}
			p1++;
			p2++;
			p3--;
			p4--;
		}
	}
	
	//��ά����Ľ���
	private static void swap(int[][] arr ,int p1,int p2,int p3,int p4){
		int temp = arr[p1][p2];
		arr[p1][p2] = arr[p3][p4];
		arr[p3][p4] = temp;
	}

	//��ȡһ��m��n�еľ������
	private static int[][] getMatr(int m,int n) {
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
