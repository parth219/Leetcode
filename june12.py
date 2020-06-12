'''
problem link: https://leetcode.com/explore/challenge/card/june-leetcoding-challenge/540/week-2-june-8th-june-14th/3358/
'''
class RandomizedSet:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.d={}
        self.l=[]

    def insert(self, val: int) -> bool:
        """
        Inserts a value to the set. Returns true if the set did not already contain the specified element.
        """
        if val not in self.d:
            self.d[val]=len(self.l)
            self.l.append(val)
            return True
        else:
            return False
        

    def remove(self, val: int) -> bool:
        """
        Removes a value from the set. Returns true if the set contained the specified element.
        """
        if val not in self.d:
            return False
        
        last_element=self.l[-1]
        index=self.d[val]
        
        self.d[last_element]=index
        self.l[index]=last_element
        self.l[-1]=val
        self.l.pop()
        self.d.pop(val)
        return True
        

    def getRandom(self) -> int:
        """
        Get a random element from the set.
        """
        return self.l[random.randint(0,len(self.l)-1)]


# Your RandomizedSet object will be instantiated and called as such:
# obj = RandomizedSet()
# param_1 = obj.insert(val)
# param_2 = obj.remove(val)
# param_3 = obj.getRandom()