
//852. Peak Index in a Mountain Array
https://leetcode.com/problems/peak-index-in-a-mountain-array/

class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int start=0;
        int end=arr.length-1;

        while(start<end){
            int mid=start+(end-start)/2;
            if(arr[mid]<arr[mid+1]){
                //you are in ascending part of the array
                start=mid+1;
            }
            else{
                end=mid;
            }
        }
        return start;
        
    }
}