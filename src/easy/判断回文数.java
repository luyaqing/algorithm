package easy;

/**
 * @Description TODO
 * @Author Hasee
 * @Date 2022/4/18 0:32
 * @Version 1.0
 */
public class 判断回文数 {

    /**
     * 最好的办法， 除了把int转成String之后再转成char[]之后， 去比对
     * 说明：为什么最后面的地方有了x==res / 10 这种case， 是因为 121 这种情况，2这一位只有一个的，只能这么处理下
     * @param x
     * @return
     */
    public static boolean isPalindrome(int x) {
        // 这个地方把负数和110 或者100情况排除掉
        if(x<0 || (x!=0 && x%10==0))
            return false;

        int res = 0;

        while(x>res){
            res = res*10 + x%10;   // 我的出错点： 这里的x写成了res， 想清楚取得是谁的末尾。
            x = x/10;
        }

        return x==res || x==res/10;
    }
    public static void main(String[] args) {
        System.out.println(isPalindrome(1232));
    }
}
