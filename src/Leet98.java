import treenode.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 98. 验证二叉搜索树
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 * 假设一个二叉搜索树具有如下特征：
 * 节点的左子树只包含小于当前节点的数。
 * 节点的右子树只包含大于当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 *
 * <p>
 * 示例 1:
 * 输入:
 * 2
 * / \
 * 1   3
 * 输出: true
 *
 * <p>
 * 示例 2:
 * 输入:
 * 5
 * / \
 * 1   4
 * / \
 * 3   6
 * 输出: false
 * 解释: 输入为: [5,1,4,null,null,3,6]。
 * 根节点的值为 5 ，但是其右子节点值为 4 。
 *
 * <p>
 * https://leetcode-cn.com/problems/validate-binary-search-tree/
 */
public class Leet98 {

    public static void main(String[] args) {
        TreeNode node3 = new TreeNode(3);
        TreeNode node6 = new TreeNode(6);
        TreeNode node4 = new TreeNode(4, node3, node6);
        TreeNode node1 = new TreeNode(1);
        TreeNode node5 = new TreeNode(5, node1, node4);
        boolean result = new Leet98().isValidBST(node5);
        System.out.println(result);
    }

    Integer last;

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (root.left != null && !isValidBST(root.left)) {
            return false;
        }
        if (last != null && last >= root.val) {
            return false;
        }
        last = root.val;
        if (root.right != null && !isValidBST(root.right)) {
            return false;
        }
        return true;
    }

//    /**
//     * 中序遍历二叉树，如果结果严格从小到大排列则为二叉搜索树
//     *
//     * @param root
//     * @return
//     */
//    public boolean isValidBST(TreeNode root) {
//        List<Integer> list = new ArrayList<>();
//        inOrder(list, root);
//        for (int i = 0; i < list.size() - 1; i++) {
//            if (list.get(i) >= list.get(i + 1)) {
//                return false;
//            }
//        }
//        return true;
//    }
//
//    private void inOrder(List<Integer> list, TreeNode node) {
//        if (node == null) {
//            return;
//        }
//        if (node.left != null) {
//            inOrder(list, node.left);
//        }
//        list.add(node.val);
//        if (node.right != null) {
//            inOrder(list, node.right);
//        }
//    }
}
