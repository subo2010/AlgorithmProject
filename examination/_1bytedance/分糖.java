package _1bytedance;

/*
 * ˼·:����һ��help�������arr�����Ӧ,�ҵ���С���Ǻ���,Ȼ�����Ӧλ����Ϊ1
 * 		Ȼ������￪ʼ��ɢ,���ڵı��Լ�������Ӧλ�ô�,���Լ�С�����Ӧλ��ҪС,�����ȵĻ����п���
 */
public class ���� {

	public static void main(String[] args) {
//		int[] arr = {8,9,10,8,7};
		int[] arr = {2,3,3,4,5,2,1};
		int num = getMinNum(arr);
		
		System.out.println(num);
	}
	
	
	private static int getMinNum(int[] arr){
		int[] help = new int[arr.length]; //����һ����������
		int minNum = Integer.MIN_VALUE;
		partion(arr, minNum, help);
		int su = 0;
		for (int i = 0; i < help.length; i++) {
			su += help[i];
		}
		return su;
	}
	private static void partion(int[] arr,int minNum,int[] help) {
		int temNum = Integer.MAX_VALUE; //ȫ����Сֵ
		int minindex = -1;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] >= minNum && help[i] == 0) { //������ֻ��û�зֹ������ұ��Ҵ��
				if (arr[i] < temNum) {//Ȼ���ڴ��������ҳ���С�ķ����±�
					temNum = arr[i];
					minindex = i;
				}
			}
		}
		//�õ��˵�ǰ����Сֵ��λ��
		if (minindex == -1) { //˵���Ѿ���������Сֵ
			return;
		}
		//�ж��������ߵ����
		int left = minindex - 1 < 0 ? 0 : help[minindex - 1]; //���������
		int right = minindex + 1 >= arr.length ? 0 : help[minindex + 1]; //���������
		help[minindex] = Math.max(left, right) + 1;
		partion(arr,temNum,help);
	}
}
