'''
problem link: https://leetcode.com/explore/featured/card/june-leetcoding-challenge/540/week-2-june-8th-june-14th/3354/
'''
class Solution:
    def isPowerOfTwo(self, n: int) -> bool:
        while n>1:
            n=n/2
        if n==1:
            return True
        else: return False