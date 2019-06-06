package ������._09���������㷨;

import org.junit.Test;

/**
 * ��Ŀ: ����һ���ַ���,�����ں���������ٵ��ַ�,ʹ���ַ�����Ϊһ�������ַ�
 * 
 * ����:abca  --> abcabc
 * 		123832  --> 1238321
 * 
 * ˼·:�����Ǹ���һ���ַ�����������ַ��γ�һ������,��������֪�����������ַ���������ʱ,�����Ϳ������ɵõ���һ������
 * 	��������Ŀ��Ҫ��ʹ�����ٵ��ַ�,��˾�ת��Ϊ��Manacher����,�������Manacher�㷨��,��������һλ����Ϊ��������
 *  �߽�,���������ұ߽��һ�ε������һ��Ԫ�ص�ʱ��,���ǽ���ʱ���Ĵ�ԭ�ַ����м���,ʣ����ַ�������ķ�ʽ��ӵ�ԭ�ַ���
 *  �ĺ���,���γɵ���С�Ļ����ַ���
 * @author Administrator
 *
 */
public class _05_ManacherӦ��֮_����ַ���ʹ�ɻ��� {

	@Test
	public void main() {
		String str = "123";
		System.out.println(str);
		String huiwen = getShortHuiwen(str); //��ԭ���ĺ�������ַ�����õ���̵Ļ���
		System.out.println(huiwen);
		
		//��֤��������Ч�� 
//		System.out.println(str.length());
//		char[] cs = str.toCharArray();
//		char[] fuZhou = getFuZhou(cs);
//		for (int i = 0; i < fuZhou.length; i++) {
//			System.out.print(fuZhou[i]);
//		}
//		System.out.println();
//		
//		int c = getC(fuZhou);
//		System.out.println(c);
//		getShortHuiwen(str);
		
	}

	//�����ַ����ں�������ַ���ʹ֮��Ϊ��̵Ļ���
	//˼·�Ǹ���Manacher��ʵ��,������һ��ı߽絽�����һ��Ԫ��ʱ�õ���ʱ�ǻ�������C
	private String getShortHuiwen(String str) {
		if (str==null) {
			return "";
		}
		char[] str1 = str.toCharArray(); //�ַ���ת��Ϊ�ַ�����
		char[] strArray = getFuZhou(str1); //���÷����������
		
		int c = getC(strArray);
		//����һ�����������������
		int i1 = 2*(strArray.length-c)-1;	//�ظ����ֵĳ���
		int i2 = strArray.length-i1;		//���ظ����ֵĳ���
		char[] resultArr = new char[strArray.length+i2]; //���ȼ���
//		System.out.println(strArray.length);
//		System.out.println(resultArr.length);
		
		int index = 0;
		for (; index < strArray.length; index++) {
			resultArr[index] = strArray[index];
		}
		while(i2>0){
			resultArr[index++] = strArray[--i2];
		}
		
		//��ʱ��resultArr�ǰ���������ַ�����
		//����ֻ��Ҫ������ȥ������ת�����ַ����ͺ���
		char[] res = new char[resultArr.length/2];
		for (int i = 0; i < res.length; i++) {
			res[i] = resultArr[2*i+1];
		}
		
//		for (int i = 0; i < res.length; i++) {
//			System.out.print(res[i]);
//		}
	
		String resultStr = String.valueOf(res);
		
		return resultStr;
	}

	//���ص��������ұ߽絽���ַ���β��ʱ�������ĵ�λ��
	private int getC(char[] strArray) {
		int[] pArr = new int[strArray.length];  //���İ뾶����
		int C = -1;	 //���ó�ʼ�Ļ������ĵ�λ��
		int pR = -1; //�����������ұ߽�ĳ�ʼֵΪ1
		//Ȼ���ÿ��Ԫ��Ϊ�����ж�ʱ���ĵĳ���
		for (int i = 0; i < strArray.length; i++) {
			pArr[i] = i<pR ?Math.min(pArr[2*C-i], pR-i):1;
			while(i-pArr[i] >= 0 && i+pArr[i] < strArray.length){
				if (strArray[i-pArr[i]]==strArray[i+pArr[i]]) {
					pArr[i]++;
				} else {
					break;
				}
			}
			if (i+pArr[i]>pR) {
				pR = i+pArr[i];
				C = i;
			}
			//���������ұ߽絽���ַ���β��ʱ,���ػ�������
			if (pR==strArray.length) {
				return C;
			}
		}
		return 1;
	}
	
	//Ϊ��ӵ��ַ������������
	private char[] getFuZhou(char[] str1) {
		char[] strArray = new char[str1.length*2+1];
		int index = 0;
		for (int i = 0; i < strArray.length; i++) {
			strArray[i] = i%2==0 ? '#' : str1[index++];
		}
		return strArray;
	}
}
