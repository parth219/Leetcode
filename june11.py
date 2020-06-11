'''
problem link: https://leetcode.com/explore/challenge/card/june-leetcoding-challenge/540/week-2-june-8th-june-14th/3357/
'''
class Solution:
    def sortColors(self, nums: List[int]) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        i=0
        j=len(nums)-1
        k=0
        while k<=j and i<j:
            if nums[k]==0 and k!=i:
                nums[k],nums[i]=nums[i],nums[k]
                i+=1
                continue
            if nums[k]==2:
                nums[k],nums[j]=nums[j],nums[k]
                j-=1
                continue
            k+=1
        

 