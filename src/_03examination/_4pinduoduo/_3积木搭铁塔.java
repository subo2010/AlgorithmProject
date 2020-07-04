package _03examination._4pinduoduo;
/*
 * ����:��һϵ�л�ľ����ΪLi ��Ϊ1,����������Щ��ľ���һ������
 * 		1.Ҫ��ÿһ��ֻ����һ����ľ,��������Ļ�ľҪ������Ļ�ľ���ҲҪС
 * 		2.ÿһ����ľ���Լ�������Wi,ÿһ����ľ�Ϸ����ܳ��ܵ��������ܳ�������������7��
 * �ṩ�����i����ľ����ΪLi[i].����ΪWi[i]
 * ������Դ���������������
 * 
 * ˼·:���ö�̬�滮������
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
		//����dp���� dp[i]�ʹ���ǰi+1������ʱ�����߶�
		int[] dp = new int[li.length];
		//��ʼ��,��ֻ��һ��Ԫ��ʱ,���ĸ߶Ⱦ�Ϊ1
		dp[0] = 1;
		//״̬ת��
		for (int x = 1; x < dp.length; x++) {
			if(li[x] > li[x-1]){ //ֻ����һ��Ԫ�ر��Լ���ſ����Ƿ������
				//���ú�����ȡxֵ�����л�ľ������
				int temWi = getWiget(wi, x); 
				//��������������Խ�x��ľ��ӽ���,����Ļ�����
				if (temWi <= wi[x]*7) {
					dp[x] = dp[x-1] + 1;
				} else{
					//�ҵ�0-x�ҳ�һ������(��������Ϊ0)
					removeOne(wi,x); //���÷���
					dp[x] = dp[x-1];
				}
			} else{	//�����һ��Ԫ�غ��Լ���ͬ��С����(����ѡһ��)
				dp[x] = dp[x-1];
				if(wi[x] < wi[x-1]){ //�����һ�����Լ��صĻ���������,������Լ���Ļ�����һ��
					int temWi = getWiget(wi, x-1);
					if (temWi <= wi[x]*7) {
						wi[x-1] = 0;
					}
				} else{
					wi[x] = 0;
				}
			}
		}
		System.out.print(dp[dp.length-1]);
	}
	
	//�ҵ�0-x���ҳ�һ�����׳�,ԭ��Ϊ�ҳ�һ�����ص�����,������صĲ��ǵ�x��Ԫ��ʱ��Ҫ�ж�����֮��x�����Ԫ���Ƿ�ᳬ��
	//��������,��ֻ�ܷ���x��ľ
	private static void removeOne(int[] wi, int x) {
		//�õ����ص��±�Ϊindex
		int index = 0;
		for (int i = 0; i <= x; i++) {
			if (wi[i] > wi[index]) {
				index = i;
			}
		}
		//���index����x����Ҫ�ж�һ��,ȥ��index���Ƿ񻹻ᳬ��
		if (index == x) {
			wi[index] = 0;
		} else{
			int temWi = getWiget(wi, x);
			//���indexȥ�������������ȥ��,����ȥ��xλ��
			if (temWi - wi[index] <= wi[x]*7) {
				wi[index] = 0;
			} else {
				wi[x] = 0;
			}
		}
	}

	//��ȡx֮�ϵĻ�ľ������
	private static int getWiget(int[] wi, int x) {
		int temWi = 0;
		for (int i = 0; i < x; i++) {
			temWi += wi[i];
		}
		return temWi;
	}
	//ѡ������(arr���մ�С�����˳������,ͬʱarr1��Ӧ��λ��Ҳͬʱ����)
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
