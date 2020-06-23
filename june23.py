'''
problem link: https://leetcode.com/explore/challenge/card/june-leetcoding-challenge/542/week-4-june-22nd-june-28th/3369/
'''
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def countNodes(self, root: TreeNode) -> int:
        def solve(root,count):
            if root:
                count[0]+=1
                solve(root.left,count)
                solve(root.right,count)
        count=[0]
        solve(root,count)
        return count[0]
        