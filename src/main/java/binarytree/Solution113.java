package binarytree;
/**
 * 给你二叉树的根节点 root 和一个整数目标和 targetSum ，找出所有 从根节点到叶子节点 路径总和等于给定目标和的路径。
 *
 *  叶子节点 是指没有子节点的节点。
 *
 *  示例 1：
 *
 * 输入：root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
 * 输出：[[5,4,11,2],[5,8,4,5]]
 *
 *  示例 2：
 *
 * 输入：root = [1,2,3], targetSum = 5
 * 输出：[]
 *
 *  示例 3：
 *
 * 输入：root = [1,2], targetSum = 0
 * 输出：[]
 *
 *
 *  提示：
 *
 *  树中节点总数在范围 [0, 5000] 内
 *  -1000 <= Node.val <= 1000
 *  -1000 <= targetSum <= 1000
 *  Related Topics 树 深度优先搜索
 */

import java.util.ArrayList;
import java.util.List;

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

class Solution113 {
    private List<List<Integer>> res=new ArrayList<>();
    private List<Integer> path=new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        getRes(root,targetSum);
        return res;
    }
    public void getRes(TreeNode root,int targetSum){
        if(root == null){
            return;
        }
        path.add(root.val);
        targetSum-=root.val;
        if(targetSum == 0 && root.left == null && root.right == null){
            res.add(new ArrayList(path));
        }
        getRes(root.left,targetSum);
        getRes(root.right,targetSum);
        path.remove(path.size()-1);
    }


/**
* 方法二:消耗过多的内存 不推荐
*/
//    private List<List<Integer>> res=new ArrayList<>();
//    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
//        if(root == null){
//            return res;
//        }
//        getList(root,null,targetSum);
//        return res;
//    }
//    private void getList(TreeNode root, List<Integer> path, int targetSum){
//        if(root != null ){
//            int sum=targetSum-root.val;
//            List<Integer> load=new ArrayList<>();
//            if(path != null){
//                load.addAll(path);
//            }
//            load.add(root.val);
//            if(sum == 0 && root.left == null && root.right == null){
//                res.add(load);
//            }
//            getList(root.left,load,sum);
//            getList(root.right,load,sum);
//        }
//    }
}
