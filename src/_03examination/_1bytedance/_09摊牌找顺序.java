package _03examination._1bytedance;
import java.util.LinkedList;
import java.util.Scanner;
/*
 * ��Ŀ:��������һ���˿��ƣ� ���ǹ��ڲ�֪������˳��
	1����һ���� �Ҵ��ƶ��ó�һ���ƣ� �ŵ������ϡ�
	2���ڶ����� �Ҵ��ƶ�����һ���ƣ� ���������Ƶĵײ���
	3���������� �ظ���һ�����ڶ����Ĳ����� ֱ�����������е��ƶ��ŵ��������ϡ�
	��� ���ڿ��Կ����������Ƶ�˳���ǣ�(�Ƶײ���1,2,3,4,5,6,7,8,9,10,11,12,13(�ƶ�����
	���ʣ� �Ҹտ�ʼ����������Ƶ�˳����ʲô��
 * 
 */

public class _09̯����˳�� {
 
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        String[] str = line.split(",");
        int[] nums = new int[str.length];
        for(int i=0;i<str.length;i++)
            nums[i]=Integer.parseInt(str[i]);
        sort(nums);
    }
 
    public static void sort2(int[] pokers) {
        // �����������, �����е��Ʒŵ�������
        // ��һ���ȴ���һ������
        LinkedList<Integer> pokerList = new LinkedList<Integer>();
        for (int poker : pokers) {
            pokerList.add(poker);
        }
        //����һ���µ������������������������
        LinkedList<Integer> newPokers2 = new LinkedList<Integer>();
        for (int i = 0; i < pokers.length; i++) {
            //�������еĵ�һ�ŷ���������
            newPokers2.add(pokerList.pollFirst());
            //�����������һ��ѭ�������Ѿ�û���˾Ͳ���Ҫ��������ж���
            if (pokerList.size() > 0) {
                //����һ�ŷ����ƶѵ����
                pokerList.addLast(pokerList.pollFirst());
            }
        }
        //��ӡ������̨��
		System.out.println(newPokers2);
    }
 
    /**
     * ����Ĳ����Ǵ����Ӱ����ûص�����
     * ������ �� ���� int[] t = {13,12,11,10,9,8,7,6,5,4,3,2,1};
     * ���� {1,12,2,8,3,11,4,9,5,13,6,10,7}
     *
     * @param pokers
     */
    public static void sort(int[] pokers) {
        // �������, �������ϵ��Ʊ䵽����
        // ����һ���������Ϊ����
        LinkedList<Integer> pokerList = new LinkedList<Integer>();
        for (int poker : pokers) {
            pokerList.add(poker);
        }
        //����һ��Ŀ��������������
        LinkedList<Integer> newPokers2 = new LinkedList<Integer>();
        for (Integer aPoker : pokerList) {
            //�ж����ϵ����Ƿ����1��
            if (newPokers2.size() > 1) {
                //�������һ�ţ�������Ƶ����һ�ŷ���������
                newPokers2.addFirst(newPokers2.pollLast());
            }
            //����������һ���Ʒ�������
            newPokers2.addFirst(aPoker);
        }
        //��ӡ������̨��
        System.out.println(newPokers2);
    }
 
}

