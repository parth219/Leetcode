class Solution {
    public int singleNonDuplicate(int[] arr) {
        int lo = 0,hi = arr.length-1;
        while(lo<=hi){
            int mid = (lo+hi)/2;
            if(mid == 0 || mid == arr.length-1 || (arr[mid] != arr[mid+1] && arr[mid] != arr[mid-1])){
                return arr[mid];
            }else if(arr[mid] == arr[mid-1]){
                int te = mid - lo + 1;
                if(te % 2 == 0){
                    lo = mid + 1;
                }else{
                    hi = mid - 2;
                }
            }else{
                int te = hi - mid + 1;
                if(te % 2 == 0){
                    hi = mid - 1;
                }else{
                    lo = mid + 2;
                }
            }
        }
        return -1;
    }
}
