package ������._04������;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.LinkedBlockingDeque;

import org.junit.Test;


public class _00������ {
	@Test
	public void main() {
		Tree tree = new Tree();
		tree.add(0);
		tree.add(1);
		tree.add(2);
		tree.add(3);
		tree.add(4);
		tree.add(5);
		tree.add(6);
		tree.add(7);
		tree.add(8);
		tree.add(9);
		//��α���
		tree.levelOrder(tree.head);
		//�������
		tree.preOrder(tree.head);
		System.out.println("����");
		tree.preOrder1(tree.head);
		System.out.println();
		//�������
		tree.inOrder(tree.head);
		System.out.println("����");
		tree.inOrder1(tree.head);
		System.out.println();
		//�������
		tree.postOrder(tree.head);
		System.out.println("����");
		tree.postOrder1(tree.head);
	}
	
	//�������Ľڵ����
	class TreeNode{
		int val;
		TreeNode left = null;
		TreeNode right = null;
		public TreeNode(int val){
			this.val = val;
		}
	}

	//һ��������
	class Tree{
		public TreeNode head = null;	//����һ�����Ԫ��
		
		/** ���ӽڵ�*/
		public void add(int item){
			TreeNode node = new TreeNode(item);
			if(head == null){
				head = node;
				return;
			}
			
			LinkedList<TreeNode> list = new LinkedList<TreeNode>(); //����һ���б����洢Ԫ��
			list.add(head);		//ÿ��׷�ӵ�����β��
			while(list.size()!=0){
				TreeNode cur_node = list.getFirst();	//ÿ�δ�ͷ����ȡ(��ɾ��)
				list.removeFirst();
				if(cur_node.left == null){
					cur_node.left = node;
					return;
				} else {
					list.add(cur_node.left);
				}
				
				if(cur_node.right == null){
					cur_node.right = node;
					return;
				} else {
					list.add(cur_node.right);
				}
			}
		}
		
		//��α���
		public void levelOrder(TreeNode root){
			if(root==null){
				return;
			}
			Queue<TreeNode> queue = new LinkedBlockingDeque<TreeNode>();
			queue.add(root);
			while(queue.size() != 0){
				TreeNode cur_node = queue.poll();
				System.out.print(cur_node.val+" ");
				if(cur_node.left != null){
					queue.add(cur_node.left);
				}
				if(cur_node.right != null){
					queue.add(cur_node.right);
				}
			}
			System.out.println();
		}
		
		//ǰ�����
		public void preOrder(TreeNode root){
			if (root!=null) {
				System.out.print(root.val+" ");
				preOrder(root.left);
				preOrder(root.right);
			}
		}
		//�������
		public void inOrder(TreeNode root){
			if (root!=null) {
				inOrder(root.left);
				System.out.print(root.val+" ");
				inOrder(root.right);
			}
		}
		//�������
		public void postOrder(TreeNode root){
			if (root!=null) {
				postOrder(root.left);
				postOrder(root.right);
				System.out.print(root.val+" ");	
			}
		}

		//�ǵݹ�ǰ�����(*******************)
		public void preOrder1(TreeNode head){
			if(head!=null){ //�����Ϊ��������
				//������һ��ջ�ṹ
				Stack<TreeNode> stack=new Stack<TreeNode>();
				//��ͷ��ѹջ
				stack.add(head);
			    while(!stack.isEmpty()){
			    	head=stack.pop();		//��ջ����ӡջ��Ԫ��
			        System.out.print(head.val+" ");
			        //���ջ�����Һ�����ѹ��,Ȼ�����ж�����ѹ��
			        if(head.right != null) {
			        	stack.push(head.right); 	//��ͷ�����Ԫ��
			        }
			        if(head.left != null) {
			        	stack.push(head.left); 		//��ͷ�����Ԫ��
			        }
			    }
			}
		}
		
		//�ǵݹ��������
		public void inOrder1(TreeNode head){
			if (head!=null) {
				//������һ��ջ�ṹ
				Stack<TreeNode> stack=new Stack<TreeNode>();
				//��ǰ�ڵ㲻Ϊ��,��ǰѹջ��ǰ�����ƶ�.��ǰ�ڵ�Ϊ��,��ջ���ó�һ����Ϊ��ǰ����ӡ,��ǰ�ڵ������ƶ�
				while(!stack.isEmpty()||head!=null){	//�����ǰ��Ϊ��,��ջ�л���Ԫ����ѭ��
					if(head!=null){	//��ǰ�ڵ㲻Ϊ��,��ǰѹջ��ǰ�����ƶ�(�൱�ڽ�������߽�ѹ��)
						stack.push(head); 	
						head=head.left;
					}else {			//��ǰ�ڵ�Ϊ��,��ջ���ó�һ����Ϊ��ǰ����ӡ,��ǰ�ڵ������ƶ�
						head = stack.pop();
						System.out.print(head.val+" ");
						head=head.right;
					}		
				}
			}
		}
		
		//�ǵݹ�������(˫ջ��)
		public void postOrder1(TreeNode head) {
		    //�൱�������������->��->��  ���Ϊ  ��->��->��,���Ҳ���ӡ,Ȼ������븨��ջ��,�ڵ�ջʱ��ʵ���� ��->��->��
			Stack<TreeNode> output = new Stack<TreeNode>(); //����ջѽ
			Stack<TreeNode> stack = new Stack<TreeNode>();
			stack.add(head);//��ͷ��ѹջ
		    while(!stack.isEmpty()){
		    	head=stack.pop();		//��ջ����ӡջ��Ԫ��
		    	output.push(head);		//��ԭ���Ĵ�ӡ��ʱ�����ѹ��ջ����ջ
		        //��ѹ������ѹ�Һ���(*****�������෴*****)
		        if(head.left != null) {
		        	stack.push(head.left); 	
		        }
		        if(head.right != null) {
		        	stack.push(head.right); 	
		        }
		    }
	        while (output.size() > 0) {
	           System.out.print(output.pop().val + " ");
	        }
		}
	}
}