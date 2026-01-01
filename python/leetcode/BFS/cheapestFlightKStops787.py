from collections import defaultdict, deque
from typing import List
import math

class Solution:
    def findCheapestPrice(self, n: int, flights: List[List[int]], src: int, dst: int, k: int) -> int:
        graph=defaultdict(list)
        for fro,to,price in flights:
            graph[fro].append((to,price))
        

        # visited={}
        # # 增加stop
        # heap=[(0, src,0)]

        # while heap:
        #     cost, node, stops=heapq.heappop(heap)

        #     if node == dst:
        #         return cost

        #     if stops>k:
        #         continue
            
        #     if (node, stops) in visited and visited[(node, stops)]<=cost:
        #         continue
            
        #     visited[(node,stops)]=cost
            

        #     for nextNode, price in graph[node]:
        #         heapq.heappush(heap,(cost+price, nextNode, stops+1))

        # return -1

        dist=[math.inf]*n
        dist[src]=0

        queue=deque()
        queue.append((src,0))

        stops=0

        while queue and stops<=k:
            size = len(queue)
            for _ in range(size):
                city,cost=queue.popleft()

                for nxxt, price in graph[city]:
                    new_cost=price+cost
                    if new_cost<dist[nxxt]:
                        dist[nxxt]=new_cost
                        queue.append((nxxt, new_cost))
            stops+=1
        
        return -1 if dist[dst]==math.inf else dist[dst]
                    

        