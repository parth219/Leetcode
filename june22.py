'''
problem link: https://leetcode.com/explore/challenge/card/june-leetcoding-challenge/542/week-4-june-22nd-june-28th/3368/
'''
class Solution:
    def singleNumber(self, nums: List[int]) -> int:
        d={}
        for i in nums:
            d.setdefault(i,0)
            d[i]+=1
        for k,v in d.items():
            if v==1:
                return k