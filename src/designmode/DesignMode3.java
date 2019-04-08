package designmode;

/**
 * 功能描述：
 *      装饰模式
 * @author Karlo
 * @date 2019/3/4 09:42
 */
public class DesignMode3 {
    public static void main(String[] args) {
        NiceGirl niceGirl = new NiceGirl();
        Friend friend = new Friend(niceGirl);
        friend.behavior();
    }
}

interface Girl{
    void behavior();
}

class NiceGirl implements Girl {
    @Override
    public void behavior() {
        System.out.println("I'm a nice girl!");
    }
}

class Friend implements Girl {

    private Girl girl;

    public Friend(Girl girl) {
        this.girl = girl;
    }

    @Override
    public void behavior() {
        System.out.println("I'm the nice gril friend!");
        girl.behavior();
    }
}
