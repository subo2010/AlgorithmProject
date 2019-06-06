package _0��������;
import java.util.Arrays;

import _1���������㷨._07��������_1;


public class _02������ {
/**
 * 1.��һ������Ҫ���Եķ���a
 * 2.ʵ��һ��������ȷ���Ǹ��ӶȲ��õķ���b
 * 3.ʵ��һ���������������
 * 4.�ѷ���a�ͷ���b�ȶԺܶԴ�����֤����a�Ƿ���ȷ
 * 5.���һ����Ʒʹ�öԱȳ���,��ӡ�����Ǹ�����������
 * 6.�����������Ժ�Ϳ���ȷ��a�ǶԵ���
 * @param args
 */
	public static void main(String[] args) {
		int testTime = 500000;	//���Դ���
		int size = 10;			//�������󳤶�
		int value = 100;		//�������ֵ����
		boolean success = true;
		for (int i = 0; i < testTime; i++) {
			int[] arr1 = generateRandomArray(size, value);	//�����������������
			int[] arr2 = copyArray(arr1);					//��ýṹ��ͬ����
			int[] arr3 = copyArray(arr1);
			_07��������_1.fastSort(arr1, 0, arr1.length-1);	//���ò��Է���
			rightSort(arr2);							//���þ�����ȷ�ķ���
			if (!isEqual(arr1, arr2)) {			//���ñȶ������бȶ�
				success = false;
				printArray(arr3); // ��ʧ�ܵ�������ӡ����
				break;
			}
		}
		System.out.println(success ? "Nice!�ɹ�!" : "������");
	}
	
	
	/**
	 * ��ӡ����
	 * @param arr3
	 */
	private static void printArray(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]+" ");
		}
	}
	
	/**
	 * ����һ�����������
	 * @return
	 */
	public static int[] generateRandomArray(int size , int value){
		
		//���ɳ������������ ���ȴ���[0 , size]
//		int[] arr = new int[(int)((size + 1) * Math.random())];
		int[] arr = new int[9];//ָ������
		
		for(int i =0;i < arr.length; i++){
			arr[i] = (int)((value + 1) * Math.random()) - (int)(value * Math.random());
		}
		
		return arr;
	}
		
	/**
	 * ������ȷ�����򷽷�
	 * @param arr
	 */
	public static void rightSort(int [] arr){
		Arrays.sort(arr);
	}
		
	/**
	 * ����һ���ṹһģһ��������
	 * @param arr
	 * @return
	 */
	public static int[] copyArray(int [] arr){
		if (arr == null) {
			return null;
		}
		int[] res = new int[arr.length];
		for (int i = 0; i < res.length; i++) {
			res[i] = arr[i];
		}
		return res;
	}
		
	/**
	 * �ж���������ṹ�Ƿ���ȫ��ͬ
	 * @param arr
	 * @return
	 */
	public static boolean isEqual(int [] arr1,int [] arr2){
		if(arr1==null && arr2!=null){
			return false;
		}
		if(arr2==null && arr1!=null){
			return false;
		}
		if(arr1==null && arr2==null){
			return true;
		}
		if(arr1.length != arr2.length){
			return false;
		}
		for (int i = 0; i < arr1.length; i++) {
			if(arr1[i] != arr2[i]){
				return false;
			}
		}
		return true;
	}
	
}
