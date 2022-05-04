package 漫画算法;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *     *@ClassName 红包算法
 *
 *          问题： 如何实现红包算法，尽可能的分布均匀
 *
 *          算法一： 二倍均值法
 *              每次抢到的金额 = 随机区间[0.01, m/n x 2 - 0.01]   m: 金额数  n：剩余人数
 *
 *          算法二： 线段切割法
 *
 *
 *     *@Description TODO
 *     *@Author Administrator
 *     *@Date 2022/5/4 0004 13:05
 *     *@Version 1.0
 *    
 */
public class 红包算法 {

    public static List<Integer> divideRedPackage(Integer totalAmount, Integer totalPeopleNum) {

        List<Integer> amountList = new ArrayList<>();
        Integer restAmount = totalAmount;
        Integer restPeopleNum = totalPeopleNum;
        Random random = new Random();
        for (int i = 0; i < totalPeopleNum - 1; i++) {
            // 随机范围： [1, 剩余人均金额的2倍-1]
            int amount = random.nextInt(restAmount / restPeopleNum * 2 - 2) + 1;
            restAmount -= amount;
            restPeopleNum --;
            amountList.add(amount);
        }
        amountList.add(restAmount);
        return amountList;
    }

    public static void main(String[] args) {
        List<Integer> amountList = divideRedPackage(1000, 10);
        System.out.println(amountList);
    }

}
