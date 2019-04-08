package leetCode;

/**
 * 功能描述：
 *      实现函数 ToLowerCase()，该函数接收一个字符串参数 str，并将该字符串中的大写字母转换成小写字母，之后返回新的字符串。
 *      可直接 toLowerCase()
 * @author Karlo
 * @date 2019/2/19 10:29
 */
public class Q709 {
    public static void main(String[] args) {
        String str = "SEdd";
        System.out.println(System.nanoTime());
        System.out.println((int)'A'+"  "+(int)'Z'+"  "+(int)'a'+"  "+(int)'z');
        System.out.println(toLowerCase(str));
        System.out.println(System.nanoTime());
    }
    public static String toLowerCase1(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if(c <= 90 && c >= 65){
                sb.append((char)(str.charAt(i)+32));
            }else{
                sb.append(str.charAt(i));
            }
        }
        return sb.toString();

    }

    public static String toLowerCase(String str){
        return str.toLowerCase();
    }
}
