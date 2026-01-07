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
    long MOD = 1_000_000_007; 
    long maxProduct = 0;
    long totalSum = 0;

    public int maxProduct(TreeNode root) {
        totalSum = dfsSum(root);
        dfsSubTreeSum(root);
        return (int)(maxProduct % MOD);
    }

    private long dfsSum(TreeNode root){
        if(root == null) return 0;

        return root.val + dfsSum(root.left) + dfsSum(root.right);
    }
    
    private long dfsSubTreeSum(TreeNode root){

        if(root == null) return 0;

        long left = dfsSubTreeSum(root.left);
        long right = dfsSubTreeSum(root.right);

        long subTreeSum = root.val + left + right;

        long product = subTreeSum * (totalSum - subTreeSum);

        maxProduct = Math.max(maxProduct, product);
        
        return subTreeSum;

    }
}
