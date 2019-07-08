package _1bytedance;

import com.sun.org.apache.regexp.internal.recompile;

/*
 * ��Ŀ:��˾����������Ϊ2012��3��12��,������һ������,���ع�˾�����˶�����
 * 
 * ����:2012 3 13    -->  1��
 *     2019 3 12   -->  2556��
 * 
 */
public class _07��������� {

	public static void main(String[] args) {
		
		String date = "2019 3 13"; //���������
		String[] dateStr = date.split(" +");
		int[] dateArr = new int[3];
		dateArr[0] = Integer.parseInt(dateStr[0]);
		dateArr[1] = Integer.parseInt(dateStr[1]);
		dateArr[2] = Integer.parseInt(dateStr[2]);
		int num = parttion(dateArr); //���뵱ǰ���ڷ��س�������(�������ڳ�ǰ����-1)
		System.out.println(num);
	}

	private static int parttion(int[] dateArr) {
		//basecase  ��С�ڵ��޳�����-1
		if (dateArr[0] < 2012 || (dateArr[0] == 2012 && dateArr[1] < 3) 
				|| (dateArr[0] == 2012 && dateArr[1] == 3 && dateArr[2] < 12)) {
			return -1;
		} 
		int[] arr = {2012,3,12}; //��������
		int[] Mday_notR = {31,28,31,30,31,30,31,31,30,31,30,31};
		int[] Mday_R = {31,29,31,30,31,30,31,31,30,31,30,31};
		int count1 = 72; //2012���ĵ�72��
		int count2  = 0; //������˶�����
		for (int i = 0; i < dateArr[1]-1; i++) {
			if (dateArr[0] % 4 == 0) {
				count2 += Mday_R[i];
			} else {
				count2 += Mday_notR[i];
			}
		}
		count2 += dateArr[2];
		//getDay()��ǰ�������2012���������
		int count3 = getDay(dateArr[0]) + count2; //count3Ϊ����2012�����������
		return count3 - count1;
	}
	//����һ������,����ӭԪ��ʱ����2012�������
	private static int getDay(int year) {
		int tem = year - 2012; //����
		if (tem == 0) {
			return 0;
		}else {
			int i = (int)Math.ceil(tem/4); //Ϊ����ĸ���
			return i * 366 + (tem - i) * 365 + 1;
		}
	}
}
