package ������._08̰�Ĳ���;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import org.junit.Test;

/**
 * ��Ŀ:���������ַ�����arr1��arr2,�ж���arr2����Щ�ַ���arr1�г��ֵ�?����ӡ���ַ�������arr1�г��ֵĴ���
 
 * ˼·1: 1.��arr1�е��ַ����д�Ƶͳ��,����һ��HashMap�ṹ,keyΪ�ַ�,valueΪ���ַ����ֵĴ���
 * 		��arr1�ĵ�һԪ�ؿ�ʼ,�������hashmap��,����¼�����
 * 	    2.��arr2���б���(����ȥ��),���β���arr2�е�ÿһ��Ԫ���Ƿ������hashmap��key��,����������ӡ��Ԫ�غ�hashmap
 * 		�ж�Ӧ��valueֵ
 * 
 * @author Super PC
 *
 */
public class _01һ���ַ����а�������һ���ַ������ַ� {
	@Test
	public void main() {
		String str1 = "12121211";
		String str2 = "12134";
		char[] arr1 = str1.toCharArray();
		char[] arr2 = str2.toCharArray();
		//��ӡarr1�а�����arr2���ַ��������
		twoContentPrint(arr1,arr2);
		
	}

	//��ӡarr1�а�����arr2���ַ��������
	private void twoContentPrint(char[] arr1, char[] arr2) {
		//�������ڴ�Ƶͳ�Ƶ�hashmap
		HashMap<Character, Integer> charSize = new HashMap<Character, Integer>();
		//��arr1�е��ַ����ŵ�hashmap��
		for (int i = 0; i < arr1.length; i++) {
			if (charSize.containsKey(arr1[i])) {
				charSize.put(arr1[i], charSize.get(arr1[i])+1);
			}else {
				charSize.put(arr1[i], 1);
			}
		}
		
		//��arr2����ȥ�ش���
		HashSet<Character> set = new HashSet<Character>();//��������
		List<Character> arr2list = new ArrayList<Character>();//����ʢ��Ԫ��
		for (int i = 0; i < arr2.length; i++) {
			if (!set.contains(arr2[i])) {
				set.add(arr2[i]);
				arr2list.add(arr2[i]);
			}
		}
		
		for (int i = 0; i < arr2list.size(); i++) {
			if (charSize.containsKey(arr2list.get(i))) {
				System.out.println(arr2list.get(i)+":"+charSize.get(arr2list.get(i)));
			}
		}
		
	}
}