package _1bytedance;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class _06����ֽ����Ϸ {
	public static void main(String[] args) {
		
//		Scanner sc = new Scanner(System.in); //�ȴ�������Ϣ
//		//1.��ȡһ�е��ַ���
//        String line1 = sc.nextLine();
//        String line2 = sc.nextLine();
//        //2.���ַ����и���ַ�����
//        String[] sArr1 = line1.split(" ");
//        String[] sArr2 = line2.split(" ");
//        //3.����int����,���ַ�����ת�ʹ�ŵ�int������
//        int[] arr1 = new int[sArr1.length];
//        int[] arr2 = new int[sArr2.length];
//        for (int i = 0; i < arr1.length; i++) {
//        	arr1[i] = Integer.parseInt(sArr1[i]); // �������ַ���ת��������
//        	arr2[i] = Integer.parseInt(sArr2[i]); // �������ַ���ת��������
//        }
		int[] arr1 = {1,1,5};
		int[] arr2 = {6,10,1};
        parttion(arr1,arr2);
	}
	private static void parttion(int[] arr1, int[] arr2) {
		//arr1-->byte     arr2-->dance
		//�����˵ĸ���
		int byteNum = 0;	
		int danceNum = 0;  
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < arr1.length; i++) {
			if(HasNum(list,arr1[i])==-1){ //�ж϶������Ƿ���,û�з���-1,���򷵻ؾ���ͷ���ĸ���
				list.add(arr1[i]);
			}else { 	//������Щ��
				int num1 = HasNum(list,arr2[i]);
				byteNum += num1+1;
				int tem = list.size();
				for (int j = 0; j < num1; j++) {
					list.remove(tem -1 -j);
				}
			}
			
			if(HasNum(list,arr2[i])==-1){     //�ж϶������Ƿ���,û�з���-1,���򷵻ؾ���ͷ���ĸ���
				list.add(arr2[i]);
			}else { //������Щ��
				int num2 = HasNum(list,arr2[i]);
				danceNum += num2+1;
				int tem = list.size();
				for (int j = 0; j <num2 ; j++) {
					list.remove(tem -1 -j);
				}
			}
		}
//		System.out.println("Byte-->" +byteNum);
//		System.out.println("Dance-->" +danceNum);
		if (byteNum == danceNum) {
			System.out.println("Draw");
			return;
		} else if(byteNum > danceNum){
			System.out.println("Byte");
			return;
		} else {
			System.out.println("Dance");
		}
	}
	//���list�а���i�򷵻�,���ľ��붷�ڵ��λ��,���򷵻�-1
	private static int HasNum(List<Integer> list, int i) {
		if (!list.contains(i)) {
			return -1;
		}
		int j = 0;
		while(list.get(j) != i){
			j++;
		}
		return list.size()-j;
	}
}
