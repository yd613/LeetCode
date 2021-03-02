import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 15. 三数之和
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，
 * 使得 a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
 * 注意：答案中不可以包含重复的三元组。
 * <p>
 * 示例 1：
 * 输入：nums = [-1,0,1,2,-1,-4]
 * 输出：[[-1,-1,2],[-1,0,1]]
 * <p>
 * 示例 2：
 * 输入：nums = []
 * 输出：[]
 * <p>
 * 示例 3：
 * 输入：nums = [0]
 * 输出：[]
 * <p>
 * 提示：
 * <p>
 * 0 <= nums.length <= 3000
 * -105 <= nums[i] <= 105
 */
public class Leet15 {

    public static void main(String[] args) {
        int[] nums = new int[]{-1,0,1,2,-1,-4};
        List<List<Integer>> result = new Leet15().threeSum(nums);
        for (List<Integer> list : result) {
            for (int a : list) {
                System.out.print(a + ",");
            }
            System.out.print("\n");
        }
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length < 3) {
            return result;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int a = -nums[i];
            int ptr1 = i + 1;
            int ptr2 = nums.length - 1;
            while (ptr1 < ptr2) {
                if (nums[ptr1] + nums[ptr2] == a) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[ptr1]);
                    list.add(nums[ptr2]);
                    result.add(list);
                    ptr2--;
                    while (ptr1 < ptr2 && nums[ptr2] == nums[ptr2 + 1]) {
                        ptr2--;
                    }
                } else if (nums[ptr1] + nums[ptr2] > a) {
                    ptr2--;
                    while (ptr1 < ptr2 && nums[ptr2] == nums[ptr2 + 1]) {
                        ptr2--;
                    }
                } else {
                    ptr1++;
                    while (ptr1 < ptr2 && nums[ptr1] == nums[ptr1 - 1]) {
                        ptr1++;
                    }
                }
            }
        }
        return result;
    }
}
