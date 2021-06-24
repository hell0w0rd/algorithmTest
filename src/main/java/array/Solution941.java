package array;
//给定一个整数数组 arr，如果它是有效的山脉数组就返回 true，否则返回 false。
//
// 让我们回顾一下，如果 A 满足下述条件，那么它是一个山脉数组： 
//
// 
// arr.length >= 3 
// 在 0 < i < arr.length - 1 条件下，存在 i 使得：
// 
// arr[0] < arr[1] < ... arr[i-1] < arr[i] 
// arr[i] > arr[i+1] > ... > arr[arr.length - 1] 
// 
// 
// 
//
// 
//
// 
//
// 
//
// 示例 1： 
//
// 
//输入：arr = [2,1]
//输出：false
// 
//
// 示例 2： 
//
// 
//输入：arr = [3,5,5]
//输出：false
// 
//
// 示例 3： 
//
// 
//输入：arr = [0,3,2,1]
//输出：true 
//
// 
//
// 提示： 
//
// 
// 1 <= arr.length <= 104 
// 0 <= arr[i] <= 104 
// 
// Related Topics 数组


class Solution941 {
    public static void main(String[] args) {
        int[] arr = {2};
        System.out.println(validMountainArray(arr));
    }
    public static boolean validMountainArray(int[] arr) {
        int n = arr.length-1;
        boolean flag = true;
        if(n < 2 || arr[0] > arr[1]){
            return false;
        }
        for (int i = 0; i < n; i++) {
            if( flag && arr[i] < arr[i+1]){
                continue;
            }
            if(arr[i] > arr[i+1]){
                flag = false;
            }else {
                return false;
            }
        }
        return true;
    }
    public static boolean validMountainArray2(int[] arr) {
        int n = arr.length;
        int i = 0;
        while (i+1 < n && arr[i] < arr[i+1]){
            i++;
        }
        if(i == 0 && i == n-1){
            return false;
        }
        while (i+1 < n && arr[i] > arr[i+1]){
            i++;
        }
        return i == n-1;
    }
}