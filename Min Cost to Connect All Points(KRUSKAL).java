class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        int[][] arr = new int[n*(n-1)/2][3];
        int index = 0;
        for(int i=0;i<points.length-1;i++){
            for(int j=i+1;j<points.length;j++){
                int dist = Math.abs(points[j][0] - points[i][0]) + 
                    Math.abs(points[j][1] - points[i][1]);
                int[] temp = {i,j,dist}; 
                arr[index] = temp;
                
                index++;
            }
        }
        Arrays.sort(arr,(val1,val2) -> Integer.compare(val1[2],val2[2]));
        int[] parent = new int[n];
        for(int i=0;i<parent.length;i++){
            parent[i] = i;
        }
        int[] rank = new int[n];
        int ans = 0;
        for(int i=0;i<arr.length;i++){
            int u = arr[i][0];
            int v = arr[i][1];
            int p1 = find(u,parent);
            int p2 = find(v,parent);
            if(p1!=p2){
                if(rank[p1] > rank[p2]){
                    parent[p2] = p1;
                }else if(rank[p1] < rank[p2]){
                    parent[p1] = p2;
                }else{
                    parent[p1] = p2;
                    rank[p2]++;
                }
                ans += arr[i][2];
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
