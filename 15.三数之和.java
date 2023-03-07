import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=15 lang=java
 *
 * [15] 三数之和
 */

// @lc code=start
class Solution {
  public List<List<Integer>> threeSum(int[] nums) {
    int n = nums.length;
    Arrays.sort(nums);            //先将数组排序
    List<List<Integer>> ans = new ArrayList<List<Integer>>();    //建立二维动态数组，用于存储最终结果
    for(int a = 0; a<n-2; a++){           //第一层循环
      if(a>0 && nums[a]==nums[a-1]){     //当前元素与前一个重复时，跳过此次循环
        continue;
      }
      int c = n-1;                        //利用双指针，二三层循环同时进行，第三层循环从后往前
      int target = -nums[a];              //当前元素的目标值
      for(int b=a+1; b<n-1;b++){          //第二层循环
        if(b>a+1 && nums[b]==nums[b-1]){  //去除重复
          continue;
        }
        while(b<c && nums[b]+nums[c]>target){     //当二层指针小于三层指针，且没找到目标值时，
          c--;                                    //三层指针前移
        }
        if(b==c){                                 //当二三层指针相同时，则往后必不可能找到目标值，结束本次循环
          break;
        }
        if(nums[b]+nums[c]==target){              //找到目标值
          List<Integer> list = new ArrayList<Integer>();
          list.add(nums[a]);
          list.add(nums[b]);
          list.add(nums[c]);
          ans.add(list);
        }
      }
    }
    return ans;
  }
}
// @lc code=end

