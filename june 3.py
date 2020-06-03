'''
problem link: https://leetcode.com/explore/challenge/card/june-leetcoding-challenge/539/week-1-june-1st-june-7th/3349/
'''
class Solution:
    def twoCitySchedCost(self, costs: List[List[int]]) -> int:
        n=len(costs)
        a=n//2
        b=n//2
        ans=0
        #sorting on the basis of cost(A)-cost(B)
        costs=sorted(costs,key=lambda x:x[0]-x[1])
        for l in costs:
            if a>0:
                a-=1
                ans+=l[0]
            else:
                ans+=l[1]
        return ans