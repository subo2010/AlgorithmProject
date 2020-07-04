package _02�����㷨._08̰�Ĳ���;
import java.util.Arrays;
import java.util.Comparator;
import org.junit.Test;

/**
 * ��Ŀ:������һ���ַ�������,����Ҫ�������ַ���ƴ�ӳ�һ����С�ֵ�����ַ���,������=
 * ����: arr = {"ab","bd","c"}
 *     ����  "abbdc" 
 * ����: arr = {"ba","b"}
 *     ����  "bab" 
 *�ֵ���:��������������ȵ��ַ���"abc" "bcd"������ʵ��˳�������ʵ�ֵ���
 *		���ڳ��Ȳ�ͬ���ַ����ڳ��ȶ̵ĺ���׷����С�ĵ��ַ��Ϳ��ԱȽ���  ����"abc" "b" ������"abc" "b00"���Ƚ�
 *����:
 *	��������Ǹ���[5,2,3,4,8,2,3] �������,��������������㷨,��������þ�����С��
 *	���õ������о��൱��Ϊ�ַ������鶨��һ���������,Ȼ��Arrays.Sort()����,����бȽϲ��ԵıȽ����Ϳ�����
 *	�˴���ӵıȽϲ���Ϊ:
 *			���str1+str2 <= str2+str1 ��str1��ǰ��,����str2��ǰ��
 * @author Administrator
 *
 */

public class _02�ַ�������С�ֵ��� {

	@Test
	public void main() {
		
		String[] arr = {"ba","b","abc"};  //abcbab
		String result = getLowDicorder(arr);
		System.out.println(result);
		
	}
	
	
	//�����������ַ�������ƴ�ɵ���С�ֵ�����ַ���
	private String getLowDicorder(String[] arr) {
		//ͨ���趨�ıȽϲ�������������
		Arrays.sort( arr,new Comparator<String>() {
			public int compare(String o1, String o2) {
				return (o1+o2).compareTo(o2+o1);  //�ַ������õıȽϷ���compareTo
			}
		});
		
		String result = "";
		//������õ��ַ�������ƴ�ӳ��ַ���
		for (int i = 0; i < arr.length; i++) {
			result += arr[i];
		}
		return result;
	}
}
