package _03examination._1bytedance;
/*
 * ��Ŀ:������ֽ�����𳵵���Ϸ.���Ը��������˵���,�ŵ�������,Ӯ���Ʒŵ�һ��,�������˵����ƶ�û��ʱ
 * 		���Ǹ���Ӯ���ƶ�,�������˵�����
 */
import java.util.ArrayList;
import java.util.List;

public class _06����ֽ����Ϸ {
	public static void main(String[] args) {
		int[] arr1 = {1,3,6,2,5,7,8,1};   //Byte������
		int[] arr2 = {6,7,3,2,5,6,9,1};	//Dance������
        parttion(arr1,arr2);
	}
	
	private static void parttion(int[] arr1, int[] arr2) {
		//arr1-->Byte     arr2-->Dance
		//�����˵ĸ���
		int byteNum = 0;	
		int danceNum = 0;  
		//����ʢ��ֽ�ƵĶ���
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < arr1.length; i++) {
			//�ж϶������Ƿ��и���,û�з���-1,���򷵻�Ӧ��ɾ���ĸ���
			int num1 = HasNum(list,arr1[i]);
			if(num1 == -1){ 	//û�д���,�ӽ�ȥ
				list.add(arr1[i]);
			}else { 			//��������,�������������,������
				byteNum += num1+1;
				int tem = list.size();
				for (int j = 0; j < num1; j++) {
					list.remove(tem -1 - j);
				}
			}
			
			//�ֵ�Dance����-->ͬ��
			int num2 = HasNum(list,arr2[i]);
			if(num2 == -1){     
				list.add(arr2[i]);
			}else { 
				danceNum += num2+1;
				int tem = list.size();
				for (int j = 0; j <num2 ; j++) {
					list.remove(tem -1 - j);
				}
			}
		}
		System.out.println("Byte-->" + byteNum);
		System.out.println("Dance-->" + danceNum);
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
		return list.size() - j;
	}
}
