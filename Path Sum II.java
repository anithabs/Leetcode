Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.

For example:
Given the below binary tree and sum = 22,
              5
             / \
            4   8
           /   / \
          11  13  4
         /  \    / \
        7    2  5   1
return
[
   [5,4,11,2],
   [5,8,4,5]
]

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
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<Integer> current = new ArrayList<Integer>();
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        checkPathSum(root, sum, current, result);
        return result;
    }
    public void checkPathSum(TreeNode root, int sum,List<Integer> current,List<List<Integer>> result){
        if( root == null){ return;}
        current.add(new Integer(root.val));
        if(root.right == null && root.left == null && root.val == sum){
            result.add(new ArrayList(current));
            current.remove(current.size() - 1);
            return;
        }else{
            checkPathSum(root.left, sum-root.val, current, result);
            checkPathSum(root.right, sum-root.val, current, result);
        }
        current.remove(current.size() - 1); 
    }
}
