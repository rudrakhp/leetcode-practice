//A robot is located at the top-left corner of a m x n grid (marked 'Start' in t
//he diagram below). 
//
// The robot can only move either down or right at any point in time. The robot 
//is trying to reach the bottom-right corner of the grid (marked 'Finish' in the d
//iagram below). 
//
// Now consider if some obstacles are added to the grids. How many unique paths 
//would there be? 
//
// An obstacle and space is marked as 1 and 0 respectively in the grid. 
//
// 
// Example 1: 
//
// 
//Input: obstacleGrid = [[0,0,0],[0,1,0],[0,0,0]]
//Output: 2
//Explanation: There is one obstacle in the middle of the 3x3 grid above.
//There are two ways to reach the bottom-right corner:
//1. Right -> Right -> Down -> Down
//2. Down -> Down -> Right -> Right
// 
//
// Example 2: 
//
// 
//Input: obstacleGrid = [[0,1],[0,0]]
//Output: 1
// 
//
// 
// Constraints: 
//
// 
// m == obstacleGrid.length 
// n == obstacleGrid[i].length 
// 1 <= m, n <= 100 
// obstacleGrid[i][j] is 0 or 1. 
// 
// Related Topics Array Dynamic Programming 
// 👍 2192 👎 264


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    private static int LIMIT = 101;

    private int[][] store = new int[LIMIT][LIMIT];

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        return uniquePaths(obstacleGrid, obstacleGrid.length - 1, obstacleGrid[0].length - 1);
    }

    /**
     * Algorithm: Lookup DP
     * Space: O(MN)
     * Time: O(MN)
     * @param obstacleGrid
     * @param m
     * @param n
     * @return
     */
    private int uniquePaths(int[][] obstacleGrid, int m, int n) {
        if (m < 0 || n < 0 || obstacleGrid[m][n] == 1) {
            return 0;
        }
        if (m == 0 && n == 0) {
            return 1;
        }
        if (store[m][n] > 0) {
            return store[m][n];
        }
        return store[m][n] = uniquePaths(obstacleGrid, m, n-1) + uniquePaths(obstacleGrid, m-1, n);

    }

}
//leetcode submit region end(Prohibit modification and deletion)
