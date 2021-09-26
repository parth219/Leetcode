class Solution {
    public static class pair{
        int x;
        int y;
            public pair(int x,int y){
            this.x = x;
            this.y = y;
        }
    }
    public int shortestBridge(int[][] grid) {
        Queue<pair> qu = new LinkedList<>();
        boolean z = true;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j] == 1){
                    dfs(grid,i,j,qu);
                    z=false;
                    break;
                }
            }
            if(z == false) break;
        }
        int level = -1;
        while(qu.size()>0){
            int size = qu.size();
            level++;
            for(int i=0;i<size;i++){
                pair rem = qu.remove();
                for(int d=0;d<4;d++){
                    int nr = rem.x + rdir[d];
                    int nc = rem.y + cdir[d];
                    
                    if(nr>=0 && nr<grid.length && nc>=0 && nc<grid[0].length&&grid[nr][nc]!=-1){
                        if(grid[nr][nc] == 1){
                            return level;
                        }
                        grid[nr][nc] = -1;
                        qu.add(new pair(nr,nc));
                    }
                }
            }
            
        }
        return level;
    }
    public static int[] rdir = {-1,0,1,0};
    public static int[] cdir = {0,1,0,-1};
    public static void dfs(int[][] grid,int r,int c,Queue<pair> qu){
        qu.add(new pair(r,c));
        grid[r][c] = -1;
        for(int d=0;d<4;d++){
            int nr = r+ rdir[d];
            int nc = c + cdir[d];
            if(nr>=0&&nr<grid.length&&nc>=0&&nc<grid[0].length&&grid[nr][nc] == 1){
                dfs(grid,nr,nc,qu);
            }
        }
    }
}
