package array;
//给你一个整型数组 nums ，在数组中找出由三个数组成的最大乘积，并输出这个乘积。
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：6
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3,4]
//输出：24
// 
//
// 示例 3： 
//
// 
//输入：nums = [-1,-2,-3]
//输出：-6
// 
//
// 
//
// 提示： 
//
// 
// 3 <= nums.length <= 104 
// -1000 <= nums[i] <= 1000 
// 
// Related Topics 数组 数学 
// 👍 309 👎 0


import java.util.Arrays;
import java.util.TreeSet;

class Solution628 {
    public static void main(String[] args) {
        int[] nums = {-1,-2,-3};
        System.out.println(maximumProduct2(nums));
    }
    //不包含重复得数字
    public int maximumProduct(int[] nums) {
        TreeSet<Integer> set = new TreeSet<>();
        int res = 1;
        for (int n : nums) {
            set.add(n);
            if(set.size() > 3){
                set.pollFirst();
            }
        }
        while( !set.isEmpty()){
            res *=set.pollFirst();
        }
        return res;
    }

    public static int maximumProduct2(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        return Math.max(nums[0] * nums[1] * nums[n - 1], nums[n - 3] * nums[n - 2] * nums[n - 1]);
    }
    public static int maximumProduct3(int[] nums) {
        int min1 = Integer.MAX_VALUE,min2 = Integer.MAX_VALUE;
        int max1 = Integer.MIN_VALUE,max2 = Integer.MIN_VALUE,max3 = Integer.MIN_VALUE;
        for (int num : nums) {
            if(num < min1){
                min2 = min1;
                min1 = num;
            }else if(num < min2){
                min2 = num;
            }
            if(max1 < num){
                max3 = max2;
                max2 = max1;
                max1 = num;
            }else if(max2 < num){
                max3 = max2;
                max2 = num;
            }else if(max3 < num){
                max3 = num;
            }
        }
        return Math.max(min1*min2*max1,max1*max2*max3);
    }
}