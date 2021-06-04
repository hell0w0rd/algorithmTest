package binarytree;
/**
 * 在二叉树中，根节点位于深度 0 处，每个深度为 k 的节点的子节点位于深度 k+1 处。
 *
 *  如果二叉树的两个节点深度相同，但 父节点不同 ，则它们是一对堂兄弟节点。
 *
 *  我们给出了具有唯一值的二叉树的根节点 root ，以及树中两个不同节点的值 x 和 y 。
 *
 *  只有与值 x 和 y 对应的节点是堂兄弟节点时，才返回 true 。否则，返回 false。
 *
 *
 *
 *  示例 1：
 *
 * 输入：root = [1,2,3,4], x = 4, y = 3
 * 输出：false
 *
 *
 *  示例 2：
 *
 * 输入：root = [1,2,3,null,4,null,5], x = 5, y = 4
 * 输出：true
 *
 *
 *  示例 3：
 * 输入：root = [1,2,3,null,4], x = 2, y = 3
 * 输出：false
 *
 *
 *
 *  提示：
 *
 *
 *  二叉树的节点数介于 2 到 100 之间。
 *  每个节点的值都是唯一的、范围为 1 到 100 的整数。
 *
 *
 *
 *  Related Topics 树 广度优先搜索
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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
class Solution993 {
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root == null){
            return false;
        }
        List<Integer> res = new ArrayList<>();
        List<Integer> sonNode=new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(! queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                res.add(node.val);
                if(node.left != null){
                    queue.add(node.left);
                    sonNode.add(node.left.val);
                }
                if(node.right != null){
                    queue.add(node.right);
                    sonNode.add(node.right.val);
                }
                if(sonNode.contains(x) && sonNode.contains(y)){
                    return false;
                }
                sonNode.clear();
            }
            if(res.contains(x) && res.contains(y)){
                return true;
            }
            res.clear();
        }
        return false;
    }
//  解法二:耗时更少 消耗内存也少 优先
//    public boolean isCousins(TreeNode root, int x, int y) {
//        if(root == null){
//            return false;
//        }
//        Queue<TreeNode> queue = new LinkedList<>();
//        queue.add(root);
//        while(! queue.isEmpty()){
//            int size = queue.size();
//            int countLevel=0;
//            for (int i = 0; i < size; i++) {
//                TreeNode node = queue.poll();
//                if(containsXorY(node.left,x,y) && containsXorY(node.right,x,y)){
//                    return false;
//                }
//                if(containsXorY(node,x,y)){
//                    countLevel++;
//                }
//                if(countLevel == 2){
//                    return true;
//                }
//                if(node.left != null){
//                    queue.add(node.left);
//                }
//                if(node.right != null){
//                    queue.add(node.right);
//                }
//            }
//            if(countLevel == 1){
//                return false;
//            }
//
//        }
//        return false;
//    }
//    private boolean containsXorY(TreeNode node,int x,int y){
//        return node != null && (x==node.val || y==node.val);
//    }
}