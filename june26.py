'''
problem link: https://leetcode.com/explore/challenge/card/june-leetcoding-challenge/542/week-4-june-22nd-june-28th/3372/
'''
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def sumNumbers(self, root: TreeNode) -> int:
        
        def solve(root,l):
            if root:
                l+=str(root.val)
                if root.left:
                    solve(root.left,l)
                if root.right:
                    solve(root.right,l)
                if not root.left and not root.right:
                    self.stack.append(l)
        l=''
        self.stack=[]
        solve(root,l)
        s=0
        print(self.stack)
        for i in self.stack:
            s+=int(i)
        return s