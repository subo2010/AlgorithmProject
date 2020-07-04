package _02�����㷨._09���������㷨;

import org.junit.Test;

/**
 * ��Ŀ:������һ���ַ���(����:abcabc),ֻ������β������׷���ַ���
 * 	   ʹ������Ժ���ַ���,��������Դ�ַ������Ӵ�,����̵���ӳ���
 * 
 * ����: abcabc  -->abcabcabcabc<��������,�����Դ�ַ����ĳ���(6��)>  
 * 					abcabcabc<��������,�����3���ַ�>
 * 
 * 
 *˼·:��������KMP�㷨�����������,����������ַ���str����ΪN,
 *		������str�ַ���,����һ��N+1���ȵ�next����,��N+1��λ��(��next�����һ��λ��)
 *		��ŵ���,���ַ������ǰ��׺ƥ�䳤��(����Ϊk),������ǰ��k�ַ�,�����k�ַ���ͬ
 *		,���������Ҫ׷�ӵ���,ǰ��k���ַ�����������ַ�,����k+1��N���ַ�
 *	
 *		--->��ȡ����Ժ������
 *
 * @author Administrator
 *
 */

public class _02KMPӦ��֮_����ַ��� {
	
	@Test
	public void main() {
		String str0 = "abcabc";
		String str1 = "a";
		String str2 = "aa";
		String str3 = "ab";
		String str4 = "abc";
		String str5 = "abca";
		String str = endNextLength(str5);	//��ȡ��̵���ӳ���
		System.out.println(str);
	}

	//����һ���ַ���,�����ں�������׷�Ӷ���Ԫ��
	private String endNextLength(String str) {
		
		//BaseCase
		if (str==null||str.length()==0) {
			return "";
		} else if(str.length()==1) {
			return str + str.substring(0);
		}
		
		
		char[] charArray = str.toCharArray();//�õ��ַ�����Ӧ���ַ�����
		int[] nextArray = getNextArray(charArray);//�õ����ַ�������Ӧ��next����
		int cn = nextArray[nextArray.length-1];	//next�����һ��Ԫ�ش�����ַ������ǰ��׺��ƥ�䳤��
//		System.out.println(nextArray.length);
		return str + str.substring(cn);
	}
	
	//����һ���ַ�����,����������Ӧ��next����
	private int[] getNextArray(char[] str) {
		
		//BaseCase--->�������Ϊ1����2,ֱ�ӷ���
		if (str.length == 1) {
			return new int[] { -1,0 };
		} 
		//����һ����str2��ͬ���ȴ�1��next����.����ʼ��ǰ����λ��
		int[] next = new int[str.length+1];
		next[0] = -1;
		next[1] = 0;
		
		//��������ָ��
		int i = 2; 	//next������±�(�ӵ�3��Ԫ�ؿ�ʼ��,��Ϊǰ����)
		int cn = 0;	//����ÿ��Ҫ��i-1��ֵ,���бȽϵ�ֵ������(��i=2��cn=0,��Ϊi-1����nextֵΪ0)
		//cn������λ��,�ִ���ǰ׺�ĳ���
		
		//�ӵ�����Ԫ�ؿ�ʼ�������Ԫ�ص�nextֵ.ÿ����ǰnextֵʱ,ֻ������֮ǰ��nextֵ
		while (i < next.length) {
			if (str[i - 1] == str[cn]) { //cn����i-1λ�õ�next��,ms[cn]������ַ�ǰ׺����һ���ַ�
				next[i] = cn+1;						//���i-1λ�úʹ��ַ�ǰ׺����һ���ַ����,��iλ�õ�nextΪi-1λ�õ�next����1
				i++;	//iλ�����,������һ��
				cn = next[i-1];  //cnһֱָ�����i-1Ԫ������Ӧ��nextֵ
			} else {	//��������					
				if (cn > 0) { 
					cn = next[cn];	//��cnָ�� cn�ַ�ǰ׺����һ���ַ�,��cn����Ӧ��next��
				} else {		//ֱ��cn����0��-1ʱ����,��ʱiλ�õ�nextֵΪ0
					next[i] = 0;
					i++;
				}
			}
		}
		
		//����ȫ����ֵ�����󷵻�Nextָ��
		return next;
	}
}
