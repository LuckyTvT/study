package leetCode;

import java.util.HashSet;
import java.util.Set;

/**
 * 功能描述:
 *  国际摩尔斯密码定义一种标准编码方式，将每个字母对应于一个由一系列点和短线组成的字符串，
 *  比如: "a" 对应 ".-", "b" 对应 "-...", "c" 对应 "-.-.", 等等。
 *
 * 为了方便，所有26个英文字母对应摩尔斯密码表如下：
 *
 * [".-","-...","-.-.","-..",".","..-.","--.","....","..",".---",
 * "-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."]
 * 给定一个单词列表，每个单词可以写成每个字母对应摩尔斯密码的组合。例如，"cab"
 * 可以写成 "-.-..--..."，(即 "-.-." + "-..." + ".-"字符串的结合)。我们将这样一个连接过程称作单词翻译。
 *
 * 返回我们可以获得所有词不同单词翻译的数量。
 *
 * 例如:
 * 输入: words = ["gin", "zen", "gig", "msg"]
 * 输出: 2
 * 解释:
 * 各单词翻译如下:
 * "gin" -> "--...-."
 * "zen" -> "--...-."
 * "gig" -> "--...--."
 * "msg" -> "--...--."
 *
 * 共有 2 种不同翻译, "--...-." 和 "--...--.".
 * @author karlo
 * @date 2019/3/7 22:02
 * @since 1.0.0
 */

public class Q804 {
    public static void main(String[] args) {
        String[] words = {"gin", "zen", "gig", "msg"};
        int i = uniqueMorseRepresentations(words);
        System.out.println(i);
    }

    public static int uniqueMorseRepresentations(String[] words) {
        String[] mos = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---",
                 "-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        Set<String> strings = new HashSet<>();
        for (String word : words) {
            StringBuilder tmp = new StringBuilder();
            for (int i = 0; i < word.length(); i++) {
                int t = word.charAt(i) - 97;
                tmp = tmp.append(mos[t]);
            }
            strings.add(tmp.toString());
        }
        return strings.size();
    }


}
