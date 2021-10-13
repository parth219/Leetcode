class Solution {
    public int nextGreaterElement(int n) {
        
        String str = Integer.toString(n);
        char[] arr = str.toCharArray();
        
        int i = arr.length-2;
        //reduce i till dip found
        while(i>=0 && arr[i] >= arr[i+1]){
            i--;
        }
        if(i==-1){
            return -1;
        }
        //find element greater than arr[i]
        int k = arr.length-1;
        while(arr[i] >= arr[k]){
            k--;
        }
        // System.out.println(Arrays.toString(arr));
        //swap at i and k
        char temp = arr[i];
        arr[i] = arr[k];
        arr[k] = temp;
        
        //reverse all elements after i+1
        reverse(arr,i+1);
        // System.out.println(Arrays.toString(arr));
        long ans = Long.parseLong(String.valueOf(arr));
        if(ans <= Integer.MAX_VALUE){
            return (int)ans;
        }
        return -1; 
    }
    public void reverse(char[] arr, int i){
        int j= arr.length-1;
        while(i<j){
            char temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }
}
