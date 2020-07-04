package _02�����㷨._07�ݹ�;


/**
* �ݹ������
 * ��Ŀ������һ����˾�����¼���ϵ��һ�ö�����������˾Ҫ�ٰ���ᣬ
	  	����Ϊ��֯���Ѿ������˴�ҵ�����һ��Ա����ֱ���ϼ�������������Ա���϶���������
	  	ÿ��Ա������һ����Ծ�ȵ�ֵ������˭���������Ա�������뺯����ô�������������Ծ��
	  	�������Ļ�Ծֵ��
 * ���磺����һ���������������ֹ�ϵ
		matrix = {
			1,6
			1,5
			1,4
		}
	�������ĺ����ǣ�
	matrix[0] = {1,6}����ʾ0���Ա����ֱ���ϼ�Ϊ1,0���Ա���Լ��Ļ�Ծ��Ϊ6
	matrix[1] = {1,5}����ʾ1���Ա����ֱ���ϼ�Ϊ1�����Լ��������˾�����boss����1���Ա���Լ��Ļ�Ծ��Ϊ5
	matrix[2] = {1,4}����ʾ2���Ա����ֱ���ϼ�Ϊ1��2���Ա���Լ��Ļ�Ծ��Ϊ4
	Ϊ��������Ծ�����Ӧ����1������0��2������󷵻ػ�Ծ��Ϊ10.
˼·�������������ζ�̬�滮���赱ǰ�ڵ�Ϊx�����������ֿ����ԣ�
	������1��x������������x�����ӽڵ�(x1��x2��x3)�����Ļ�Ծ�� + x�Ļ�Ծ��
	������2��x��������������Math.max(x����һ�ӽڵ�x1���Ļ�Ծ�ȣ�x����һ�ӽڵ�x1�����Ļ�Ծ��)
			+Math.max(x����һ�ӽڵ�x2���Ļ�Ծ�ȣ�x����һ�ӽڵ�x2�����Ļ�Ծ��)
			+Math.max(x����һ�ӽڵ�x3���Ļ�Ծ�ȣ�x����һ�ӽڵ�x3�����Ļ�Ծ��)
		Ҳ����˵���κ�һ�����ȡ����Կ���һ�־��ߣ���ô״̬������ĳ����ȡ��ʱ����߲�ȡ��ʱ��
		����Ϊ�����������е�����Ծ��ֵ���ֱ������f[i,1]��f[i,0]��ʾ��i�������Ͳ�����
	��i����ʱ��dp[i][1] += dp[j][0];//jΪi������
	��i������ʱ��dp[i][0] +=max(dp[j][1],dp[j][0]);//jΪi������	

 */
public class _07����_��˾����Ծ�� {
	
	public static void main(String[] args) {
        int[][] matrix = {{1, 6}, {1, 5}, {1, 4}};
        System.out.println(maxHappy(matrix));
    }

    public static int maxHappy(int[][] matrix) {
        int[][] dp = new int[matrix.length][2];
        boolean[] visited = new boolean[matrix.length];
        int root = 0;
        for (int i = 0; i < matrix.length; i++) {
            if (i == matrix[i][0]) {
                root = i;
            }
        }
        process(matrix, dp, visited, root);
        return Math.max(dp[root][0], dp[root][1]);
    }

    public static void process(int[][] matrix, int[][] dp, boolean[] visited, int root) {
        visited[root] = true;
        dp[root][1] = matrix[root][1];
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0] == root && !visited[i]) {
                process(matrix, dp, visited, i);
                dp[root][1] += dp[i][0];
                dp[root][0] += Math.max(dp[i][1], dp[i][0]);
            }
        }
    }
}

