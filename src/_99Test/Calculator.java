package _99Test;

public class Calculator {
    public int result=0;

    public  int add(int operand1,int operand2){
        result=operand1+operand2;   //�������������������Ӳ���
        return result;
    }

    public  int subtract(int operand1,int operand2){
        result=operand1-operand2;   //������������������������
        return  result;
    }

    public int multipe(int operand1,int operand2){
        result=operand1*operand2;   //�������������������˲���
//        for(;;){                    //��ѭ��
//        }
        return  result;
    }
    public int divide(int operand1,int operand2){
//        result=operand1/0;      //��0����
        result=operand1/operand2;      //��0����
        return result;
    }
    public int getResult(){
        return this.result;     //���ؼ�����
    }
}
