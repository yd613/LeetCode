import java.util.*;

/**
 * 253. 会议室 II
 * <p>
 * 给你一个会议时间安排的数组 intervals ，每个会议时间都会包括开始和结束的时间 intervals[i] = [starti, endi] ，
 * 为避免会议冲突，同时要考虑充分利用会议室资源，请你计算至少需要多少间会议室，才能满足这些会议安排。
 * <p>
 * 示例 1：
 * 输入：intervals = [[0,30],[5,10],[15,20]]
 * 输出：2
 * <p>
 * 示例 2：
 * 输入：intervals = [[7,10],[2,4]]
 * 输出：1
 * <p>
 * 提示：
 * <p>
 * 1 <= intervals.length <= 10^4
 * 0 <= starti < endi <= 10^6
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/meeting-rooms-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Leet253 {

    /**
     * 有序化
     * @param intervals
     * @return
     */
    public int minMeetingRooms(int[][] intervals) {
        int result = 0;
        int[] starts = new int[intervals.length];
        int[] ends = new int[intervals.length];
        int sIndex = 0, eIndex = 0;
        for (int i = 0; i < intervals.length; i++) {
            int[] meeting = intervals[i];
            starts[i] = meeting[0];
            ends[i] = meeting[1];
        }

        Arrays.sort(starts);
        Arrays.sort(ends);

        while (sIndex < intervals.length && eIndex < intervals.length) {
            if (starts[sIndex] < ends[eIndex]) {
                result++;
            } else {
                eIndex++;
            }
            sIndex++;
        }
        return result;
    }

//    /**
//     * 优先队列
//     *
//     * @param intervals
//     * @return
//     */
//    public int minMeetingRooms(int[][] intervals) {
//        int result = 1;
//        PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
//        Arrays.sort(intervals, new Comparator<int[]>() {
//            @Override
//            public int compare(int[] o1, int[] o2) {
//                return o1[0] - o2[0];
//            }
//        });
//        for (int[] meeting : intervals) {
//            while (!queue.isEmpty() && queue.peek() <= meeting[0]) {
//                queue.poll();
//            }
//            queue.offer(meeting[1]);
//            result = Math.max(result, queue.size());
//        }
//        return result;
//    }

    public static void main(String[] args) {
        Leet253 leet = new Leet253();
        int result = leet.minMeetingRooms(new int[][]{{0, 2}, {1, 3}, {2, 4}, {3, 5}, {4, 6}, {5, 7}});
//        int result = leet.minMeetingRooms(new int[][]{{0, 30}, {5, 10}, {15, 20}});
//        int result = leet.minMeetingRooms(new int[][]{{7, 10}, {2, 4}});
        System.out.println(result);
    }
}
