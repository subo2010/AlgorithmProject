package _03examination._1bytedance;
/*
 * ��Ŀ:��N������վ��һ�ţ�ÿ��������һ����ֵ������Щ�����ɷ��ǹ�����Ҫ������������
		1��ÿ���������ٷֵ�һ���ǹ�
		2����ֵ���ߵĺ��ӱ�������λ�ĺ��ӻ�ø�����ǹ�
		��������Ҫ�ַ������ǹ���
	����:0,1,0  -->  4
		5,4,1,1  -->  7
		
	˼·:����һ��help�������arr�����Ӧ,��Ӧλ��Ϊ��ͬѧ�ֵõ�����
		��һ��ͬѧ�ֵõ�����,Ҫ�ֱ���������������½��ĸ���,�ϴ���Ǹ�ֵ��1,Ϊ��ͬѧ������
 */
public class _04���ǹ� {
	public static void main(String[] args) {
//		int[] arr = {1,2,3};
//		int[] arr = {8,9,10,8,7};
//		int[] arr = {2,3,3,4,5,2,1};
		int[] arr = {2,3,4,1,5,6,2,1};
		int num = getMinNum(arr);
		System.out.println(num);
	}
	
	
	private static int getMinNum(int[] arr){
		//�ֱ����ÿ��ͬѧ���ǹ�����,�������Ǽ�����
		int su = 0;
		for (int index = 0; index < arr.length; index++) {
			su += partion(arr , index);
		}
		return su;
	}
	
	//����һ��λ��,���������ǹ�����
	private static int partion(int[] arr,int index) {
		
		int left = 0;	//���������С�ĸ���
		int right = 0;	//�Ҳ�������С�ĸ���
		int leftIndex = index-1; //�����Ԫ��
		int rightIndex = index+1; //�����Ԫ��
		while(leftIndex >= 0 && arr[leftIndex] <= arr[leftIndex+1] ){
			if (arr[leftIndex] < arr[leftIndex+1]) { //���С�ھͼ�һ,������ھͲ�����
				left++;
			}
			leftIndex--;
		}
		
		while(rightIndex < arr.length && arr[rightIndex-1] >= arr[rightIndex] ){
			if (arr[rightIndex-1] > arr[rightIndex]) { //���С�ھͼ�һ,������ھͲ�����(�������½��ĸ���)
				right++;
			}
			rightIndex++; 
		}
		return Math.max(left, right) + 1; //���������С�ĸ�����1
	}
}
