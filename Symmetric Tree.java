Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

For example, this binary tree [1,2,2,3,4,4,3] is symmetric:

    1
   / \
  2   2
 / \ / \
3  4 4  3
But the following [1,2,2,null,3,null,3] is not:
    1
   / \
  2   2
   \   \
   3    3
   
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isSymmetric(TreeNode root) {
        return root == null || checkSymmetric ( root.left, root.right);
    }
    public boolean checkSymmetric(TreeNode subTree0, TreeNode subTree1){
        if(subTree0 == null && subTree1== null ) return true;
        else if(subTree0 != null && subTree1 != null ){
            return subTree0.val == subTree1.val && checkSymmetric( subTree0.left, subTree1.right) && checkSymmetric( subTree0.right, subTree1.left);
        }
        return false;
    }
}
