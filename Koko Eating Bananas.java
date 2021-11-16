class Solution {
    public int minEatingSpeed(int[] arr, int h) {
        int lo = 1;
        int max = arr[0];
        for(int i=1;i<arr.length;i++){
            max = Math.max(arr[i],max);
        }
        int hi = max;
        int ans = Integer.MAX_VALUE;
        while(lo <= hi){
            int mid = (lo+hi)/2;
            int time = 0;
            for(int i=0;i<arr.length;i++){
                time += arr[i]/mid;
                if(arr[i] % mid !=0){
                    time++;
                }
            }
            if(time<=h){
                ans = Math.min(ans,mid);
                hi = mid - 1;
            }else{
                lo = mid + 1;
            }
        }
        return ans;
    }
}
