import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * 79. 单词搜索
 * 给定一个二维网格和一个单词，找出该单词是否存在于网格中。
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。
 * 同一个单元格内的字母不允许被重复使用。
 *
 *
 * </p>
 * 示例:
 * board =
 * [
 * ['A','B','C','E'],
 * ['S','F','C','S'],
 * ['A','D','E','E']
 * ]
 * <p>
 * 给定 word = "ABCCED", 返回 true
 * 给定 word = "SEE", 返回 true
 * 给定 word = "ABCB", 返回 false
 * <p>
 * <p>
 * 提示：
 * board 和 word 中只包含大写和小写英文字母。
 * 1 <= board.length <= 200
 * 1 <= board[i].length <= 200
 * 1 <= word.length <= 10^3
 * <p>
 * https://leetcode-cn.com/problems/word-search
 */
public class Leet79 {

    public static void main(String[] args) {
        char[][] board = new char[][]{
                {'b', 'b', 'a', 'a', 'b', 'a'},
                {'b', 'b', 'a', 'b', 'a', 'a'},
                {'b', 'b', 'b', 'b', 'b', 'b'},
                {'a', 'a', 'a', 'b', 'a', 'a'},
                {'a', 'b', 'a', 'a', 'b', 'b'}
        };
        Leet79 leet = new Leet79();
        boolean result1 = leet.exist(board, "abbbababaa");
//        boolean result2 = leet.exist(board, "SEE");
//        boolean result3 = leet.exist(board, "ABCB");
        System.out.println("abbbababaa :" + result1);
//        System.out.println("SEE :" + result2);
//        System.out.println("ABCB :" + result3);
    }

    private class Trie {
        HashMap<Character, Trie> map = new HashMap<Character, Trie>();

        public boolean search(String word) {
            Trie trie = this;
            int length = word.length();
            for (int i = 0; i < length; i++) {
                char c = word.charAt(i);
                if (trie.map.get(c) == null) {
                    return false;
                }
                trie = trie.map.get(c);
            }
            return true;
        }
    }

    public boolean exist(char[][] board, String word) {
        Trie trie = new Trie();
        int length1 = board.length;
        int length2 = board[0].length;
        if (word.length() > length1 * length2) {
            return false;
        }
        char startChar = word.charAt(0);
        for (int i = 0; i < length1; i++) {
            for (int j = 0; j < length2; j++) {
                if (startChar != board[i][j]) {
                    continue;
                }
                insert(board, trie, new HashSet<>(), length1, length2, i, j);
                if (trie.search(word)) {
                    return true;
                }
            }
        }
        return trie.search(word);
    }

    public void insert(char[][] board, Trie trie, Set<Integer> set, int length1, int length2, int x, int y) {
        if (x < 0 || x >= length1 || y < 0 || y >= length2) {
            return;
        }
        int setIndex = x * length2 + y;
        if (set.contains(setIndex)) {
            return;
        }
        set.add(setIndex);
        char c = board[x][y];
        trie.map.putIfAbsent(c, new Trie());
        Trie t = trie.map.get(c);

        insert(board, t, set, length1, length2, x - 1, y);
        insert(board, t, set, length1, length2, x + 1, y);
        insert(board, t, set, length1, length2, x, y - 1);
        insert(board, t, set, length1, length2, x, y + 1);
        set.remove(setIndex);
    }
}
