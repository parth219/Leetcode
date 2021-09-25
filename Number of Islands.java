class Solution {
    public int numIslands(char[][] grid) {
        int count = 0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j] == '1'){
                    sol(grid,i,j);
                    count++;
                }
            }
        }
        return count;
    }
    public static int[] rdir = {-1,0,1,0};
    public static int[] cdir = {0,1,0,-1};
    public static void sol(char[][] grid,int r,int c){
        grid[r][c] = '0';
        for(int dir = 0;dir<rdir.length;dir++){
            int nr = r+rdir[dir];
            int nc = c + cdir[dir];
            if(nr >=0 && nr < grid.length && nc>=0&&nc<grid[0].length && grid[nr][nc] == '1'){
                sol(grid,nr,nc);
            }
        }
    }
}
