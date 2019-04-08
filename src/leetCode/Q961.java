package leetCode;

import java.util.HashMap;

/**
 * 功能描述：
 *
 * @author Karlo
 * @date 2019/2/21 09:07
 */
public class Q961 {

    public static void main(String[] args) {
        int[] A = new int[10];
        System.out.println(repeatedNTimes(A));

    }

    public static int repeatedNTimes(int[] A) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            Integer result = map.get(A[i]);
            if(result != null){
                return A[i];
            }else{
                map.put(A[i],0);
            }
        }
        return 0;
    }

}
