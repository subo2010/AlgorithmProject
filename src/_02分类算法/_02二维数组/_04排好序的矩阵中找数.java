package _02�����㷨._02��ά����;

/**
 * �ź���ľ���������
	����Ŀ�� 	����һ����N*M�����;���matrix��һ������K��matrix��ÿһ�к�ÿһ�ж����ź���ġ�
			ʵ��һ���������ж�K�Ƿ���matrix�С� 
			���磺      	0 1 2 5 
					2 3 4 6 
					4 4 4 8 
					5 7 8 9 
			���KΪ7������true��
			���KΪ6������false��
	��Ҫ�� ʱ�临�Ӷ�ΪO(N+M)������ռ临�Ӷ�ΪO(1)��
	˼·:�����������ǱȽ������,���Կ��Եõ��Ƚ������Ľ������
	*	�����Ͻǿ�ʼ�����Ƿ����K,�����ȷ���true,���cur����k�������ƶ�,���curС��K�������ƶ�
	*	�ƶ�����curָ��ǰֵ,ѭ���Ƚ�ֱ���ߵ�������֮���ֻ�����ƶ�.����ֱ���ߵ�������֮���ֻ�����ƶ�
 * @author Administrator
 *
 */
public class _04�ź���ľ��������� {
	public static void main(String[] args) {
	//�ź���ľ���������
		int[][] matr = getMatr(5,4);
		matr[3][0] = 12;
		matr[2][3] = 11;
		myPrint(matr);
		System.out.println("----------------");
		boolean contain = findNum(matr,12);
		System.out.println(contain);
		
	}
	
	private static boolean findNum(int[][] arr, int num) {
		int rows = arr.length-1;		//����(���������)
		int columns = arr[0].length-1;	//����(��������)
		int p1 = 0;
		int p2 = columns;
		//��ָ���û�е����¶���û�е������ʱ
		if (num==arr[rows][0]) {
			return true;
		}
		while(p1<rows&&p2>0){
			if (num>arr[p1][p2]) {		//���num���ڵ�ǰֵ�����±Ƚ�
				p1++;
			} else if(num<arr[p1][p2]){	//���numС�ڵ�ǰֵ������Ƚ�
				p2--;
			} else {
				return true;
			}
		}
		
		//���Ѿ��������,��ʼ�����ƶ�
		while(p1<rows){
			if(num>arr[p1][p2]){	
				p1++;
			} else if (num<arr[p1][p2]) {
				return false;
			}else{
				return true;
			}
		}
		//���Ѿ������¶�
		while(p2>0){
			if(num<arr[p1][p2]){	
				p2--;
			} else if (num>arr[p1][p2]) {
				return false;
			}else{
				return true;
			}
		}
		return false;
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

