package test;

/**
 * 功能描述:
 *
 * @author karlo
 * @date 2019/3/14 21:18
 * @since 1.0.0
 */

public class Test8 {
    public static void main(String[] args) {
        int i = 1 << 30;
        System.out.println(i);
        int j = 1 << 31;
        System.out.println(j);
        System.out.println(j-1);
        System.out.println(Integer.MAX_VALUE);
    }


}
