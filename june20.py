'''
problem link: https://leetcode.com/explore/challenge/card/june-leetcoding-challenge/541/week-3-june-15th-june-21st/3366/
'''
from itertools import permutations
class Solution:
    def getPermutation(self, n: int, k: int) -> str:
        l=[]
        for i in range(1,n+1):
            l.append(i)
        perm=permutations(l)
        j=[]
        for i in perm:
            j.append(i)
        return "".join(map(str, j[k-1]))