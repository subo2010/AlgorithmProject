package ��ָoffer;

import org.junit.Test;

/*
 * ��ʵ��һ����������һ���ַ����е�ÿ���ո��滻�ɡ�%20����
 * ���磬���ַ���ΪWe Are Happy.�򾭹��滻֮����ַ���ΪWe%20Are%20Happy��
 * 
 * ˼·:1.�����ж�������ո����
 */
public class _02�滻�ո� {

	@Test
	public void main() {
		StringBuffer str1 = new StringBuffer(" ��  �� �� ");
		String str2 = replaceSpace(str1);
//		System.out.println(str1);
//		System.out.println(str2);
	}
	public String replaceSpace(StringBuffer str) {
		if (str==null ) {
			return null;
		}
		if (str.equals(" ")) {
			return "%20";
		}
    	String[] strArr = str.toString().split(" ");
    	System.out.println(strArr.length);
    	for (int i = 0; i < strArr.length; i++) {
			System.out.println(strArr[i]);
		}
    	String strTem = "";
    	for (int i = 0; i < strArr.length; i++) {
    		if (i==strArr.length-1) {
    			strTem += strArr[i];
			} else{
				strTem += strArr[i] + "%20";
			}
		}
		return strTem;
    }
}
