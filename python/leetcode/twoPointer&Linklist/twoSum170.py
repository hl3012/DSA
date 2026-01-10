class TwoSum:
    def __init__(self):
        self.__count={}
        
    def add(self, number: int) -> None:
        self.__count[number] = self.__count.get(number, 0) + 1

    def find(self, value: int) -> bool:
        for num in self.__count:
            diff = value - num
            if diff in self.__count:
                if diff != num or self.__count[num] > 1:
                    return True
        return False
    
    
twoSum = TwoSum()
twoSum.add(1)
twoSum.add(3)
twoSum.add(5)
print(twoSum.find(4))
print(twoSum.find(7))