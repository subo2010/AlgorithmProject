package _0��������;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class _06�ҳ�һ���ַ����������Ӵ� {
	
	@Test
	public void main() {
		//8888����һ���ַ����������Ӵ�����ɵļ���
		String str = "123456";
		List<String> parList = Participle(str);  //���صļ����а��������е��Ӵ�
		for (int i = 0; i < parList.size(); i++) {
			System.out.print(parList.get(i)+" ");
		}
		System.out.println( );
		
		//8888����һ������,���ش����������������ļ���
		int[] arr = {1,2,3,4,5,6};
		List<int[]> parList1 = Participle1(arr); //���صļ����а���������������
		for (int i = 0; i < parList1.size(); i++) {
			for (int j = 0; j < parList1.get(i).length; j++) {
				System.out.print(parList1.get(i)[j]);
			}
			System.out.print(" ");
		}
		
	}

	

	//����һ���ַ����������Ӵ�����ɵļ���
    public static List<String> Participle(String str){
    	StringBuffer buffer = new StringBuffer(str); //���ڷִʽ�ȡ
    	List<String> reList =new ArrayList<String>();//���طִʽ��
    	
		for(int i = 0;i < buffer.length()-1; i++){		
			for(int j = i+1; j < buffer.length()+1; j++){	//	�˴�j=i+1 ���j=i+2�򲻰�������Ԫ��
				String str12 = buffer.substring(i, j);	//����ҿ�
//				System.out.println(str12); //��ӡ�Ӵ�
				reList.add(str12);
			}
		}
    	return reList;
    }
    
    //����һ������,���ش����������������ļ���
    private List<int[]> Participle1(int[] arr) {
    	List<int[]> reList =new ArrayList<int[]>();//���طִʽ��
    	for(int i = 0;i < arr.length-1; i++){		
			for(int j = i+1; j < arr.length+1; j++){	//	�˴�j=i+1 ���j=i+2�򲻰�������Ԫ��
				//����һ��������
				int[] newarr = new int[j-i];
				for (int k = 0; k < newarr.length; k++) {
					newarr[k] = arr[k+i];
				}
				//����������뼯���з���
				reList.add(newarr);
			}
		}
    	return reList;
	}
}
