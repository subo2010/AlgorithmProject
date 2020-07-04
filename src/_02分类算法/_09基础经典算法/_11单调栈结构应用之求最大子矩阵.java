package _02�����㷨._09���������㷨;

import java.util.Stack;

import org.junit.Test;

/**
 * ������Ӿ���Ĵ�С
 * ��Ŀ:����һ�����ξ���map,���е�ֵֻ��0��1����,������ȫ��1�ľ���������,����ǿ���ε����
 * ����:  1 1 1 0
 * 		����,���ľ������Ϊ3
 * ����:
 * 1 0 1 1
 * 1 1 1 1
 * 1 1 1 0
 * 		�������������Ϊ6
 * 
 * ����һ����ά����,����������	
 * 
 * ˼·:
 *     1   1   1  
 *   1 1   1   1 1
 * 1 1 1 1 1   1 1
 * 1 1 1 1 1 1 1 1
 * ����һ������ͼ����,���ڵ�i��ͨ������ջ�����ҵ����Ҳ��һ������������,��ôλ���������ڲ������,�Ϳ����γ�
 * һ����ԭ��Ϊ�ߵľ���,ÿһ�������԰��մ˷�ʽ���õ�һ���Դ���Ϊ�ߵ�������,����һ��ȫ���������¼�Ϳ�����,�õ�������ֵ
 * 
 * �����п�������������������:
 * ÿһ�еĽ��з���,��һ���˽���һ����Ϊһ�����α����,Ȼ���ٷ���ǰ����,���ڶ��е�Ԫ��Ϊ1ʱ���ĸ߶ȼ�1,������ո߶�
 *
 */
public class _11����ջ�ṹӦ��֮������Ӿ��� {

	@Test
	public void main() {
		int[][] matr = getMatr(4,7);
//		int[][] matr = {{1,0,1,1},{0,0,1,1},{1,0,1,1},{1,0,0,1}};
		myPrint(matr);
		int area = getMaxArea(matr);
		System.out.println(area);
	}
	
	//�����ά����,�������������
	private int getMaxArea(int[][] map) {
		//basecase
		if (map == null || map.length == 0 || map[0].length == 0) {
			return 0;
		}
		int[] table = new int[map[0].length]; 	//����һ�����α�,����Ϊÿһ�еĳ���
		
//		System.out.println(map.length);//����
		int max = Integer.MIN_VALUE;
		for (int j = 0; j < map.length; j++) {	//����ÿһ��
			for (int i = 0; i < table.length; i++) { //��������ͼ
				table[i] = map[j][i]==0 ? 0 : table[i]+1;
			}
			int colMax = getColumnMax(table);	//���÷������ش�����ͼ���е�������
			max = Math.max(max, colMax);
		}
		return max;
	}

	//����һ�����α�,���ش����α��еĵ�������(���õ�����ջ)
	private int getColumnMax(int[] arr) {
		int max = Integer.MIN_VALUE; //ά��һ�����ֵ
		Stack<Integer> stack = new Stack<Integer>(); //�������һ��С����(�׵���-->��С����)
		//����Ԫ�س��Խ�ջ
		for (int i = 0; i < arr.length; i++) {
			while(!stack.isEmpty()&&arr[stack.peek()]>arr[i]){//ͷ��������Ԥ�ھ͵�ջ
				int high = arr[stack.pop()];
				int j = stack.isEmpty() ? -1 :stack.peek();
				int width = i-j-1;
				max = Math.max(max, high*width);

			}
			//�����Ǹ�������
			stack.push(i);
		}
		//���ⵯ��Ԫ��
		while(!stack.isEmpty()){
			int high = arr[stack.pop()];
			int width = stack.isEmpty() ? -1 :stack.peek();
			max = Math.max(max, high*(arr.length-width-1));
			
		}
		return max;
	}

	//----------------���߷���----------------���߷���----------------���߷���----------------���߷���
	//��ȡһ��m��n�еľ������
	private  int[][] getMatr(int m,int n) {
		int[][] matr = new int[m][n];
		for (int i = 0; i < matr.length; i++) {
			for (int j = 0; j < matr[i].length; j++) {
				matr[i][j] = (int)(Math.random()+0.7);		//ֻ����0��1�ľ���
			}
		}
		return matr;
	}
		
	//��ӡ��ά����
	public void myPrint(int[][] arr){
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
	}
}
