package designmode;

/**
 * 功能描述:
 * 建造者模式：将复杂对象的创建和表示分离，使得同样的创建可以创建不同的表示
 *
 * @author karlo
 * @date 2019-03-16 17:49
 * @since 1.0.0
 */

public class DesignMode9 {
    public static void main(String[] args) {
        BuilderFirst first = new BuilderFirst();
        BuilderSecond second = new BuilderSecond();
        Director director = new Director(first);
        People people = director.build();
        Director director1 = new Director(second);
        People people1 = director1.build();
        System.out.println(people.getHead());
        System.out.println(people1.getHead());
    }
}


class People {
    private String head;
    private String body;
    private String hand;
    private String foot;

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getHand() {
        return hand;
    }

    public void setHand(String hand) {
        this.hand = hand;
    }

    public String getFoot() {
        return foot;
    }

    public void setFoot(String foot) {
        this.foot = foot;
    }
}

class Director {
    //指挥者
    private Builder builder;
    public Director(Builder builder) {
        this.builder = builder;
    }

    public People build(){
        builder.buildHead();
        builder.buildBody();
        builder.buildHand();
        builder.buildFoot();
        return builder.getPeople();
    }

}

interface Builder {
    void buildHead();
    void buildBody();
    void buildHand();
    void buildFoot();
    People getPeople();
}

class BuilderFirst implements Builder {
    private People people = new People();
    //建造者
    public void buildHead() {
        people.setHead("head");
    }

    public void buildBody() {
        people.setBody("body");
    }

    public void buildHand() {
        people.setHand("hand");
    }

    public void buildFoot() {
        people.setFoot("foot");
    }

    public People getPeople(){
        return people;
    }

}

class BuilderSecond implements Builder {

    private People people = new People();

    @Override
    public void buildHead() {
        people.setHead("head1");
    }

    @Override
    public void buildBody() {
        people.setBody("body1");
    }

    @Override
    public void buildHand() {
        people.setHand("hand1");
    }

    @Override
    public void buildFoot() {
        people.setFoot("foot1");
    }

    @Override
    public People getPeople() {
        return people;
    }
}

