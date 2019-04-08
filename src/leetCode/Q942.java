package leetCode;

/**
 * 功能描述：
 *  给定只含 "I"（增大）或 "D"（减小）的字符串 S ，令 N = S.length。
 *
 * 返回 [0, 1, ..., N] 的任意排列 A 使得对于所有 i = 0, ..., N-1，都有：
 *
 * 如果 S[i] == "I"，那么 A[i] < A[i+1]
 * 如果 S[i] == "D"，那么 A[i] > A[i+1]
 *
 *
 * 示例 1：
 * 输出："IDID"
 * 输出：[0,4,1,3,2]
 *
 * 示例 2:
 * 输出："III"
 * 输出：[0,1,2,3]
 *
 * 示例 3：
 * 输出："DDI"
 * 输出：[3,2,0,1]
 *
 * 1 <= S.length <= 1000
 * S 只包含字符 "I" 或 "D"。
 *
 * @author Karlo
 * @date 2019/2/20 14:35
 */
public class Q942 {
    public static void main(String[] args) {
        String S = "IDID";
        int[] ints = diStringMatch(S);
        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);
        }
//        System.out.println((int)'I'+"  "+(int)'D');
    }


    public static int[] diStringMatch(String S) {
        int length = S.length();
        int[] s = new int[length+1];
        int head = 0;
        int tail = length;
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            if((int)c == 'I'){
                s[i] = head;
                head ++;
            }
            if((int)c == 'D'){
                s[i] = tail;
                tail -- ;
            }
        }
        s[length] = head;

        return s;
    }
}
