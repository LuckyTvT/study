package leetCode;

import java.util.*;

/**
 * 功能描述：
 *  我们有一个由平面上的点组成的列表 points。需要从中找出 K 个距离原点 (0, 0) 最近的点。
 *
 * （这里，平面上两点之间的距离是欧几里德距离。）
 *
 * 你可以按任何顺序返回答案。除了点坐标的顺序之外，答案确保是唯一的。
 * @author Karlo
 * @date 2019/2/15 09:41
 */
public class Q973 {
    public static void main(String[] args) {
        int[][] points = {{3,3},{5,-1},{-2,4}};
        int K = 2;
        int[][] ints = kClosest1(points, K);
        System.out.println(ints);
    }

    public static int[][] kClosest(int[][] points, int K) {
        Map<Double, Integer> map = new HashMap<>();
        List<Double> list = new ArrayList<>();
        for (int i = 0; i < points.length; i++) {
            double t = Math.sqrt(Math.pow(points[i][0], 2)+Math.pow(points[i][1], 2));
            map.put(t,i);
            list.add(t);
        }
        Collections.sort(list, (o1, o2) -> {
            if(o1.equals(o2)){
                return 0;
            }else{
                return o1 < o2 ? -1 : 1;
            }
        });
        int[][] ints = new int[K][2];
        for (int i = 0; i < K; i++) {
            for (int j = 0; j < 2; j++) {
                ints[i][j] = points[map.get(list.get(i))][j];
            }
        }
        return ints;
    }

    public static int[][] kClosest1(int[][] points, int K) {

        TreeMap<Double, Integer> treeMap = new TreeMap<>();
        for (int i = 0; i < points.length; i++) {
            double t = Math.sqrt(points[i][0]*points[i][0]+points[i][1]*points[i][1]);
            treeMap.put(t,i);
        }
        ArrayList<Integer> list = new ArrayList<>();
        Double key = treeMap.firstKey();
        for (int i = 0; i < K; i++) {
            list.add(treeMap.get(key));
            key = treeMap.higherKey(key);
        }
        int[][] ints = new int[K][2];
        for (int i = 0; i < K; i++) {
            for (int j = 0; j < 2; j++) {
                ints[i][j] = points[list.get(i)][j];
            }
        }
        return ints;
    }

}
