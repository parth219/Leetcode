class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        for(int i=0;i<nums.length;i++){
            if((nums[i]&1)==1){
                nums[i] = 1;
            }else{
                nums[i] = 0;
            }
        }
        HashMap<Integer,Integer> map  =new HashMap<>();
		map.put(0,1);
		int sum = 0;
		int ans = 0;
		for(int i=0;i<nums.length;i++){
		    sum += nums[i];
		    if(map.containsKey(sum-k)){
		        ans += map.get(sum-k);
		    }
		    int val = map.getOrDefault(sum,0);
		    map.put(sum,val+1);
		}
		return ans;
    }
}
