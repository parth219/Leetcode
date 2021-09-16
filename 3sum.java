class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for(int i=0;i<nums.length-2;i++){
            if(i!=0 && nums[i] == nums[i-1]) continue;
            List<List<Integer>> subres = twosum(nums,-nums[i],i+1);
            for(List<Integer> list:subres){
                list.add(nums[i]);
                res.add(list);
            }
        }
        return res;
    }
    public List<List<Integer>> twosum(int[] nums,int target,int si){
        List<List<Integer>> res = new ArrayList<>();
        int left = si;
        int right = nums.length-1;
        while(left < right){
            if(left != si && nums[left] == nums[left-1]){
                left++;
                continue;
            }
            if(nums[left]+nums[right] == target){
                List<Integer> subres = new ArrayList<>();
                subres.add(nums[left]);
                subres.add(nums[right]);
                res.add(subres);
                left++;
                right--;
            }else if(nums[left] + nums[right] > target){
                right--;
            }else{
                left++;
            }
        }
        return res;
    }
}
