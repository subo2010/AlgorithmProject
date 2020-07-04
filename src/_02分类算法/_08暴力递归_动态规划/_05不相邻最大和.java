package _02�����㷨._08�����ݹ�_��̬�滮;
import org.junit.Test;
/*
 * ��Ŀ:��������һ��רҵ��������׼������һ���ִ�ٷ��ݡ�ÿ�����Ӷ�������ض�����Ǯ��
 * 		�����ٵ�ΨһԼ�������ǣ����ڵķ���װ���໥��ϵ�ķ���ϵͳ���� �����ڵ���������ͬһ�챻���ʱ��
 * 		��ϵͳ���Զ�����������һ���Ǹ������б���ʾÿ�������д�ŵ�Ǯ�� ��һ�㣬�������ȥ��٣�
 * 		�������Եõ�����Ǯ �ڲ���������װ�õ�����¡�
 * ����  arrΪ[1, 3, 5, 4, 9]����ô���Ϊ 1 + 5 + 9 = 15
 * 	   arrΪ[5, 1, 3, 11, 7]����ô���Ϊ5 + 11 = 16
 * 
 * ˼·:����һ������p��p[i] ����ӵ�0����i�����ݣ���ٵ�i������Ϊֹ����ý�Ǯ�ܶҲ����˵��i������һ��Ҫ��٣�
 * 		��p[i]�϶�����arr[i] + p[i-2]����arr[i] + p[i-3]�����ֵ����Ϊ���ڵķ��ݲ��ܴ�٣�����p[i-1]�����㡣
 * 		�������ֻҪ����p[arr.length-1]��p[arr.length-2]�ĸ�������ˡ�
 * 		p[arr.length-3]�϶��������ģ���Ϊp[arr.length-3] + arr[arr.length-1]�϶���p[arr.length-3]��
��������ʵ��
 */
public class _05���������� {
	@Test
	public void main() {
		int[] arr = {5, 1, 3, 11, 7};
		int sum = getMaxSum(arr);
		System.out.println(sum);
	}
	
	public static int getMaxSum(int[] arr) {
        if(arr.length == 0) return 0;
        if(arr.length == 1) return arr[0];
        if(arr.length == 2) return Math.max(arr[0], arr[1]);
        if(arr.length == 3) return Math.max(arr[1], arr[0] + arr[2]);
        int[] p = new int[arr.length]; //p[i]����һ����ӡi��ʱ����õ��������
        //��Ϊ�ڷ��ص�ʱ��᷵��,����������нϴ���Ǹ�
        p[0] = arr[0];
        p[1] = arr[1];
        p[2] = arr[0] + arr[2]; 
        for(int i = 3; i < arr.length; i++) {
            p[i] = arr[i] + Math.max(p[i-2], p[i-3]);
        }
        return Math.max(p[arr.length-1],p[arr.length-2]);
    }
}
