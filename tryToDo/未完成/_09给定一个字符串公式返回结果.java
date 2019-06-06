package 未完成;
/*
 * 给定一个字符串str，str表示一个公式，公式里可能有整数、加减乘除符号和左右括号，返回公式的计算结果。
【举例】
str="48*((70-65)-43)+8*1"，返回-1816。
str="3+1*4"，返回7。 str="3+(1*4)"，返回7。
【说明】
1．可以认为给定的字符串一定是正确的公式，即不需要对str做公式有效性检查。
2．如果是负数，就需要用括号括起来，比如"4*(-3)"。但如果负数作为公式的开头或括号部分的开头，则可以没有括号，比如"-3*4"和"(-3)*4"都是合法的。
3．不用考虑计算过程中会发生溢出的情况
思路：
1 我们首先考虑没有小括号的情况的计算方法
如果遍历的过程中发现栈顶的元素的 不是 *和/,那么 就继续往栈里面放，如果在栈顶遇到了元素是 *或者/，那么把栈顶和栈顶第二元素拿出来
计算结果，然后把结果扔到栈里面。 最后  栈里面只剩下数字和 + - 符号了，从栈底开始一次相加相减就可以。
2 加上小括号的过程。
此时我们需要设计合适的数据结构
我们定义一个fun的函数，参数为(string ,index)
1 参数一表示是整个字符串，是固定的，参数二表示从这个字符串中的哪个位置开始向后计算
2 函数终止条件是遇到 ")" 或者 字符串结尾
3 返回值为 开头到")"这段的计算结果，和 ")"的终止位置
 */
public class _09给定一个字符串公式返回结果 {

}
