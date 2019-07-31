package _4pinduoduo;
/*
 * ����:����������.����arr1��΢�ϸ���������(����ֻ��һ��Ԫ��,�����Ķ����ϸ���������)
 * 		��Ҫ�ҳ�����Ԫ��,Ȼ����arr2���ҳ�һ������Ԫ�������,����Ҳ�������� NO
 * 		������ҵ�������� arr1
 */
public class _1�ϸ��������� {

	public static void main(String[] args) {
		int[] arr1 = {1,3,7,9,8};
		int[] arr2 = {2,1,5,8,9,11};
		partion(arr1,arr2);
	}

	///�ҵ�arr1�ж�Ӧ��Ԫ��,����ǰ
	private static void partion(int[] arr1, int[] arr2) {
		if(arr1 == null || arr2 == null || arr1.length <= 1){
			System.out.print("NO");
			return;
		}
		int index = 0;
		while (index < arr1.length-1 && arr1[index] < arr1[index+1]) {
			index++;
		}
		//�õ��±�Ϊi
		if (index == arr1.length-1) {
			System.out.print("NO");
			return;
		}
		if (index == 0) {
			int tem = Integer.MIN_VALUE;//ԭ��λ���ϵ�ֵ
			for (int i = 0; i < arr2.length; i++) {
				if (arr2[i] < arr1[1]) {
					tem = Math.max(tem, arr2[i]);
				}
			}
			if (tem == Integer.MIN_VALUE) {
				System.out.print("NO");
				return;
			} else{
				arr1[0] = tem;
				for (int i : arr1) {
					System.out.print(i+" ");
				}
				return;
			}
		} else if (index == arr1.length-2) {
			int tem = Integer.MIN_VALUE;//ԭ��λ���ϵ�ֵ
			for (int i = 0; i < arr2.length; i++) {
				if (arr2[i] > arr1[arr1.length-2]) {
					tem = Math.max(tem, arr2[i]);
				}
			}
			if (tem == Integer.MIN_VALUE) {
				System.out.print("NO");
				return;
			} else{
				arr1[arr1.length-1] = tem;
				for (int i : arr1) {
					System.out.print(i+" ");
				}
				return;
			}
		} else{
			int tem = Integer.MIN_VALUE;//ԭ��λ���ϵ�ֵ
			for (int i = 0; i < arr2.length; i++) {
				if (arr2[i] > arr1[index] && arr2[i] < arr1[index+2]) {
					tem = Math.max(tem, arr2[i]);
				}
			}
			if (tem == Integer.MIN_VALUE) {
				System.out.print("NO");
				return;
			} else{
				arr1[index+1] = tem;
				for (int i : arr1) {
					System.out.print(i+" ");
				}
				return;
			}
		}
	}
}
