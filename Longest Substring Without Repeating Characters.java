class Solution {
    public int lengthOfLongestSubstring(String str) {
        HashMap<Character,Integer> map = new HashMap<>();
        String ans = "";
		int i=0,j=0;
		boolean flag = false;
		while(true){
		    //acquire
		    boolean f1 = false;
		    boolean f2 = false;
		    while(i<str.length() && flag == false){
		        char ch = str.charAt(i);
		        if(!map.containsKey(ch)){
		            map.put(ch,1);
		            i++;
		            String pans = str.substring(j,i);
    		        if(ans.length()==0|| pans.length()>ans.length()){
    		            ans = pans;
    		        }
		        }else{
		            map.put(ch,2);
		            flag = true;
		            i++;
		        }
		        f1 = true;
		    }
		    //release
		    while(j<i && flag == true){
		        
		        char ch = str.charAt(j);
		        if(map.get(ch) == 1){
		            map.remove(ch);
		            j++;
		        }else{
		            map.put(ch,1);
		            j++;
		            flag = false;
		            
		        }
		        f2 = true;
		    }
		    if(f1 == false && f2 == false){
		        break;
		    }
		}
		return ans.length();
    }
}
