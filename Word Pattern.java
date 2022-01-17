class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] arr = s.split(" ");
        if(arr.length != pattern.length()) return false;
        HashMap<Character,String> map = new HashMap<>();
        HashSet<String> set = new HashSet<>();
        for(int i=0;i<pattern.length();i++){
            char ch = pattern.charAt(i);
            if(map.containsKey(ch)){
                if(!map.get(ch).equals(arr[i])){
                    return false;
                }
            }else if(set.contains(arr[i])){
                return false;
            }else{
                map.put(ch,arr[i]);
                set.add(arr[i]);
            }
        }
        return true;
    }
}
