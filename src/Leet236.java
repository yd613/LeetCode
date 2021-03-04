import treenode.TreeNode;

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

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

    }

    private TreeNode find_p_or_q(TreeNode node, TreeNode p, TreeNode q) {
        // 空节点
        if (node == null) {
            return null;
        }

        // 左右子树为空
        if (node.left == null && node.right == null) {
            return determineNode(node, p, q);
        }


        TreeNode leftResult = find_p_or_q(node.left, p, q);
        TreeNode rightResult = find_p_or_q(node.right, p, q);

        // 左子树、右子树啥也不是
        if (leftResult == null && rightResult == null) {
            return determineNode(node, p, q);
        }

        // 找到了，结果在左子树上
        if (leftResult != null && leftResult != p && leftResult != q) {
            return leftResult;
        }

        // 找到了，结果在右子树上
        if (rightResult != null && rightResult != p && rightResult != q) {
            return rightResult;
        }
        if ((leftResult == p || node == p) && (node == q || rightResult == q)) {
            return node;
        }else if((leftResult == q || node == q) && (node == p || rightResult == p)){
            return node;
        }else if(leftResult == p || node == p || rightResult == p){
            return p;
        }else if(leftResult == q || node == q || rightResult == q){
            return q;
        }
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
