//Question : https://leetcode.com/problems/sum-of-root-to-leaf-binary-numbers/description/
class Solution {
    public static int helper(TreeNode root,int curr){
        curr=curr*2+root.val;
        if(root.left==null&&root.right==null){
            return curr;
        }
        int ans=0;
        if(root.left!=null){
            ans+=helper(root.left,curr);
        }
        if(root.right!=null){
            ans+=helper(root.right,curr);
        }  
        return ans; 
    }
    public int sumRootToLeaf(TreeNode root) {
        
        return helper(root,0);
    }
}