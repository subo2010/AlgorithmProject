package _00��������;

public class _04һά������������� {

	
	public static void main(String[] args) {
		int[] arr = generateRandomArray(5,9);
		myPrint(arr);
	}
	
	//��ӡ����ķ���
	private static void myPrint(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}

	//���ɳ�����������鳤�ȴ���[0 , size]��ÿ��Ԫ�ص�ֵΪ [-value , value]
	public static int[] generateRandomArray(int size , int value){
		//���ɳ������������ ���ȴ���[0 , size]
		int[] arr = new int[(int)((size + 1) * Math.random())];
//		int[] arr = new int[9];//ָ������
		
		for(int i =0;i < arr.length; i++){
			arr[i] = (int)((value + 1) * Math.random()) - (int)(value * Math.random());
		}
		return arr;
	}
	
}
