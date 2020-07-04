package _02�����㷨._04������;

import java.util.Stack;

import _02�����㷨._04������._00������.TreeNode;

public class _10��ȡ�������ĸ߶� {

	/**
     * �ݹ������
     * @param root
     * @return
     */
	public static int treeDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // ���������������
        int left = treeDepth(root.left);
        // ���������������
        int right = treeDepth(root.right);
        // ��root�����=·������������ + 1
        return left >= right ? (left + 1) : (right + 1);
    }
	
	
	/**
     * �ǵݹ飬����ջ���������(����)
     * ����                root���ȷ���ջ��
     *         5          ��ǰջ��Ԫ������Ϊ1��len=1��ȡ��ջ�д�ʱ���е�Ԫ�أ���5��Ȼ�����ӽڵ�3��7����ջ��
     *     3       7      ��ǰջ��Ԫ������Ϊ2��len=2������������ջ��pop���Σ�ʹջ�в��ں��иò�Ԫ�أ�ͬʱ���²�ڵ�2��4����ջ��
     * 2       4          ��ǰջ��Ԫ������Ϊ2��len=2������������ջ��pop����
     *                    ��¼��ȣ�����ÿ��pop��ջ������Ԫ��(ĳ������нڵ�)ֻ�����+1����depth++
     * @param root
     * @return
     */
    public static int treeDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // ��ʼ�����
        int depth =  0;
        // ���ÿ�����ڵ��ջ
        Stack<TreeNode> stack = new Stack<TreeNode>();
        // �����ĸ�(����һ��)����ջ��
        stack.push(root);
        while (!stack.isEmpty()) {
            // ��ջ��Ϊ��ʱ������+1��
            // ��Ϊÿ�ζ���pop����ǰ������нڵ㣬�����ò����нڵ���ӽڵ����ջ��
            depth++;
            // ��ǰջ��Ԫ�ص�����
            int length = stack.size();
            while (length-- > 0) {
                // ȡ��ջ�����еĽڵ㣬������Ӧ�ڵ���ӽڵ����ջ��
                TreeNode node = stack.pop();
                if (node.left != null) {
                    stack.push(node.left);
                }
                if (node.right != null) {
                    stack.push(node.right);
                }
            }
        }
        return depth;
    }
}
