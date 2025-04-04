//Question : https://leetcode.com/problems/lowest-common-ancestor-of-deepest-leaves/description/
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
class Pair {
    int height;
    TreeNode lca;

    Pair(TreeNode lca, int height) {
        this.lca = lca;
        this.height = height;
    }    
}

class Solution {
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        Pair res = helper(root);
        return res.lca;
    }

    private Pair helper(TreeNode root) {
        if(root == null) {
            return new Pair(null, 0);
        }

        Pair l = helper(root.left);
        Pair r = helper(root.right);

        if(l.height == r.height) {
            return new Pair(root, l.height + 1);
        }

        return (l.height > r.height) ? new Pair(l.lca, l.height + 1) : new Pair(r.lca, r.height + 1);
    }
}
