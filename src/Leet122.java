import java.util.LinkedList;
import java.util.Queue;

/**
 * 122. 买卖股票的最佳时机 II
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 * 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 *
 * </p>
 * 示例 1:
 * 输入: [7,1,5,3,6,4]
 * 输出: 7
 * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
 * 随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6-3 = 3 。
 *
 * </p>
 * 示例 2:
 * 输入: [1,2,3,4,5]
 * 输出: 4
 * 解释: 在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
 * 注意你不能在第 1 天和第 2 天接连购买股票，之后再将它们卖出。
 * 因为这样属于同时参与了多笔交易，你必须在再次购买前出售掉之前的股票。
 *
 * </p>
 * 示例 3:
 * 输入: [7,6,4,3,1]
 * 输出: 0
 * 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
 *
 * </p>
 * 提示：
 * 1 <= prices.length <= 3 * 10 ^ 4
 * 0 <= prices[i] <= 10 ^ 4
 * <p>
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii
 */
public class Leet122 {
    public static void main(String[] args) {
//        int[] prices = new int[]{1, 2, 3, 4, 5};
        int[] prices = new int[]{7, 1, 5, 3, 6, 4};
//        int[] prices = new int[]{7, 6, 4, 3, 1};
        int result = new Leet122().maxProfit(prices);
        System.out.println(result);
    }

    public int maxProfit(int[] prices) {
        int result = 0;
        boolean lookForBuy = true;
        for (int i = 1; i < prices.length; i++) {
            // 寻找买入机会
            if (lookForBuy) {
                if (prices[i] > prices[i - 1]) {
                    result -= prices[i - 1];
                    lookForBuy = false;
                }
            }
            // 寻找卖出机会
            else {
                if (prices[i - 1] > prices[i]) {
                    result += prices[i - 1];
                    lookForBuy = true;
                }
            }
        }
        if (!lookForBuy) {
            result += prices[prices.length - 1];
        }
        return result;
    }

//    public int maxProfit(int[] prices) {
//        int result = 0;
//        boolean  = true;
//        LinkedList<Integer> buyQueue = new LinkedList<>();
//        Queue<Integer> sellQueue = new LinkedList<>();
//        for (int i = 1; i < prices.length; i++) {
//            // 寻找买入机会
//            if (buyQueue.size() == sellQueue.size()) {
//                if (prices[i] > prices[i - 1]) {
//                    buyQueue.offer(i - 1);
//                }
//            }
//            // 寻找卖出机会
//            else {
//                if (prices[i - 1] > prices[i]) {
//                    sellQueue.offer(i - 1);
//                }
//            }
//        }
//        if (buyQueue.size() > sellQueue.size()) {
//            sellQueue.offer(prices.length - 1);
//        }
//        while (!buyQueue.isEmpty()) {
//            result += prices[sellQueue.poll()] - prices[buyQueue.poll()];
//        }
//        return result;
//    }
}
