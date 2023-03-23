// 81. Search in Rotated Sorted Array II
// If element in low, mid and high are same, do low++ bcz it will fail in cases like [1,1,1,2,1,1].

class Search_in_rotated_sorted_array2 {
    public boolean search(int[] nums, int target) {
        int n = nums.length;
        int low = 0;
        int high = n-1;
        
        if(n == 1) {
            if(nums[0] == target)   return true;
            return false;
        }
        
        while(low <= high) {
            int mid = low + (high - low)/2;
            
            if(target == nums[mid]) return true;
            
            if(nums[low] == nums[mid] && nums[mid] == nums[high]) {
                low++;
            }  
            else if(nums[low] <= nums[mid]) {
                if(target >= nums[low] && target < nums[mid]) {
                    high = mid - 1;
                }
                else {
                    low = mid + 1;
                }
            }
            else {
                if(target > nums[mid] && target <= nums[high]) {
                    low = mid + 1;
                }
                else {
                    high = mid -1;
                }
            }
        }
        return false;
    }
}
