from typing import List
from collections import deque

class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        m=len(grid)
        n=len(grid[0])
        count = 0
        
        
        def isValid(x, y):
            return x>=0 and y>=0 and x<m and y<n and grid[x][y]=="1"
        
        def bfs(i,j):
            queue=deque()
            queue.append((i, j))
            grid[i][j]="0"
            
            while queue:
                x, y = queue.popleft()
                
                for dx, dy in [(0, 1), (0, -1), (1, 0),(-1, 0)]:
                    newX = x + dx
                    newY = y + dy
                    if isValid(newX, newY):
                        queue.append((newX, newY))
                        grid[newX][newY]="0"        
                        
        # def bfs(i, j):
        #     if isValid(i, j):
        #         grid[i][j]="0"
        #         bfs(i+1, j)
        #         bfs(i-1, j)
        #         bfs(i, j+1)
        #         bfs(i, j-1)
        #     else:
        #         return
        
        for i in range(m):
            for j in range(n):
                if grid[i][j]=="1":
                    bfs(i, j)
                    count+=1
        return count