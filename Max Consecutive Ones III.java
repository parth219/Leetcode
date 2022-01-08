class Solution {
    public int longestOnes(int[] arr, int k) {
        // write your code here
        int c = 0;
        int i=0,j=0;
        int ans = 0;
        while(true){
            boolean f1 = false,f2 = false;
            //acquire
            while(i<arr.length && c <= k){
                if(arr[i] == 1){
                    i++;
                    ans = Math.max(ans,i-j);
                }else if(c < k){
                    c++;
                    i++;
                    ans = Math.max(ans,i-j);
                }else{
                    i++;
                    c++;
                }
                f1 = true;
            }
            //release
            while(j<i && c>k){
                while(arr[j] ==1){
                    j++;
                }
                if(arr[j] == 0){
                    c--;
                    j++;
                }
                f2 = true;
            }
            if(f1 == false && f2 == false){
                break;
            }
        }
        return ans;
    }
}
