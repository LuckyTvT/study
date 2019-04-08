package test;


import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 功能描述：
 *
 * @author Karlo
 * @date 2019/2/27 16:21
 */
public class Test2 {
    public static void main(String[] args) {

        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(10, 20, 20L, TimeUnit.SECONDS, new ArrayBlockingQueue<>(10));
        int activeCount = threadPoolExecutor.getActiveCount();
        System.out.println(activeCount);
        threadPoolExecutor.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println("ssss");
            }
        });
        System.out.println(threadPoolExecutor.getActiveCount());
        threadPoolExecutor.shutdownNow();
//
    }

}

class Testx{

    public void test(){
        synchronized (this){
            System.out.println(Thread.currentThread().getName());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}