package ������._10��������;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.junit.Test;

/*
 * ��Ŀ:n�ʺ������о�������ν� n���ʺ������ n��n �������ϣ�����ʹ�ʺ�˴�֮�䲻���໥������
 * 		(��ĳһ�ʺ�ͬ�л�ͬ�п��Թ���,��ĳһ�ʺ�λ�����̵ĶԽ���Ҳ���γɹ���)
 * 	Ҫ��:����λ����ķ�ʽ�����N�ʺ�����������

 * ˼·:
 * DFS����ÿһ����б���,������ÿһ���ʱ��ѭ��������,���жϵ�ǰλ���Ƿ���Է��ûʺ�,���������ֱ������,�������,��ֱ�ӽ�����һ��
 */
public class _10N�ʺ�����_λ����ⷨ {
	
	// ����һ��ȫ�ֱ���������ⷨ�ĸ���
	int count = 0;
	
	@Test
	public void main() {
		// n�ʺ���������Ŀ
		DFS(4,0,0,0,0);
		System.out.println(count);
	}

	// ������ȱ���(��int��������ռ�õ�)
	private void DFS(int n, int row, int col, int pie, int na) {
		// ���е���Ŀ�����������һ�е�ʱ��˵�������������������վλ
		if (row >= n) {
			count++; return;
		}
		// bit������λ(0�����г�ͻ,1�������վ������)-> �ҳ������п���վ�ʺ��λ��
		int bit = (~ (col|pie|na)&((1<<n)-1));
		while(bit > 0) { // ֻ������������˵������1,��˱��оͿ��Ծ���վ�ʺ�
			int p = bit & -bit;	// �õ���������һλ1
			DFS(n, row+1, col|p, (pie|p)<<1, (na|p)>>1); // �ݹ����
			bit &= bit-1;	// ȥ��������һλ1
		}
	}
}
