package 欢乐颂._10经典问题;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.junit.Test;

/*
 * 题目:n皇后问题研究的是如何将 n个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 * 		(与某一皇后同行或同列可以攻击,与某一皇后位于棋盘的对角线也会形成攻击)
 * 	要求:利用位运算的方式来求出N皇后问题解的数量

 * 思路:
 * DFS按照每一层进行遍历,遍历到每一层的时候循环他的列,并判断当前位置是否可以放置皇后,如果不可以直接跳过,如果可以,则直接进行下一行
 */
public class _10N皇后问题_位运算解法 {
	
	// 定义一个全局变量来代表解法的个数
	int count = 0;
	
	@Test
	public void main() {
		// n皇后问题解的数目
		DFS(4,0,0,0,0);
		System.out.println(count);
	}

	// 深度优先遍历(用int数来代表占用的)
	private void DFS(int n, int row, int col, int pie, int na) {
		// 当列的数目到达棋盘最后一行的时候说明满足出现满足条件的站位
		if (row >= n) {
			count++; return;
		}
		// bit二进制位(0代表有冲突,1代表可以站在这里)-> 找出了所有可以站皇后的位置
		int bit = (~ (col|pie|na)&((1<<n)-1));
		while(bit > 0) { // 只有条件成立就说明存在1,因此本行就可以据需站皇后
			int p = bit & -bit;	// 得到最后右面的一位1
			DFS(n, row+1, col|p, (pie|p)<<1, (na|p)>>1); // 递归进行
			bit &= bit-1;	// 去除最右面一位1
		}
	}
}
