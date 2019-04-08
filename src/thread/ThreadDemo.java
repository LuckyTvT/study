package thread;

/**
 * 功能描述：
 *
 * @author Karlo
 * @date 2019/4/8 09:16
 */
public class ThreadDemo {

    private static String result;

    public static void main(String[] args) throws InterruptedException {
        threadOneByOne();
    }

    private static void threadOneByOne() throws InterruptedException {
        Thread t1 = new Thread(ThreadDemo::action, "t1");
        Thread t2 = new Thread(ThreadDemo::action, "t2");
        Thread t3 = new Thread(ThreadDemo::action, "t3");

        //捕获线程异常
        t1.setUncaughtExceptionHandler((thread,throwable)->{
            System.out.printf("线程:[%s],异常[%s] \n", thread.getName(), throwable.getMessage());
        });
        t2.setUncaughtExceptionHandler((thread,throwable)->{
            System.out.printf("线程:[%s],异常[%s] \n", thread.getName(), throwable.getMessage());
        });
        t3.setUncaughtExceptionHandler((thread,throwable)->{
            System.out.printf("线程:[%s],异常[%s] \n", thread.getName(), throwable.getMessage());
        });

        t1.start();
        t1.join();
        t2.start();
        t2.join();
        t3.start();
        t3.join();

    }

    public static void action(){
        System.out.printf("线程:[%s]正在执行 \n",Thread.currentThread().getName());
        throw new RuntimeException("异常测试！");
    }

    /**
     * 字节码synchronized测试  确实有monitorenter 和monitorexit 详见out\production\leetcode\thread\tmp.txt
     */
    private static void test(){
        synchronized (result){

        }
    }

}
