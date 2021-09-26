class Solution {
    public class pair{
        int x;
        int y;
        public pair(int x,int y){
            this.x = x;
            this.y = y;
        }
    }
    public static int[] rdir = {-1,0,1,0};
    public static int[] cdir = {0,1,0,-1};
    public int maxDistance(int[][] grid) {
        Queue<pair> qu = new LinkedList<>();
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j] == 1){
                    qu.add(new pair(i,j));
                    grid[i][j] = -1;
                }
            }
        }
        //bfs
        if(qu.size() == 0 || qu.size() == grid.length * grid[0].length) return -1;
        
        
        int level = -1;
        while(qu.size()>0){
            level++;
            int size = qu.size();
            for(int i=0;i<size;i++){
                pair rem = qu.remove();
                for(int d=0;d<4;d++){
                    int nr = rem.x + rdir[d];
                    int nc = rem.y + cdir[d];
                    if(nr>=0&&nr<grid.length&&nc>=0&&nc<grid[0].length&&grid[nr][nc]!=-1){
                        qu.add(new pair(nr,nc));
                        grid[nr][nc]=-1;
                    }
                }
            }
        }
        return level;
    }
}
