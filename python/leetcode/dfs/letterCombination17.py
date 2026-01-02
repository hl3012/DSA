class Solution:
    def letterCombinations(self, digits: str) -> List[str]:
        phoneList=[
            "",
            "",
            "abc",
            "def",
            "ghi",
            "jkl",
            "mno",
            "pqrs",
            "tuv",
            "wxyz"
        ]
        
        
        res=[]

        def dfs(startIndex, path):
            if len(path)==len(digits):
                res.append("".join(path))
                return
            
            letters=phoneList[int(digits[startIndex])]
            for ch in letters:
                path.append(ch)
                dfs(startIndex+1, path)
                path.pop()
            

        dfs(0, [])
        return res