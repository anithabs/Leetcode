// When given node has parent pointer 
 public class TreeNode {
      int val;
      TreeNode parent;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
  
  class solution{
      public static TreeNode LCAWithParentPointer( TreeNode node0, TreeNode node1){
          int depth0 = Depth(node0);
          int depth1 = Depth(node1);
          if( depth0 > depth1){
              TreeNode temp = node0;
              node0 = node1;
              node1 = temp;
          }
          int diff = Math.abs(depth0 - depth1);
          while(diff-- > 0){
              node1 = node1.parent;
          }
          while( node0 != node1){
              node0 = node.parent;
              node1 = node1.parent;
          }
          return node1;
      }
      public static int Depth(TreeNode node){
          int depth = 0;
          while(node.parent != null){
              node = node.parent;
              depth++;
          }
          return depth;
      }
  }
