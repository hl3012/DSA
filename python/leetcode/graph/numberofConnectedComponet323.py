class Solution:
    def countComponents(self, n: int, edges: List[List[int]]) -> int:
        graph=defaultdict(list)

        for start, end in edges:
            graph[start].append(end)
            graph[end].append(start)
        
        count = 0
        visited=set()

        def bfs(i):
            queue=deque()
            queue.append(i)
            visited.add(i)

            while queue:
                j=queue.popleft()
                for nei in graph[j]:
                    if nei not in visited:
                        queue.append(nei)
                        visited.add(nei)
            

        for i in range(n):
            if i not in visited:
                bfs(i)
                count+=1
        
        return count
