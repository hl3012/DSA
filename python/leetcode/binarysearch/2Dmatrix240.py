class Solution:
    def searchMatrix(self, matrix, target):
        if(not matrix or not matrix[0]):
            return False
    
        row = len(matrix)
        col=len(matrix[0])
        
        i=0
        j=col-1
        while j>=0 or i<row:
            if(matrix[i][j]>target):
                j-=1
            elif(matrix[i][j]<target):
                i+=1
            else:
                return True
        return False
    
matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]]
target = 5
s=Solution()
print(s.searchMatrix(matrix, target))
    