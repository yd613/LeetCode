import treenode.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 102. 二叉树的层序遍历
 * 给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
 *
 *
 * </p>
 * 示例：
 * 二叉树：[3,9,20,null,null,15,7],
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回其层序遍历结果：
 * <p>
 * [
 * [3],
 * [9,20],
 * [15,7]
 * ]
 * <p>
 * https://leetcode-cn.com/problems/binary-tree-level-order-traversal/
 */
public class Leet102 {

    public static void main(String[] args) {
        TreeNode node7 = new TreeNode(7);
        TreeNode node15 = new TreeNode(15);
        TreeNode node20 = new TreeNode(20, node15, node7);
        TreeNode node9 = new TreeNode(9);
        TreeNode node3 = new TreeNode(3, node9, node20);
        List<List<Integer>> result = new Leet102().levelOrder(node3);
        for (List<Integer> list : result) {
            for (int value : list) {
                System.out.print(value + ",");
            }
            System.out.println("\n");
        }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        queue.offer(null);
        List<Integer> list = new ArrayList<>();
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node == null) {
                result.add(list);
                if (!queue.isEmpty()) {
                    queue.offer(null);
                    list = new ArrayList<>();
                }
            } else {
                list.add(node.val);
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
        }
        return result;
    }

//    public List<List<Integer>> levelOrder(TreeNode root) {
//        List<List<Integer>> result = new ArrayList<>();
//        if (root == null) {
//            return result;
//        }
//        dfs(root, 0, result);
//        return result;
//    }
//
//    private void dfs(TreeNode root, int level, List<List<Integer>> list) {
//        if (list.size() <= level) {
//            list.add(new ArrayList<>());
//        }
//        list.get(level).add(root.val);
//        if (root.left != null) {
//            dfs(root.left, level + 1, list);
//        }
//        if (root.right != null) {
//            dfs(root.right, level + 1, list);
//        }
//    }
}
