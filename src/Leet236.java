import treenode.TreeNode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * 236. 二叉树的最近公共祖先
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个节点 p、q，最近公共祖先表示为一个节点 x，
 * 满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 *
 * </p>
 * 示例 1：
 * 输入：root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 * 输出：3
 * 解释：节点 5 和节点 1 的最近公共祖先是节点 3 。
 *
 * </p>
 * 示例 2：
 * 输入：root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
 * 输出：5
 * 解释：节点 5 和节点 4 的最近公共祖先是节点 5 。因为根据定义最近公共祖先节点可以为节点本身。
 *
 * </p>
 * 示例 3：
 * 输入：root = [1,2], p = 1, q = 2
 * 输出：1
 *
 * </p>
 * 提示：
 * 树中节点数目在范围 [2, 105] 内。
 * -109 <= Node.val <= 109
 * 所有 Node.val 互不相同 。
 * p != q
 * p 和 q 均存在于给定的二叉树中。
 *
 * </p>
 * https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree
 */
public class Leet236 {

    public static void main(String[] args) {
//        TreeNode node4 = new TreeNode(4);
//        TreeNode node7 = new TreeNode(7);
//        TreeNode node8 = new TreeNode(8);
//        TreeNode node0 = new TreeNode(0);
//        TreeNode node2 = new TreeNode(2, node7, node4);
//        TreeNode node6 = new TreeNode(6);
//        TreeNode node1 = new TreeNode(1, node0, node8);
//        TreeNode node5 = new TreeNode(5, node6, node2);
//        TreeNode node3 = new TreeNode(3, node5, node1);
//        TreeNode result = new Leet236().lowestCommonAncestor(node3, node5, node4);

        TreeNode node2 = new TreeNode(2);
        TreeNode node1 = new TreeNode(1, node2, null);
        TreeNode result = new Leet236().lowestCommonAncestor(node1, node1, node2);

        System.out.println(result.val);
    }

    /**
     * 迭代
     *
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return find_p_or_q(root, p, q);
    }

    private TreeNode find_p_or_q(TreeNode node, TreeNode p, TreeNode q) {
        // 空节点
        if (node == null) {
            return null;
        }

        // 叶子节点
        if (node.left == null && node.right == null) {
            return determineNode(node, p, q);
        }


        TreeNode leftResult = find_p_or_q(node.left, p, q);
        TreeNode rightResult = find_p_or_q(node.right, p, q);

        // 左子树、右子树啥也不是
        if (leftResult == null && rightResult == null) {
            return determineNode(node, p, q);
        }

        // 在左子树找到了目标节点
        else if (leftResult != null && leftResult != p && leftResult != q) {
            return leftResult;
        }

        // 在右子树找到了目标节点
        else if (rightResult != null && rightResult != p && rightResult != q) {
            return rightResult;
        }

        // 分别在左右子树或当前节点找到了p和q，即当前节点就是目标节点
        else if ((leftResult == p || node == p) && (node == q || rightResult == q)) {
            return node;
        } else if ((leftResult == q || node == q) && (node == p || rightResult == p)) {
            return node;
        }

        // 在左右子树或当前节点找到了p或者q，返回p或q
        else if (leftResult == p || node == p || rightResult == p) {
            return p;
        } else if (leftResult == q || node == q || rightResult == q) {
            return q;
        }

        // 啥也不是
        return null;
    }

    private TreeNode determineNode(TreeNode node, TreeNode p, TreeNode q) {
        if (node == p) {
            return p;
        } else if (node == q) {
            return q;
        } else {
            return null;
        }
    }
}
