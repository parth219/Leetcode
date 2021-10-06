class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int[] parent = new int[edges.length+1];
        int[] rank = new int[edges.length+1];
        for(int i=0;i<parent.length;i++){
            parent[i] = i;
        }
        int[] ans = edges[0];
        for(int i=0;i<edges.length;i++){
            int val1 = edges[i][0];
            int val2 = edges[i][1];
            
            int p1 = find(val1,parent);
            int p2 = find(val2,parent);
        
            if(p1 == p2){
                ans = edges[i];
                continue;
            }
            if(rank[p1] > rank[p2]){
                parent[p2] = p1;
            }else if(rank[p1] < rank[p2]){
                parent[p1] = p2;
            }else{
                parent[p1] = p2;
                rank[p1]++;
            }
        }
        return ans;
    }
    public static int find(int x,int[] parent){
        if(parent[x] == x){
            return x;
        }
        int temp = find(parent[x],parent);
        parent[x] = temp;
        return temp;
    }
}
