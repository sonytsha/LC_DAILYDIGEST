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

/* 

Create Binary Tree from Descriptions 
HashMap<Integer, TreeNode>
    My map stores value → TreeNode.
    Purpose: Create only one node for each value and reuse it whenever it appears again.
    It does NOT store parent → child.


HashSet<Integer>
    My set stores only child values.
    Purpose: Find the root.
    The node that is never a child is the root.
    For each description [parent, child, isLeft]:
    If parent node doesn't exist → create it.
    If child node doesn't exist → create it.


Connect:
    isLeft == 1 → parent.left = child
    isLeft == 0 → parent.right = child
    Add the child value to the set.

Finally:
    Traverse the map.
    The value not present in the child set is the root.
*/