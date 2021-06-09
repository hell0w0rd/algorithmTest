package array;
//给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
//
// 
//
// 在杨辉三角中，每个数是它左上方和右上方的数的和。 
//
// 示例: 
//
// 输入: 5
//输出:
//[
//     [1],
//    [1,1],
//   [1,2,1],
//  [1,3,3,1],
// [1,4,6,4,1]
//] 
// Related Topics 数组


import java.util.ArrayList;
import java.util.List;

class Solution118 {
    public static void main(String[] args) {
        System.out.println(generate(3));
    }
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> cur;
        if(numRows > 0){
            for(int i = 0;i < numRows;i++){
                cur = new ArrayList<>();
                for(int j = 0;j <= i;j++){
                    if(j == 0 || j ==i){
                        cur.add(1);
                    }else {
                        cur.add(res.get(i-1).get(j-1)+res.get(i-1).get(j));
                    }
                }
                res.add(cur);
            }
        }
        return res;
    }
}
