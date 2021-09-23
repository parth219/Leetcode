class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            int val = Math.abs(nums[i])-1;
            if(nums[val] < 0){
                //if already marked value repeated
                res.add(val+1);
            }else{ 
                //mark
                nums[val] = -nums[val];
            }
        }
        return res;
    }
}
