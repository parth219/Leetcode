class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        //find next greater 
        int n = nums.length;
        int[] ngr = new int[n];
        Stack<Integer> st = new Stack<>();
        st.push(0);
        for(int i=1;i<n;i++){
            while(st.size() > 0 && nums[st.peek()] < nums[i]){
                ngr[st.pop()] = i;
            } 
            st.push(i);
        }
        while(st.size() > 0){
            ngr[st.pop()] = n;
        }
        
        int[] ans = new int[n-k+1];
        int j=0;
        for(int i=0;i<ans.length;i++){
            if(j<i){
                j=i;
            }
            while(ngr[j] < i+k){
                j = ngr[j];
            }
            ans[i] = nums[j];
        }
        return ans;
    }
}
