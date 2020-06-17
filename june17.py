'''
problem link: https://leetcode.com/explore/challenge/card/june-leetcoding-challenge/541/week-3-june-15th-june-21st/3363/
'''
class Solution:
    def solve(self, board: List[List[str]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        def search(board,i,j):
            if i>=0 and i<len(board) and j>=0 and j<len(board[0]):
                if board[i][j]=='O':
                    board[i][j]='*'
                    search(board,i+1,j)
                    search(board,i-1,j)
                    search(board,i,j+1)
                    search(board,i,j-1)
        for i in range(len(board)):
            if i==0 or i==len(board)-1:
                for j in range(len(board[i])):
                    if board[i][j]=='O':
                        search(board,i,j)
            if board[i][0]=='O':
                search(board,i,0)
            if board[i][-1]=='O':
                search(board,i,len(board[i])-1)
        
        for i in range(len(board)):
            for j in range(len(board[i])):
                if board[i][j]=='O':
                    board[i][j]='X'
        for i in range(len(board)):
            for j in range(len(board[i])):
                if board[i][j]=='*':
                    board[i][j]='O'
                    
                        
        