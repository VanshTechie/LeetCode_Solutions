//https://leetcode.com/problems/search-in-rotated-sorted-array/description/
//33. Search in Rotated Sorted Array

class Solution {
    public int search(int[] nums, int target) {
        int pivot=pivot(nums);
         //if pivot is not found
        if(pivot==-1){
            return BinarySearch(nums,target,0,nums.length-1);
        }

        
        if(nums[pivot]==target){
            return pivot;
        }
        if(target<nums[0]){
             return BinarySearch(nums,target,pivot+1,nums.length-1);
        }
        if(target>nums[0]){
            return BinarySearch(nums,target,0,pivot-1);
        }
        if(target==nums[0]){
            return 0;
        }
        return -1;   
    }

    public int BinarySearch(int[] nums,int target,int start,int end){
        while(start<=end){
            int mid=start+(end-start)/2;

            if(target==nums[mid]){
                return mid;
            }
            else if(target>nums[mid]){
                start=mid+1;
            }
            else{
                end=mid-1;
            }
        }
        return -1;
        }
    public int pivot(int[] nums){
        int start=0;
        int end=nums.length-1;

        while(start<=end){
            int mid=start+(end-start)/2;
            if(mid<end && nums[mid]>nums[mid+1]){
                return mid;
            }
            else if(mid>start && nums[mid]<nums[mid-1]){
                return mid-1;
            }
            if(nums[start]>=nums[mid]){
                end=mid-1;
            }
            else{
                start=mid+1;
            }

        }
        return -1;
    }
}