'''
problem link: https://leetcode.com/explore/challenge/card/june-leetcoding-challenge/542/week-4-june-22nd-june-28th/3373/
'''
class Solution:
    def numSquares(self, n: int) -> int:
        def solve(n,dp):
            if n<0:
                return inf
            if n==0:
                return 0
            if dp[n]!=-1:
                return dp[n]
            m=n
            i=1
            while i*i<=n:
                m=min(solve(n-(i*i),dp),m)
                i+=1
            dp[n]=m+1
            return m+1
        dp=[-1 for i in range(n+1)]
        return solve(n,dp)