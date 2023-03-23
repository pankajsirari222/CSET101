// 162. Find Peak Element
class Find_Peak_Element {
    public int findPeakElement(int[] nums) {
        int n = nums.length;
        int low = 0;
        int high = n - 1;
        
        while(low <= high) {
            int mid = low + (high - low)/2;
            
            if((mid == 0 || nums[mid] > nums[mid-1]) && (mid == n-1 || nums[mid] > nums[mid+1])) {
                return mid;
            }
            else if(nums[mid+1] > nums[mid]) {
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }
        return -1;
    }
}

// Like a mountain peak, draw a graph.
// We will move in the direction of greater element and for every element we will check if it is peak or not.
// For multiple peaks or largest peak element, binary search will not work.
// for n==1 or n==2, we added two more conditions, we can write code for them separately also.