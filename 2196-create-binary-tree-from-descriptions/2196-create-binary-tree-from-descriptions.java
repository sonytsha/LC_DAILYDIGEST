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
        TreeNode root = new TreeNode(0);
        HashMap<Integer, TreeNode> map = new HashMap<>();
        Set<Integer> children = new HashSet<>();
        for(int i=0;i<descriptions.length;i++){
            int parent = descriptions[i][0];
            int child = descriptions[i][1];
            int isLeft = descriptions[i][2];

            if(!map.containsKey(parent)){
                map.put(parent, new TreeNode(parent));
            }

            if(!map.containsKey(child)){
                map.put(child, new TreeNode(child));
            }

            TreeNode parentNode = map.get(parent);
            TreeNode childNode = map.get(child);

            if(isLeft == 1){
                parentNode.left = childNode;
            }
            else{
                parentNode.right = childNode;
            }
            children.add(child);
            }
            for(int key : map.keySet()){
                if(!children.contains(key)){
                    return map.get(key);
                }
            }
            return null;
    }
}