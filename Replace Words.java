class Solution {
    public class Node{
        Node[] children;
        String s;
        boolean isEnd;
        public Node(){
            this.children = new Node[26];
            this.isEnd = false;
        }
    }
    public void insert(Node ptr,String word){
        for(int i=0;i<word.length();i++){
            char ch = word.charAt(i);
            if(ptr.children[ch-'a'] == null){
                ptr.children[ch-'a'] = new Node();
            }
            ptr = ptr.children[ch-'a'];
        }
        ptr.isEnd = true;
        ptr.s = word;
    }
    public String replaceWords(List<String> dictionary, String sentence) {
        Node root = new Node();
        
        for(int i=0;i<dictionary.size();i++){
            insert(root,dictionary.get(i));
        }
        
        String[] arr = sentence.split(" ");
        
        find(arr,root);
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<arr.length;i++){
            if(i==arr.length-1){
                sb.append(arr[i]);
            }else{
                sb.append(arr[i]+" ");
            }   
        }
        return sb.toString();
    }
    public void find(String[] arr,Node root){
        
        for(int j=0;j<arr.length;j++){
            String word = arr[j];
            Node ptr = root;
            for(int i=0;i<word.length();i++){
                char ch = word.charAt(i);
                if(ptr.children[ch-'a'] == null){
                    break;
                }
                ptr = ptr.children[ch-'a'];
                if(ptr.isEnd == true){
                    arr[j] = ptr.s;
                    break;
                }
            }
        }
    }
}
