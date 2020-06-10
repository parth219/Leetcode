'''
problem link: https://leetcode.com/submissions/detail/351739531/?from=/explore/challenge/card/june-leetcoding-challenge/540/week-2-june-8th-june-14th/3356/
'''
class Solution:
    def searchInsert(self, nums: List[int], target: int) -> int:
        low=0
        high=len(nums)-1
        while low<=high:
            mid=(low+high)//2
            #check for edge cases
            if mid==0 and nums[mid]>target:
                return mid
            if mid==len(nums)-1 and nums[mid]<target:
                return mid+1
            if nums[mid]==target:
                return mid
            elif nums[mid]>target:
                if nums[mid-1]<target:
                    return mid
                else:
                    high=mid
            else:
                if nums[mid+1]>target:
                    return mid+1
                else:
                    low=mid+1