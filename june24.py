'''
problem link: https://leetcode.com/explore/challenge/card/june-leetcoding-challenge/542/week-4-june-22nd-june-28th/3370/
'''
class Solution:
    def numTrees(self, n: int) -> int:
        dp=[0 for i in range(n+1)]
        dp[0]=1
        dp[1]=1
        for i in range(2,n+1):
            for j in range(i):
                dp[i]+=dp[j]*dp[i-j-1]
        return dp[n]