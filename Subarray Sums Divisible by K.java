class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int ans = 0;
        int sum = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        for(int i=0;i<nums.length;i++){
            sum += nums[i];
            int rem = sum%k;
            if(rem<0) rem+=k;
            if(map.containsKey(rem)){
                ans += map.get(rem);
            }
            int val = map.getOrDefault(rem,0);
            map.put(rem,val+1);
        }
        return ans;
    }
}
