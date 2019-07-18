package 欢乐颂._08暴力递归_动态规划;

import org.junit.Test;
/*
 * 题目:话说有一哥们去森林里玩发现了一堆宝石，他数了数，一共有n个。 
 * 	但他身上能装宝石的就只有一个背包，背包的容量为C。
 * 	这哥们把n个宝石排成一排并编上号： 0,1,2,…,n-1。
 * 	第i个宝石对应的体积和价值分别为V[i]和W[i] 。
 * 	排好后这哥们开始思考： 背包总共也就只能装下体积为C的东西，那我要装下哪些宝石才能让我获得最大的利益呢？
 */
public class _06背包问题 {

//	@Test
	public void main() {
		
	}
    public static void main(String[] args) {
        int N = 3 ;     // 宝石个数
        int C = 10 ;    // 书包容量
        int V[] = {0,5,3,4};       // 每个宝石的体积，这里前面的0是为了后面表示方便，即V[1]表示为第一个宝石的体积，下同
        int W[] = {0,20,10,12};    // 每个宝石的价值
        int[][] d = new int [N+1][C+1] ; //d[i][j]表示前i个宝石时,背包容量j时的最大价值

        d[0][C] = 0 ;  //一个宝石也没有,空书包时容量为C-->对应的价值为0

        for (int i = 1; i <= N; i++) {
            for (int j= 1; j<=C; j++) {
                if (j>=V[i]) { //背包容量大于第i个物品体积时
                	// 状态转移方程
                    d[i][j] = Math.max(d[i-1][j] , d[i-1][j-V[i]] + W[i]);  
                    //选择要这个物品,还是不要这个物品中价值最大的方案 
                }
            }
        }
        System.out.println(d[N][C]);
    }
}
