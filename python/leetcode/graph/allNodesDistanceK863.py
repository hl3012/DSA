# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def distanceK(self, root: TreeNode, target: TreeNode, k: int) -> List[int]:
        graph=defaultdict(list)

        def dfs(node, parent):
            if parent:
                graph[node].append(parent)
                graph[parent].append(node)
            if node.left:
                graph[node].append(node.left)
                dfs(node.left, node)
            if node.right:
                graph[node].append(node.right)
                dfs(node.right, node)
            
        dfs(root, None)

        queue=deque()
        queue.append(target)
        visited=set()
        visited.add(target)

        while queue and k>0:
            size=len(queue)
            res=[]
            for _ in range(size):
                curr=queue.popleft()
                res.append(curr.val)
                for nei in graph[curr]:
                    if nei not in visited:
                        queue.append(nei)
                        visited.add(nei)

            k-=1

        return [node.val for node in queue]