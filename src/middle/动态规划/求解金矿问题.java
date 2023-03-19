package middle.动态规划;

/**
 * 一个国王有五座金矿，每座金矿黄金的储量不同，需要参与挖掘的工人人数也不同， 例如有的金矿储量是500kg黄金，需要五个人来挖，有的金矿储备量是200kg黄金， 需要3个工人来挖掘。
 * 如果参与挖矿的工人的总数是10，每座金矿要么全挖、要么不挖，不能派出一半的人去挖取一半的金矿。要求用程序求出，要尽可能多的黄金，应该选择挖取哪几座金矿？
 *
 * 解法思路：
 * 金矿问题的状态转移方程式如下：
 * 金矿数量设为n， 工人数量设为w， 金矿的含金量设为数组g[], 金矿所需的开采人数设为数组p[], 设F(n, w) 为n个金w个工人时的最优收益函数，那状态转移方程式如下：
 *
 * F(n, w) = 0   (n = 0 或 w=0) 问题的边界，金矿数为0或工人数为0的情况。
 *
 * F(n,w) = F(n-1, w)   （n >=1, w < p[n-1]），
 * 当所剩工人数不够挖掘当前金矿时，只有一个最优子结构。
 *
 *
 * F(n,w) = max(F(n-1, w), F(n-1, w-p[n-1])+g[n-1]) (n >=1, w>=p[n-1])
 * 在常规的情况下， 具有两种最优子结构（挖当前金矿或不挖当前金矿）。
 */
public class 求解金矿问题 {

    public static void main(String[] args) {
        int w = 10;
        int[] p = {5,5,3,4,3};
        int[] g = {400,500,200,300,350};

        System.out.println(getMaxGold(w, g.length, p, g));
        System.out.println(getMaxGold2(w, p, g));
        System.out.println(getMaxGold3(w, p, g));
    }

    /**
     * 递归的方式，最低级的办法，效率是最差的
     * @param w 工人人数
     * @param n 金矿数量
     * @param p 金矿所需的开采人数
     * @param g 金矿的含金量
     * @return
     */
    public static int getMaxGold(int w, int n, int[] p, int[] g) {
        if (w == 0 || n == 0) {
            return 0;
        }

        // 剩下的人不够挖最后一个金矿时
        if (w < p[n-1]) {
            return getMaxGold(w, n - 1, p, g);
        }

        return Math.max(getMaxGold(w, n -1, p, g), g[n-1] + getMaxGold(w-p[n-1], n-1, p, g));
    }

    // 自底向上求解，二位数组解法
    public static int getMaxGold2(int w, int[] p, int[] g) {
        // 创建表格
        int[][] resultTable = new int[g.length+1][w+1];

        for (int i = 1; i <= g.length; i++) {
            for (int j = 1; j <= w ; j++) {

                // 剩余的工人不够挖最后一个金矿了
                if (j < p[i-1]) {
                    resultTable[i][j] = resultTable[i-1][j];
                } else {
                    resultTable[i][j] = Math.max(resultTable[i-1][j-p[i-1]] + g[i-1], resultTable[i-1][j]);
                }
            }
        }
        return resultTable[g.length][w];
    }


    public static int getMaxGold3(int w, int[] p, int[] g) {
        int[] result = new int[w+1];

        for (int i = 1; i <= g.length; i++) {
            for (int j=w; j>=1; j--) {
                if (j >= p[i-1]) {
                    result[j] = Math.max(result[j], result[j-p[i-1]] + g[i-1]);
                }
            }
        }

        return result[w];
    }
}
