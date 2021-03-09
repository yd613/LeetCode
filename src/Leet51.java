import java.util.*;

/**
 * 51. N 皇后
 * n 皇后问题 研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 * 给你一个整数 n ，返回所有不同的 n 皇后问题 的解决方案。
 * 每一种解法包含一个不同的 n 皇后问题 的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
 *
 *
 * </p>
 * 示例 1：
 * 输入：n = 4
 * 输出：[[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
 * 解释：如上图所示，4 皇后问题存在两个不同的解法。
 *
 * </p>
 * 示例 2：
 * 输入：n = 1
 * 输出：[["Q"]]
 *
 * </p>
 * 提示：
 * 1 <= n <= 9
 * 皇后彼此不能相互攻击，也就是说：任何两个皇后都不能处于同一条横行、纵行或斜线上。
 * <p>
 * https://leetcode-cn.com/problems/n-queens
 */
public class Leet51 {

    public static void main(String[] args) {
        List<List<String>> result = new Leet51().solveNQueens(4);
        for (List<String> list : result) {
            System.out.println("[");
            for (String string : list) {
                System.out.println(string);
            }
            System.out.println("]");
        }
    }

    String dot = ".";

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> answer = new ArrayList<>();
        dfs(n,
                0,
                answer,
                new HashMap<>(),
                new HashSet<>(),
                new HashSet<>(),
                new HashSet<>(),
                new String[n]);
        return answer;
    }

    private void dfs(int n,
                     int line,
                     List<List<String>> answer,
                     Map<Integer, Integer> map,
                     Set<Integer> aSet,
                     Set<Integer> bSet,
                     Set<Integer> cSet,
                     String[] strArr) {
        if (line == n) {
            answer.add(Arrays.asList(strArr.clone()));
            return;
        }
        // 遍历line行上每个列的位置
        for (int iColumn = 0; iColumn < n; iColumn++) {
            if (!check(line, iColumn, aSet, bSet, cSet, map)) {
                continue;
            }
            strArr[line] = dot.repeat(iColumn) + "Q" + dot.repeat(n - iColumn - 1);
            map.put(line, iColumn);
            aSet.add(line + iColumn);
            bSet.add(iColumn);
            cSet.add(line - iColumn);
            dfs(n, line + 1, answer, map, aSet, bSet, cSet, strArr);
            aSet.remove(line + iColumn);
            bSet.remove(iColumn);
            cSet.remove(line - iColumn);
            map.remove(line);
        }
    }

    private boolean check(int iLine,
                          int iColumn,
                          Set<Integer> aSet,
                          Set<Integer> bSet,
                          Set<Integer> cSet,
                          Map<Integer, Integer> map) {
        // 遍历前几行的位置，判断（line，iColume）是否可行
        if (aSet.contains(iLine + iColumn) || bSet.contains(iColumn) || cSet.contains(iLine - iColumn)) {
            return false;
        }
        return true;
    }

}
