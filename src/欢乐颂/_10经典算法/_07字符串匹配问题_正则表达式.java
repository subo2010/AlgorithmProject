package ������._10�����㷨;

import org.junit.Test;

/*
 ����һ���ַ��� (s) ��һ���ַ�ģʽ (p)��ʵ��֧�� '.' �� '*' ��������ʽƥ�䡣
	'.' ƥ�����ⵥ���ַ���
 	'*' ƥ���������ǰ���Ԫ�ء�(���ܷŵ���λ)
	ƥ��Ӧ�ø��������ַ��� (s) �������ǲ����ַ�����
˵��:
	s ����Ϊ�գ���ֻ������ a-z ��Сд��ĸ��
	p ����Ϊ�գ���ֻ������ a-z ��Сд��ĸ���Լ��ַ� . �� *��
����:
	����: s = "aa"	p = "a"
	���: false  ����: "a" �޷�ƥ�� "aa" �����ַ���
	����: s = "aab"  p = "c*a*b"
	���: true 	����: 'c' ���Բ����ظ�, 'a' ���Ա��ظ�һ�Ρ���˿���ƥ���ַ��� "aab"��
	����: s = "aa"	p = "a*"
	���: true	����: '*' �����ƥ���������ǰ���Ԫ��, ������ƥ�� 'a' �����, �ظ� 'a' һ��, �ַ����ɱ�Ϊ "aa"��
	
����˼·:�ݹ��;
 	���һ���ݹ麯������Ϊ(str,exp,i,j)��ʾexp��jλ�ÿ�ʼ�ܲ���ƥ����str��iλ�ÿ�ʼ���ַ���
 		1.����jλ��Ϊexp.length,������ĩβû��Ԫ��,ֻ�е�iλ��Ҳ����str.lengthʱ,�Ż᷵��true
 		2.����˵jû������β��,j���滹���ַ�,����Ӧ�ÿ���j+1�����
 			1.���j+1û����,��ֻ��i+1Ҳû��,��
 */
public class _07�ַ���ƥ������_������ʽ {
	
	@Test
	public void main() {
		String str = "aab";
		String exp = "c*a*b";
		//���õݹ麯�������Ƿ���ƥ��
		boolean h = isMatch(str.toCharArray(),exp.toCharArray(),0,0);
		System.out.println(h);
	}
	
	//�ݹ�ⷨ	��ʾstr[i...�����]�ܷ���exp[j...�����]ƥ��ɹ�
	private boolean isMatch(char[] str, char[] exp ,int i, int j) {
		//basecase j������exp��β��ʱ,������Ԫ��
		if (j == exp.length) {
			return i == str.length;
		}
		//exp��j���滹���ַ�,����j+1�����
		if (j + 1 == exp.length || exp[j+1] != '*') {
			return i != str.length && (exp[j] == str[i] || exp[j] == '.')
					&& isMatch(str, exp, i + 1, j + 1);
		}
		
		//exp��j+1λ���ϲ��������ַ������ַ�Ϊ * 
		while(i != str.length && (exp[j] == str[i] || exp[j] == '.')){
			if (isMatch(str, exp, i, j+2)) {
				return true;
			}
			i++;
		}
		return isMatch(str, exp, i, j+2);
	}
}
