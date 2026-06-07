//Question : https://leetcode.com/problems/create-binary-tree-from-descriptions/description/
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
    public TreeNode createBinaryTree(int[][] descriptions) {
        // parent -> left child
        Map<Integer, Integer> leftMap= new HashMap<>();
        // parent -> right child
        Map<Integer, Integer> rightMap= new HashMap<>();
        // stores all nodes that appear as children
        Set<Integer> children= new HashSet<>();

        for(int[] d: descriptions){
            int parent=d[0];
            int child=d[1];

            children.add(child);
            if(d[2]==1) leftMap.put(parent, child);
            else rightMap.put(parent, child);
        }

        int rootNode=-1;

        // traverse the nodes and check which node is never a child that is our parent
        for(int[] d: descriptions){
            if(!children.contains(d[0])){
                rootNode=d[0];
                break;
            }
        }

        // just recursively build bt by it
        TreeNode root= build(rootNode, leftMap, rightMap);

        return root;

    }

    private TreeNode build(int val, Map<Integer, Integer> leftMap, Map<Integer, Integer> rightMap){
        TreeNode root= new TreeNode(val) ;

        // build left subtree
        if(leftMap.containsKey(val)){
            root.left = build(leftMap.get(val), leftMap, rightMap);
        }

        // build right subtree
        if(rightMap.containsKey(val)){
            root.right = build(rightMap.get(val), leftMap, rightMap);
        }

        return root;
    }
}
