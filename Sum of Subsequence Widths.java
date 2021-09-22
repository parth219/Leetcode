class Solution {
    public int sumSubseqWidths(int[] nums) {
        //onlymax and min element matters of subsequence and not its order
        //therefore we can sort it
        Arrays.sort(nums);
        int mod = (int)1e9 + 7;
        int n = nums.length;
        //for each element find no of times it occurs at max and min
        //no of subsequence of n elements equals 2^n
        //store power values
        long[] power = new long[n];
        power[0] = 1;
        for(int i=1;i<n;i++){
            power[i] = (power[i-1]*2) % mod;
        }
        //total subsequence as min and as max
        //val*(no. of times as max - no of times as min)
        long ans = 0;
        for(int i=0;i<n;i++){
            ans = (ans + (nums[i]*(power[i] - power[n-1-i]))) % mod;
        }
        return (int)ans;
    }
}
