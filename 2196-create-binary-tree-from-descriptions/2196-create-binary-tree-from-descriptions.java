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
        TreeNode[] nodes = new TreeNode[100001];
        boolean[] child = new boolean[1000001];

        for(int i=0;i<descriptions.length;i++){
            int parent = descriptions[i][0];
            int kid = descriptions[i][1];
            int isLeft = descriptions[i][2];

            if(nodes[parent] == null){
                nodes[parent] = new TreeNode(parent);
            }

            if(nodes[kid] == null){
                nodes[kid] = new TreeNode(kid);
            }

            if(isLeft == 1){
                nodes[parent].left = nodes[kid];
            }
            else{
                nodes[parent].right = nodes[kid];
            }

            child[kid] = true;
        }

        for(int i=1;i<=1000001;i++){
            if(nodes[i] != null && !child[i]){
                return nodes[i];
            }
        }

        return null;
    }
}