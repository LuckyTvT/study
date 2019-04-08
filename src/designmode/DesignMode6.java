package designmode;

import java.util.Objects;

/**
 * 功能描述：
 *      原型模式（prototype）:说白了就是通过深克隆、浅克隆来复制对象，避免创建对象消耗资源。
 *          用原型实例指定创建对象的种类，并且通过拷贝这些原型创建新的对象。
 * @author Karlo
 * @date 2019/3/5 09:54
 */
public class DesignMode6 {
    public static void main(String[] args) {
        Person z = new Person("Z");
        z.age = 27;
        Person person = new Person(z);
        person.age = 30;
        System.out.println(z.age);
        System.out.println(person.age);


        Asian y = new Asian("y", z);
        System.out.println(y.person.age);
        Asian asian = new Asian(y);
        System.out.println(asian.person.age);
        asian.person.age = 55;
        System.out.println(y.person.age);
        System.out.println(asian.person.age);



    }
}

class Resume implements Cloneable{
    public int id;
    public String name;
    public String content;


    public Resume(String name) {
        this.name = name;
    }

    public void setIdandContent(int id, String content){
        this.id = id;
        this.content = content;
    }

    @Override
    public String toString() {
        return "Resume{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", content='" + content + '\'' +
                '}';
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

class Person implements Cloneable{
    public int age;
    public String name;

    public Person(String name) {
        this.name = name;
    }

    public Person(Person p){
        this.age = p.age;
        this.name = p.name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person person = (Person) o;
        return age == person.age &&
                name.equals(person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(age, name);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

class Asian{
    public String skin;
    public Person person;

    public Asian(String skin, Person person) {
        this.skin = skin;
        this.person = person;
    }

    public Asian(Asian a){
        this(a.skin,a.person);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Asian)) return false;
        Asian asian = (Asian) o;
        return Objects.equals(skin, asian.skin) &&
                Objects.equals(person, asian.person);
    }

    @Override
    public int hashCode() {
        return Objects.hash(skin, person);
    }
}




