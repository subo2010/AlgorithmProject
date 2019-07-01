package _1bytedance;
/*
 * ��Ŀ:��N������վ��һ�ţ�ÿ��������һ����ֵ������Щ�����ɷ��ǹ�����Ҫ������������
		1��ÿ���������ٷֵ�һ���ǹ�
		2����ֵ���ߵĺ��ӱ�������λ�ĺ��ӻ�ø�����ǹ�
		��������Ҫ�ַ������ǹ���
	����:0,1,0  -->  4
		5,4,1,1  -->  7
		
	˼·:����һ��help�������arr�����Ӧ,������ͬѧ�ֵõ�����
		��һ��ͬѧ�ֵõ�����,Ҫ�ֱ���������������½��ĸ���,�ϴ���ظ�ֵ��1,Ϊ��ͬѧ������
 */
public class _04���ǹ� {
	public static void main(String[] args) {
		int[] arr = {8,9,10,8,7};
//		int[] arr = {2,3,3,4,5,2,1};
		int num = getMinNum(arr);
		
		System.out.println(num);
	}
	
	
	private static int getMinNum(int[] arr){
		int[] help = new int[arr.length]; //����һ����������

		//�ֱ����ÿ��λ�õ��ǹ�����
		for (int index = 0; index < help.length; index++) {
			help[index] = partion(arr , index);
		}
		
		int su = 0;
		for (int i = 0; i < help.length; i++) {
			su += help[i];
		}
		return su;
	}
	
	//����һ��λ��,���������ǹ�����
	private static int partion(int[] arr,int index) {
		
		int left = 0;	//���������С�ĸ���
		int right = 0;	//�Ҳ�������С�ĸ���
		int leftIndex = index-1; //�����Ԫ��
		int rightIndex = index+1;
		while(leftIndex >= 0 && arr[leftIndex] <= arr[leftIndex+1] ){
			if (arr[leftIndex] < arr[leftIndex+1]) { //���С�ھͼ�һ,������ھͲ���
				left++;
			}
			leftIndex--;
		}
		
		while(rightIndex < arr.length && arr[rightIndex-1] >= arr[rightIndex] ){
			if (arr[rightIndex-1] > arr[rightIndex]) { //���С�ھͼ�һ,������ھͲ���
				right++;
			}
			rightIndex++;
		}
		
		return Math.max(left, right) + 1;
	}
}
