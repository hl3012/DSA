class Solution:
    def hasPath(self, maze: List[List[int]], start: List[int], destination: List[int]) -> bool:
        m=len(maze)
        n=len(maze[0])

        queue=deque()
        queue.append((start[0],start[1]))
        visited=[[False for _ in range(n)] for _ in range(m)]

        visited[start[0]][start[1]]=True

        while queue:
            x, y= queue.popleft()

            if [x,y] == destination:
                return True

            for dx, dy in [(0,1),(0,-1),(1,0),(-1,0)]:
                nx,ny=x,y

                while 0<=nx+dx<m and 0<=ny+dy<n and maze[nx+dx][ny+dy]!=1:
                    nx+=dx
                    ny+=dy
                
                if not visited[nx][ny]:
                    
                    queue.append((nx,ny))
                    visited[nx][ny]=True
                
        return False