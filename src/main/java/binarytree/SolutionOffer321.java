package binarytree;//从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。
//
// 
//
// 例如: 
//给定二叉树: [3,9,20,null,null,15,7], 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
// 
//
// 返回： 
//
// [3,9,20,15,7]
// 
//
// 
//
// 提示： 
//
// 
// 节点总数 <= 1000 
// 
// Related Topics 树 广度优先搜索 
// 👍 96 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

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
 *     TreeNode(int x) { val = x; }
 * }
 */
class SolutionOffer321 {
    public int[] levelOrder(TreeNode root) {
        List<Integer> temp = new ArrayList<>();
        int[] res={};
        Queue<TreeNode> queue=new LinkedList<>();
        if(root == null){
            return res;
        }else{
            queue.add(root);
        }
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            temp.add(node.val);
            if(node.left != null){
                queue.add(node.left);
            }
            if(node.right != null){
                queue.add(node.right);
            }

        }
        res=new int[temp.size()];
        for (int i = 0; i < temp.size(); i++) {
            res[i]=temp.get(i);
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
