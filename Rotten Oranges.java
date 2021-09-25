class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<Time> qu = new LinkedList<>();
        // add all rotten oranges in queue
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j] == 2){
                    qu.add(new Time(i,j,0));
                }
            }
        }
        int ans = 0;
        while(qu.size()>0){
            //get + remove
            Time t = qu.remove();
            //mark + add neigbhours
            for(int dir =0;dir<rdir.length;dir++){
                int nr = t.x + rdir[dir];
                int nc = t.y + cdir[dir];
                if(nr>=0&&nr<grid.length&&nc>=0&&nc<grid[0].length&&grid[nr][nc] == 1){
                    grid[nr][nc] = 2;
                    qu.add(new Time(nr,nc,t.rt+1));
                }
            }
            ans = Math.max(ans,t.rt);
        }
        //check if any fresh orange
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j] == 1) return -1;
            }
        }
        return ans;
    }
    public static int[] rdir ={-1,0,1,0};
    public static int[] cdir ={0,1,0,-1};
    public static class Time{
        int x; // x coordinate
        int y; // y coordiante
        int rt; // rot time
        public Time(int x,int y,int rt){
            this.x = x;
            this.y = y;
            this.rt = rt;
        }
    }
}
