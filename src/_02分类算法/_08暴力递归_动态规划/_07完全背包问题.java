package _02�����㷨._08�����ݹ�_��̬�滮;
import org.junit.Test;
/*
 * ��Ŀ:��N����Ʒ��һ������Ϊcap�ı�����ÿ����Ʒ�������޼����á�
 * 		��i����Ʒ��������wight[i]����ֵ��value[i]��
 * 		��⽫��Щ��Ʒװ�뱳����ʹ��Щ��Ʒ�ķ����ܺͲ����������������Ҽ�ֵ�ܺ����
 * 
 * ˼·��֮ǰд��01�������⣬����д��ȫ�������⡣��01������ͬ���ǣ���ȫ�������޶�ĳ����Ʒ�ļ�����
 * 		����װ0,1,2��...����01����ֻ��װ�벻װ�����𡣵���˼������ķ�ʽ����һ����
 */
public class _07��ȫ�������� {
	@Test
	public void main() {
		int cap = 10 ; 			//����������
		int[] wight = {5,3,4};	//ÿ����Ʒ������
		int[] value = {20,10,12}; //ÿ����Ʒ�ļ�ֵ
		int maxValue = partion(cap,wight,value);  //�������ļ�ֵ
		System.out.println(maxValue);  //��ȷΪ40
	}

	//��ȫ������
	private int partion(int cap, int[] wight, int[] value) {
		//basecase
		if(cap <= 0 || wight.length != value.length || wight.length == 0) return 0;
		//����һ��dp����,dp[x][y]  ����ǰx����Ʒ,�ڱ������Ϊyʱ,������ֵ
		int[][] dp = new int[wight.length+1][cap+1];
		//��ʼ������֪���������ݻ�Ϊ0����0����Ʒʱ��ֵΪ0-->�ͳ�ʼ��ֵ��ͬ,��˾Ͳ��ٸ�ֵ
		//dp[0][x] = dp[0][y] = 0;
		
		for (int x = 1; x < dp.length; x++) {
			for (int y = 1; y < dp[0].length; y++) {
				//��01����������������01����ֻ������״̬�����벻��
				//����ȫ�������Է�0��k����Ʒi��ͬ����ȡ���ֵ
				int count = y/wight[x-1]; //**�˱�������ʢ�Ŷ��ٸ���x����Ʒ
				for (int i = 0; i <= count; i++) { //�ӷ�0������count��,�ó�����
					dp[x][y] = Math.max(dp[x-1][y], 
							dp[x-1][y - i * wight[x-1]] + i * value[x-1]);
				}
			}
		}
		return dp[wight.length][cap];
	}
}
