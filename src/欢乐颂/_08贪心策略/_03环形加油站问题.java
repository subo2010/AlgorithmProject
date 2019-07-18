package ������._08̰�Ĳ���;

import org.junit.Test;

/*
 * ��Ŀ:��֪ÿ������վ�ܼӵ�����gas[i]�����е�i������վ��i+1��վ����Ҫ����cost[i]�����͡� 
 * 		�����ʼ����Ϊ�գ��������������ޣ�����ĸ�վ�㿪ʼ��������һȦ�������ڷ���-1
 * 
 * ˼·:�����������ص��㷨������ÿ���㣬���gas[i] �C cost[i] >=0����ô�Ըõ�xΪ��㣬����жϡ�
 * ·;������������Ϊ����˵������㲻�ԡ� ���x +1�ظ����̡�����
������Ȼ���Ӷ�Ϊo(n^2)��������������أ�

����Ĺ������������ʱ��ֱ�ӽ�����+1�����ǳ�ʼ������һ���� 
����˵������abcdefg ��ô�������վ��aΪһ��ʼ��վ�㣬������d���ֲ����ˡ����Ŵ�b��ʼ��
Ȼ����û�б�Ҫ�� ��Ϊ�ڹ����У��У�
	gas[a] �C cost[a] >=0 ������ö�ٵ�������
	gas[a] �C cost[a] + gas[b] �C cost[b] >=0
	gas[a] �C cost[a] + gas[b] �C cost[b]  + gas[c] �C cost[c] >=0
	gas[a] �C cost[a] + gas[b] �C cost[b]  + gas[c] �C cost[c]  + gas[d] �C cost[d] < 0
	��d֮ǰ��ÿһ�����ǲ�С��0�ġ�Ȼ�����ǵ��ۼӹ�����d���վ�㣬Ҳ����˵��abc�������ǽ⡣
	����0���������ȥ���������˺ο����ӣ���dҲ�����ǽ⣬��Ϊ��Ȼ��gas[d] �C cost[d] < 0
	��˽�������e��ʼ��á�
 */
public class _03���μ���վ���� {
	
	@Test
	public void main() {
		int[] gas =  {1,2,3,4,5};
		int[] cost = {3,4,5,1,2};
		int i = canCompleteCircuit(gas, cost); //��ȷ4  Ҳ�����±�Ϊ3�ļ���վ
		System.out.println(i);
	}
	public int canCompleteCircuit(int[] gas, int[] cost) {
		//basecase
        if(gas == null||gas.length == 0){
            return -1;
        }
        int start = 0; //��ʼ��λ��
        int remain = 0; //ÿ��ʣ�������
        int total = 0;  //��ͷ��ʼ�ܵ�������ȥ�ܵ�����
        for(int i = 0; i < gas.length; ++i){
        	total += gas[i] - cost[i];
            remain += gas[i] - cost[i];
            if(remain < 0){
                remain = 0;
                start = i + 1; //����һ��վ�㿪ʼ
            }
        }
        return total < 0 ? -1 : start;
    }
}
