class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        PriorityQueue<pair> pq = new PriorityQueue<>();
        int max = Integer.MIN_VALUE; // max to maintain max val in pq
        for(int l=0;l<nums.size();l++){
            int val = nums.get(l).get(0);
            max = Math.max(max,val);
            pq.add(new pair(val,l,0));
        }
        int sp = 0;
        int ep = 0;
        int length = Integer.MAX_VALUE;
        while(true){
            pair rem = pq.remove();
            //update length 
            if(max - rem.val < length){
                length = max - rem.val;
                sp = rem.val;
                ep = max;
            }
            //add next element of smallest element
            if(rem.j < nums.get(rem.i).size() - 1){
                int val = nums.get(rem.i).get(rem.j + 1);
                max = Math.max(max,val);
                pq.add(new pair(val,rem.i,rem.j+1));
            }else{
                break;
            }
        }
        return new int[]{sp,ep};
    }
    class pair implements Comparable<pair>{
        int val;
        int i; //index of list
        int j; //index of element in list
        public pair(int val,int i,int j){
            this.val = val;
            this.i = i;
            this.j = j;
        }
        public int compareTo(pair o){
            return this.val - o.val;
        }
    }
}
