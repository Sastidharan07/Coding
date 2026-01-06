//Question : https://leetcode.com/problems/maximum-level-sum-of-a-binary-tree/description/
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
    public int maxLevelSum(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int max = Integer.MIN_VALUE;
        int ans = 1;
        int curr = 1;
        while (!q.isEmpty()) {
            int c = 0;
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode temp = q.remove();
                c += temp.val;
                if (temp.left != null)
                    q.add(temp.left);
                if (temp.right != null) 
                    q.add(temp.right);
            }    
            if (c > max) {
                max = c;
                ans = curr;
            }
            curr += 1;
        }
        return ans;
    }
}