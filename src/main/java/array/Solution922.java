package array;
//给定一个非负整数数组 A， A 中一半整数是奇数，一半整数是偶数。
//
// 对数组进行排序，以便当 A[i] 为奇数时，i 也是奇数；当 A[i] 为偶数时， i 也是偶数。 
//
// 你可以返回任何满足上述条件的数组作为答案。 
//
// 
//
// 示例： 
//
// 输入：[4,2,5,7]
//输出：[4,5,2,7]
//解释：[4,7,2,5]，[2,5,4,7]，[2,7,4,5] 也会被接受。
// 
//
// 
//
// 提示： 
//
// 
// 2 <= A.length <= 20000 
// A.length % 2 == 0 
// 0 <= A[i] <= 1000 
// 
//
// 
// Related Topics 排序 数组


import java.util.Arrays;

class Solution922 {
    public static void main(String[] args) {
        int[] nums = {2,3,1,1,4,0,0,4,3,3};
        System.out.println(Arrays.toString(sortArrayByParityII2(nums)));
    }
    public static int[] sortArrayByParityII(int[] nums) {
        int[] sort = new int[nums.length];
        int i = 0;
        for (int num : nums) {
            if(num % 2 == 0){
                sort[i] = num;
                i += 2;
            }
        }
        int j = 1;
        for (int num : nums) {
            if(num % 2 != 0){
                sort[j] = num;
                j += 2;
            }
        }
        return sort;
    }
    public static int[] sortArrayByParityII2(int[] nums) {
        int j = 1;
        for (int i = 0; i < nums.length;i += 2){
            if(nums[i]%2 == 1){
                while (nums[j]%2 == 1){
                    j += 2;
                }
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }
        return nums;
    }
}