package ������._08�����ݹ�_��̬�滮;
/*
 * ��Ŀ:������һ������,Ȼ������������������������еĳ���
 * 
 * ˼·:DP�ⷨ,����һ��dp[]����  ����dp[i]�������±�Ϊi��Ԫ�ؽ�β������������еĸ���
 * 		1.dp[i] = 1,��Ϊ�Ե�һ�����ֽ�β��������ֻ��һ��-->�˴�Ĭ���κ��������ֽ�β�ĳ��ȶ�Ϊ1
 * 		2.dp[i] Ϊһ�±�Ϊi��β�ĵ��������г���,�����ͨ���ҵ�iǰ��,������arr[j] < arr[i]��j,Ȼ������dp[j]��1�õ�dp[i]
 * 		3.���������Ϊ,�����ҵ�iָ��Ԫ��֮ǰ,��iԪ��С,����������.��1
 * 		4.��������ÿ���ַ���β����ĵ�������
 */
public class _10�����������_dp {
		  
	public static void main(String [] args){
		int [] randArr = new int[]{5,2,8,6,3,6,9,7};
		int len = maxAscLen(randArr);
		System.out.println(len);
	}
	
    public static int maxAscLen(int [] arr){
    	//basecase
    	if (arr == null || arr.length == 0) {
			return 0;
		}
    	//����dp����  dp[i]�������±�Ϊi��Ԫ�ؽ�β������������еĸ���
    	int[] dp = new int[arr.length];
    	//��ʼ��ÿ��Ԫ�ؽ�β��Ĭ��ֻ��һ��
    	for (int i = 0; i < dp.length; i++) {
    		dp[i] = 1;
		}
    	for (int i = 1; i < dp.length; i++) {
    		for (int j = 0; j < i; j++) { //����i��ǰ,����arr[j]<arr[i],��jԪ����dp[j]����
    			if (arr[j] < arr[i]) {
    				dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
		}
    	//�ҵ����
    	int ret = 1;//��СΪ1
    	for (int i : dp) {
			ret = Math.max(ret, i);
		}
        return ret;
    }
}
