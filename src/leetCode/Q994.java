package leetCode;

import java.util.*;

/**
 * 功能描述：
 * 在给定的网格中，每个单元格可以有以下三个值之一：
 * <p>
 * 值 0 代表空单元格；
 * 值 1 代表新鲜橘子；
 * 值 2 代表腐烂的橘子。
 * 每分钟，任何与腐烂的橘子（在 4 个正方向上）相邻的新鲜橘子都会腐烂。
 * <p>
 * 返回直到单元格中没有新鲜橘子为止所必须经过的最小分钟数。如果不可能，返回 -1。
 *
 * @author Karlo
 * @date 2019/2/22 15:24
 */
public class Q994 {

    public static void main(String[] args) {
        int[][] grid = new int[][]{{1},{2},{1},{2}};
//        int[][] grid = new int[][]{{2,2,2,1,1}};
        System.out.println(orangesRotting1(grid));
    }

    public static int orangesRotting1(int[][] grid) {
        //腐烂橘子队列
        Deque<Integer> rotted = new ArrayDeque<>();
        //记录每个格子深度
        Map<Integer, Integer> depth = new HashMap<>();
        int h = grid.length;
        int l = grid[0].length;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if(grid[i][j] == 2){
                    rotted.add(i * l+ j);
                    depth.put(i * l + j,0);
                }
            }
        }
        int time = 0;
        int[] dh = {-1,0,1,0};
        int[] dl = {0,-1,0,1};
        while(!rotted.isEmpty()) {
            //找到腐烂的橘子，然后确定其在2维数组中的位置，然后 对坐标进行±1
            Integer rottedOrange = rotted.remove();
            //获取坐标
            for (int k = 0; k < 4; k++) {
                int i = rottedOrange / l + dh[k];
                int j = rottedOrange % l + dl[k];
                if(i>=0 && j>=0 && i<h && j<l && grid[i][j] == 1){
                    grid[i][j] = 2;
                    rotted.add(i*l + j);
                    depth.put(i*l+j,depth.get(rottedOrange)+1);
                    time = depth.get(i*l+j);
                }
            }

        }
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if(grid[i][j] == 1){
                    return -1;
                }
            }
        }
        return time;
    }

    public static int orangesRotting(int[][] grid) {
        int R = grid.length, C = grid[0].length;
        int[] dr = new int[]{-1, 0, 1, 0};
        int[] dc = new int[]{0, -1, 0, 1};
        // queue : all starting cells with rotten oranges
        Queue<Integer> queue = new ArrayDeque();
        Map<Integer, Integer> depth = new HashMap();
        for (int r = 0; r < R; ++r) {
            for (int c = 0; c < C; ++c) {
                if (grid[r][c] == 2) {
                    int code = r * C + c;
                    queue.add(code);
                    depth.put(code, 0);
                }
            }
        }

        int ans = 0;
        while (!queue.isEmpty()) {
            int code = queue.remove();
            int r = code / C, c = code % C;
            for (int k = 0; k < 4; ++k) {
                int nr = r + dr[k];
                int nc = c + dc[k];
                if (0 <= nr && nr < R && 0 <= nc && nc < C && grid[nr][nc] == 1) {
                    grid[nr][nc] = 2;
                    int ncode = nr * C + nc;
                    queue.add(ncode);
                    depth.put(ncode, depth.get(code) + 1);
                    ans = depth.get(ncode);
                }
            }
        }

        for (int[] row : grid){
            for (int v : row){
                if (v == 1){
                    return -1;
                }
            }
        }

        return ans;

    }

}
