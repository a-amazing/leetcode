/*
 * @lc app=leetcode.cn id=543 lang=java
 *
 * [543] 二叉树的直径
 *
 * https://leetcode.cn/problems/diameter-of-binary-tree/description/
 *
 * algorithms
 * Easy (57.29%)
 * Likes:    1092
 * Dislikes: 0
 * Total Accepted:    237.7K
 * Total Submissions: 414.9K
 * Testcase Example:  '[1,2,3,4,5]'
 *
 * 给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过也可能不穿过根结点。
 * 
 * 
 * 
 * 示例 :
 * 给定二叉树
 * 
 * ⁠         1
 * ⁠        / \
 * ⁠       2   3
 * ⁠      / \     
 * ⁠     4   5    
 * 
 * 
 * 返回 3, 它的长度是路径 [4,2,1,3] 或者 [5,2,1,3]。
 * 
 * 
 * 
 * 注意：两结点之间的路径长度是以它们之间边的数目表示。
 * 
 */

// @lc code=start
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
class Solution {

    //最大直径
    int max = 0;
    //当前节点最大直径
    int curr = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        traverse(root);
        return max;
    }

    public void traverse(TreeNode root){
        if(root == null){
            return;
        }

        int leftDep = maxDepth(root.left);
        int rightDep = maxDepth(root.right);
        curr = leftDep + rightDep + 1;
        max = Math.max(max,curr);

        traverse(root.left);
        traverse(root.right);
    }

    public int maxDepth(TreeNode root){
        if(root == null){
            return 0;
        }

        return Math.max(maxDepth(root.left),maxDepth(root.right)) + 1;
    }
}
// @lc code=end

