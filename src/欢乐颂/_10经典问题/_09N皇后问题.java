package ������._10��������;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

/*
 * ��Ŀ:n�ʺ������о�������ν� n���ʺ������ n��n �������ϣ�����ʹ�ʺ�˴�֮�䲻���໥������
 * 		(��ĳһ�ʺ�ͬ�л�ͬ�п��Թ���,��ĳһ�ʺ�λ�����̵ĶԽ���Ҳ���γɹ���)
 * 	Ҫ��:�ṩһ��n*n������ ,�������в�ͬ�� n�ʺ�����Ľ��������(��ӡ����)
 * 	����: ����4
	���: 
	// �ⷨ 1
	 [".Q..",  
	  "...Q",
	  "Q...",
	  "..Q."],
	// �ⷨ 2
	 ["..Q.",  
	  "Q...",
	  "...Q",
	  ".Q.."]
	  
 * ˼·:����������ȱ���������(DFS),�������ǿ���֪�����ʺ�ռ��һ��λ��ʱ,���������к��оͲ����ٷŻʺ�,�˴���Ϊÿһ���ҵ���һ���ʺ�
 * 		�Ͳ��ڴ������(������һ�п϶�û�лʺ�,���ֻ���ע���е���Ϣ),������Ҫ��һ����������ע��Щ�б�ռ����(����һ�������Ӧ������Ϊ����ռ��)
 * 		(�˴�Ϊ�ɱ���Խ��,����set������ʵ��,ÿ��ռ��һ���е�ʱ��,�ͼ��з���set��,�´�ֻ��Ҫ�ж�һ��,set���Ƿ���ڴ���,���������ٷ�)
 * 		�������ͬһ���ϲ��ܴ���һ���ʺ�,���̶Խ���Ҳ���ܴ��������ʺ�,��˶�����������pie��na��Ӧ�����Խ���(col��  row��)
 * 		����i�� j�� ��Ԫ��������ڻʺ�,��pie[i+j]=1������Խ��� . na[i-j]=1�����ҶԽ���
 * DFS����ÿһ����б���,������ÿһ���ʱ��ѭ��������,���жϵ�ǰλ���Ƿ���Է��ûʺ�,���������ֱ������,�������,��ֱ�ӽ�����һ��
 */
public class _09N�ʺ����� {

	@Test
	public void main() {
		// n�ʺ�����Ľ������
		solveNQueens(8);
	}
	
	public void solveNQueens(int n)	{
		//basecase
		if (n < 1) { return; }
		
		//����������������
		Set<Integer> cols = new HashSet<Integer>();	//���ڴ���ռ�õ���
		Set<Integer> pie = new HashSet<Integer>();	//���ڴ���ռ�õķ��Խ���
		Set<Integer> na = new HashSet<Integer>();	//���ڴ���ռ�����Խ���
		// ����һ���洢�ʺ�λ�õļ���(ÿ�лʺ����ڵ�λ��)
		Map<Integer,Integer> reMap =  new HashMap<Integer,Integer>();
		
		// �ӵ�һ�п�ʼ������������ȱ���
		DFS(0,n,cols,pie,na,reMap);
	}

	// ������ȱ���
	private void DFS(int row, int n, Set<Integer> cols, Set<Integer> pie,
			Set<Integer> na,Map reMap) {
		
		// ����������һ�����������ݱ�ʾ�ɹ�
		if (row >= n) {
			System.out.println(reMap);
		}
		
		// �ӵ�һ�п�ʼ����
		for (int col = 0; col < n; col++) {
			// �����λ�ú����еĻʺ��ͻ�򽫴�λ������
			if (cols.contains(col) ||  pie.contains(col+row) || na.contains(col-row)) {
				continue;
			}
			// �˻ʺ�ռ�д�λ��
			cols.add(col);
			pie.add(col+row);
			na.add(col-row);
			reMap.put(row, col);
			// �ݹ�Ѱ����һ��
			DFS(row+1, n, cols, pie, na,reMap);
			
			// �ָ��ֳ�
			reMap.remove(row);
			cols.remove(col);
			pie.remove(col+row);
			na.remove(col-row);
		}
		
	}
}
