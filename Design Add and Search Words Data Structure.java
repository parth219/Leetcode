class WordDictionary {

    public class Node{
        Node[] children;
        boolean isEnd;
        public Node(){
            this.children = new Node[26];
            this.isEnd = false;
        }
    }
    Node root = null;
    public WordDictionary() {
        root = new Node();
    }
    
    public void addWord(String word) {
        Node ptr = root;
        for(int i=0;i<word.length();i++){
            char ch = word.charAt(i);
            if(ptr.children[ch-'a'] == null){
                Node nn = new Node();
                ptr.children[ch-'a'] = nn;
            }
            ptr = ptr.children[ch-'a'];
        }
        ptr.isEnd = true;
    }
    
    public boolean search(String word) {
        return find(root,word,0);
    }
    public boolean find(Node root,String word,int idx){
        if(idx == word.length()){
            return root.isEnd;
        }
        char ch = word.charAt(idx);
        if(ch == '.'){
            for(Node val : root.children){
                if(val != null){
                    boolean res = find(val,word,idx+1);
                    if(res == true){
                        return true;
                    }
                }
            }
        }else{
            if(root.children[ch-'a'] == null){
                return false;
            }
            root = root.children[ch-'a'];
            return find(root,word,idx+1);
        }
        return false;
    }
}
