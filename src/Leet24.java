import listnode.ListNode;

/**
 * 24. 两两交换链表中的节点
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * <p>
 * 示例 1：
 * 输入：head = [1,2,3,4]
 * 输出：[2,1,4,3]
 * <p>
 * 示例 2：
 * 输入：head = []
 * 输出：[]
 * <p>
 * 示例 3：
 * 输入：head = [1]
 * 输出：[1]
 * <p>
 * 提示：
 * 链表中节点的数目在范围 [0, 100] 内
 * 0 <= Node.val <= 100
 * <p>
 * 进阶：你能在不修改链表节点值的情况下解决这个问题吗?（也就是说，仅修改节点本身。）
 * <p>
 * https://leetcode-cn.com/problems/swap-nodes-in-pairs/
 */
public class Leet24 {

    public static void main(String[] args) {
        ListNode node4 = new ListNode(4);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(1, node2);
        node1.printNode();
        System.out.println("=====================================================");
        ListNode result = new Leet24().swapPairs(node1);
        result.printNode();
    }

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode prev = null;
        ListNode curr = head;
        ListNode result = head.next;
        while (curr != null && curr.next != null) {
            if (prev != null) {
                prev.next = curr.next;
            }
            ListNode next2next = curr.next.next;
            curr.next.next = curr;
            curr.next = next2next;
            prev = curr;
            curr = next2next;
        }
        return result;
    }

}
