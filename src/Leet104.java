import treenode.TreeNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 104. 二叉树的最大深度
 * 给定一个二叉树，找出其最大深度。
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 * 说明: 叶子节点是指没有子节点的节点。
 * <p>
 * 示例：
 * 给定二叉树 [3,9,20,null,null,15,7]，
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回它的最大深度 3 。
 *
 * https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/
 */
public class Leet104 {

    public static void main(String[] args) {
        TreeNode node7 = new TreeNode(7);
        TreeNode node15 = new TreeNode(15);
        TreeNode node20 = new TreeNode(20, node15, node7);
        TreeNode node9 = new TreeNode(9);
        TreeNode node3 = new TreeNode(3, node9, node20);

        int result = new Leet104().maxDepth(node7);
        System.out.println(result);
    }

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = 0, right = 0;
        if (root.left != null) {
            left = maxDepth(root.left);
        }
        if (root.right != null) {
            right = maxDepth(root.right);
        }
        return Math.max(left, right) + 1;
    }

//    public int maxDepth(TreeNode root) {
//        int result = 0;
//        if (root == null) {
//            return result;
//        }
//        Queue<TreeNode> queue = new LinkedList<>();
//        queue.offer(root);
//        queue.offer(null);
//        while (!queue.isEmpty()) {
//            TreeNode node = queue.poll();
//            if (node == null) {
//                result++;
//                if (!queue.isEmpty()) {
//                    queue.offer(null);
//                }
//            } else if (node != null && node.left != null) {
//                queue.offer(node.left);
//            }
//            if (node != null && node.right != null) {
//                queue.offer(node.right);
//            }
//        }
//        return result;
//    }
}
