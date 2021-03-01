import listnode.ListNode;

import java.util.Stack;

/**
 * 25. K 个一组翻转链表
 * 给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
 * k 是一个正整数，它的值小于或等于链表的长度。
 * 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 * <p>
 * 进阶：
 * 你可以设计一个只使用常数额外空间的算法来解决此问题吗？
 * 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
 * <p>
 * 示例 1：
 * 输入：head = [1,2,3,4,5], k = 2
 * 输出：[2,1,4,3,5]
 * <p>
 * 示例 2：
 * 输入：head = [1,2,3,4,5], k = 3
 * 输出：[3,2,1,4,5]
 * <p>
 * 示例 3：
 * 输入：head = [1,2,3,4,5], k = 1
 * 输出：[1,2,3,4,5]
 * <p>
 * 示例 4：
 * 输入：head = [1], k = 1
 * 输出：[1]
 * <p>
 * 提示：
 * 列表中节点的数量在范围 sz 内
 * 1 <= sz <= 5000
 * 0 <= Node.val <= 1000
 * 1 <= k <= sz
 */
public class Leet25 {
    public static void main(String[] args) {
//        ListNode node5 = new ListNode(5);
//        ListNode node4 = new ListNode(4, node5);
//        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2);
        ListNode node1 = new ListNode(1, node2);
        node1.printNode();
        System.out.println("=====================================================");
        ListNode result = new Leet25().reverseKGroup(node1, 2);
        result.printNode();
    }

//    public ListNode reverseKGroup(ListNode head, int k) {
//        if (k == 1 || head == null || head.next == null) {
//            return head;
//        }
//        ListNode result = null;
//        ListNode curr = head;
//
//        while (curr != null) {
//            ListNode last = null;
//            ListNode start = head;
//            ListNode end = null;
//            ListNode prev = null;
//            int sum = k;
//            while (sum > 0 && curr != null) {
//                ListNode next = curr.next;
//                curr.next = prev;
//                prev = curr;
//                if (sum == 1) {
//                    end = curr;
//                } else if (sum == k) {
//                    start = curr;
//                }
//                sum--;
//                curr = next;
//            }
//            curr = end.next;
//            start.next = end.next;
//            last.next = end;
//            if (result == null) {
//                result = end;
//            }
//        }
//
//        return result;
//    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if (k == 1 || head == null || head.next == null) {
            return head;
        }
        ListNode result = head;
        ListNode prev = null;
        ListNode curr = head;
        ListNode stackPtr = head;
        Stack<ListNode> stack = new Stack<>();
        while (stackPtr != null) {
            curr = stackPtr;
            while (stack.size() < k && stackPtr != null) {
                stack.push(stackPtr);
                stackPtr = stackPtr.next;
            }
            if (stack.size() < k) {
                prev.next = curr;
                return result;
            }
            while (!stack.isEmpty()) {
                if (prev != null) {
                    prev.next = stack.pop();
                    prev = prev.next;
                } else {
                    prev = stack.pop();
                }
                prev.next = null;
                if (result == head) {
                    result = prev;
                }
            }
        }
        return result;
    }
}
