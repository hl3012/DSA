class Solution:
    def wallsAndGates(self, rooms: List[List[int]]) -> None:
        """
        Do not return anything, modify rooms in-place instead.
        """
        m=len(rooms)
        n=len(rooms[0])

        queue=deque()
        INF=2**31-1

        def bfs():
            while queue:
                
                x,y=queue.popleft()

                for dx, dy in [(0,1),(0,-1),(1,0),(-1,0)]:
                    newX=x+dx
                    newY=y+dy
                    if 0<=newX<m and 0<=newY<n and rooms[newX][newY]==INF:
                        queue.append((newX, newY))
                        rooms[newX][newY]=rooms[x][y]+1
               

        for i in range(m):
            for j in range(n):
                if rooms[i][j]==0:
                    queue.append((i,j))
        bfs()        
