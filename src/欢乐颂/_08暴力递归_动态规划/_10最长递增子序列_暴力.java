package ������._08�����ݹ�_��̬�滮;
/*
 * ��Ŀ:������һ������,Ȼ������������������������еĳ���
 */
public class _10�����������_���� {
		  
	public static void main(String [] args){
		int [] randArr = new int[]{5,2,8,6,3,6,9,7};
		maxAscLen(randArr);
	}
	
    public static void maxAscLen(int [] arr){
        int n = arr.length;
        int [] lens = new int[n];	//������Ԫ��i��β�ĵ��������г���
        int [][] lensArr = new int[n][n];	//������ÿ��Ԫ��i��β�ĵ���������
        for(int i = 0; i <= n - 1; i++){	//��ʼ�������ռ�
        	lens[i] = 1;
            lensArr[i][0] = arr[i];
        }
       
        for(int i = 0; i < n; i++){
           for(int j = i - 1; j >= 0; j--){	//�Ӻ���ǰѰ��
             if(arr[i] > arr[j] && lens[j] + 1 > lens[i]){
            	 lens[i] = lens[j] + 1;	//������Ԫ��i��β������������г���
                 for(int k = 0; k <= lens[j]; k++){	//����Ԫ��j��β������������п�������Ԫ��i��β���������������
                     lensArr[i][k] = lensArr[j][k];
                 }
                 lensArr[i][lens[i] - 1] = arr[i];
              }
           }
       }
        //Ѱ�������������г��ȵ�Ԫ���±�
        //����ֻ���ҵ���һ������������е��±꣬���籾���е�������зֱ�Ϊ{2��3��6��9}��{2��3��6��7}
        //Ҳ������ֻ�ܷ���9���±�
        int index = 0;
        for(int i = 0; i <= n - 1; i++){
           if(lens[index] < lens[i]){
             index = i;
          }
        }
        //����ֻ�����һ�������������
        System.out.println("�����������г��ȣ�" + lens[index]);
        System.out.print("������������Ϊ��");
        for(int i = 0; i < lens[index]; i++){
        	System.out.print(lensArr[index][i] + " ");
        }
        System.out.println();
    }
}
