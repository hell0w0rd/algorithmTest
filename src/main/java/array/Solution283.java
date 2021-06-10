package array;
//给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
//
// 示例: 
//
// 输入: [0,1,0,3,12]
//输出: [1,3,12,0,0] 
//
// 说明: 
//
// 
// 必须在原数组上操作，不能拷贝额外的数组。 
// 尽量减少操作次数。 
// 
// Related Topics 数组 双指针


import java.util.Arrays;

class Solution283 {
    public static void main(String[] args) {
        int[] nums = {4,1,0,3,12};
        moveZeroes1(nums);
    }
    public void moveZeroes(int[] nums) {
        int left = 0, right = 0;
        while( right < nums.length){
            if(nums[right] != 0){
                int temp = nums[right];
                nums[right] = nums[left];
                nums[left] =temp;
                left++;
            }
            right++;
        }
    }
    public static void moveZeroes1(int[] nums) {
        int left = 0;
        for(int i = 0;i < nums.length;i++){
            if(nums[i] != 0){
                nums[left++] = nums[i];
            }
        }
        for(int i = left;i < nums.length;i++){
            nums[i] = 0;
        }
        System.out.println(Arrays.toString(nums));
    }
}