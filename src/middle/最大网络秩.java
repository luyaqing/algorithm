package middle;

import java.util.Arrays;

/**
 * @Description n 座城市和一些连接这些城市的道路 roads 共同组成一个基础设施网络。每个 roads[i] = [ai, bi]
 * 都表示在城市 ai 和 bi 之间有一条双向道路。
 *  求最大网络秩
 *
 *  明白原理之后，这个其实是很简单的，
 *  快手二面就是这个算法， 当时做的时候完全没思路。。哈哈
 *
 * @Author Hasee
 * @Date 2022/4/17 19:04
 * @Version 1.0
 */
public class 最大网络秩 {

    public static int maximalNetworkRank(int n, int[][] roads) {
        int[][] map = new int[n][n];//邻接矩阵
        int[] degree = new int[n];//出度
        for (int[] road : roads) {
            map[road[0]][road[1]]++;
            map[road[1]][road[0]]++;
            degree[road[0]]++;
            degree[road[1]]++;
        }

        for (int[] aa : map) {
            System.out.println(Arrays.toString(aa));
        }
        System.out.println("----------");
        System.out.println(Arrays.toString(degree));

        int ans =Integer.MIN_VALUE;
        for (int i = 0; i <n-1 ; i++) {
            for (int j = i+1; j <n ; j++) {
                // 出度的意思是，计算顶点出现的次数， 邻接矩阵中为1的表示是重复的边
                int temp = degree[i]+degree[j]-map[i][j]; //出度和减去重复的边   
                ans = Math.max(ans,temp);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int n = 4;
        int[][] roads = {{0,1},{0,3},{1,2},{1,3}};
        System.out.println(maximalNetworkRank(n, roads));
        System.out.println(getMaxNetWorkRank(n, roads));
    }

    public static int getMaxNetWorkRank(int n, int[][] roads) {

        int[][] map = new int[n][n];
        int[] degree = new int[4];

        for (int[] road : roads) {
            map[road[0]][road[1]]++;
            map[road[1]][road[0]]++;
            degree[road[0]]++;
            degree[road[1]]++;
        }

        int ans = 0;
        for (int i = 0; i < n-1; i++) {
            for (int j = i+1; j < n;  j++) {
                int count = degree[i] + degree[j] - map[i][j];
                ans = Math.max(ans, count);
            }
        }

        return ans;
    }

}
