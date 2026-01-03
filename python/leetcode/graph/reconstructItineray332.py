class Solution:
    def findItinerary(self, tickets: List[List[str]]) -> List[str]:
        res=[]
       
        if not tickets:
            return res
        
        graph=defaultdict(list)

        for src, dest in tickets:
            heapq.heappush(graph[src],dest)

        def dfs(node):   
            while graph[node]:
                next_=heapq.heappop(graph[node])
                dfs(next_)
            res.append(node)

        dfs("JFK")
        return res[::-1]