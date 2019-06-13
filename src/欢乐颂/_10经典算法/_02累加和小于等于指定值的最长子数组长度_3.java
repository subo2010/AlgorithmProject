package ������._10�����㷨;
import java.util.Map;
import java.util.TreeMap;
import org.junit.Test;

/*
 * ��Ŀ:������һ��int���͵�����,��һ��armֵ.��������������������С�ڵ���arm�����������ĳ���.
 * ����:int arr = {7,3,2,1,1,7,7,7}  int arm = 7				
 * ��Ϊ��Ϊ7���������Ϊ{3,2,1,1},�򷵻ص� 4
 * 
 * ������˼·:�������������,�ֱ����ÿ��������ĺ�ʱ�Ƿ�Ϊarm,Ȼ���ڱ���һ����󳤶Ƚ��з���
 * 
 * ����˼·:˵�ع�����������min_sum[]��min_sun_index[]���ȶ�Ϊarr.length
 * 		min_sum[i] ����ӵ�i��λ�ÿ�ʼ�������ܼӳ�����С�ۼӺ�
 * 		min_sun_index[i] ����ӵ�i��λ�ÿ�ʼ�������ܼӳ�����С�ۼӺ͵����һλ���±�(�൱��С�͵��ұ߽�)
 * 		�������������ʱ���ǴӺ���ǰ��,O(n)��ʱ�临�Ӷ�
 * ����:       arr = {1,-3,4,-5,7,3,-6,9}
 * 	      min_sum = {-3,-4,-1,-5,4,-3,-6,9}
 * 	min_sun_index = {3,3,3,3,6,6,6,7}
 * 
 * �������0��ʼ��������ʱ,���õ���0λ��Ԫ�ؿ�ͷ����С�ۼӺ�sum1,���С��aim,���ó�min_sun_index[0]+1λ�ô�����С�ۼӺ�sum2
 * 		���sum1+sum2����С��arm�ͽ���������,ֱ��sum1+sum2+..����arm,��¼��ʱ���ַ�������,��0��ͷС�ڵ���arm��������鳤��
 * Ȼ���ڼ�����0��ͷ��ʱ����(0--T)(T+1)��Χ�ڼ���(T+1)�Ƿ�������arm
 * ��˽�arr[0]�߳���,����(1--T)ʱ�ܲ��ܽ�(T+1)�ӽ���,�������
 * Ȼ����arr[1]�߳���,����(2--T)ʱ�ܲ��ع���(T+1)�ӽ���....��������      (�����ұ߽粻����)
 */
public class _02�ۼӺ�С�ڵ���ָ��ֵ��������鳤��_3 {
	
	@Test
	public void main() {
		int[] arr = {7,3,2,1,1,7,7,7};
		int arm = 7;
		int len = getMaxLong(arr,arm);
		System.out.println(len);
	}

	//˫ָ��
	private int getMaxLong(int[] arr, int arm) {
		//basecase
		if(arr == null || arr.length == 0 || arm <= 0){
			return 0;
		}
		int[] sums = new int[arr.length]; //��С��
		int[] ends = new int[arr.length]; //�ұ߽�
		sums[arr.length - 1] = arr[arr.length-1];
		ends[arr.length - 1] = arr.length - 1;
		
		//���������������Ϣ
		for (int i = arr.length - 2; i >= 0; i--) {
			if (sums[i + 1] < 0) { //�����һλС��0˵��������ͼ,����չǰ�����С��
				sums[i] = arr[i] + sums[i+1];
				ends[i] = ends[i+1];
			} else {			//�����һλ���ڵ���0,˵��������ͼ,����ǰ��չ,��С��Ϊ�Լ�,�ұ߽�Ϊ�Լ����±�
				sums[i] = arr[i];
				ends[i] = i;
			}
		}
		
		//�ұ߽��ʼλ��
		int R = 0;
		//��ʼ�Ĵ���Ԫ�غ�
		int sum = 0;
		//��ʼ����
		int len = 0; 
		for (int start = 0; start < ends.length; start++) {
			while(R < arr.length && sum +sums[R] <= arm){
				sum += sums[R];
				R = ends[R] + 1;
			}
			sum -= R > start? arr[start] : 0;
			len = Math.max(len, R - start);
			R = Math.max(R, start + 1);
		}
		return len;
	}
}
