外观数列」是一个整数序列，从数字 1 开始，序列中的每一项都是对前一项的描述。前五项如下：

1.     1
2.     11
3.     21
4.     1211
5.     111221
1 被读作  "one 1"  ("一个一") , 即 11。
11 被读作 "two 1s" ("两个一"）, 即 21。
21 被读作 "one 2",  "one 1" （"一个二" ,  "一个一") , 即 1211。

给定一个正整数 n（1 ≤ n ≤ 30），输出外观数列的第 n 项。

注意：整数序列中的每一项将表示为一个字符串。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/count-and-say
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
class Solution {
    public String countAndSay(int n) {
        StringBuilder sb=new StringBuilder("1");
        while(n>1){
            int count=1;
            StringBuilder tmp=new StringBuilder();
            sb.append("#");
            for(int i=0;i<sb.length()-1;i++){
                if(sb.charAt(i)==sb.charAt(i+1)){
                    count++;
                }else{
                    tmp.append(count).append(sb.charAt(i));
                    count=1;
                }
            }
            sb=tmp;
            n--;
        }
        return new String(sb);
    }
}

给定一个二叉树，判断其是否是一个有效的二叉搜索树。

假设一个二叉搜索树具有如下特征：

节点的左子树只包含小于当前节点的数。
节点的右子树只包含大于当前节点的数。
所有左子树和右子树自身必须也是二叉搜索树。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/validate-binary-search-tree
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
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
    public boolean isValidBST(TreeNode root) {
        return isBst(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }
    private boolean isBst(TreeNode root,long min,long max){
        if(root==null){
            return true;
        }
        if(root.val<=min||root.val>=max){
            return false;
        }
        return isBst(root.left,min,root.val)&&isBst(root.right,root.val,max);
    }
}

给定一个二叉树，检查它是否是镜像对称的。

例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
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
        return isSame(root,root);
    }
    private boolean isSame(TreeNode q,TreeNode p){
        if(q==null&&p==null){
            return true;
        }
        if(q==null||p==null){
            return false;
        }
        if(q.val!=p.val){
            return false;
        }
        return isSame(q.left,p.right)&&isSame(q.right,p.left);
    }
}

给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
class Solution {
    public int maxSubArray(int[] nums) {
        int max=nums[0];
        int sum=0;
        for(int i:nums){
            if(sum>=0){
                sum+=i;
            }
            if(sum<0){
                sum=i;
            }
            max=Math.max(max,sum);
        }
        return max;
    }
}

打乱一个没有重复元素的数组。
class Solution {
    private int[] arr;
    private int[] original;
    private int len;
    Random random=new Random();
    public Solution(int[] nums) {
        len=nums.length;
        original=nums.clone();
        arr=nums;
    }
    
    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        arr=original;
        original=original.clone();
        return original;
    }
    
    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        for(int i=0;i<len;i++){
            int r=random.nextInt(len-i)+i;
            int tmp=arr[i];
            arr[i]=arr[r];
            arr[r]=tmp;
        }
        return arr;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */
 