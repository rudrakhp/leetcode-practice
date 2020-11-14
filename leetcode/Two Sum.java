//Given an array of integers nums and an integer target, return indices of the t
//wo numbers such that they add up to target. 
//
// You may assume that each input would have exactly one solution, and you may n
//ot use the same element twice. 
//
// You can return the answer in any order. 
//
// 
// Example 1: 
//
// 
//Input: nums = [2,7,11,15], target = 9
//Output: [0,1]
//Output: Because nums[0] + nums[1] == 9, we return [0, 1].
// 
//
// Example 2: 
//
// 
//Input: nums = [3,2,4], target = 6
//Output: [1,2]
// 
//
// Example 3: 
//
// 
//Input: nums = [3,3], target = 6
//Output: [0,1]
// 
//
// 
// Constraints: 
//
// 
// 2 <= nums.length <= 105 
// -109 <= nums[i] <= 109 
// -109 <= target <= 109 
// Only one valid answer exists. 
// 
// Related Topics Array Hash Table 
// 👍 17747 👎 635


import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

//leetcode submit region begin(Prohibit modification and deletion)

/**
 * @Author: Rudrakh
 */
class Solution {
    /**
     * Algorithm: Two pointer
     * Space: Extra O(N)
     * Time: O(N)
     * @param nums
     * @param target
     * @return array of two indexes in nums with sum of target
     */
    public int[] twoSum(int[] nums, int target) {
        IndexMap[] indexMaps = new IndexMap[nums.length];
        for(int i=0; i<nums.length; ++i) {
            indexMaps[i] = new IndexMap();
            indexMaps[i].index = i;
            indexMaps[i].value = nums[i];
        }
        Arrays.sort(indexMaps, Comparator.comparing(indexMap -> indexMap.value));
        int ptr1 = 0, ptr2 = indexMaps.length - 1;
        int[] ans = new int[2];
        while(ptr1 < ptr2) {
            if (indexMaps[ptr1].value + indexMaps[ptr2].value > target) {
                ptr2 --;
            } else if (indexMaps[ptr1].value + indexMaps[ptr2].value < target) {
                ptr1 ++;
            } else {
                ans[0] = indexMaps[ptr1].index;
                ans[1] = indexMaps[ptr2].index;
                break;
            }
        }
        return ans;
    }
}

/**
 * Object to capture index to value mapping
 * Can be an array as well
 */
class IndexMap {
    public int index;
    public int value;
}
//leetcode submit region end(Prohibit modification and deletion)
