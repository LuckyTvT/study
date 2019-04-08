package test;

/**
 * 功能描述：
 *
 * @author Karlo
 * @date 2019/2/26 10:53
 */
public class S1 {
    public static void main(String[] args) {
        long s = 0xffffffff00000000L;
        System.out.println(s);
        long l = 0x00000000ffffffffL;
        double l1 = 15*Math.pow(16,7)+15*Math.pow(16,6)+15*Math.pow(16,5)+15*Math.pow(16,4)
                +15*Math.pow(16,3)+15*Math.pow(16,2)+15*Math.pow(16,1)+15*Math.pow(16,0);

        System.out.println(l);
        System.out.println(l1);
        long t1 = 0xffffffffffffffffL;
        System.out.println(t1);
        long t2 = 0x0fffffffffffffffL;
        System.out.println(t2);
        long t3 = 0xafffffffffffffffL;
        System.out.println(t3);

        long l2 = 0xffffffff00000000L | 0x00000000ffffffffL;
        System.out.println(l2);

        int i = -43 | 40;
        System.out.println(i);

        int i1 = -43 & 40;
        System.out.println(i1);

    }



}


