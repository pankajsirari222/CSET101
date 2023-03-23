class Search_a_2D_Matrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        int col = matrix[0].length;
        
        int low = 0;
        int high = row*col -1;
        
        while(low <= high) {
            int mid = low + (high - low)/2;
            if(matrix[mid/col][mid%col] == target) {
                return true;
            }
            else if(matrix[mid/col][mid%col] > target) {
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }
        return false;
    }
}
// We can do this ques by linear search and by hashing also but the optimized approach is binary search.
// 1 3 5 7 10 11 16 20 23 34 60
// The elements in the matrix are in the group of the column no. i.e. 4 here so if we will do,
// mid/col, we get row no. and if we do mid%col, we get column no..
// Then normal Binary Search.