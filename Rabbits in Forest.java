class Solution {
    public int numRabbits(int[] answers) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int val:answers){
            map.put(val,map.getOrDefault(val,0)+1);
        }
        int ans = 0;
        for(int val:map.keySet()){
            int grp = (int)Math.ceil((map.get(val)*1.0)/(val+1));
            ans += (val+1)*grp;
        }
        return ans;
    }
}
