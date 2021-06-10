package array;
//给你一个非空数组，返回此数组中 第三大的数 。如果不存在，则返回数组中最大的数。
//
// 示例 1： 
//
// 
//输入：[3, 2, 1]
//输出：1
//解释：第三大的数是 1 。 
//
// 示例 2： 
//
// 
//输入：[1, 2]
//输出：2
//解释：第三大的数不存在, 所以返回最大的数 2 。
// 
//
// 示例 3： 
//
// 
//输入：[2, 2, 3, 1]
//输出：1
//解释：注意，要求返回第三大的数，是指在所有不同数字中排第三大的数。
//此例中存在两个值为 2 的数，它们都排第二。在所有不同数字中排第三大的数为 1 。 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 104 
// -231 <= nums[i] <= 231 - 1
// 进阶：你能设计一个时间复杂度 O(n) 的解决方案吗？ 
// Related Topics 数组


import java.util.Arrays;
import java.util.TreeSet;

class Solution414 {
    public static void main(String[] args) {
        int[] nums = {2, 2, 2, 1};
        System.out.println(thirdMax(nums));
    }
    public static int thirdMax(int[] nums) {
        TreeSet<Integer> set = new TreeSet<>();
        for (int n : nums) {
            set.add(n);
            if(set.size() > 3){
                set.pollFirst();
            }
        }
        if(set.size() < 3){
            return set.pollLast();
        }else {
            return set.pollFirst();
        }
    }
    public int thirdMax1(int[] nums) {
        Arrays.sort(nums);
        int count = 1;
        for(int i = nums.length-1;i > 1; i--){
            if(nums[i]>nums[i-1]){
                count++;
            }
            if(count == 3){
                return nums[i-1];
            }
        }
        return nums[nums.length-1];
    }
}