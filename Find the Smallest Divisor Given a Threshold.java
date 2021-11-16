class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int lo = 1;
        int max = nums[0];
        for(int i=0;i<nums.length;i++){
            max = Math.max(nums[i],max);
        }
        int hi = max;
        int ans = max;
        while(lo<=hi){
            int mid = (lo+hi)/2;
            int temp = 0;
            for(int i=0;i<nums.length;i++){
                temp += Math.ceil(nums[i]*1.0/mid);
            }
            if(temp <= threshold){
                ans = mid;
                hi = mid -1;
            }else{
                lo = mid + 1;
            }
        }
        return ans;
    }
}
