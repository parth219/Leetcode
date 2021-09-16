class Solution {
    public List<Integer> getRow(int rowIndex) {
       long val = 1;
        List<Integer> lst = new ArrayList<>();
        for(int i=0;i<=rowIndex;i++){
            lst.add((int)val);
            val = (val * (rowIndex-i)) / (i+1);
        }
        // lst.add(1);
        return lst;
    }
}
