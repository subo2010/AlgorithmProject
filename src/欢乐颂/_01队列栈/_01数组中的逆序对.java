package ������._01����ջ;

import org.junit.Test;

/**
 * ��Ŀ����:��һ�������������������������飬��ǰ��һ�����ں���һ�����֣����������������һ������ԡ������һ����Ч���㷨��
 * ������������е�����Ը�����
 * ��������:����һ��int����A�����Ĵ�Сn���뷵��A�е�����Ը�������֤nС�ڵ���5000
 * 
 * ����������
   [1,2,3,4,5,6,7,0],8
       ���أ�7
 * @author Administrator
 */

public class _01�����е������ {
	
	@Test
	public  void main() {
		int[] arr = {1,2,3,4,5,6,7,0};
		System.out.println(count(arr, arr.length));
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]+" ");
			String si = "";
		}
	}
    
	 public  int count(int[] arr, int n) {
		//������С�ڵ���1�򲻴��������
    	if(arr == null || arr.length < 2){
    		return 0;
		}
		return merge(arr,0,arr.length-1);
	 }
	
	//���ù鲢����˼·�ڽ������
    public  int merge(int[] arr,int left,int right) {
    	
    	//�ݹ�Ľ�ֹ����
        if(left == right) {
            return 0;
        }
        
      //��ȡ�м��
        int mid = left + ((right - left) >> 1);
        
//        merge(arr,left,mid);
//        merge(arr,mid+1,right);
        
        return	merge(arr,left,mid) + merge(arr,mid+1,right) + mergerSort(arr,left,mid,right) ;
    }
    
    public  int mergerSort(int[] arr,int left,int mid,int right){
    	
    	//������������
        int[] help = new int[right - left + 1];
        
        int i = 0;
        int p1 = left;
        int p2 = mid+1;
        int result = 0;
        //������������ֺϲ�Ϊ�����һ���ִ洢��result��
        while (p1 <= mid && p2 <= right){
        	//***�ص�***�������ַֿ�����.���������ֶ����ɴ��С�����,�������һ����A���������һ����Bʱ
            //����һ������B�����������,Ҳ����˵B���������B������A��������
        	result += (arr[p1] > arr[p2] ? right-p2+1 : 0);
            help[i++] = (arr[p1] > arr[p2] ? arr[p1++] : arr[p2++]);
        }
        //��������һ����ͷʱ����һ��ֱ�Ӹ��Ƶ�result��
        while (p1 <= mid){
             help[i++] = arr[p1++];
        }
        while (p2 <= right){
             help[i++] = arr[p2++];
        }
      //���ⲿ���������洢��arr������λ��
        for (int j = 0; j < help.length; j++) {
			arr[j+left] = help[j];
		}
        return result;
    }
}
