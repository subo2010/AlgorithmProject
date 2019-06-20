package ������._02��ά����;

/**
 * ����Ŀ�� ����һ�����;���matrix���밴��תȦ�ķ�ʽ��ӡ����
	���磺 	1  2  3  4 
			5  6  7  8 
			9  10 11 12
			13 14 15 16 
	��ӡ���Ϊ��1��2��3��4��8��12��16��15��14��13��9��5��6��7��11�� 10
	��Ҫ�� ����ռ临�Ӷ�ΪO(1)
	˼·:��ϸ������ת��Ϊ�������---->���ȿ��Ǵ�ӡ������һ��,Ȼ�������ڲ���ӡ
		�����ĸ�ָ��:p1=0����ʼ��λ��,p2=0����ʼ��λ��,p3=...��������λ��,p4=...��������λ��
		�������ж����ȴ�arr[p1][p2] ��ӡ�� arr[p1][p4-1]
				Ȼ���ӡ arr[p1][p4]�� arr[p3-1][p4]
				Ȼ���ӡ arr[p3][p4]�� arr[p3][p2+1]
				Ȼ���ӡ arr[p3][p2]�� arr[p1+1][p2]
		��ʱ���һȦ�Ĺ���,Ȼ����p1++,p2++,p3--,p4--����ѭ��
		ֱ��p1>p3����p2>p4
 * @author Administrator
 *
 */
public class _01תȦ��ӡ���� {
	public static void main(String[] args) {
		int[][] matr = getMatr(5,3);
		myPrint(matr);
		System.out.println("-----------------------");
		printMatr(matr);
		
	}

	
	//תȦ�ķ�ʽ��ӡ��ά����
	private static void printMatr(int[][] arr) {
		int p1 = 0;
		int p2 = 0;
		int p3 = arr.length-1;		//����
		int p4 = arr[0].length-1;	//����
//		System.out.println(p3+" "+p4);
		while(p1<=p3&&p2<=p4){
			for (int i = p2; i < p4; i++) {
				System.out.print(arr[p1][i]+" ");
			}
			for (int i = p1; i < p3; i++) {
				System.out.print(arr[i][p4]+" ");
			}
			for (int i = p4; i > p2; i--) {
				System.out.print(arr[p3][i]+" ");
			}
			for (int i = p3; i > p1; i--) {
				System.out.print(arr[i][p2]+" ");
			}
			p1++;
			p2++;
			p3--;
			p4--;
		}
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

