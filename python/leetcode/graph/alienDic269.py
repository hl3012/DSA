class Solution:
    def alienOrder(self, words: List[str]) -> str:
        graph=defaultdict(list)
        degree={}

        for word in words:
            for ch in word:
                if ch not in graph:
                    degree[ch]=0
        
        for i in range(len(words)-1):
            word_pre=words[i]
            word_after=words[i+1]

            if len(word_pre)>len(word_after) and word_pre.startswith(word_after):
                return ""
            
            m=min(len(word_pre), len(word_after))

            for j in range(m):
                from_letter=word_pre[j]
                to_letter=word_after[j]

                if from_letter!=to_letter:
                    if to_letter not in graph[from_letter]:
                        graph[from_letter].append(to_letter)
                        degree[to_letter]+=1
                    break

        queue=deque()

        for key, val in degree.items():
            if val==0:
                queue.append(key)

        res=[]
        while queue:
            curr=queue.popleft()
            res.append(curr)
            for nei in graph[curr]:
                degree[nei]-=1
                if degree[nei]==0:
                    queue.append(nei)
        
        if len(res)!=len(degree):
            return ""
        
        return "".join(res)