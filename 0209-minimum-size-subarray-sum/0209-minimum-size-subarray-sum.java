class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int l=0,r=0,ans=Integer.MAX_VALUE,sum=0;
        int n=nums.length;
        for(r=0;r<n;r++){
            sum+=nums[r];
            while(sum>=target){
                ans=Math.min(ans,r-l+1);
                sum-=nums[l];
                l++;
            }
        }
        return ans==Integer.MAX_VALUE ? 0 : ans;
    }
}