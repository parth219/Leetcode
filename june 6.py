'''
problem link: https://leetcode.com/explore/challenge/card/june-leetcoding-challenge/539/week-1-june-1st-june-7th/3352/
code source and video explanation: https://www.youtube.com/watch?v=HKHkzKvb0J4
'''
class Solution:
    def reconstructQueue(self, people: List[List[int]]) -> List[List[int]]:
        if people==[]:
            return []
        people.sort(key=lambda x:(-x[0],x[1]))
        l=[]
        for i in people:
            l.insert(i[1],i)
        return l