package ������._08�����ݹ�_��̬�滮;

import org.junit.Test;

/*
 * ��Ŀ:�����ַ����е�������ַ�����ĳ���-->�ṩ���������ַ���,�����Ĺ���������,�ĳ���
 * 		����  abcbdab  bced  -->  �����������Ϊbcd 
 
 */
public class _12�����ַ����������������_���� {
	
	@Test
	public void main() {
		String str1 = "ABCBDCAB";
		String str2 = "BDCABA";  //BDAB
		int maxLen = partion(str1,str2);
		System.out.println(maxLen);
	}

	private int partion(String str1, String str2) {
		return 0;
	}

}
