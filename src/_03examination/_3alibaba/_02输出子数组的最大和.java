package _03examination._3alibaba;
/*
 * ��Ŀ:����һ������,���������������
 * 
 * ˼·1:������,�ֱ����ÿһ��������,���������ǵĳ���,Ȼ��ά��һ��ȫ�����ֵ
 * 
 * ˼·2:����һ����̬�� wmax,�ӵ�һ����ʼ�ۼ�,��¼ÿ�ε����ֵ,
 * 		����ӵ���һ����С��0ʱ,�ͽ�wmax=0,Ȼ������ۼ�,ֱ������,�������wmax 
 */

public class _02��������������{ 
	
	public static void main(String[] args) {
		//����
		int[] arr = {-1,5,4,-1,-2,10,-1,100};
		
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < arr.length; i++) {
			max = Math.max(arr[i], max);
		}
		//���������,�����ȫ������ֵ
		if (max <= 0) {
			System.out.println(max);
			return;
		}
		//�����������Ǹ����Ļ�
		max = 0;
		int wmax = 0;
		for(int i = 0; i < arr.length; i++){
			//�������һ�����Ժ�С��0,��wmax��Ϊ0.������������
			if(wmax + arr[i] >= 0){
				wmax = wmax + arr[i];
			}else{
				wmax = 0;
			}
			max = Math.max(wmax, max);
		}
		System.out.println(max);
	}
}
