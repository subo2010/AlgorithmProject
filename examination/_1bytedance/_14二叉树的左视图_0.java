package _1bytedance;

import java.util.ArrayList;
import java.util.List;

/*
 *��Ŀ: �������Ľڵ㰴�մ��ϵ��£������ң���1��ʼ��ţ����п��ŵĽڵ��á�#����ʾ�������������ͼ���磺
		���룺1 2 3 # 4 5 6 # # # # 7 8
		�����1 2 4 7
 * ˼·:����ͼ����:��ӡÿһ��ĵ�һ���ڵ�
 */
public class _14������������ͼ_0 {
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
        rightSideView(root.left,list,level+1);
        rightSideView(root.right,list,level + 1);
     }
     
     public class TreeNode {
 		public int val;
 		public TreeNode left;
 		public TreeNode right;
 		public TreeNode(int data) {
 			this.val = data;
 		}
 	}
}
