package _02�����㷨._09���������㷨;

import java.util.LinkedList;

import org.junit.Test;

/**
 * ��Ŀ����:���ֵ��ȥ��СֵС�ڻ����num������������
 *   ��������arr������num, �������ж��ٸ������������������:
 *   max(arr[i...j])-min(arr[i...j]) <= num
 *   max(arr[i...j])��ʾ������arr[i...j]�е����ֵ,
 *   min(arr[i...j])��ʾ������arr[i...j]�е���Сֵ,
 *   
 *   Ҫ��:�������ĳ���ΪN,������ʱ�临�Ӷ�ΪN���㷨
 * 
 * ˼·:
 * �����ⷢ:ʱ�临�Ӷ�ΪO(N^3)
 * 	ͨ��ð���㷨����ѡ�������㷨���Խ��������������������ó�
 * 	���������ÿ��������ó����ֵ����Сֵ(���߲�������ֻ�õ����ֵ����Сֵͨ������Integer.min��ʵ��O(n))
 * 	Ȼ������������жϼ������Ƿ��1
 * 
 * ���û�����������:������ʱ�临�Ӷ�ΪO(N)  --> ˫�˶���,��С����
 * 	������max(arr[i...j])-min(arr[i...j]) <= num��֮Ϊ���
 *  i��j��λ�ô��,��i��j���Ӵ�һ�������(��i��j�ڲ������ж϶����)
 *  i��j��λ�ò����,�����i��j���Ӵ�һ���������(��i��j�ⲿ�����ж϶������)
 *  ���û�������(���ڵ����ΪL ����ΪR)��������±�Ϊ0��λ��R����������,����˵
 *  L��R��λ��ֵ����굱rָ��pλ��ʱ��һ�β����,���ǿ��Եó���0�±꿪ͷ���Ӵ�����
 *  ����Ϊp,Ȼ��L�����ƶ�һ�������ж�1С��Ŷλ����ͷ���ĸ���,����ѭ��,֪��L��������.���жϳ���
 *  ��ÿһ��Ԫ�ؿ�ͷ���Ӵ���Ӧ�Ĵ�����,���������Ļ��͵õ���result
 *  ����:��Ϊ�������̾����������ڻ�������Ĺ���,���ʱ�临�Ӷ�ΪO(n)
 *  
 * @author Administrator
 */
public class _08��������֮Ӧ�����������ֵ����Сֵ {
	
	@Test
	public void main() {
		int[] arr = {3,5,2,6};	//����
		int num = 2; 					//�Ƚ�ֵ�Ĵ�С
		int i = getNum(arr,num);
		System.out.println(i);
		
	}
	
	
	//����һ������,������������������ĸ���
	//����:����������ֵ��ȥ��СֵС�ڵ���num
	private int getNum(int[] arr, int num) {
		if (arr == null || arr.length ==0) {
			return 0;
		}
		//���÷���ֵ
		int result = 0;
		//���ô��ڵ����ұ߽�
		int L = 0;	//������߽�
		int R = 0;	//�����ұ߽�
		//����������������ֵ����Сֵ��˫�˶���///(--->����β������ͷ��ȡ��)
		LinkedList<Integer> maxNum = new LinkedList<Integer>();
		LinkedList<Integer> minNum = new LinkedList<Integer>();
		//L�ӵ�һ��λ�õ�������һ��λ��(ÿһ��ѭ���õ���ǰλ�ÿ�ͷ���Ӵ����ж��ٴ��)
		while(L < arr.length){
			//�����Ҷ˿�ʼ�����ƶ�˫�˶��п�ʼ��Ԫ��(ֱ��R�ߵ������Ҳ���������˵�һ���������������Ӵ�)
			while(R < arr.length){
				//���ֵջ����Ӳ���
				while(!maxNum.isEmpty() && arr[maxNum.peekLast()] <= arr[R]){
					maxNum.pollLast();
				}
				maxNum.addLast(R);
				while(!minNum.isEmpty() && arr[minNum.peekLast()] >= arr[R]){
					minNum.pollLast();
				}
				minNum.addLast(R);
				if (arr[maxNum.peekFirst()]-arr[minNum.peekFirst()] > num) {
					break;
				}
				//R�����ƶ�һ��
				R++;
			}
			//�õ���ǰLλ�ÿ�ͷ���Ӵ��з���������
			result += R - L;
			
			//��������
			if (maxNum.peekFirst()==L) {
				maxNum.pollFirst();
			}
			if (minNum.peekFirst()==L) {
				minNum.pollFirst();
			}
			L++;
		}
		return result;
	}
	


}
