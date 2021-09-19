class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        //only possible sol is first val of top on top or bottom
        // or first val of bottom on bottom or top
        // else not possible
        int val1 = tops[0];
        int val2 = bottoms[0];
        int count1 = 0; // val1 as top
        int count2 = 0; //val2 as top
        int count3 = 0; //val2 as bottom
        int count4 = 0; //val 1 as bottom
        for(int i=0;i<tops.length;i++){
            if(count1 != Integer.MAX_VALUE){
                if(tops[i] == val1){
                    
                }else if(bottoms[i] == val1){
                    count1++;
                }else{
                    count1 = Integer.MAX_VALUE;
                }
            }
            if(count2 != Integer.MAX_VALUE){
                if(tops[i] == val2){
                    
                }else if(bottoms[i] == val2){
                    count2++;
                }else{
                    count2 = Integer.MAX_VALUE;
                }
            }
            if(count3 != Integer.MAX_VALUE){
                if(bottoms[i] == val2){
                    
                }else if(tops[i] == val2){
                    count3++;
                }else{
                    count3 = Integer.MAX_VALUE;
                }
            }
            if(count4 != Integer.MAX_VALUE){
                if(bottoms[i] == val1){
                    
                }else if(tops[i] == val1){
                    count4++;
                }else{
                    count4 = Integer.MAX_VALUE;
                }
            }
        }
        int ans = Math.min(Math.min(count1,count2),Math.min(count3,count4));
        if(ans == Integer.MAX_VALUE){
            return -1;
        }
        return ans;
        
    }
}
