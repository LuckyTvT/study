package designmode;


import java.util.Random;

/**
 * 功能描述：
 *      代理模式
 * @author Karlo
 * @date 2019/3/4 14:49
 */
public class DesignMode4 {
    public static void main(String[] args) {
        RealSub realSub = new RealSub();
        Proxy proxy = new Proxy(realSub);
        proxy.done();
    }
}

interface Subject{
    void done();
}

class RealSub implements Subject {

    @Override
    public void done() {
        System.out.println("this is real Subject done!");
    }
}

class Proxy implements Subject {
    private Subject subject;

    public Proxy(Subject subject) {
        this.subject = subject;
    }

    @Override
    public void done() {
        Random random = new Random();
        boolean tmp = random.nextBoolean();
        System.out.println(tmp);
        if(tmp){
            System.out.println("this is proxy!");
            subject.done();
        }else{
            System.out.println("i can't do it!");
        }
    }
}