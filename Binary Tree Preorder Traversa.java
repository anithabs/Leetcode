//Given a binary tree, return the preorder traversal of its nodes' values.

/*For example:
Given binary tree [1,null,2,3],
   1
    \
     2
    /
   3
return [1,2,3].

 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack();
        if(root != null){
            stack.push(root);
        }
        List<Integer> result = new ArrayList<>();
        while(!stack.isEmpty()){
            TreeNode curr = stack.pop();
            result.add(curr.val);
            if(curr.right != null){
                stack.push(curr.right);
            }
            if(curr.left != null){
                stack.push(curr.left);
            }
        }
        return result;
        
    }
}
