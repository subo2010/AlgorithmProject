package ��ָoffer;

import org.junit.Test;

/*
 * ��Ŀ:��ֻ����������2��3��5��������������Ugly Number����
 * 		����6��8���ǳ�������14���ǣ���Ϊ������������7�� 
 * 		ϰ�������ǰ�1�����ǵ�һ��������
 * 		�󰴴�С�����˳��ĵ�N��������
 * 
 * ˼·1(������):��ν�ĳ�����ֻ�ܹ���2 3 5��Ϊ���ӵ���,���Զ���һ���������ϳ���2,���ϳ���3,���ϳ���5�Ժ�һ��Ϊ1,
 * 		����ͨ����һ�����жϴ����ǲ��ǳ���,���������ж�ĳһ�����ǲ��ǳ���.
 */
public class _34���� {
	
	@Test
	public void main() {
		int num = GetUglyNumber_Solution(5); //��ȡ��3������
		System.out.println(num);
	}
	
	
	//������
	public int GetUglyNumber_Solution(int size) {
		if (size < 0) {
			throw new RuntimeException("��������");
		}
		if(size == 1){
			return 1;
		}
		int index = 2; 	//�ڶ���������ʼ��
		int num = 2;	//��2��ʼ�ж�
		while (index != size) {
			if (isChoushu(num)) {
				index++; 
			}
			num++;
		}
        return num;
    }
	
	public boolean isChoushu(int num){
		//ֻҪ�������ͽ��г�������
		while(num % 2 == 0) num = num/2;
		while(num % 3 == 0) num = num/3;
		while(num % 5 == 0) num = num/5;
		//������Ϊ1,˵���ǳ���
		return num == 1;
	}
}
