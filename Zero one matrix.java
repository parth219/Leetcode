class Solution {
    public class pair{
        int x;
        int y;
        public pair(int x,int y){
            this.x = x;
            this.y = y;
        }
    }
    
    public int[] rdir = {-1,0,1,0};
    public int[] cdir = {0,1,0,-1};
    
    public int[][] updateMatrix(int[][] mat) {
        //add all zeroes in queue and mark it
        int[][] vis = new int[mat.length][mat[0].length];
        Queue<pair> qu = new LinkedList<>();
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[0].length;j++){
                if(mat[i][j] == 0){
                    vis[i][j] = -1;
                    qu.add(new pair(i,j));
                }
            }
        }
        //bfs
        int level = -1;
        while(qu.size()>0){
            int size = qu.size();
            level++;
            for(int i=0;i<size;i++){
                //remove
                pair rem = qu.remove();
                //add neigbhours and mark
                for(int d=0;d<4;d++){
                    int nr = rem.x + rdir[d];
                    int nc = rem.y + cdir[d];
                    if(nr>=0&&nr<mat.length&&nc>=0&&nc<mat[0].length&&vis[nr][nc] !=-1){
                        vis[nr][nc] = -1;
                        qu.add(new pair(nr,nc));
                    }
                }
                //mark level when found
                mat[rem.x][rem.y] = level;
            }
        }
        return mat;
    }
}
