package �ο�;

public class Code_01_KMP {

	public static void main(String[] args) {
		String str = "abcabcababaccc";
		String match = "ababa";
		System.out.println(getIndexOf(str, match));

	}
	
	public static int getIndexOf(String s, String m) {
		if (s == null || m == null || m.length() < 1 || s.length() < m.length()) {
			return -1;
		}
		char[] ss = s.toCharArray();
		char[] ms = m.toCharArray();
		int si = 0;	//��
		int mi = 0;	//�� 
		int[] next = getNextArray(ms);	//��ȡNext����
		while (si < ss.length && mi < ms.length) {
			if (ss[si] == ms[mi]) {	//����ͬʱ�ƶ� 
				si++;
				mi++;
			} else if (next[mi] == -1) { //0λ���Ӧ���ַ�,����һ���ַ�
				si++; 	//��������һ��
			} else {	//�ײ���,���ƶ�
				mi = next[mi];
			}
		}
		return mi == ms.length ? si - mi : -1;
	}

	public static int[] getNextArray(char[] ms) {
		if (ms.length == 1) {
			return new int[] { -1 };
		}
		int[] next = new int[ms.length];
		next[0] = -1;
		next[1] = 0;
		int pos = 2; //�±�
		int cn = 0;	//����pos-1λ�õ�next��,,��������λ��(����ÿ��ǰ��Ҫ�Ƚϵĵ�λ��)
		//cn������λ��,�д���ǰ׺�ĳ���
		while (pos < next.length) {
			if (ms[pos - 1] == ms[cn]) { //cn����pos-1λ�õ�next��,ms[cn]������ַ�ǰ׺����һ���ַ�
				next[pos] = ++cn;	//���pos-1λ�úʹ��ַ�ǰ׺����һ���ַ����,��posλ��Ϊpos-1λ�õ�next����һ
				pos++;
			} else if (cn > 0) { //�����߲���ȵ������
				cn = next[cn];	//��cn���� pos-1�ַ�ǰ׺����һ���ַ�����Ӧ��next��
			} else {	//֪��cn����0��-1ʱ����,��ʱnext��Ϊ0
				next[pos] = 0;
				pos++;
			}
		}
		return next;
	}

	

}
