class Solution {
    public int[] findRedundantDirectedConnection(int[][] edges) {
        int[] dual= new int[edges.length+1];
        Arrays.fill(dual,-1);
        int bl1 = -1;
        int bl2 = -1;
        
        for(int i=0;i<edges.length;i++){
            int u = edges[i][0];
            int v = edges[i][1];
            
            if(dual[v] == -1){
                dual[v] = i;
            }else{
                bl1 = i;
                bl2 = dual[v];
                break;
            }
        }
        
        int[] parent = new int[edges.length+1];
        for(int i=0;i<parent.length;i++){
            parent[i] = i;
        }
        int[] rank = new int[edges.length+1];
        for(int i=0;i<edges.length;i++){
            if(i == bl1){
                continue;
            }
            int u = edges[i][0];
            int v = edges[i][1];
            boolean flag = union(u,v,parent,rank);
            if(flag == true){
                //cyclic
                //2 possible casses: only cyclic or cyclic and dual parent
                if(bl1 == -1){
                    //only cyclic
                    return edges[i];
                }else{
                    //cyclic and dual parent
                    return edges[bl2];
                }
            }
        }
        return edges[bl1];
    }
    public static boolean union(int u,int v,int[] parent,int[] rank){
        int p1 = find(u,parent);
        int p2 = find(v,parent);
        if(p1!=p2){
            if(rank[p1] > rank[p2]){
                parent[p2] = p1;
            }else if(rank[p1] < rank[p2]){
                parent[p1] = p2;
            }else{
                parent[p1] = p2;
                rank[p1]++;
            }
            return false;
        }else{
            //cycle present
            return true;
        }
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
