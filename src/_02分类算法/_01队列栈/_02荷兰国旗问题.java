package _02�����㷨._01����ջ;

import org.junit.Test;

/**
 * 	������������:����һ������arr����һ����num�����С��num�������������
		��ߣ�����num��������������м䣬����num��������������ұ�
		
	Ҫ��:����ռ临�Ӷ�O(1)��ʱ�临�Ӷ�O(N)
 * @author Administrator
 *
 *˼·: ��������ָ��lessָ����ʼλ�ü�һ,moreָ��ĩβλ�ü�һ,curָ����ʼλ��,
 *		��numС��curָ�������,������less��һ����λ�ý���,cur++
 *		��num����curָ�������.��cur++
 *		��num����curָ�������,������moreǰһ����λ�ý���
 *		ֱ��more��cur����
 */

public class _02������������ {
	
	@Test
	public  void main() {
		int[] arr = {-34 ,-19, 33, 62, 85, -31, -70, -57, -68};
		int num = 3300;
		int[] test = test(arr, 0, arr.length-1, num);
		
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.println();
		for (int i = 0; i < test.length; i++) {
			System.out.print(test[i]+" ");
		}
	}
	
	//������Ȳ��ֵ��±�ֵ   ---> ����Ϊ ����,��߽�,�ұ߽�,Ҫ�Ƚϵ���
	public int[] test(int[] arr, int L ,int R ,int num){

		int less =L - 1;	//С��numb��ָ��
		int more =R + 1;	//����num��
		int cur = L;		//����num��ָ��
		
		while (cur < more) { 		//ֻҪcur��moreû��������һֱѭ��
			if (arr[cur] < num) {
				swap(arr, ++less, cur++);
			} else if (arr[cur] > num) {
				swap(arr, --more, cur);		//�˴�cur���ܼ�һ,��Ϊ�ƹ�����more--��û�о����ж�,����Ҫ�ж�
			} else {		//������
				cur++;
			}
		}
		
		if(less+1>more-1){  //��������num������������,�򷵻�һ����
			return new int[]{0};
		}
		//�������д���num�򷵻ش���num���±귶Χ
		return new int[] {less+1,more-1};
	}
	
	//��������a�±��b�±��Ԫ��
	public void swap(int[] arr , int a ,int b){
		int tem = arr[a];
		arr[a] = arr[b];
		arr[b] = tem;
	}
}
