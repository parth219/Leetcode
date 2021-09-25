class Solution {
    public int numEnclaves(int[][] grid) {
        // travel on boundary and solve as count island
        for(int c=0;c<grid[0].length;c++){
            //top row
            if(grid[0][c] == 1){
                sol(grid,0,c);
            }
            //bottom col
            if(grid[grid.length-1][c] == 1){
                sol(grid,grid.length-1,c);
            }
        }
        for(int r=0;r<grid.length;r++){
            //first col
            if(grid[r][0] == 1){
                sol(grid,r,0);
            }
            //last col
            if(grid[r][grid[0].length-1] == 1){
                sol(grid,r,grid[0].length-1);
            }
        }
        int count = 0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j] == 1){
                    count++;
                }
            }
        }
        return count;
    }
    public static int[] rdir = {-1,0,1,0};
    public static int[] cdir = {0,1,0,-1};
    
    public static void sol(int[][] grid,int r,int c){
        grid[r][c] = 0;
        for(int dir = 0;dir<rdir.length;dir++){
            int nr = r + rdir[dir];
            int nc = c + cdir[dir];
            
            if(nr>=0 && nr<grid.length&&nc>=0&&nc<grid[0].length&&grid[nr][nc] == 1){
                sol(grid,nr,nc);
            }
        }
       
    }
}
