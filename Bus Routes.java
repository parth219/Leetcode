class Solution {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        //create hashmap
        int max = Integer.MIN_VALUE; // to find max value to create visited array size
        HashMap<Integer,ArrayList<Integer>> map = new HashMap<>();
        for(int i=0;i<routes.length;i++){
            for(int j=0;j<routes[i].length;j++){
                int busstop = routes[i][j];
                max = Math.max(max,busstop);
                if(map.containsKey(busstop)){
                    ArrayList<Integer> al = map.get(busstop);
                    al.add(i);
                    map.put(busstop,al);
                }else{
                    ArrayList<Integer> al = new ArrayList<>();
                    al.add(i);
                    map.put(busstop,al);
                }
            }
        }
        //apply bfs
        Queue<Integer> qu = new LinkedList<>();
        qu.add(source);
        boolean[] vis = new boolean[max+1]; //mark for visited stops
        int level = -1; //need to intiate with -1 if source is target return value needs to be 0 and not 1.
        boolean[] vis_bus = new boolean[routes.length]; //needed to avoid tle
        while(qu.size()>0){
            level++;
            int size = qu.size();
            for(int i=0;i<size;i++){
                int stop = qu.remove();
                if(vis[stop] == true) continue;
                vis[stop] = true;
                if(stop == target){
                    return level;
                }
                for(int bus : map.get(stop)){
                    if(vis_bus[bus] == true) continue;
                    for(int val : routes[bus]){
                        
                        if(vis[val] == false){
                            qu.add(val);
                        }
                    }
                    vis_bus[bus] = true;
                }
            }
        }
        return -1;
    }
}
