package designmode;

/**
 * 功能描述：
 *  策略模式ssssss
 * @author Karlo
 * @date 2019/3/1 15:37
 */
public class DesignMode1 {

    public static void main(String[] args) {
//        StrategyMode strategyModeA = new StrategyMode(new ConcreteStrategyA());
//        strategyModeA.algorithm();
//
//        StrategyMode strategyModeB = new StrategyMode(new ConcreteStrategyB());
//        strategyModeB.algorithm();
//
//        StrategyMode strategyModeC = new StrategyMode(new ConcreteStrategyC());
//        strategyModeC.algorithm();

        BeanFactoryStrategy.execute("A");
        BeanFactoryStrategy.execute("B");
        BeanFactoryStrategy.execute("C");




    }
}

interface Strategy{

    void algorithm();

}

class ConcreteStrategyA implements Strategy {

    @Override
    public void algorithm() {
        System.out.println(this.getClass().getName());
    }
}

class ConcreteStrategyB implements Strategy {

    @Override
    public void algorithm() {
        System.out.println(this.getClass().getName());
    }
}

class ConcreteStrategyC implements Strategy {

    @Override
    public void algorithm() {
        System.out.println(this.getClass().getName());
    }
}

class StrategyMode{

    Strategy strategy;

    public StrategyMode(Strategy strategy) {
        this.strategy = strategy;
    }

    public void algorithm(){
        strategy.algorithm();
    }
}


class BeanFactoryStrategy{
    public static void execute(String strategyName){
        Strategy strategy = null;
        switch (strategyName){
            case "A":
                strategy = new ConcreteStrategyA();
                break;
            case "B":
                strategy = new ConcreteStrategyB();
                break;
            case "C":
                strategy = new ConcreteStrategyC();
                break;
        }
        if(strategy != null){
            strategy.algorithm();
        }
    }
}