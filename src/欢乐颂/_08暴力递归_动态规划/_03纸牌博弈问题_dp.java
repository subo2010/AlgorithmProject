package ������._08�����ݹ�_��̬�滮;
import org.junit.Test;
/*
 * ��Ŀ:����һ����������arr��������ֵ��ͬ��ֽ���ų�һ���ߡ����A�����B��������ÿ��ֽ�ƣ�
 * �涨���A���ã����B���ã�����ÿ�����ÿ��ֻ��������������ҵ�ֽ�ƣ����A�����B������������
 * �뷵������ʤ�ߵķ�����
��̬�滮:��2����ͬ�ĵݹ麯������Ҫ���ű�ÿһ�ű���Ҫ2��������i��j
	1.i�϶��������j���°�����ֱ�Ӳ�������ȿ�Ŀ��λ�ã������ǵĵط�����Ȼ�����ϲ�������ֵ���ӵݹ��п��� i==j��ʱ�򣬿���ֱ�ӵó������
		�ڱ�����д�϶�Ӧ��ֵ
	2.�鿴�ձ�λ������ô������
		f(i,j)��s��s(i+1,j)��s(i,j-1)�й�
		s(i,j)��f��f(i+1,j)��f(i,j-1)�й�
 */
public class _03ֽ�Ʋ�������_dp {
	@Test
	public void main(){
		int[] arr = {1,2,100,4};
		int print2= getWinPoint_dp(arr);
		System.out.println(print2);
	}
	//��̬�滮�ⷨ
	private int getWinPoint_dp(int[] arr) {
		if (arr == null || arr.length == 0) {
            return 0;
        }
		//frist[x][y] ��ָ���±�Ϊx���±�Ϊy,���õ���,���Եõ������ֵ
        int[][] frist = new int[arr.length][arr.length];
        int[][] second = new int[arr.length][arr.length];
        //��ʼ��f��ĶԽ���(��ֻ��һ��Ǯ��ʱ��,�϶����õ���)
        for (int i = 0; i < second.length; i++) {
        	frist[i][i] = arr[i];
        	//second[j][j] = 0; ���ʼ�����
		}
        for (int j = 0; j < arr.length; j++) { //�������ұ߽�
            //����i��j�Ĺ�ϵ������ÿһ�е�iȻ��������ϼ���i(��������dp������)
            for (int i = j - 1; i >= 0; i--) { //��߽���ұ߽�������չ
                frist[i][j] = Math.max(arr[i] + second[i + 1][j], arr[j] + second[i][j - 1]);
                second[i][j] = Math.min(frist[i + 1][j], frist[i][j - 1]);
            }
        }
        return Math.max(frist[0][arr.length - 1], second[0][arr.length - 1]);
	}
}