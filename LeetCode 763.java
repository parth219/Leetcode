class Solution {
    public List<Integer> partitionLabels(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        //create map of last occurence of character
        for(int i=s.length()-1;i>=0;i--){
            char ch = s.charAt(i);
            if(map.containsKey(ch) == false){
                map.put(ch,i);
            }
        }
        int max = Integer.MIN_VALUE;
        int prev = 0; // to store last partition index
        
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            max = Math.max(max,map.get(ch)); 
            if(max == i){ //if max imapct of array traversed till now 
                list.add(i-prev +1); //is at index i then partition is created
                prev = i+1;
            }
        }
        return list;
    }
}
