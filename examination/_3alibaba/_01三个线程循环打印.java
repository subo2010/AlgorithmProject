package _3alibaba;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class _01�����߳�ѭ����ӡ implements Runnable {

	public static void main(String[] args) throws InterruptedException {
        _01�����߳�ѭ����ӡ task = new _01�����߳�ѭ����ӡ();
        //���������̲߳�����
        Thread thread1 = new Thread(task);
        Thread thread2 = new Thread(task);
        Thread thread3 = new Thread(task);
        thread1.setName("a");
        thread2.setName("l");
        thread3.setName("i");
        thread1.start();
        thread2.start();
        thread3.start();
    }
	
    private ReentrantLock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();
    private volatile Boolean a = false;
    private volatile Boolean b = false;
    private volatile Boolean c = true;

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        lock.lock();
        try {
            for (int i = 0; i < 100 ; i++) {
            	if (name.equals("a")) {
            		//ֻҪc�߳�û��ִ��,�����߳���������,ֻ��c�߳�ִ�����˲Ż�����
                    if ( !c ) condition.await(); 
                    //��ʼִ��a�߳�
                    a = true;
                    b = false;
                    c = false;
                } else if (name.equals("l")) {
                    //ֻ��a1��a2ͬʱΪtrueʱ�Ŵ�ӡB������������ǰ�߳�
                    if ( !a ) condition.await();
                    b = true;
                    a = false;
                    c = false;
                } else if (name.equals("i")) {
                    if ( !b ) condition.await();
                    c = true;
                    a = false;
                    b = false;
                }
                System.out.print(name);
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
