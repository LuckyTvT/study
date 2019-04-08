package leetCode;

import java.util.Scanner;

/**
 * 功能描述：
 *      leetcode 691题镜面反射
 *      1<= p <=1000
 *      0<= q <= q
 * @author Karlo
 * @date 2019/2/13 09:54
 */
public class Q858 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String ps = scanner.nextLine();
        String qs = scanner.nextLine();
        Integer p = Integer.valueOf(ps);
        Integer q = Integer.valueOf(qs);
        mirrorReflection(p,q);
//        int gcd = gcd(p, q);
//        System.out.println(gcd);

    }
    public static int mirrorReflection(int p, int q) {

        int gcd = gcd(p, q);
        p = p / gcd;
        q = q / gcd;
        return (p+1)%2+q%2;


    }

    public static int gcd(int p, int q){
        int max = (p > q) ? p : q;
        int min = (p < q) ? p : q;
        while(max % min != 0){
            return gcd(min,max%min);
        }
        return min;
    }
}
