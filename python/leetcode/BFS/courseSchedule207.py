class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        indegree=[0]*numCourses #依赖数量

        graph = [[] for _ in range(numCourses)]

        for prepe in prerequisites:
            course=prepe[0]
            preq=prepe[1]

            graph[preq].append(course)
            indegree[course]+=1
        
        queue=deque()
        for course in range(numCourses):
            if indegree[course]==0:
                queue.append(course)

        count=0 #完成的课程数

        while queue:
            comp = queue.popleft()

            count+=1

            for next in graph[comp]:
                indegree[next]-=1
                if indegree[next]==0:
                    queue.append(next)
        
        return count==numCourses