package _1bytedance;

import java.util.ArrayList;
import java.util.LinkedList;
/*
 * ��Ŀ:����һ����num��2��,ÿ��һ����,��һ������num
 * 		��������num�к������
 * 		���һ�е�������,����������num���еĵڼ�����(����������)
 * 
 * ˼·:����Ч���ŵ�һ����������,Ȼ���ó��ڼ���
 */
public class _03���뵥�����յ�Ϊk�Ľڵ� {

	public static void main(String[] args) {

		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);	
		int num = 2;
		printIndexNum(list,num);
	}

	public static void printIndexNum(ArrayList<Integer> list, int num) {
		//basecase
		if (num >= list.size() || num < 0) {
			System.out.println("null");
			return;
		}
		System.out.println(list.get(list.size() - 1 -num));
	}
}
