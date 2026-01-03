class Solution:
    def findCircleNum(self, isConnected: List[List[int]]) -> int:
        count=0
        visited=set()

        def bfs(i):
            queue=deque()
            queue.append(i)
            visited.add(i)
            while queue:
                curr=queue.popleft()
                for ne in range(len(isConnected)):
                    if isConnected[curr][ne] and ne not in visited:
                        visited.add(ne)
                        queue.append(ne)



        for i in range(len(isConnected)):
            if i in visited:
                continue
            count+=1
            bfs(i)
        return count