package binarytree;
/**
 * 给定一个二叉树，检查它是否是镜像对称的。
 *
 *
 *
 *  例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 *
 *      1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 *
 *  但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
 *
 *      1
 *    / \
 *   2   2
 *    \   \
 *    3    3
 *
 *
 *  进阶：
 *
 *  你可以运用递归和迭代两种方法解决这个问题吗？
 *  Related Topics 树 深度优先搜索 广度优先搜索
 *
 */
class Solution101 {
    public boolean isSymmetric(TreeNode root) {
        if(root==null){
            return true;
        }
        return check(root,root);
    }

    private boolean check(TreeNode p, TreeNode q){
        if(p==null && q==null){
            return true;
        }
        if(p==null || q==null){
            return false;
        }
        if(p.val != q.val){
            return false;
        }
        return check(p.left,q.right) && check(p.right,q.left);
    }

}
