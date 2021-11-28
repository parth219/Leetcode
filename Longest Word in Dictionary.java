public static class Node{
      Node[] children;
      String s;
      public Node(){
          this.children = new Node[26];
      }
  }
  
  public static void insert(Node root,String word){
      Node ptr = root;
      for(int i=0;i<word.length();i++){
          char ch = word.charAt(i);
          if(ptr.children[ch-'a'] == null){
              ptr.children[ch-'a'] = new Node();
          }
          ptr = ptr.children[ch-'a'];
      }
      ptr.s = word;
  }
  public static void dfs(Node ptr){
      if(ptr.s == null){
          return;
      }
      if(ptr.s.length() > ans.length()){
          ans = ptr.s;
      }
      for(int i=0;i<26;i++){
          if(ptr.children[i]!=null){
              dfs(ptr.children[i]);
          }
      }
  }
  public static String ans = "";
  public static String longestWord(String[] words) {
    Node root = new Node();
    ans = "";
    for(String word:words){
        insert(root,word);
    }
    for(int i=0;i<26;i++){
        if(root.children[i]!=null){
            dfs(root.children[i]);
        }
    }
    return ans;
  }
