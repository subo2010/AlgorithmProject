package _1bytedance;
import java.util.*;
/*
 * ��Ŀ:�������������һ�������ĩ���������ʿ������,��������ʿ�õ�����(����Ϊһ��NԪ�ĳ�Ʊ����ס,ֻ��һ�ų�Ʊ),
 * Ϊ�˷�ֹ�����Լ���ս����Ƶ��������,������Լ���һЩ����,�����������˵ؾ��̵�ǰ������ʿ:"��Ҫ�����!"
	�ؾ�����:"�������������ֵ���,Ѫƿ150��һ��,ħ��ҩ200��һ��,�޵�ҩˮ350��һ��."
	������ʿ:"�õ�,����һ��Ѫƿ."˵�����ͳ�����NԪ�Ĵ󳮵ݸ��ؾ�����.
	�ؾ�����:"��������������,��������û���ҿ���Ǯ��ϰ�ߵ�,���Ǯ���Ƕ���С�����˵�,�ٺ�."������ʿ:"......"
	������ʿ��,�����Ǯ��С���͸����������Լ�����һ�����,�����Ժ�Ҫ���,������˷��ڼ���Ҳ��,����Ҫ����������׬С��.
	����������ʿ���������⣬ϣ�����ܰ�������һ��,������Ҫ���ؾ����˶���С�ѡ�
	
	����:2                ���       40
		340			0
		900
 */
public class _13������ʿ������ {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        for(int i = 0;i < n;i++){
            int num = Integer.parseInt(in.nextLine());
            partion(num);
        }
    }
    
    public static void partion(int num){
        if(num<150){
            System.out.println(num);
            return;
        }
        if(num%150 == 0 || num%200 == 0 || num%350 == 0){
            System.out.println(0);
            return;        
        }
        int min = num%350;
        min = Math.min(min,num%200);
        min = Math.min(min,num%150);
        System.out.println(min);
    }
}
