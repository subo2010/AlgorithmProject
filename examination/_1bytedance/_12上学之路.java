package _1bytedance;
import java.util.*;
/*
 * ��Ŀ:С���Ĵ�ѧ��Ǩ������У������У�������е�·�����ݺύ�������һ����������
 * ��ÿ��Ҫ���������ѧ¥֮�����������������ѧ¥ǡ��λ��һ��n��n������������ĶԽ��ߵ����ˣ�
 * ��ô������Խ���������������Խ�������̵�·�̴������ߵ���ѧ¥���м����߷���
 *  ����  3   ���  5
 * ˼·:dp˼��������_10������
 */
public class _12��ѧ֮·{
     public static void main(String[] args) {
         Scanner in = new Scanner(System.in);
         int n = Integer.parseInt(in.nextLine());
         int[][] arr = new int[n+1][n+1];
         for(int i = 0; i < arr.length ; i++){
             arr[0][i] = 1;
             arr[i][0] = 1;
         }
         for(int i = 1;i < arr.length ; i++){
             for(int j = 1;j < arr.length ; j++){
                 if(i == j){
                     arr[i][j] = arr[i][j-1];
                 } else{
                     arr[i][j] = arr[i][j-1] + arr[i-1][j];
                 }
             }
         }
         System.out.println(arr[n][n]);
     }
}
