package test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 功能描述：
 *
 * @author Karlo
 * @date 2019/2/21 10:12
 */
public class Proxy {
    public static void main(String[] args) {
        Student student = new Student();
        Person monitor = new Monitor(student);

        Person stuProxy = (Person)java.lang.reflect.Proxy.newProxyInstance(Person.class.getClassLoader(), new Class<?>[]{Person.class},
                new MyInvocationHandler<>(monitor));
        stuProxy.giveMoney(2);


    }
}

interface Person{

    public void giveMoney(int i);
}

class Student implements Person {
    @Override
    public void giveMoney(int i){
        System.out.println("交钱了"+i);
    }
}

class Monitor implements Person {

    Student student;

    public Monitor(Student student) {
        this.student = student;
    }
    @Override
    public void giveMoney(int i){
        System.out.println("this is monitor!");
        student.giveMoney(i);
    }

}

class MyInvocationHandler<T> implements InvocationHandler{

    T target;

    public MyInvocationHandler(T target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("代理执行"+method.getName()+"方法！");
        Object result = method.invoke(target, args);
        return result;
    }
}