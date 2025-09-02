//34. Find First and Last Position of Element in Sorted Array
//https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/

class Solution {
    public int[] searchRange(int[] nums, int target) {

        int[] ans={-1,-1};
        int first=BinarySearch(nums,target,true);
        int last=BinarySearch(nums,target,false);
        ans[0]=first;
        ans[1]=last;
        return ans;

        
        
    }

    public int BinarySearch(int[] nums, int target, Boolean FindFirstOccurence){
        int start =0;
        int end=nums.length-1;
        int ans=-1;
       
        

        while(start<=end){

            int mid=start+(end-start)/2;


            if(target<nums[mid]){
                end=mid-1;
            }
            else if(target>nums[mid]){
                start=mid+1;

            }
            else{
                //potential answer
                ans=mid;
                if(FindFirstOccurence){
                    end=mid-1;
                }
                else{
                    start=mid+1;
                }
                
            }
        }
        return ans;

    }
}