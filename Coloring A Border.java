class Solution {
    public int[][] colorBorder(int[][] grid, int row, int col, int color) {
        boolean[][] vis = new boolean[grid.length][grid[0].length];
        dfs(grid,row,col,vis);
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(vis[i][j] == true){
                    // border of grid
                    if(i == 0 || j == 0|| i==grid.length-1 || j == grid[0].length-1){
                        grid[i][j] = color;
                    }
                    else if(!(vis[i+1][j] && vis[i][j+1] && vis[i-1][j] && vis[i][j-1])){
                        grid[i][j] = color;
                    }
                }
            }
        }
        return grid;
    }
    public static int[] rdir = {-1,0,1,0};
    public static int[] cdir = {0,-1,0,1};
    public static void dfs(int[][] grid,int r,int c,boolean[][] vis){
        vis[r][c] = true;
        int cc = grid[r][c];
        for(int d=0;d<4;d++){
            int nr = r + rdir[d];
            int nc = c + cdir[d];
            if(nr>=0 && nc >=0 && nr<grid.length && nc<grid[0].length && grid[nr][nc] == cc && vis[nr][nc] == false){
                dfs(grid,nr,nc,vis);
            }
        }
    }
}
