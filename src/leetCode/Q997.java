package leetCode;

/**
 * 功能描述：
 *  给定一个按非递减顺序排序的整数数组 A，返回每个数字的平方组成的新数组，要求也按非递减顺序排序。
 * 示例 1：
 *
 * 输入：[-4,-1,0,3,10]
 * 输出：[0,1,9,16,100]
 *  1 <= A.length <= 10000
 *  -10000 <= A[i] <= 10000
 *
 *
 * @author Karlo
 * @date 2019/2/18 10:41
 */
public class Q997 {
    public static void main(String[] args) {
        int[] ints = new int[]{-4,-1,0,3,10};
//        for (int i = 0; i < ints.length; i++) {
//            ints[i] = i;
//        }
        int[] result = sortedSquares(ints);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }


    public static int[] sortedSquares1(int[] A) {
        int length = 0;
        for (int i = 0; i < A.length; i++) {
            if(A[i]< 0){
                length ++;
            }else{
                break;
            }
        }
        //负数部分
        int[] b = new int[length];
        //0和正数部分
        int[] c = new int[A.length - length];
        int tmpLength = length;
        for (int i = 0; i < length; i++) {
            b[tmpLength-1] = A[i] * A[i];
            tmpLength -- ;
        }

        int index = 0;
        for (int i = length; i < A.length; i++) {
            c[index] = A[i] * A[i];
            index ++;
        }

        int p1 = 0;
        int p2 = 0;
        int tmp = 0;
        while(p1 < length && p2 < A.length - length){
            if(b[p1]< c[p2]){
                A[tmp] = b[p1];
                tmp++;
                p1++;
            }else{
                A[tmp] = c[p2];
                tmp++;
                p2++;
            }
        }
        while(p1 == length && p2 <A.length - length){
            A[tmp] = c[p2];
            tmp++;
            p2++;
        }

        while(p1 < length && p2 == A.length -length){
            A[tmp] = b[p1];
            tmp++;
            p1++;
        }
        return A;
    }

    public static int[] sortedSquares(int[] A) {
        //负数部分
        int[] b = new int[A.length];
        //非负数部分
        int[] c = new int[A.length];
        int t1 = 0;
        int t2 = 0;
        for (int i = 0; i < A.length; i++) {
            if(A[i]<0){
               b[t1] = A[i] * A[i];
               t1++;
            }else{
                c[t2] = A[i] * A[i];
                t2++;
            }
        }
        int p1 = t1-1;
        int p2 = 0;
        for (int i = 0; i < A.length; i++) {
            if(p1 >=0 && p2 < t2){
                if(b[p1]<c[p2]){
                    A[i] = b[p1];
                    p1--;
                }else{
                    A[i] = c[p2];
                    p2++;
                }
            }else if(p1 < 0 && p2 < t2){
                A[i] = c[p2];
                p2++;
            }else if(p1 >= 0 && p2 >= t2){
                A[i] = b[p1];
                p1--;
            }
        }
        return A;
    }
}
