package leetCode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 功能描述：
 *      在一个小镇里，按从 1 到 N 标记了 N 个人。传言称，这些人中有一个是小镇上的秘密法官。
 *
 * 如果小镇的法官真的存在，那么：
 *
 * 小镇的法官不相信任何人。
 * 每个人（除了小镇法官外）都信任小镇的法官。
 * 只有一个人同时满足属性 1 和属性 2 。
 * 给定数组 trust，该数组由信任对 trust[i] = [a, b] 组成，表示标记为 a 的人信任标记为 b 的人。
 *
 * 如果小镇存在秘密法官并且可以确定他的身份，请返回该法官的标记。否则，返回 -1。
 * 示例 1：
 * 输入：N = 2, trust = [[1,2]]
 * 输出：2
 * 示例 2：
 * 输入：N = 3, trust = [[1,3],[2,3]]
 * 输出：3
 * 示例 3：
 * 输入：N = 3, trust = [[1,3],[2,3],[3,1]]
 * 输出：-1
 * 示例 4：
 * 输入：N = 3, trust = [[1,2],[2,3]]
 * 输出：-1
 * 示例 5：
 * 输入：N = 4, trust = [[1,3],[1,4],[2,3],[2,4],[4,3]]
 * 输出：3
 *
 * @author Karlo
 * @date 2019/2/25 09:32
 */
public class Q997new {
    public static void main(String[] args) {
        int N = 3;
        int[][] trust = new int[][]{{1, 3}, {2, 3}, {3, 1}};
        System.out.println(findJudge(N, trust));
    }

    private static int findJudge(int N, int[][] trust) {
        Set<Integer> set = new HashSet<>();
        Map<Integer, Integer> map = new HashMap<>(N);
        //可能的输入  1 []
        if(trust.length == 0){
            return 1;
        }
        int[] tmp = new int[N+1];
        for (int i = 0; i < trust.length; i++) {
            set.add(trust[i][0]);
            tmp[trust[i][0]] = 1;
            Integer times = map.getOrDefault(trust[i][1], 0);
            map.put(trust[i][1],times + 1);
        }
        if(set.size() != N - 1){
            return -1;
        }
        int t = 0;
        for (int i = 1; i < N+1; i++) {
            if(tmp[i] == 0){
                t = i;
                break;
            }
        }
        if(set.contains(t)){
            return -1;
        }
        if(map.get(t) == N-1){
            return t;
        }else{
            return -1;
        }

    }
}
