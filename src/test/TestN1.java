package test;

import java.util.HashMap;
import java.util.Map;

/**
 * 功能描述：
 *
 * @author Karlo
 * @date 2019/3/1 16:30
 */
public class TestN1 {

    public static void main(String[] args) {
        System.out.println(ActivityId.getAct(1) instanceof String);
        System.out.println(ActivityId.getAct(2));
        System.out.println(ActivityId.getAct(3));
        System.out.println(ActivityId.getAct(4));
        System.out.println(ActivityId.ACT_1.toString());

    }


}

enum ActivityId{
//
//    ACT_1(1,"act1"),
//    ACT_2(2,"act2"),
//    ACT_3(3,"act3"),
//    ACT_4(4,"act4");

    ACT_1(1),
    ACT_2(2),
    ACT_3(3),
    ACT_4(4);

    private final Integer actType;
//    private final String value;

    ActivityId(Integer actType) {
        this.actType = actType;
//        this.value = value;
    }

    private static final Map<Integer,String> enumMap = new HashMap<>();

    static{
        for (ActivityId value : ActivityId.values()) {
            enumMap.put(value.actType,value.toString());
        }
    }

    public static String getAct(Integer actType){
        if(actType == null){
            return null;
        }
        return enumMap.get(actType);
    }

}
