import treenode.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 111. 二叉树的最小深度
 * 给定一个二叉树，找出其最小深度。
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 * 说明：叶子节点是指没有子节点的节点。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：2
 * <p>
 * 示例 2：
 * 输入：root = [2,null,3,null,4,null,5,null,6]
 * 输出：5
 * <p>
 * <p>
 * 提示：
 * 树中节点数的范围在 [0, 105] 内
 * -1000 <= Node.val <= 1000
 *
 * https://leetcode-cn.com/problems/minimum-depth-of-binary-tree/
 */
public class Leet111 {
    public static void main(String[] args) {
//        TreeNode node7 = new TreeNode(7);
//        TreeNode node15 = new TreeNode(15);
//        TreeNode node20 = new TreeNode(20, node15, node7);
//        TreeNode node9 = new TreeNode(9);
//        TreeNode node3 = new TreeNode(3, node9, node20);

        TreeNode node6 = new TreeNode(6);
        TreeNode node5 = new TreeNode(5, null, node6);
        TreeNode node4 = new TreeNode(4, null, node5);
        TreeNode node3 = new TreeNode(3, null, node4);
        TreeNode node2 = new TreeNode(2, null, node3);

        int result = new Leet111().minDepth(node2);
        System.out.println(result);
    }

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int result = 1;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        queue.offer(null);
        while (true) {
            TreeNode node = queue.poll();
            if (node == null) {
                result += 1;
                if (!queue.isEmpty()) {
                    queue.offer(null);
                }
            } else if (node.left == null && node.right == null) {
                break;
            } else {
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }
        return result;
    }

//    public int minDepth(TreeNode root) {
//        if (root == null) {
//            return 0;
//        }
//        if (root.left == null && root.right == null) {
//            return 1;
//        } else if (root.left == null) {
//            return minDepth(root.right) + 1;
//        } else if (root.right == null) {
//            return minDepth(root.left) + 1;
//        } else {
//            int left = minDepth(root.left);
//            int right = minDepth(root.right);
//            return Math.min(left, right) + 1;
//        }
//    }
}
