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
    
    private int maxPath = Integer.MIN_VALUE;
    
    public int maxPathSum(TreeNode root) {
        
        dfs(root);
        return maxPath;
        
    }
    
    // Check if left, right, and current sum to greater than the max count
    private int dfs( TreeNode root) {
        
        int leftsum;
        int rightsum;
        
        if(root.left == null & root.right == null){
            checkMax(root.val);
            return root.val;
        } else if (root.left == null){
            rightsum = Math.max( root.val + dfs(root.right) , root.val );
            checkMax(rightsum);
            return rightsum;
            
        } else if (root.right == null){
            leftsum = Math.max(root.val + dfs(root.left), root.val);
            checkMax(leftsum);
            return leftsum;
            
        } else { // both leaves exist
            leftsum = dfs(root.left);
            rightsum = dfs(root.right);
            
            
            if (leftsum < 0 && rightsum < 0){
                checkMax(root.val);
                return root.val;
            } else if(rightsum < 0){
                checkMax(root.val + leftsum);
                return root.val + leftsum;
            } else if(leftsum < 0) {
                checkMax(root.val + rightsum);
                return root.val + rightsum;
            }  
            checkMax(root.val + leftsum + rightsum);
            return root.val + Math.max(leftsum,rightsum);
        }
        
        
    }
    
    private void checkMax(int newMax){
        if (newMax > maxPath){
            maxPath = newMax;
        }
        
    }
}

/* 
Time Submitted      Status     Runtime  Memory  Language
10/14/2021 18:14	Accepted	2 ms	45.4 MB	java

- notes this one was easier for me to visualize.
- managed with no googling 
*/