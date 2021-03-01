import java.util.HashMap;
import java.util.Stack;

/**
 * 20. 有效的括号
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 * 有效字符串需满足：
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * <p>
 * 示例 1：
 * 输入：s = "()"
 * 输出：true
 * <p>
 * 示例 2：
 * 输入：s = "()[]{}"
 * 输出：true
 * <p>
 * 示例 3：
 * 输入：s = "(]"
 * 输出：false
 * <p>
 * 示例 4：
 * 输入：s = "([)]"
 * 输出：false
 * <p>
 * 示例 5：
 * 输入：s = "{[]}"
 * 输出：true
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 104
 * s 仅由括号 '()[]{}' 组成
 * <p>
 * https://leetcode-cn.com/problems/valid-parentheses/
 */
public class Leet20 {

    public static void main(String[] args) {
        boolean result = new Leet20().isValid("([)]");
        System.out.println(result);
    }

    public boolean isValid(String s) {
        if (s.length() == 1) {
            return false;
        }
        HashMap<Character, Character> map = new HashMap();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');

        Stack<Character> stack = new Stack<>();
        for (Character character : s.toCharArray()) {
            if (map.containsKey(character)) {
                if (stack.isEmpty()) {
                    return false;
                } else if (stack.peek() == map.get(character)) {
                    stack.pop();
                } else {
                    stack.push(character);
                }
            } else {
                stack.push(character);
            }
        }
        return stack.isEmpty();
    }

}
