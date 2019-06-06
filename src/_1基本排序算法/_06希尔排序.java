package _1���������㷨;

public class _06ϣ������ {
	/**
	 * ʱ�临�Ӷ�: O(n^1.3)  O(n^2) ---ƽ��---->O(nlogn)-O(n^2)
	 * �ռ�ռ��: O(1)
	 * �ȶ���: ���ȶ�
	 * @param args
	 */
	
	public static void main(String[] args) {
		int[] arr = {5,3,2,8,5,9,21,6,0};
		shellSort(arr);
		for (int i : arr) {
			System.out.print(i + " ");
		}
	}
	
	
	/**
	 * ϣ������
	 * ϣ���������Բ�������Ϊǰ��,���������ǽ�����ֳ�������,һ��������һ��������
	 * ��ϣ�������ǽ�����ֳ��˼�����(ͨ�������ָ�),�ֱ���в�������
	 * @param arr
	 */
	public static void shellSort(int[] arr){
		
		//���ò���
		int gap = 3;
		
		while(gap > 0){
			for(int i=gap; i<arr.length; i++){ //�ӵڶ��п�ʼ,һֱ�ߵ�ͷ
				
				for(int j=i; j >= gap; j=j-gap){ //����ÿһ�������ȽϵĴ���
					
					if(arr[j] < arr[j-gap]){	//ÿ��ֻ��ǰ�������Ƚ�
						swap(arr, j, j-gap);
					} else {
						break;
					}
				}
				
			}
			//��������
			gap = gap/2; 
		}
	}
	
	//Ԫ�ؽ����ķ���
	private static void swap(int[] arr,int i, int j) {
		// TODO Auto-generated method stub
		arr[i]   = arr[i]^arr[j];
		arr[j]   = arr[i]^arr[j];
		arr[i]   = arr[i]^arr[j];
	}
	
	
	
}
