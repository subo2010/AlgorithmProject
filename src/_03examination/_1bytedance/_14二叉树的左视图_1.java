package _03examination._1bytedance;

import java.util.Scanner;

/*
 *��Ŀ: �������Ľڵ㰴�մ��ϵ��£������ң���1��ʼ��ţ����п��ŵĽڵ��á�#����ʾ�������������ͼ���磺
		���룺1 2 3 # 4 5 6 # # # # 7 8
		�����1 2 4 7
 * ˼·:����ͼ����:��ӡÿһ��ĵ�һ���ڵ�
 */
public class _14������������ͼ_1 {
	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int i= 0;  //��ǰ���ٲ�
        int j = 0; //��ǰ��ĵڼ����ڵ�
        boolean flag = true; //�Ƿ�Ϊ����ĵ�һ���ڵ�

        while(in.hasNext()) {
            i = i+1;
            j = 1;
            flag = true; //Ĭ���ǵ�һ���ڵ�
            //ִ�е�i��ı���
            while(j <= Math.pow(2,i-1)) { //pow(2,i-1)��i��Ľڵ����
                if(!in.hasNext()){ //û��Ԫ����
                	return;  	//����˲��ȡ����ĩβ,��ֱ�ӽ���
                } else{		//�нڵ�Ļ��ж��ǲ��ǵ�һ���ڵ�
                	String str = in.next(); //��ȡ�ڵ�
                	if(flag == true && !str.equals("#")){ //����ǵ�һ���ǿսڵ������
                		System.out.print(str + " ");
                		flag = false;
                	}
                	j++;
                }
            }
        }
    }
}
