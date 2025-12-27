class Solution:
    def searchMatrix(self, matrix, target):
        m = len(matrix)
        n = len(matrix[0])
        start = 0
        end = m*n-1
        while (start<=end):
            mid = start + (end- start)//2
            row = mid//n
            col= mid%n
            if(matrix[row][col]>target):
                end= mid-1
            elif(matrix[row][col]<target):
                start=mid+1
            else:
                return True
        return False
    
    
matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]]
target = 9
s=Solution()
print(s.searchMatrix(matrix, target))