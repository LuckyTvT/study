package designmode;

/**
 * 功能描述：
 *      工厂方法模式
 *          对比：简单工厂方法 不方便扩展，增加功能时需要更改工厂类，
 *               工厂方法模式 方便扩展，增加功能时，只需要增加子类工厂实现即可。
 *
 * @author Karlo
 * @date 2019/3/4 15:32
 */
public class DesignMode5 {
    public static void main(String[] args) {

    }
}

interface Operation{
    void operate();
}

class Add implements Operation {
    @Override
    public void operate() {
        System.out.println("+");
    }
}

class Sub implements Operation {
    @Override
    public void operate() {
        System.out.println("-");
    }
}

interface FactoryParent{
    Operation operation();
}

class FactoryAdd implements FactoryParent {
    @Override
    public Operation operation() {
        return new Add();
    }
}

class FactorySub implements FactoryParent {
    @Override
    public Operation operation() {
        return new Sub();
    }
}

