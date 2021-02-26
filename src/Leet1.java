import java.util.*;

/**
 * 两数之和
 * https://leetcode-cn.com/problems/two-sum/
 * <p>
 * <p>
 * 题目：
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 的那 两个 整数，并返回它们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 * 你可以按任意顺序返回答案。
 * <p>
 * <p>
 * 示例 1：
 * 输入：nums = [2,7,11,15], target = 9
 * 输出：[0,1]
 * 解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
 * <p>
 * <p>
 * 示例 2：
 * 输入：nums = [3,2,4], target = 6
 * 输出：[1,2]
 * <p>
 * <p>
 * 示例 3：
 * 输入：nums = [3,3], target = 6
 * 输出：[0,1]
 * <p>
 * <p>
 * 提示：
 * 2 <= nums.length <= 103
 * -109 <= nums[i] <= 109
 * -109 <= target <= 109
 * 只会存在一个有效答案
 */
public class Leet1 {

    public static void main(String[] args) {
        Leet1 leet = new Leet1();
        int[] reuslt = leet.twoSum(new int[]{2, 7, 11, 15}, 9);
        for (int num : reuslt) {
            System.out.println(num);
        }
    }

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> table = new Hashtable<>();
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            int a = target - nums[i];
            if (table.containsKey(a)) {
                return new int[]{table.get(a), i};
            } else {
                table.put(nums[i], i);
            }
        }
        return null;
    }
}
