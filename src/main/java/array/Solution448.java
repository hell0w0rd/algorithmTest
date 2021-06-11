package array;
//给你一个含 n 个整数的数组 nums ，其中 nums[i] 在区间 [1, n] 内。
// 请你找出所有在 [1, n] 范围内但没有出现在 nums 中的数字，并以数组的形式返回结果。
//
// 示例 1： 
//
//输入：nums = [4,3,2,7,8,2,3,1]
//输出：[5,6]
// 
//
// 示例 2： 
//
//输入：nums = [1,1]
//输出：[2]
//
// 提示： 
//
// 
// n == nums.length 
// 1 <= n <= 105 
// 1 <= nums[i] <= n 
// 
//
// 进阶：你能在不使用额外空间且时间复杂度为 O(n) 的情况下解决这个问题吗? 你可以假定返回的数组不算在额外空间内。 
// Related Topics 数组


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

class Solution448 {

    public List<Integer> findDisappearedNumbers(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        List<Integer> res = new ArrayList<>();
        for (int num : nums) {
            set.add(num);
        }
        for(int i = 1;i <= nums.length;i++){
            if ( !set.contains(i)){
                res.add(i);
            }
        }
        return res;
    }


    public List<Integer> findDisappearedNumbers1(int[] nums) {
        List<Integer> res = new ArrayList<>();
        boolean[] array = new boolean[nums.length+1];
        for (int n : nums) {
            array[n] = false;
        }
        for (int i = 1;i <= nums.length;i++){
            if(array[i]){
                res.add(i);
            }
        }
        return res;
    }

    public List<Integer> findDisappearedNumbers2(int[] nums) {
        List<Integer> res = new ArrayList<>();
        int n = nums.length;
        for (int num : nums) {
            int temp = (n-1)%n;
            nums[temp] += n;
        }
        for(int i = 0;i < n;i++){
            if(nums[i]<=n){
                res.add(i+1);
            }
        }
        return res;
    }
}
