import heapq
from typing import List
from collections import defaultdict


class Solution:
    def networkDelayTime(self, times: List[List[int]], n: int, k: int) -> int:
        graph = defaultdict(list)

        for u,v,w in times:
            graph[u].append((v,w))

        visited={}
        #dist,node
        heap=[(0,k)]

        while heap:
            curr, node=heapq.heappop(heap)
            
            if node in visited:
                continue
            visited[node]=curr

            for nextNode,weight in graph[node]:
                if nextNode not in visited:
                    heapq.heappush(heap, (curr+weight, nextNode))
            
        if len(visited)<n:
            return -1
        
        return max(visited.values())