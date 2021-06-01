package binarytree;
/**
 * 给你二叉树的根节点 root 和一个表示目标和的整数 targetSum ，判断该树中是否存在 根节点到叶子节点 的路径，
 *  这条路径上所有节点值相加等于目标和targetSum 。
 *
 *  叶子节点 是指没有子节点的节点。
 *  示例 1：
 *
 *
 * 输入：root = [5,4,8,11,null,13,4,7,2,null,null,null,1], targetSum = 22
 * 输出：true
 *
 *
 *  示例 2：
 *
 *
 * 输入：root = [1,2,3], targetSum = 5
 * 输出：false
 *
 *
 *  示例 3：
 *
 *
 * 输入：root = [1,2], targetSum = 0
 * 输出：false
 *
 *  提示：
 *  树中节点的数目在范围 [0, 5000] 内
 *  -1000 <= Node.val <= 1000
 *  -1000 <= targetSum <= 1000
 *
 *  Related Topics 树 深度优先搜索
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution112 {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root==null){
            return false;
        }
        if(root.right ==null && root.left == null){
            return root.val==targetSum;
        }
        //自顶向下 做减法
        return hasPathSum(root.left,targetSum-root.val) || hasPathSum(root.right,targetSum-root.val);
    }

    public boolean sumByRoot(TreeNode root,int sum,int target){
        if(root == null){
            return false;
        }
        //自顶向下 做加法
        sum=sum+root.val;
        if(root.left == null && root.right == null){
            return sum==target;
        }else {
            return sumByRoot(root.left,sum,target) || sumByRoot(root.right,sum,target);
        }
    }
}
