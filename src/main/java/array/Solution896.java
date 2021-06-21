package array;
//如果数组是单调递增或单调递减的，那么它是单调的。
//
// 如果对于所有 i <= j，A[i] <= A[j]，那么数组 A 是单调递增的。 如果对于所有 i <= j，A[i]> = A[j]，那么数组 A 是
//单调递减的。 
//
// 当给定的数组 A 是单调数组时返回 true，否则返回 false。 
//
// 
//
// 
// 
//
// 示例 1： 
//
// 输入：[1,2,2,3]
//输出：true
// 
//
// 示例 2： 
//
// 输入：[6,5,4,4]
//输出：true
// 
//
// 示例 3： 
//
// 输入：[1,3,2]
//输出：false
// 
//
// 示例 4： 
//
// 输入：[1,2,4,5]
//输出：true
// 
//
// 示例 5： 
//
// 输入：[1,1,1]
//输出：true
// 
//
// 
//
// 提示： 
//
// 
// 1 <= A.length <= 50000 
// -100000 <= A[i] <= 100000 
// 
// Related Topics 数组


class Solution896 {
    public static void main(String[] args) {
        int[] nums = {1,1,0};
        System.out.println(isMonotonic(nums));
    }
    public static boolean isMonotonic(int[] nums) {
        boolean dec = true, inc = true;
        for (int i = 0; i < nums.length - 1; i++) {
            if(nums[i] > nums[i+1]){
                inc = false;
            }
            if(nums[i] < nums[i+1]){
                dec = false;
            }
        }
        return dec || inc;
    }
}