package easy;

/**
 * @Description 一块钱可以卖一颗糖， 三张糖纸可以换一颗糖，输入X元， 可以吃几颗糖
 * @Author Hasee
 * @Date 2022/4/18 20:41
 * @Version 1.0
 */
public class 糖和糖纸的问题 {

    public static void main(String[] args) {

        System.out.println(getMaxSugarCount(10));
        System.out.println(getSugarPaperNumber(10));
    }

    public static int getMaxSugarCount(int x) {

        int tangzhinum = x;
        int count = x;

        while (tangzhinum >= 3) {
            count = count + tangzhinum / 3;
            tangzhinum = tangzhinum  % 3 + tangzhinum / 3;
            // 出错点： +=，  这里怎么可能是+=呢， 直接就是 = 啊， 因为之前的糖纸被消耗了啊
        }

        return count;
    }


    public static int getSugarPaperNumber(int x) {
        int sugarPaperNum = x;
        int count = x;

        while (sugarPaperNum >=3) {
            count += sugarPaperNum / 3;
            sugarPaperNum = sugarPaperNum % 3 + sugarPaperNum / 3;
        }
        return count;
    }
}
