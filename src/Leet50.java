/**
 * 50. Pow(x, n)
 * 实现 pow(x, n) ，即计算 x 的 n 次幂函数（即，xn）。
 *
 *
 * </p>
 * 示例 1：
 * 输入：x = 2.00000, n = 10
 * 输出：1024.00000
 *
 * </p>
 * 示例 2：
 * 输入：x = 2.10000, n = 3
 * 输出：9.26100
 *
 * </p>
 * 示例 3：
 * 输入：x = 2.00000, n = -2
 * 输出：0.25000
 * 解释：2-2 = 1/22 = 1/4 = 0.25
 *
 * </p>
 * 提示：
 * -100.0 < x < 100.0
 * -231 <= n <= 231-1
 * -104 <= xn <= 104
 * <p>
 * https://leetcode-cn.com/problems/powx-n
 */
public class Leet50 {
    public static void main(String[] args) {
//        double result = new Leet50().myPow(2, 10);
//        double result = new Leet50().myPow(2.00000, -2147483648);
//        double result = new Leet50().myPow(1.00000, -2147483648);
        double result = new Leet50().myPow(0.00001, 2147483647);
        System.out.println(result);
    }

    public double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        } else if (x == 0) {
            return 0;
        } else if (n == 1) {
            return x;
        } else if (n == -1) {
            return 1 / x;
        }

        double a = x;
        int pow = n;
        double result = 1;

        if (n == -2147483648) {
            a *= a;
            pow = pow >> 1;
        }
        if (pow < 0) {
            a = 1 / a;
            pow = -pow;
        }

        while (pow > 0) {
            if ((pow & 1) == 1) {
                result = result * a;
            }
            pow = pow >> 1;
            a = a * a;
        }
        return result;
    }

//    /**
//     * 递归
//     *
//     * @param x
//     * @param n
//     * @return
//     */
//    public double myPow(double x, int n) {
//        if (n == 0) {
//            return 1;
//        } else if (x == 0) {
//            return 0;
//        } else if (n == 1) {
//            return x;
//        } else if (n == -1) {
//            return 1 / x;
//        }
//
//        if (n % 2 == 0) {
//            double y = myPow(x, n / 2);
//            return y * y;
//        } else {
//            double y = myPow(x, (n - 1) / 2);
//            return x * y * y;
//        }
//    }
}
