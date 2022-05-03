package 漫画算法;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @Description 如何求解金矿问题
 *
 *      题目： 总共10个工人， 一座金矿是200kg 需要3个人， 一个是300kg / 4个人
 *      一个是350kg / 3个人， 一个是400kg / 5个人  一个是500kg / 5个人
 * @Author Hasee
 * @Date 2022/5/3 12:05
 * @Version 1.0
 */
public class 金矿问题 {

    /**
     * 获得金矿的最优收益
     * @param w 工人数量
     * @param n 可选金矿数量
     * @param p 金矿开采所需的工人数量
     * @param g 金矿储量
     * @return
     */
    public static int getMaxGolden(int w, int n, int[] p, int[] g) {

        // 问题边界
        if (w == 0 || n == 0) {
            return 0;
        }

        // 特殊情况需要考虑下这个问题
        if (w < p[n-1]) {
            return getMaxGolden(w, n -1, p, g);
        }

        // 常规情况下， 有两种最优的子结构， （当前金矿挖和不挖）
        return Math.max(getMaxGolden(w, n -1, p, g), getMaxGolden(w-p[n-1], n-1, p, g) + g[n-1]);
    }

    public static void main(String[] args) {
        int w = 10;
        int[] p = {5,5,3,4,3};
        int[] g = {400,500,200,300,350};
        System.out.println(getMaxGolden(w, g.length, p, g));
    }
}
