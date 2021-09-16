class Solution {
    public int maximumSwap(int num) {
        String s = num +"";
        char[] ch = s.toCharArray();
        int[] arr = new int[ch.length];
        
        arr[arr.length-1] = arr.length-1;
        //find index of greatest element on right
        for(int i=arr.length-2;i>=0;i--){
            if(ch[arr[i+1]] >= ch[i]){
                arr[i] = arr[i+1];
            }else{
                arr[i] = i;
            }
        }
       //if element is smaller than its greatest element on right
        //swap it and break loop
        for(int i=0;i<arr.length;i++){
            if(ch[i] < ch[arr[i]]){
                char temp = ch[i];
                ch[i] = ch[arr[i]];
                ch[arr[i]] = temp;
                break;
            }
        }
        //build string from character array
        StringBuilder sb = new StringBuilder();
        for(char val:ch){
            sb.append(val);
        }
        String str = sb.toString();
        //return integer 
        return Integer.parseInt(str);
    }
}
