package ������._02��ά����;

/**
 ��֮�����δ�ӡ����
	����Ŀ�� ����һ������matrix�����ա�֮�����εķ�ʽ��ӡ��
		���������磺	 1 2  3  4 
					 5 6  7  8 
					 9 10 11 12
		��֮�����δ�ӡ�Ľ��Ϊ��1��2��5��9��6��3��4��7��10��11��8��12
	��Ҫ�� ����ռ临�Ӷ�ΪO(1)
 * 
	˼·:�����˼·��Ȼ�ǽ�����ϸ��ת��Ϊ��۲���(��Ϊ��Ҫ��ռ临�Ӷ�Ϊ1��˲����Խ��������ռ�)
		����������ֱ�һ��������һ��������,ÿ�ζ���һ������ʼλ�ö���ԭ��,
		�������ߵĵ��ߵ������Ҳ�Ϳ�ʼ������
		�������ߵĵ��ߵ������²�Ϳ�ʼ������
		����������������ʼ�����ڶԽ��ߵ�λ�õ�
 *
 */
public class _03֮���δ�ӡ���� {

	public static boolean flag;//��ӡ�ı�־(����)
	public static void main(String[] args) {
		int[][] matr = getMatr(4,3);
		myPrint(matr);
		System.out.println("----------------");
		zhiPrint(matr);
		
	}
	
	private static void zhiPrint(int[][] arr) {
		int rows = arr.length-1;		//����(���������)
		int columns = arr[0].length-1;	//����(��������)
		//���������ߵĵ�ĺ�������������
		int dp1 = 0;
		int dp2 = 0;
		//���������ߵĵ�ĺ�������������
		int rp1 = 0;
		int rp2 = 0;
		//ÿ������ͬʱ��һ��,ÿ��һ��������ô�ӡ����
		while(dp1<=rp1||dp1==0){
			//ʵ�ִ�zhi�ִ�ӡ
			booleanPrint(arr,dp1,dp2,rp1,rp2);
			//�����ߵĵ������ƶ�,���ƶ���rowsʱ�����ƶ�
//			System.out.println(dp1+" "+dp2+"--"+rp1+" "+rp2);
			if (dp2<rows) {
				dp2++;
			}else {
				dp1++;
			}
			//�����ߵĵ������ƶ�,���ƶ���columnsʱ�����ƶ�
			if (rp1<columns) {
				rp1++;
			}else {
				rp2++;
			}
		}
	}

	private static void booleanPrint(int[][] arr, int dp1, int dp2, int rp1,int rp2) {
		if (flag) {
			while(dp1<=rp1){
				System.out.print(arr[rp2++][rp1--]+" ");
//				rp1--;
//				rp2++;
			}
			flag =false;
		} else{
			while(dp1<=rp1){
				System.out.print(arr[dp2--][dp1++]+" ");
//				dp1++;
//				dp2--;
			}
			flag = true;
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
