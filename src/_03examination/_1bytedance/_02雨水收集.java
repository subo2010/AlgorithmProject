package _03examination._1bytedance;

import org.junit.Test;
/**
 * ��ˮ�ۼ�����
 * ��Ŀ:����һ������,ÿһ�����ִ���һ��ˮ�ӵĸ߶�,������ʱ,ˮ�ӿ����ֻ�������ˮ
 * @author Administrator
 *
 */
public class _02��ˮ�ռ� {
    
	@Test
    public void main() {
//        Scanner sc = new Scanner(System.in);
        //����ĳ���
//        int n = sc.nextInt();
//        int[] arr = new int[n];
//        for(int i = 0; i < n; i++){
//        	arr[i] = sc.nextInt();
//        } 
        int[] arr = {4,0,2,4,3};
        int n = arr.length;
        getyushui(arr,n);
    }
    
    //���÷���������
	private static void getyushui(int[] arr, int n) {
		if (arr==null || arr.length==0 ||arr.length==1 || arr.length==2) {
			System.out.println(0);
		}
		// ����һ������Ϊarrװ��ˮ֮�������
		//�ҵ�ÿ��λ�������Ҳ���ߵĸ߶�,����θߵĸ߶�С������,��Ϊ����,����Ϊ�θߵ�ֵ
		//�½�����
		int[] arr1 = new int[n]; 
		arr1[0] = arr[0];
		arr1[n-1] = arr[n-1];
		for (int i = 1; i < arr.length-1; i++) {
			arr1[i] = getnum(arr,i);
		}
		int sum = 0;
		for (int i = 0; i < arr1.length; i++) {
			sum += arr1[i] - arr[i];
		}
		System.out.println(sum);
	}
	
	private static int getnum(int[] arr, int i) {
		int leftnum = arr[i];
		for (int j = i; j >= 0; j--) {
			leftnum = Math.max(leftnum, arr[j]);
		}
		int rightnum = arr[i];
		for (int j = i; j < arr.length; j++) {
			rightnum = Math.max(rightnum, arr[j]);
		}
		return Math.min(leftnum, rightnum);
	}
}

