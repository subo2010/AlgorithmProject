package _03examination._0niuke;
import java.util.Scanner;

/*
 * ����������Ϣ,�ÿո���� ---> 5 4 1 1
 * ����ÿ��һ����
			 * 1
			 * 2
			 * 3
 * ������ת����int�浽������
 */
public class _1����������_�ո� {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); //�ȴ�������Ϣ
		
		while(sc.hasNextInt()){  	//���滹��û��int��
			int i = sc.nextInt(); 	//��ȡ��һ��int��(֮���ÿո�����Ʊ������)
			System.out.print(i + " ");
		}
	}
}
