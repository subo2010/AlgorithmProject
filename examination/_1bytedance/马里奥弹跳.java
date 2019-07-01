package _1bytedance;

public class ����µ��� {

	public static void main(String[] args) {
		int[] arr = {10,0,2,1,1,0,1};
		int index = 3;
		int step = getStepNum(arr,index);
		System.out.println(step);
	}

	private static int getStepNum(int[] arr, int index) {
		int[] help = new int[arr.length]; //��������Ǹ�λ�ñ�������
		return parttion(arr,help,index);
	}

	private static int parttion(int[] arr, int[] help, int index) {
		//basecase
		if (arr[index] == -1) return -1;
		if (index == arr.length) return 0;
		if (index + arr[index] >= arr.length) return 1;
		
		int minStep = Integer.MAX_VALUE;//ȫ����Сֵ
		for (int i = -arr[index]; i <= arr[index]; i++) { //�ܹ���Ծ�ķ�Χ
			//�����ǰλ��û������������û��Խ��,�������
			if (index+i >= 0 && index+i < arr.length && help[index+i] == 0) { 
				help[index+i] = 1;//��ʾ��ǰλ������
				int tempStep = parttion(arr, help, index+i);
				if (tempStep != -1) { //ֻ�е���һ��λ�ò�������,���ǲ���
					minStep = Math.min(minStep, tempStep + 1);
				}
			}
		}
		int result = minStep == Integer.MAX_VALUE ? -1: minStep;
		return result;
	}
}
