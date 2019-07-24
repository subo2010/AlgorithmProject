package ������._08�����ݹ�_��̬�滮;

import java.util.LinkedHashSet;
import java.util.Set;

import org.junit.Test;

/*
 * ����:������һ���ַ���,������������ظ��Ӵ��ĸ���
 * 
 *  ����: 4,5,6,7,4,3,6,8  --> ����ظ��Ӵ�Ϊ5,6,7,4,3��7,4,3,6,8-->����Ϊ5
 *  
 *  ˼·:����˫ָ���set������ʵ��,�ֱ������ÿһ���ַ�����β�Ĳ��ظ��Ӵ��Ĵ�С
 */
public class _15����ظ��Ӵ� {

	@Test
	public void main() {
		int[] arr = {1,2,3,3,4,5,2,5,6};
		int size = partion(arr);
		System.out.println(size);
	}

	//��������ظ��Ӵ��ĳ���
	private int partion(int[] arr) {
		//basecase
		if (arr == null || arr.length == 0) {
			return 0;
		}
		//������һ��Ԫ��
		int size = 1;
		//�����ж�ȥ�ص�set����
		Set<Integer> set = new LinkedHashSet<Integer>();
		//����˫ָ��
		int left = 0;
		int right = 0;
		while(left != arr.length){
			//ֻҪ����ָ��û��Խ��,����set�в�����arr[right]Ԫ��
			while(right < arr.length && !set.contains(arr[right])){
				set.add(arr[right]);
				right++;
			}
			//˵�����������Ҳ�,����right��ָ���Ԫ�ش����ظ�
			size = Math.max(size, right-left);
			System.out.println(set.toString());
			//ȥ������ǰ���Ԫ�������ж�
			set.remove(arr[left++]);
		}
		return size;
	}
}
