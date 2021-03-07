import java.util.ArrayList;
import java.util.List;

/**
 * 22. 括号生成
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 *
 *
 * </p>
 * 示例 1：
 * 输入：n = 3
 * 输出：["((()))","(()())","(())()","()(())","()()()"]
 *
 * </p>
 * 示例 2：
 * 输入：n = 1
 * 输出：["()"]
 *
 * </p>
 * 提示：
 * 1 <= n <= 8
 * <p>
 * https://leetcode-cn.com/problems/generate-parentheses/
 */
public class Leet22 {

    public static void main(String[] args) {
        List<String> answer = new Leet22().generateParenthesis(3);
        for (String ans : answer) {
            System.out.println(ans);
        }
    }

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        gen(result, "", n, n);
        return result;
    }

    private void gen(List<String> list, String str, int left, int right) {
        if (left == 0 && right == 0) {
            list.add(str);
            return;
        }
        if (left > 0) {
            gen(list, str + "(", left - 1, right);
        }
        if (left < right) {
            gen(list, str + ")", left, right - 1);
        }
    }
}
