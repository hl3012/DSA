class Solution:
    def validTree(self, n: int, edges: List[List[int]]) -> bool:
        if len(edges)!=n-1:
            return False
        
        graph=defaultdict(list)

        for start, end in edges:
            graph[start].append(end)
            graph[end].append(start)

        queue=deque()
        visited={0}
        queue.append(0)

        while queue:          
            node= queue.popleft()
            neighbors=graph[node]
            for neighbor in neighbors:
                if neighbor not in visited:
                    queue.append(neighbor)
                    visited.add(neighbor)
        
        return len(visited)==n
        