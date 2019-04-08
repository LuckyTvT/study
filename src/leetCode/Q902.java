package leetCode;

/**
 * 功能描述：
 *
 * @author Karlo
 * @date 2019/2/13 16:54
 */
public class Q902 {

    public static void main(String[] args) {
//        String[] D = new String[]{"1","2","3","4","5","6","7","8","9"};
        String[] D = new String[]{"1","3","5","7"};
        int N = 941;
        int i = atMostNGivenDigitSet(D, N);
        System.out.println(i);
    }

    public static int atMostNGivenDigitSet(String[] D, int N) {
        //统计多少个组合符合要求
        int count;
        String strN = String.valueOf(N);
        //给定数字最高位
        int highNum = Integer.valueOf(strN.substring(0, 1));
        //去掉最高位的长度
        int targetLength = strN.length() - 1;
        int t = 0;
        for (int i = 0; i < D.length; i++) {
            if(Integer.valueOf(D[i]) < highNum){
                t++;
            }
        }
        //判断数组中是否有跟给定数字最高位相同的数字
        boolean trig = false;
        for (int i = 0; i < D.length; i++) {
            if(Integer.valueOf(D[i]).equals(highNum)){
                trig = true;
                break;
            }
        }

        if(targetLength == 0){
            //说明此时长度只有1，直接返回数组中等于该数字的数量
            return trig ? t+1 : t;
        }

        //计算比给定数字位数少的所有组合数量
        if(D.length == 1){
            count = targetLength;
        }else{
            count = (D.length - (int)Math.pow(D.length,targetLength+1)) / (1-D.length);
        }

        //计算最高位小于给定数字的组合数量
        count = count + t * (int)Math.pow(D.length,targetLength);
        //计算最高位相等的组合的数量
        int temp = 0;
        if(trig){
            temp = re(D,strN);
        }
        return count + temp;
    }

    private static int re(String[] D, String N) {
        String newN = N.substring(1);
        if(newN.length() == 1){
            int t1 = 0;
            for (int i = 0; i < D.length; i++) {
                if(Integer.valueOf(D[i]) <= Integer.valueOf(newN)){
                    t1 ++;
                }
            }
            return t1;
        }
        String highStr = newN.substring(0,1);
        int highNum = Integer.valueOf(highStr);
        int temp = 0;
        int count = 0;
        boolean trig = false;
        for (int i = 0; i < D.length; i++) {
            if(Integer.valueOf(D[i]) ==  highNum){
                trig = true;
                break;
            }
        }
        for (int i = 0; i < D.length; i++) {
            if(Integer.valueOf(D[i]) < highNum){
                temp ++;
            }
        }
        count = temp * (int)Math.pow(D.length,newN.length()-1);
        int re = 0;
        if(trig){
            re = re(D, newN);
        }

        return count+re;
    }

}
