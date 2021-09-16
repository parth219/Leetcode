class Solution {
    public int partitionDisjoint(int[] nums) {
        int ans = 0;
        int leftmax = nums[0]; //greates num in left subsset
        int greater  =nums[0]; // greatest num countered till now but not inluded
        for(int i=1;i<nums.length;i++){
            if(nums[i] > greater){
                greater = nums[i];
            }
            if(nums[i] < leftmax){
                leftmax = greater;
                ans = i;
            }
        }
        return ans+1;
    }
}
