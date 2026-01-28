import matplotlib.pyplot as plt
plt.
print("matplotlib works")

def two_sum(nums, target):
    hashmap ={}
    for i, num in enumerate(nums):
        diff = target - num
        if (diff in hashmap):
            return [diff, nums[i]]
        hashmap[num] = i
    
    return []

nums=[1,2,3,4,5]
target = 6
print(two_sum(nums, target))
        
arr=[1,2,3,4,5]
arr.append(7)
print(two_sum(arr, 8))

arr.insert(0,1)
arr1=list(range(10))
arr2=list("abc")
arr.remove(5)
del arr[1:4]
del arr[2]
print(arr)
print(f"result is {two_sum(arr, 8)}")

person={"name":"alice", "age":20}
print(person["name"])

person.pop("name")
# print(person["name"])
print(person.get("name"))
print(person)

print("name" in person)