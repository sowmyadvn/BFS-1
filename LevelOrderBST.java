// ============================= BFS using DFS =============================
/*
Time: O(N), space: O(H) stack space
Algorithm:
=========
1. Keep track of which level is being traversed by passing level variable as argument
2. Whenever level increases and equals list's size, add new array list to list of lists
3. Add node value to list at that level and increment level when calling level order on its left and right
*/
class Solution {
    List<List<Integer>> list;
    public List<List<Integer>> levelOrder(TreeNode root) {
        list = new ArrayList<List<Integer>>();      //result - level order of binary tree
        levelOrder(root,0);
        return list;
    }
    
    private void levelOrder(TreeNode root, int level) {
        if(root == null)                //base
            return;
        if(level >= list.size())       // node is on new level
             list.add(new ArrayList<Integer>());
        list.get(level).add(root.val);  // add value of current node 
        levelOrder(root.left,list,level+1); // call levelOrder on its left
        levelOrder(root.right,list,level+1);    // levelOrder on its right
    }
}
// ============================= BFS ===============================
