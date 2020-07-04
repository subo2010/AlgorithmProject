package _02�����㷨._08�����ݹ�_��̬�滮;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

/*
 *����Ŀ����������arr��arr�����е�ֵ��Ϊ�����Ҳ��ظ���ÿ��ֵ����һ����ֵ�Ļ��ң�ÿ����ֵ�Ļ��ҿ���ʹ�������ţ��ٸ���һ������aim����Ҫ�ҵ�Ǯ����
 * 		��Ǯ�ж����ַ�����
 *�������� arr=[5,10,25,1]��aim=0��	���0Ԫ�ķ�����1�֣�����������ֵ�Ļ��Ҷ����á����Է���1��
 *		arr=[5,10,25,1]��aim=15��
 *		���15Ԫ�ķ�����6�֣��ֱ�Ϊ3��5Ԫ��1��10Ԫ+1��5Ԫ��1��10Ԫ+5��1Ԫ��10��1Ԫ+1��5Ԫ��2��5Ԫ+5��1Ԫ��15��1Ԫ�����Է���6��
 *		arr=[3,5]��aim=2��	�κη������޷����2Ԫ�����Է���0��
 *
 * �Ż��������->(���仯����):��������Ľⷨ�����˴������ظ�����,��˿���ͨ������һ������ṹ����ÿ�μ���Ľ�����д洢,
 * 		Ȼ��������ʱ,�ڻ���ṹ�в���.
 */
public class _01��Ǯ�ķ�����_���仯���� {
	@Test
	public void main() {
		int[] arr = {5,10,25,1};
		int aim = 15;
		int num2 = baoliyouhua(arr,aim);
		System.out.println(num2);
	}

	//�Ż��������
	private int baoliyouhua(int[] arr, int aim) {
		if (arr == null || arr.length == 0 || aim <= 0) {
			return 0;
		}
		return baoliyouhuaPartion(arr,0,aim);
	}

	//�����������Ż��������
	private int baoliyouhuaPartion(int[] arr, int index, int arm) {
		//����һ�������ڻ����map�ṹ����keyΪ:index_aim ��valueΪindex�����aim�ķ�����
		Map<String, Integer> map = new HashMap<String, Integer>();
		//���巵�ؽ��
		int res = 0; 
		if (index == arr.length) {
			return res = arm == 0 ? 1 : 0;
		}
		int count = arm/arr[index];
		for (int i = 0; i <= count; i++) { 
			//���μ����һ��λ��Ϊ��ֵͬʱ���صķ������ĺ�
			String key = String.valueOf(index+1)
					+"_"+String.valueOf(arm - arr[index] * i);
			if(map.containsKey(key)){
				res += map.get(key);
			} else{
				res += baoliyouhuaPartion(arr, index + 1, arm - arr[index] * i);
				map.put(key, res);
			}
		}
		return res;
	}
}