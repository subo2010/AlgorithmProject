package _03examination._2baidu;

import org.junit.Test;

public class _02������� {

	@Test
	public void main() {
		String str = multiply("25","25"); //�����������������
		System.out.println(str);
	}
	
	public String multiply(String num1, String num2) {
		//������int����ת��Ϊchar����
		char[] chars1 = num1.toCharArray();
		char[] chars2 = num2.toCharArray();
		int fuHao1 = 0; 	//0����û�з���λ,1�������λΪ��,2�������λΪ��
		int fuHao2 = 0;	
		int n1[]= new int[chars1.length];  		//û�з���λʱ���鳤��
		int n2[]= new int[chars2.length];
		int n11[]= new int[chars1.length-1];	//�з���λʱ���鳤��
		int n22[]= new int[chars2.length-1];
		//������λȷ��,�����ַ�����,ת��Ϊ��Ӧ��int����
		if (chars1[0] == '-' || chars1[0] == '+') {
			if (chars1[0] == '+') fuHao1 = 1;
			if (chars1[0] == '-') fuHao1 = 2;
			for (int i =1; i < chars1.length; i++){
				n11[i-1] = chars1[i] - '0';
			}
		} else {
			for (int i =0; i < chars1.length; i++){
				n1[i] = chars1[i] - '0';
			}
		}
		
		if (chars2[0] == '-' || chars2[0] == '+') {
			if (chars2[0] == '+') fuHao2 = 1;
			if (chars2[0] == '-') fuHao2 = 2;
			for (int i =1; i < chars2.length; i++){
				n22[i-1] = chars2[i] - '0';
			}
		} else {
			for (int i =0; i < chars2.length; i++){
				n2[i] = chars2[i] - '0';
			}
		}
		
		if(fuHao1 == 0 && fuHao2 == 0){ return partion(n1, n2);}
		if(fuHao1 == 0 && fuHao2 == 1){ return partion(n1, n22);}
		if(fuHao1 == 0 && fuHao2 == 2){ return "-"+partion(n1, n22);}
		if(fuHao1 == 1 && fuHao2 == 0){ return partion(n11, n2);}
		if(fuHao1 == 1 && fuHao2 == 1){ return partion(n11, n22);}
		if(fuHao1 == 1 && fuHao2 == 2){ return "-"+partion(n11, n22);}
		if(fuHao1 == 2 && fuHao2 == 0){ return "-"+partion(n11, n2);}
		if(fuHao1 == 2 && fuHao2 == 1){ return "-"+partion(n11, n22);}
		if(fuHao1 == 2 && fuHao2 == 2){ return partion(n11, n22);}
		return null;
	}

	//��������int���鷵��������˺�Ľ��
	private String partion(int[] n1, int[] n2) {
		//����һ�����ڷ��س˻�������
		//����Ϊ����ʱ���һλ���±�Ϊn1.length+n2.length-2(����������±�����)
		int result[] = new int[n1.length + n2.length - 1]; 
		//�����������(ģ�������ʵ����µ��������,������λ)
		for (int i = n1.length -1; i >= 0; i--){
			for (int j = n2.length -1; j >= 0; j--) {
				result[i+j] += n1[i] * n2[j];
			}
		}
		
		//���н�λ����(��λʱ�Ӻ���ǰ��λ)
		for (int i = result.length - 1; i > 0; i--) {
			result[i-1] += result[i] / 10; //�����λ
			result[i] = result[i] % 10;		//��λ����
		}
		
		//������λ��0��ֱ�ӷ���0 (��ֹ����0000�����)
		if (result[0] == 0) { 
			return "0";
		}
		
		//����Ϊstring����,���ַ��������鴮����
		String resultStr = "";
		for (int i = 0; i < result.length; i++) {
			resultStr += result[i];
		}
		return resultStr;
	}
}




