class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double ans = Integer.MIN_VALUE;
        double sum = 0;
        for(int i=0;i<k;i++){
            sum += nums[i];
        }
        //need to calulate avg here in case k == nums.length
        ans = Math.max(ans,sum/k);
        int j=0;
        //find sum after k elements
        for(int i=k;i<nums.length;i++){
            
            sum+=nums[i];
            sum-=nums[j];
            j++;
            ans = Math.max(ans,sum/k);
        }
        return ans;
    }
}
