class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums2.length < nums1.length){
            return findMedianSortedArrays(nums2,nums1);
        }
        int n1 = nums1.length;
        int n2 = nums2.length;
        int te = n1 + n2;
        int lo = 0;
        int hi = n1;
        
        while(lo<=hi){
            int cut = (lo+hi)/2;
            int cut2 = (te+1)/2 - cut;
            int l1 = cut == 0? Integer.MIN_VALUE:nums1[cut-1];
            int l2 = cut2 == 0?Integer.MIN_VALUE:nums2[cut2-1];
            int r1 = cut == n1?Integer.MAX_VALUE:nums1[cut];
            int r2 = cut2 == n2? Integer.MAX_VALUE:nums2[cut2];
            if(l1 <= r2 && l2 <= r1){
                if(te % 2 == 0){
                    double median = (Math.max(l1,l2) + Math.min(r1,r2))*1.0/2;
                    return median;
                }else{
                    //odd elements
                    return Math.max(l1,l2)*1.0;
                }
            }else if(l2 > r1){
                lo = cut + 1;
            }else{
                hi = cut-1;
            }
        }
        return 0.0;
    }
}
