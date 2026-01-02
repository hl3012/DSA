class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, color: int) -> List[List[int]]:
        m= len(image)
        n=len(image[0])

        original=image[sr][sc]

        if original==color:
            return image

        def dfs(i, j):
            if i<0 or i>=m or j<0 or j>=n:
                return
            
            if image[i][j]!=original:
                return

            image[i][j]=color

            for dx, dy in [(0,1), (0,-1), (1,0), (-1,0)]:
                dfs(i+dx, j+dy)

        dfs(sr,sc)
        return image