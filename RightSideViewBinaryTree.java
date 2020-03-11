// =================================== DFS ====================================

/**
Time: O(N)
Space: O(H)
Algorithm:
=========
1. Keep track of level of the node for every recusive call
2. Whenever level is equal to result list's size, implies we are in a new level. So, add right nodes first. 
3. This leads to right most nodes being updated in the list in every level
 */
class Solution {
    List<Integer> result;
    public List<Integer> rightSideView(TreeNode root) {
        result = new ArrayList<Integer>();
        if(root == null) return result;
        dfs(root, 0); 
        return result;
    }
    
    private void dfs(TreeNode root, int level) {
        if(root == null) return;
        if(level == result.size()) result.add(root.val);    // if size of result is equal to level, implies we are in a new level
        dfs(root.right, level+1);   // right first as we need right side view
        dfs(root.left, level+1);
    }
}

// =================================== BFS ====================================

/**
Time: O(N)
Space: O(N)
Algorithm:
=========
1. Add root to queue and while queue is not empty, calculatr size of queue
2. That would be equal to number of nodes in that level of tree. So, iterate through them by polling and if first node in queue, 
it means that node is right most node of that level
3. So, add it to the result and offer its right and left children in that order to queue.
 */
class Solution {
    List<Integer> result;
    public List<Integer> rightSideView(TreeNode root) {
        result = new ArrayList<Integer>();
        if(root == null) return result;
        
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        
        while(!q.isEmpty()) {               
            int size = q.size();            // calculate size of every level
            for(int i = 0; i < size; i++) {     // for every node in queue till size is reached, poll and add its right and left children
                TreeNode node = q.poll();
                if(i == 0) result.add(node.val);        // if i == 0, implies it is the rightmost node, so add to result
                if(node.right != null) q.offer(node.right);     // add right node to queue
                if(node.left != null) q.offer(node.left);   // add left node to queue
            }
        }
        return result;
    }
}