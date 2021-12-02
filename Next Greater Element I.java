class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums2.length;i++){
            map.put(nums2[i],i);
        }
        int[] ans = nextGreater(nums2);
        
        for(int i=0;i<nums1.length;i++){
            
            nums1[i] = ans[map.get(nums1[i])];
        }
        return nums1;
    }
    public int[] nextGreater(int[] arr){
        Stack<Integer> st = new Stack<>();
        int[] ans = new int[arr.length];
        st.push(0);
        for(int i=1;i<arr.length;i++){
            while(st.size()>0 && arr[st.peek()]<arr[i]){
                ans[st.pop()] = arr[i];
            }
            st.push(i);
        }
        while(st.size()>0){
            ans[st.pop()] = -1;
        }
        return ans;
    }
}
