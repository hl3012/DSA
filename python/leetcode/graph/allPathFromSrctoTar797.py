class Solution:
    def allPathsSourceTarget(self, graph: List[List[int]]) -> List[List[int]]:
        res=[]

        def dfs(path):
            if path[-1]==len(graph)-1:
                res.append(path+[])
                return
            
            for each in graph[path[-1]]:
                path.append(each)
                dfs(path)
                path.pop()


        dfs([0])
        return res
