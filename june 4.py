'''
problem link: https://leetcode.com/explore/challenge/card/june-leetcoding-challenge/539/week-1-june-1st-june-7th/3350/
'''

class Solution:
    def reverseString(self, s):
        """
        Do not return anything, modify s in-place instead.
        """
        i=0
        j=len(s)-1
        while i<=j:
            s[i],s[j]=s[j],s[i]
            i+=1
            j-=1
            
####################################################################
'''Another Approch'''
class Solution:
    def reverseString(self, s):
        """
        Do not return anything, modify s in-place instead.
        """
        s.reverse()