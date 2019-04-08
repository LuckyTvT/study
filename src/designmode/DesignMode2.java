package designmode;

/**
 * 功能描述：
 *      工厂模式
 * @author Karlo
 * @date 2019/3/1 15:29
 */
public class DesignMode2 {

    public static void main(String[] args) {
        Parent bean = BeanFactory.getBean("1");
        System.out.println(bean instanceof Child1);
        System.out.println(bean instanceof Child2);
        System.out.println(bean instanceof Child3);

    }

}


interface Parent {

}

class Child1 implements Parent {

}

class Child2 implements Parent {

}

class Child3 implements Parent {

}


class BeanFactory{

    public static Parent getBean(String childName){
        Parent parent = null;
        switch(childName){
            case "1":
                parent = new Child1();
                break;
            case "2":
                parent = new Child2();
                break;
            case "3":
                parent = new Child3();
                break;
        }
        return parent;
    }
}