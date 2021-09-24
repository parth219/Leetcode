class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int lp = 1; //left product
        int rp = 1; // right product
        
        int lmax = Integer.MIN_VALUE; // max in left product
        int rmax = Integer.MIN_VALUE; //max in right product
        //find left product
        for(int i=0;i<n;i++){
            if(nums[i] == 0){
                lp = 1;
                lmax = Math.max(lmax,0);
            }else{
                lp = lp*nums[i];
                lmax = Math.max(lmax,lp);
            }   
        }
        // find right product
        for(int i=n-1;i>=0;i--){
            if(nums[i] == 0){
                rp = 1;
                rmax = Math.max(rmax,0);
            }else{
                rp = rp*nums[i];
                rmax = Math.max(rmax,rp);
            }
        }
        int ans = Math.max(lmax,rmax);
        return ans;
    }
}
