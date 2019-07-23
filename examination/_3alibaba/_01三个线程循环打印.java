package _3alibaba;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class _01�����߳�ѭ����ӡ implements Runnable {

	public static void main(String[] args) throws InterruptedException {
        _01�����߳�ѭ����ӡ task = new _01�����߳�ѭ����ӡ();
        //���������̲߳�����
        Thread thread1 = new Thread(task,"1");
        Thread thread2 = new Thread(task,"2");
        Thread thread3 = new Thread(task,"3");
//        thread1.setName("1");
//        thread2.setName("2");
//        thread3.setName("3");
        thread1.start();
        thread2.start();
        thread3.start();
    }
	
    private ReentrantLock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();
    //Ϊtrue����ִ�����
    private volatile Boolean a = false;
    private volatile Boolean b = false;
    private volatile Boolean c = true;
    private  int j = 1;

    @Override
    public void run() {
        lock.lock();
        try {
            for (int i = 0; i < 40 ; i++) {
            	//��ȡ��ǰ�̵߳�����
            	String name = Thread.currentThread().getName();
            	if (name.equals("1")) {
            		//ֻҪc�߳�û��ִ��,�����߳���������,ֻ��c�߳�ִ�����˲Ż�����
                    if ( !c ) condition.await(); 
                    //a�߳�ִ�н���
                    a = true;
                    //c�߳�û��ִ��
                    c = false;
                } else if (name.equals("2")) {
                	//ֻҪa�߳�û��ִ��,�����߳���������,ֻ��a�߳�ִ�����˲Ż�����
                    if ( !a ) condition.await();
                    b = true;
                    a = false;
                } else if (name.equals("3")) {
                    if ( !b ) condition.await();
                    c = true;
                    b = false;
                }
                System.out.print(j++ + " ");
                //֪ͨ���ڵȴ����߳�
                condition.signalAll();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
