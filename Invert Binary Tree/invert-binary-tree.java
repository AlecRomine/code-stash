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
    public TreeNode invertTree(TreeNode root) {
        
        return invertTreeHelper(root);
    }
    
    private TreeNode invertTreeHelper(TreeNode root) {
        
        if(root == null){
            return null;
        }
        
        TreeNode tempLeft = root.left;
        
        root.left = invertTreeHelper(root.right);
        root.right = invertTreeHelper(tempLeft);
        
            
        return root;
    }
}


/* 
Time Submitted     Status     Runtime   Memory  Language
07/07/2021 13:39	Accepted	0 ms	36.7 MB	java

*/