class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            graph.add(new ArrayList<>());
        }
        for(int i=0;i<prerequisites.length;i++){
            int u = prerequisites[i][0];
            int v = prerequisites[i][1];
            graph.get(u).add(v);
        }
        int[] dg = new int[graph.size()];//indegree array
        for(int v=0;v<graph.size();v++){
            for(int nbr : graph.get(v)){
                dg[nbr]++;
            }
        }
        int count = 0;
        Queue<Integer> qu = new LinkedList<>();
        for(int i=0;i<dg.length;i++){
            if(dg[i] == 0){
                qu.add(i);
            }
        }
        if(qu.size() == 0) return false; //cyclic
        while(qu.size() > 0){
            int val = qu.remove();
            count++;
            for(int nbr : graph.get(val)){
                dg[nbr]--;
                if(dg[nbr] == 0){
                    qu.add(nbr);
                }
            }
        }
        if(count == graph.size()) return true;
        return false;
    }
}
