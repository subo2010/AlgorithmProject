package _0niuke;
import java.util.Scanner;

/*
 * ����������Ϣ,�ö��Ÿ��� ---> 5,4,1,1
 * ������ת����int�浽������
 */
public class _1����������_���� {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); //�ȴ�������Ϣ
		//1.��ȡһ�е��ַ���
        String line = sc.nextLine();
        //2.���ַ����и���ַ�����
        String[] sArr = line.split(",");
        //3.����int����,���ַ�����ת�ʹ�ŵ�int������
        int[] arr = new int[sArr.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(sArr[i]); // �������ַ���ת��������
            System.out.print(arr[i] + " ");
        }
	}
}
