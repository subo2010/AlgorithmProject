package _1bytedance;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import _0��������._05ֱ�۴�ӡ������.TreeNode;

/*
 *��Ŀ: �������Ľڵ㰴�մ��ϵ��£������ң���1��ʼ��ţ����п��ŵĽڵ��á�#����ʾ�������������ͼ���磺
		���룺1 2 3 # 4 5 6 # # # # 7 8
		�����1 2 4 7
 * ˼·:����ͼ����:��ӡÿһ��ĵ�һ���ڵ�
 */
public class _14������������ͼ_0 {
	
	@Test
	public void main() {
		TreeNode head = new TreeNode(1);
		head.left = new TreeNode(2);
		head.left.left = new TreeNode(3);
		head.right = new TreeNode(4);
		head.right.left = new TreeNode(5);
		head.right.right = new TreeNode(6);
		printTree(head);
		rightSideView1(head,0,0);
	}
	
	private void rightSideView1(TreeNode head, int high, int level) {
	 	if (head == null) {
	        return;
	    }
	    //�ӵ�0�㿪ʼ,ÿ�ν��˲��������Ԫ���콣��list,�����һ���Ժ�˲��û�취�������
	    if (level == high) { 
	        System.out.print(head.val+" ");
	        high++;
	    }
	    rightSideView1(head.left,high,level+1);
	    rightSideView1(head.right,high,level + 1);
	}

	public List<Integer> rightSideView(TreeNode root) {
       List<Integer> list = new ArrayList<Integer>(); //�������ڷ���������ͼ�ڵ�
       rightSideView(root,list,0);
       return list;
    }
    public void rightSideView(TreeNode root, List<Integer> list ,int level) {
        if (root == null) {
            return;
        }
        //�ӵ�0�㿪ʼ,ÿ�ν��˲��������Ԫ���콣��list,�����һ���Ժ�˲��û�취�������
        if (level == list.size()) { 
            list.add(root.val);
        }
        rightSideView(root.left,list,level + 1);
        rightSideView(root.right,list,level + 1);
     }
     
    
    //--------------------------------------------------------------
     public class TreeNode {
 		public int val;
 		public TreeNode left;
 		public TreeNode right;
 		public TreeNode(int data) {
 			this.val = data;
 		}
 	}
     public void printTree(TreeNode head) {
 		System.out.println("Binary Tree:");
 		printInOrder(head, 0, "H", 17);
 		System.out.println();
 	}

 	public void printInOrder(TreeNode head, int height, String to, int len) {
 		if (head == null) {
 			return;
 		}
 		printInOrder(head.right, height + 1, "v", len);
 		String val = to + head.val + to;
 		int lenM = val.length();
 		int lenL = (len - lenM) / 2;
 		int lenR = len - lenM - lenL;
 		val = getSpace(lenL) + val + getSpace(lenR);
 		System.out.println(getSpace(height * len) + val);
 		printInOrder(head.left, height + 1, "^", len);
 	}

 	public String getSpace(int num) {
 		String space = " ";
 		StringBuffer buf = new StringBuffer("");
 		for (int i = 0; i < num; i++) {
 			buf.append(space);
 		}
 		return buf.toString();
 	}
}
