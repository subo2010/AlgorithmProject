package _4pinduoduo;

/*
 * ����:�ṩһ���ַ�������,�ж������ַ����Ƿ���β���,,�������һ���ַ��������һ���ַ��͵�һ�����ַ����ĵ�һ���ַ�
 * 	���,�γ���β�����Ļ�(�涨�ַ�����������������Ԫ��,ÿ���ַ�������������Ԫ��)
 * 	������γ������ true  ���� false
 */
public class _2��β����Ƿ�ɻ� {
	public static void main(String[] args) {
		String[] arr = {"1328","81"};
		partion(arr);
	}

	private static void partion(String[] arr) {
		//basecase
		//��һ���ַ���
		char[] firstStr = arr[0].toCharArray();
		char frist = firstStr[0]; //��һ���ַ����ĵ�һ���ַ�
		char temLast = firstStr[firstStr.length-1];
		for (int i = 1; i < arr.length; i++) {
			char[] temArr = arr[i].toCharArray();
			if (temLast == temArr[0]) {
				temLast = temArr[temArr.length-1];
			} else{
				System.out.println("false");
				return;
			}
		}
		if (frist != temLast) {
			System.out.println("false");
			return;
		}
		System.out.println("true");
	}
}
