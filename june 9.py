'''
problem link: https://leetcode.com/explore/challenge/card/june-leetcoding-challenge/540/week-2-june-8th-june-14th/3355/
'''
class Solution:
    def isSubsequence(self, s: str, t: str) -> bool:
        if len(s)==0:
            return True
        j=0
        for i in range(len(t)):
            if t[i]==s[j]:
                j+=1
                if j==len(s):
                    return True
                
        if j==len(s):
            return True
        else: return False