package PAT;

import java.util.Scanner;

/**
 * 功能描述：
 *
 * 读入一个正整数 n，计算其各位数字之和，用汉语拼音写出和的每一位数字。
 *
 * 输入格式：
 *
 * 每个测试输入包含 1 个测试用例，即给出自然数 n 的值。这里保证 n 小于 10
 * ​100
 * ​​ 。
 *
 * 输出格式：
 *
 * 在一行内输出 n 的各位数字之和的每一位，拼音数字间有 1 空格，但一行中最后一个拼音数字后没有空格。
 *
 * 输入样例：
 *
 * 1234567890987654321123456789
 * 输出样例：
 *
 * yi san wu
 * @author Karlo
 * @date 2019/2/21 10:24
 */
public class Q1002 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            result  += (int)c - 48;
        }

        System.out.println(result);
    }
}
