/**
 * 69. x 的平方根
 * 实现 int sqrt(int x) 函数。
 * 计算并返回 x 的平方根，其中 x 是非负整数。
 * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 *
 * </p>
 * 示例 1:
 * 输入: 4
 * 输出: 2
 *
 * </p>
 * 示例 2:
 * 输入: 8
 * 输出: 2
 * 说明: 8 的平方根是 2.82842..., 由于返回类型是整数，小数部分将被舍去。
 *
 * </p>
 * https://leetcode-cn.com/problems/sqrtx/
 */
public class Leet69 {

    public static void main(String[] args) {
//        int result = new Leet69().mySqrt(101);
        int result = new Leet69().mySqrt(Integer.MAX_VALUE);
        System.out.println(result);
    }

    public int mySqrt(int x) {
        if (x == 0 || x == 1) {
            return x;
        }
        int left = 0, right = x;
        while (right - left > 1) {
            long mid = (right + left) >> 1;
            long power = mid * mid;
            if (power == x) {
                return (int)mid;
            } else if (power > x) {
                right = (int)mid;
            } else {
                left = (int)mid;
            }
        }
        return left;
    }
}
