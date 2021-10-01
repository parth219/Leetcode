class Solution {
    public long maxMatrixSum(int[][] matrix) {
        int count = 0;
        long sum = 0;
        int min = Integer.MAX_VALUE;
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix.length;j++){
                if(matrix[i][j] < 0){
                    count++;
                }
                int val = Math.abs(matrix[i][j]);
                sum += val;
                min = Math.min(min,val);
            }
        }
        if(count %2 == 0){
            return sum;
        }else{
            return sum - min*2;
        }
    }
}
