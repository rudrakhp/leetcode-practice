//A robot is located at the top-left corner of a m x n grid (marked 'Start' in t
//he diagram below). 
//
// The robot can only move either down or right at any point in time. The robot 
//is trying to reach the bottom-right corner of the grid (marked 'Finish' in the d
//iagram below). 
//
// How many possible unique paths are there? 
//
// 
// Example 1: 
//
// 
//Input: m = 3, n = 7
//Output: 28
// 
//
// Example 2: 
//
// 
//Input: m = 3, n = 2
//Output: 3
//Explanation:
//From the top-left corner, there are a total of 3 ways to reach the bottom-righ
//t corner:
//1. Right -> Down -> Down
//2. Down -> Down -> Right
//3. Down -> Right -> Down
// 
//
// Example 3: 
//
// 
//Input: m = 7, n = 3
//Output: 28
// 
//
// Example 4: 
//
// 
//Input: m = 3, n = 3
//Output: 6
// 
//
// 
// Constraints: 
//
// 
// 1 <= m, n <= 100 
// It's guaranteed that the answer will be less than or equal to 2 * 109. 
// 
// Related Topics Array Dynamic Programming 
// 👍 4092 👎 226


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    private static int LIMIT = 101;

    private int[][] store = new int[LIMIT][LIMIT];

    /**
     * Algorithm: Lookup DP
     * Space: O(MN)
     * Time: O(MN)
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths(int m, int n) {
        if (m == 1 || n == 1) {
            return 1;
        }
        if (store[m][n] > 0) {
            return store[m][n];
        }
        return store[m][n] = uniquePaths(m-1, n) + uniquePaths(m, n-1);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
