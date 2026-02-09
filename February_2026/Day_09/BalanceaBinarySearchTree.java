//Question : https://leetcode.com/problems/balance-a-binary-search-tree/description/
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
    private void inorder(TreeNode node, java.util.ArrayList<TreeNode> nodes){
        if (node == null) 
            return;
        inorder(node.left, nodes);
        nodes.add(node);
        inorder(node.right, nodes);
    }

    private TreeNode build(java.util.ArrayList<TreeNode> nodes, int left, int right){
        if (left > right) 
            return null;
        int mid = left + (right - left) / 2;
        TreeNode root = nodes.get(mid);
        root.left = build(nodes, left, mid - 1);
        root.right = build(nodes, mid + 1, right);
        return root;
    }

    public TreeNode balanceBST(TreeNode root) {
        if (root == null) 
            return null;
        java.util.ArrayList<TreeNode> nodes = new java.util.ArrayList<>();
        inorder(root, nodes);
        return build(nodes, 0, nodes.size() - 1);
    }
}