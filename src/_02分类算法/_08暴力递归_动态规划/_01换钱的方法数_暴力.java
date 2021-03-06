package _02分类算法._08暴力递归_动态规划;
import org.junit.Test;
/*
 *【题目】给定数组arr，arr中所有的值都为正数且不重复。每个值代表一种面值的货币，每种面值的货币可以使用任意张，再给定一个整数aim代表要找的钱数，
 * 		求换钱有多少种方法。
 *【举例】 arr=[5,10,25,1]，aim=0。	组成0元的方法有1种，就是所有面值的货币都不用。所以返回1。
 *		arr=[5,10,25,1]，aim=15。
 *		组成15元的方法有6种，分别为3张5元、1张10元+1张5元、1张10元+5张1元、10张1元+1张5元、2张5元+5张1元和15张1元。所以返回6。
 *		arr=[3,5]，aim=2。	任何方法都无法组成2元。所以返回0。
 * 暴力递归解法:以[5,10,25,1]，aim=15。为例此枚举
 * 			使用0个5: 10,25,1 组成  15 的方法数为 - a
 * 			使用1个5: 10,25,1 组成  10 的方法数为 - b
 * 			使用2个5: 10,25,1 组成  5  的方法数为 - c
 * 			使用3个5: 10,25,1 组成  0  的方法数为 - d
 * 然后依次将 a b c d 加起来.
 */
public class _01换钱的方法数_暴力 {
	@Test
	public void main() {
		int[] arr = {5,10,25,1};
		int aim = 15;
		int num1 = baoli(arr,aim);
		System.out.println(num1);
	}
	//暴力解法
	private int baoli(int[] arr, int aim) {
		if (arr == null || arr.length == 0 || aim <= 0) {
			return 0;
		}
		return baoliPartion(arr,0,aim);  //表示从第0个位置,包括0,以后随便使,组出aim来的方法数
	}
	/*
	 * 暴力递归过程
	 * arr:是原始数组,不变
	 * index:是指从index位置开始后面的前可以随便用
	 * aim :代表要拼出的目的钱数
	 * 返回值时方法数
	 */
	private int baoliPartion(int[] arr, int index, int aim) {
		int res = 0; 	//定义返回结果
		if (index == arr.length) {
			//遍历到结束,也就意味着一分钱也没有了,如果目标钱数正好为0,则返回1的方法数
			return res = aim == 0 ? 1 : 0; 
		}
		//依次计算第一个位置为不同值时返回的方法数的和
		int count = aim/arr[index]; //最多可以使用此钱币的张数
		for (int i = 0; i <= count; i++) { 
			res += baoliPartion(arr, index + 1, aim - arr[index] * i);
		}
		return res;
	}
}