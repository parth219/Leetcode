class Solution {
    public String longestPalindrome(String s) {
        String ans = s.charAt(0)+"";
        int length =1;
        int n = s.length();
        int[][] dp = new int[n][n];
        for(int gap=0;gap<n;gap++){
            for(int i=0,j=gap;j<n;j++,i++){
                if(gap == 0){
                    dp[i][j] = 1;
                }else if(gap == 1){
                    if(s.charAt(i) == s.charAt(j)){
                        if(length<2){
                            length=2;
                            ans = s.substring(i,j+1);
                        }
                        dp[i][j] = 2;
                    }
                }else{
                    if(s.charAt(i) == s.charAt(j)){
                        if(dp[i+1][j-1]>0){
                            dp[i][j] = dp[i+1][j-1]+2;
                            if(length < dp[i][j]){
                                length = dp[i][j];
                                ans = s.substring(i,j+1);
                            }
                        }
                    }
                }
            }
        }
        return ans;
    }
}
