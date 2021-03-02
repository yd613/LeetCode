import java.util.Arrays;
import java.util.HashMap;
import java.util.function.BiConsumer;

/**
 * 242. 有效的字母异位词
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 * <p>
 * 示例 1:
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 * <p>
 * 示例 2:
 * 输入: s = "rat", t = "car"
 * 输出: false
 * 说明:
 * 你可以假设字符串只包含小写字母。
 * <p>
 * 进阶:
 * 如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
 */
public class Leet242 {

    public static void main(String[] args) {
        boolean result = new Leet242().isAnagram("anagram", "nagaram");
        System.out.println(result);
    }

    public boolean isAnagram(String s, String t) {
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        Arrays.sort(sChars);
        Arrays.sort(tChars);
        return Arrays.equals(sChars, tChars);
    }

//    public boolean isAnagram(String s, String t) {
//        int length = 0;
//        if ((length = s.length()) != t.length()) {
//            return false;
//        }
//        HashMap<Character, Integer> map = new HashMap<>();
//        for (int i = 0; i < length; i++) {
//            char sChar = s.charAt(i);
//            char tChar = t.charAt(i);
//            if (sChar == tChar) {
//                continue;
//            }
//            map.put(sChar, map.getOrDefault(sChar, 0) + 1);
//            map.put(tChar, map.getOrDefault(tChar, 0) - 1);
//        }
//        for (int a : map.values()) {
//            if (a != 0) {
//                return false;
//            }
//        }
//        return true;
//    }
}
