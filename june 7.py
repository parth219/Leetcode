'''
problem link: https://leetcode.com/explore/challenge/card/june-leetcoding-challenge/539/week-1-june-1st-june-7th/3353/
'''
class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        def solve(amount,coins,n,dp):
            if amount==0:
                return 1
            if amount<0 or n<0:
                return 0
            if dp[n][amount]!=-1:
                return dp[n][amount]
            a=solve(amount-coins[n],coins,n,dp)
            b=solve(amount,coins,n-1,dp)
            dp[n][amount]= a+b
            return dp[n][amount]
        
        dp=[[-1 for i in range(amount+1)] for j in range(len(coins)+1)]
        return solve(amount,coins,len(coins)-1,dp)