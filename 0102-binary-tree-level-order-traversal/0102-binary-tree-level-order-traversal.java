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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans=new ArrayList<>();
        if(root==null)
        return ans;
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        q.add(null);
        List<Integer> a=new ArrayList<>();
        while(!q.isEmpty()){
            TreeNode f=q.remove();
            if(f==null){
                ans.add(new ArrayList(a));
                a.clear();
                if(!q.isEmpty()){
                    q.add(null);
                }
            }
            else{
                a.add(f.val);
                if(f.left!=null)
                q.add(f.left);
                if(f.right!=null)
                q.add(f.right);
            }
        }
        return ans;
    }
}