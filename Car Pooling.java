class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int max = Integer.MIN_VALUE;
        for(int i=0;i<trips.length;i++){
            max = Math.max(max,trips[i][2]);
        }
        int[] arr = new int[max+1];
        //add passenger on start point
        //remove passenfer from end point
        for(int i=0;i<trips.length;i++){
            int sp = trips[i][1];
            int ep = trips[i][2];
            arr[sp] += trips[i][0];
            arr[ep] += -trips[i][0];
        }
        max = arr[0];
        ///below code doesnt update max for arr[i]
        for(int i=1;i<arr.length;i++){
            arr[i] += arr[i-1];
            max = Math.max(max,arr[i]);
        }
        if(max > capacity) return false;
        return true;
    }
}
