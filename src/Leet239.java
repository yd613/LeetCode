import java.util.Comparator;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * 239. 滑动窗口最大值
 * 给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。
 * 你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 * 返回滑动窗口中的最大值。
 * <p>
 * 示例 1：
 * 输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
 * 输出：[3,3,5,5,6,7]
 * 解释：
 * 滑动窗口的位置                最大值
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 * 1 [3  -1  -3] 5  3  6  7       3
 * 1  3 [-1  -3  5] 3  6  7       5
 * 1  3  -1 [-3  5  3] 6  7       5
 * 1  3  -1  -3 [5  3  6] 7       6
 * 1  3  -1  -3  5 [3  6  7]      7
 * <p>
 * 示例 2：
 * 输入：nums = [1], k = 1
 * 输出：[1]
 * <p>
 * 示例 3：
 * 输入：nums = [1,-1], k = 1
 * 输出：[1,-1]
 * <p>
 * 示例 4：
 * 输入：nums = [9,11], k = 2
 * 输出：[11]
 * <p>
 * 示例 5：
 * 输入：nums = [4,-2], k = 2
 * 输出：[4]
 * <p>
 * 提示：
 * 1 <= nums.length <= 105
 * -104 <= nums[i] <= 104
 * 1 <= k <= nums.length
 * <p>
 * https://leetcode-cn.com/problems/sliding-window-maximum/
 */
public class Leet239 {

    public static void main(String[] args) {
        int[] result = new Leet239().maxSlidingWindow(
                new int[]{1, -1},
                1
        );
        for (int i : result) {
            System.out.println(i);
        }
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] result = new int[nums.length - k + 1];
        Deque<Integer> deque = new LinkedList<>();
        int i = 0;
        for (; i < k; i++) {
            while (deque.size() > 0 && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }
            deque.offer(i);
        }
        result[0] = nums[deque.peekFirst()];
        for (; i < nums.length; i++) {
            while (!deque.isEmpty() && deque.peekFirst() <= i - k) {
                deque.pollFirst();
            }
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }
            deque.offer(i);
            result[i - k + 1] = nums[deque.peekFirst()];
        }
        return result;
    }

//    public int[] maxSlidingWindow(int[] nums, int k) {
//        int[] result = new int[nums.length - k + 1];
//        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(k, new Comparator<int[]>() {
//            @Override
//            public int compare(int[] o1, int[] o2) {
//                return o2[0] == o1[0] ? o2[1] - o1[1] : o2[0] - o1[0];
//            }
//        });
//        int i = 0;
//        for (; i < k; i++) {
//            priorityQueue.offer(new int[]{nums[i], i});
//        }
//        result[0] = nums[priorityQueue.peek()[1]];
//        while (i < nums.length) {
//            priorityQueue.offer(new int[]{nums[i], i});
//            while (priorityQueue.peek()[1] <= i - k) {
//                priorityQueue.poll();
//            }
//            result[i - k + 1] = priorityQueue.peek()[0];
//            i++;
//        }
//        return result;
//    }
}
