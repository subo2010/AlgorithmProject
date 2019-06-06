package �ο�;

public class Code_04_Manacher {
	
	public static void main(String[] args) {
		String str1 = "abc1234321ab";
		System.out.println(maxLcpsLength(str1));
	}

	
	
	//���������ĳ���
	public static int maxLcpsLength(String str) {
		if (str == null || str.length() == 0) {
			return 0;
		}
		char[] charArr = manacherString(str);  //����װ�κõ��ַ�����
		int[] pArr = new int[charArr.length];  //���İ뾶����
		int c = -1;
		int pR = -1;
		int max = Integer.MIN_VALUE;
		for (int i = 0; i != charArr.length; i++) {
			//index ��������
			//2 * index - i ----> i'   pArr[2 * index - i]Ϊi'�Ļ��İ뾶
			//pR > i ���� i���ұ߽�����
			//Math.min(pArr[2 * index - i], pR - i) ---> ȡi'�Ļ��İ뾶��pR-i�н�С���Ǹ�
			pArr[i] = pR > i ? Math.min(pArr[2 * c - i], pR - i) : 1;
			
			//��������2��3����һ���оͻ�õ�һ��pArr[i]-->
			//�������4�õ�����pR - i 
			//�������1 �õ�����1
			//�������1��4����Ҫ������,������г�ʼֵ��������Ҷ���һ��,��Ϊ2��3�Ѿ��еĳ�ʼֵ������һ�¾�ʧ����
			//��������Ŀ����Ϊ�˲��÷��������,���ٴ�����
			while (i + pArr[i] < charArr.length && i - pArr[i] > -1) {
				if (charArr[i + pArr[i]] == charArr[i - pArr[i]])
					pArr[i]++;
				else {
					break;
				}
			}
			
			//��ȡ�µĻ����ұ߽�
			if (i + pArr[i] > pR) {
				pR = i + pArr[i];
				c = i;
			}
			max = Math.max(max, pArr[i]);//��¼ȫ�����ֵ
		}
		return max - 1;
	}
	
	//Ϊ�ṩ���ַ��������,�������ַ�����
	public static char[] manacherString(String str) {
		char[] charArr = str.toCharArray();
		char[] res = new char[str.length() * 2 + 1];
		int index = 0;
		for (int i = 0; i != res.length; i++) {
			res[i] = (i & 1) == 0 ? '#' : charArr[index++];
		}
		return res;
	}

}
