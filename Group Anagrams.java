class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<HashMap<Character,Integer>,ArrayList<String>> map = new HashMap<>();
        for(int i=0;i<strs.length;i++){
            HashMap<Character,Integer> key = new HashMap<>();
            for(int j=0;j<strs[i].length();j++){
                char ch = strs[i].charAt(j);
                key.put(ch,key.getOrDefault(ch,0)+1);
            }
            if(map.containsKey(key)){
                map.get(key).add(strs[i]);
            }else{
                ArrayList<String> al = new ArrayList<>();
                al.add(strs[i]);
                map.put(key,al);
            }
        }
        List<List<String>> ans = new ArrayList<>();
        for(HashMap<Character,Integer> val:map.keySet()){
            ans.add(map.get(val));
        }
        return ans;
    }
}
