/**
 * 208. 实现 Trie (前缀树)
 * 实现一个 Trie (前缀树)，包含 insert, search, 和 startsWith 这三个操作。
 *
 * </p>
 * 示例:
 * Trie trie = new Trie();
 * trie.insert("apple");
 * trie.search("apple");   // 返回 true
 * trie.search("app");     // 返回 false
 * trie.startsWith("app"); // 返回 true
 * trie.insert("app");
 * trie.search("app");     // 返回 true
 *
 * </p>
 * 说明:
 * 你可以假设所有的输入都是由小写字母 a-z 构成的。
 * 保证所有输入均为非空字符串。
 * <p>
 * https://leetcode-cn.com/problems/implement-trie-prefix-tree
 */
public class Leet208 {

    public static void main(String[] args) {
        Trie obj = new Trie();
        obj.insert("word");
        boolean param_2 = obj.search("word");
        boolean param_3 = obj.startsWith("w");
        System.out.println(param_2);
        System.out.println(param_3);
    }

    static class Trie {

        Trie trie[];
        boolean isWordEnd = false;

        /**
         * Initialize your data structure here.
         */
        public Trie() {
            trie = new Trie[26];
        }

        /**
         * Inserts a word into the trie.
         */
        public void insert(String word) {
            int length = word.length();
            Trie t = this;
            for (int i = 0; i < length; i++) {
                int index = word.charAt(i) - 'a';
                if (t.trie[index] == null) {
                    t.trie[index] = new Trie();
                }
                t = t.trie[index];
            }
            t.isWordEnd = true;
        }

        /**
         * Returns if the word is in the trie.
         */
        public boolean search(String word) {
            int length = word.length();
            Trie t = this;
            for (int i = 0; i < length; i++) {
                char c = word.charAt(i);
                if (t.trie[c - 'a'] == null) {
                    return false;
                }
                t = t.trie[c - 'a'];
            }
            return t.isWordEnd;
        }

        /**
         * Returns if there is any word in the trie that starts with the given prefix.
         */
        public boolean startsWith(String prefix) {
            int length = prefix.length();
            Trie t = this;
            for (int i = 0; i < length; i++) {
                char c = prefix.charAt(i);
                if (t.trie[c - 'a'] == null) {
                    return false;
                }
                t = t.trie[c - 'a'];
            }
            return true;
        }
    }
}
