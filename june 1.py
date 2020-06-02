# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def invertTree(self, root: TreeNode) -> TreeNode:
        if root:
            stack=[root]
        
            while stack:
                node=stack.pop()
                if node:
                    stack.append(node.left)
                    stack.append(node.right)
                    node.left,node.right=node.right,node.left
                
        return root
        