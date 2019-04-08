package leetCode;

/**
 * 功能描述：
 *
 * @author Karlo
 * @date 2019/2/21 09:18
 */
public class Q905 {
    public static void main(String[] args) {
        int[] A = new int[10];
        sortArrayByParity(A);
    }

    public static int[] sortArrayByParity(int[] A) {
        int[] B = new int[A.length];
        int head = 0;
        int tail = A.length - 1;
        for (int i = 0; i < A.length; i++) {
            if(A[i] % 2 == 0){
                B[head] = A[i];
                head ++;
            }else{
                B[tail] = A[i];
                tail --;
            }
        }
        return B;
    }
}
