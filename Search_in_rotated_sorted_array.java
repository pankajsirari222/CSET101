// 33. Search in a Rotated Sorted Array
/*  
    Brute Force - Linear Search O(n)

    Hashing vs Binary Search - Hashing takes O(n) for input and O(n) space for storing the input.
    So, for searching a single number, binary search is better but if there are q queries, then hashing is better as it will take O(1) for all queries but for binary search it will be qlog(n).

    Approach in Binary Search - 
    For any test case, at least one side of the array will be sorted so first check if the left side is sorted or not, if it is then check if target is present there or not. If yes, go left else go right.
    Else if left side is not sorted go to right and check for the target and do the same.
    
 */
class Search_in_rotated_sorted_array {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int low = 0;
        int high = n - 1;

        while(low <= high) {
            int mid = low + (high - low)/2;

            if(nums[mid] == target) return mid;

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
                    high = mid - 1;
                }
            }
        }
        return -1;
    }
}
