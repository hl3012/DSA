class Solution:
    def exist(self, board: List[List[str]], word: str) -> bool:
        m = len(board)
        n=len(board[0])
        visited=[[False for _ in range(n)] for _ in range(m)]
        queue=deque()

        def dfs(index, i, j):
            if len(word)==index: 
                return True
            
            if i < 0 or i >= m or j < 0 or j >= n:
                return False

            if visited[i][j]==True:
                return False
            
            if board[i][j]!=word[index]:
                return False

            visited[i][j]=True

            for dx, dy in [(0,1),(0,-1),(1,0),(-1,0)]:
                newX=i+dx
                newY=j+dy       
                if dfs(index+1, newX, newY):
                    return True
            visited[i][j]=False
            return False


        for i in range(m):
            for j in range(n):
                if dfs(0, i, j):
                    return True

        return False  