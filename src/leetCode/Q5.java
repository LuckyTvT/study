package leetCode;

/**
 * 功能描述：
 *      最长回文子串
 * @author Karlo
 * @date 2019/3/26 09:52
 */
public class Q5 {
    public static void main(String[] args) {
        String s = "babad";
        String s1 = longestPalindrome(s);
        System.out.println(s1);

    }

    public static String longestPalindrome(String s) {
        if(s == null || "".equals(s) || s.length()< 2){
            return s;
        }
        char[] chars = s.toCharArray();

        for (int i = 1; i < chars.length-1; i++) {
            if(chars[i] == chars[i+1]){
                if(chars[i-1] == chars[i+2]){

                }
            }else{
                if(chars[i-1] == chars[i+1]){

                }
            }
        }
        return "";

    }

}
