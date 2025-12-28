class Solution:
    # def searchMin(self, trucks, items):
        # def binarySearch(sorted_trucks_trucks, item):
        #     left=0
        #     right=len(sorted_trucks_trucks)-1
        #     while(left<=right):
        #         mid=left+(right-left)//2
        #         weight,_ = sorted_trucks_trucks[mid]
        #         if weight<=item:
        #             left=mid+1
        #         else:
        #             right=mid-1
        #     return left
                    
        # #[4,5,7,2]
        # #[1,2,5]
        # #[3,0,2]
        # res=[]
        # truckssorted_trucks=[(weight, index) for index, weight in enumerate(trucks)]
        # truckssorted_trucks.sort(key=lambda x: x[0])
        
        # for item in items:
        #     pos=binarySearch(truckssorted_trucks, item)
            
        #     if pos!=-1 and pos<len(truckssorted_trucks):
        #         _,original_index=truckssorted_trucks[pos]
        #         res.append(original_index)
        #     else:
        #         res.append(-1)
        
        # return res
        
        
        def searchMin(self, trucks, items):
            def binarySearch(sorted_trucks, item):
                left=0
                right=len(sorted_trucks)-1
                if sorted_trucks[right]<=item:
                    return -1
                while(left<=right):
                    mid=left+(right-left)//2
                    if sorted_trucks[mid]<=item:
                        left=mid+1
                    else:
                        right= mid-1 
                return left 
            
            res=[]
            index_map={}
            
            for i in range(len(trucks)):
                index_map[trucks[i]]=i

            # sorted_trucks_trucks=sorted(trucks)
            trucks.sort()
            
            for item in items:
                pos=binarySearch(trucks, item)
                if pos!=-1:
                    weight=trucks[pos]
                    res.append(index_map[weight])
                else:             
                    res.append(-1)   
            return res
    
    
trucks=[4,5,7,2]
items=[1,2,5]
s=Solution()
print(s.searchMin(trucks, items))

