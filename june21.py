'''
problem link: https://leetcode.com/explore/challenge/card/june-leetcoding-challenge/541/week-3-june-15th-june-21st/3367/
'''
class Solution:
    def calculateMinimumHP(self, dungeon: List[List[int]]) -> int:
        x=len(dungeon)
        y=len(dungeon[0])
        dp=[[inf for i in range(y+1)] for k in range(x+1)]
        dp[x-1][y],dp[x][y-1]=1,1
        for i in range(x-1,-1,-1):
            for j in range(y-1,-1,-1):
                dp[i][j]=max(min(dp[i+1][j],dp[i][j+1])-dungeon[i][j],1)
        return dp[0][0]