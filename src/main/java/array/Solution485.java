package array;
//给定一个二进制数组， 计算其中最大连续 1 的个数。
//
// 
//
// 示例： 
//
// 
//输入：[1,1,0,1,1,1]
//输出：3
//解释：开头的两位和最后的三位都是连续 1 ，所以最大连续 1 的个数是 3.
// 
//
// 
//
// 提示： 
//
// 
// 输入的数组只包含 0 和 1 。 
// 输入数组的长度是正整数，且不超过 10,000。 
// 
// Related Topics 数组


import java.util.TreeSet;

class Solution485 {
    public int findMaxConsecutiveOnes(int[] nums) {
        TreeSet<Integer> set = new TreeSet<>();
        int temp=0;
        for (int i=0;i<nums.length; i++) {
            if(nums[i]==1){
                temp++;
                if(i == nums.length-1){
                    set.add(temp);
                }
            }else {
                set.add(temp);
                temp = 0;
            }
        }
        return set.pollLast();
    }

    /**
     * 耗时 耗空间最少
     */
    public int findMaxConsecutiveOnes2(int[] nums) {
        int max = 0;
        int temp=0;
        for (int i=0;i<nums.length;i++) {
            if(nums[i] == 1){
                temp++;
                if(i == nums.length-1){
                    max=getMax(max,temp);
                }
            }else {
                max=getMax(max,temp);
                temp=0;
            }
        }
        return max;
    }
    public int getMax(int a,int b){
        if(a < b){
            a=b;
        }
        return a;
    }
}