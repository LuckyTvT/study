package leetCode;

/**
 * 功能描述：
 *
 * @author Karlo
 * @date 2019/3/19 10:32
 */
public class Q832 {
    public static void main(String[] args) {
        int[][] A ={{1,1,0},{0,1,0},{0,0,0}};
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                System.out.print(A[i][j]);
                System.out.print(",");
            }
            System.out.println();
        }
        System.out.println("------------");
        int[][] ints = flipAndInvertImage(A);
        for (int i = 0; i < ints.length; i++) {
            for (int j = 0; j < ints[0].length; j++) {
                System.out.print(ints[i][j]);
                System.out.print(",");
            }
            System.out.println();
        }
    }

    public static int[][] flipAndInvertImage(int[][] A) {
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[i].length / 2; j++) {
                if((A[i][j] ^ A[i][(A[i].length -1-j)]) != 1){
                    //如果两个被交换的值相同，变换位置后，再进行反转，实际上就是将0->1  1->0
                    A[i][j] = A[i][j] ^ 1;
                    A[i][(A[i].length -1-j)] = A[i][(A[i].length -1-j)] ^ 1;
                }else{
                    //如果两个被交换的值不相同，变换位置后，需要反转，实际上就是保持原有值不变
                    //这里直接不做处理即可
                }
            }
        }
        if(A.length % 2 ==1){
            int t = A.length/2;
            for (int k = 0; k < A.length; k++) {
                A[k][t] = A[k][t] ^ 1;
            }
        }
        return A;
    }

    public static int[][] flipAndInvertImage1(int[][] A) {
        if(A.length % 2 == 1){
            int t = A.length/2;
            for (int i = 0; i < A.length; i++) {
                A[i][t] = A[i][t] ^ 1;
                for (int j = 0; j < A[i].length / 2; j++) {
                    if((A[i][j] ^ A[i][(A[i].length -1-j)]) != 1){
                        //如果两个被交换的值相同，变换位置后，再进行反转，实际上就是将0->1  1->0
                        A[i][j] = A[i][j] ^ 1;
                        A[i][(A[i].length -1-j)] = A[i][(A[i].length -1-j)] ^ 1;
                    }
                }
            }
        }else{
            for (int i = 0; i < A.length; i++) {
                for (int j = 0; j < A[i].length / 2; j++) {
                    if((A[i][j] ^ A[i][(A[i].length -1-j)]) != 1){
                        //如果两个被交换的值相同，变换位置后，再进行反转，实际上就是将0->1  1->0
                        A[i][j] = A[i][j] ^ 1;
                        A[i][(A[i].length -1-j)] = A[i][(A[i].length -1-j)] ^ 1;
                    }else{
                        //如果两个被交换的值不相同，变换位置后，需要反转，实际上就是保持原有值不变
                        //这里直接不做处理即可
                    }
                }
            }
        }
        return A;
    }
}
