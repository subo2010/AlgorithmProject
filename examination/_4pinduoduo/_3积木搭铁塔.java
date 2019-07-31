package _4pinduoduo;
/*
 * ����:��һϵ�л�ľ����ΪLi ��Ϊ1,����������Щ��ľ���һ������
 * 		1.Ҫ��ÿһ��ֻ����һ����ľ,��������Ļ�ľҪ������Ļ�ľ���ҲҪС
 * 		2.ÿһ����ľ���Լ�������Wi,ÿһ����ľ�Ϸ����ܳ��ܵ��������ܳ�������������7��
 * �ṩ�����i����ľ����ΪLi[i].����ΪWi[i]
 * ������Դ���������������
 */
public class _3��ľ������ {
	public static void main(String[] args) {
		int[] Li = {1,2,3,4,5,6,7,8,9,10};
		int[] Wi = {1,1,1,1,1,1,1,1,1,10};
		//���ձ߳���С�����������(ע���Ӧ������ҲҪ����)
		selectSort(Li,Wi);
		//��̬�滮����
		partion(Li,Wi);
	}
	
	//��̬�滮��
	private static void partion(int[] li, int[] wi) {
		//basecase
		if (li.length <= 1 || wi.length <= 1) {
			System.out.println(li.length);
			return;
		}
		//����dp���� dp[i]�ʹ���ǰi������ʱ�����߶�
		int[] dp = new int[li.length];
		//��ʼ��,��ֻ��һ��Ԫ��ʱ,���ĸ߶Ⱦ�Ϊ1
		dp[0] = 1;
		//״̬ת��
		for (int x = 1; x < dp.length; x++) {
			if(li[x] > li[x-1]){
				//��������x֮ǰ������
				int temWi = 0;
				for (int i = 0; i < x; i++) {
					temWi += wi[i];
				}
				//��������������Խ�x��ľ��ӽ���,����Ļ�����
				if (temWi <= wi[x]*7) {
					dp[x] = dp[x-1] + 1;
				} else{
					//�ҵ�0-x�����ص�һ������(��������Ϊ0)
					partion1(wi,x);
					dp[x] = dp[x-1];
				}
			} else{
				wi[x] = 0;
				dp[x] = dp[x-1];
			}
		}
		System.out.print(dp[dp.length-1]);
	}
	
	//�ҵ�0-x�����ص�һ����Ϊ0
	private static void partion1(int[] wi, int x) {
		int tem = 0;
		for (int i = 0; i <= x; i++) {
			if (wi[i] > wi[tem]) {
				tem = i;
			}
		}
		wi[tem] = 0;
	}

	//ѡ������
	public static void selectSort(int[] arr,int[] arr1){
		for(int i = 0;i < arr.length-1; i++){
			for(int j = i+1; j < arr.length; j++){
				if(arr[i]>arr[j]){
					swap(arr,i,j);
					swap(arr1,i,j);
				}
			}
		}
	}
	private static void swap(int[] arr,int i, int j) {
		arr[i]   = arr[i]^arr[j];
		arr[j]   = arr[i]^arr[j];
		arr[i]   = arr[i]^arr[j];
	}
}
