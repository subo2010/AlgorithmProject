package ������._08�����ݹ�_��̬�滮;

import org.junit.Test;

/*
 * ˼·:һ������ΪN��·,1~N,һ����������Mλ�ã���������P���������1λ��ֻ�����ң���Nλ��ֻ���������ʻ�������P������ͣ��Kλ���ϵ��߷��ж����֡�
 * ����n=4 m=2 p=2 k=2   1-2-3-4  ��������2λ������������2λ��,һ����2�зֱ�Ϊ 2->3->2  2->1->2
 * ˼·1:�����ݹ飺����һ������f(N,M,P,K)
 * 		K��N�ǹ̶��ģ���ʾ Kλ�� �� NΪ·�ĳ��ȣ�
 * 		P��M�ǿɱ�ģ�P��ʾ��ǰʣ����ٲ����� M��ʾ��ǰ��·��ʲôλ��*(���p��mȷ�����ؽ����ȷ����)
 * 		����ֵΪ��ǰ״̬�� ����������ͣ��Kλ�õ��߷�
 */
public class _04���ߵĻ�����_���� {

	@Test
	public void main() {
		int n = 4; // ·�ĳ���
		int m = 2; // ��ǰλ��
		int step = 2; // �����ߵĲ���
		int aim = 2; // Ŀ��λ��
		int num1 = baoli(n, m, step, aim);
		System.out.println(num1);
	}

	// �����ݹ鷨
	private int baoli(int n, int m, int step, int aim) {
		// basecase
		if (n < 1 || m < 1 || m > n || step < 0 || aim > n) {
			return 0;
		}
		//��ʣ�ಽ��Ϊ0ʱ�ж�,��ǰλ���Ƿ���Ŀ��λ����
		if (step == 0) {
			return m == aim ? 1 : 0;
		}
		// �������ؽ��
		int count = 0; 
		// ����˵����������
		if (m == 1) { // �ߵ���߽�
			count = baoli(n, m + 1, step - 1, aim);
		} else if (m == n) { // �ߵ��ұ߽�
			count = baoli(n, m - 1, step - 1, aim);
		} else { // ���м��ʱ��(��������Ҳ��������)
			count = baoli(n, m + 1, step - 1, aim) + baoli(n, m - 1, step - 1, aim);
		}
		return count;
	}
}
