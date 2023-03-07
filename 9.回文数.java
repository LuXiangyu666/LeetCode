/*
 * @lc app=leetcode.cn id=9 lang=java
 *
 * [9] 回文数
 */

// @lc code=start
class Solution {
    public boolean isPalindrome(int x) {
      if(x<0 || (x>0 && x%10==0) ){         //当x为负数，或x大于0且个位为0时，x必不是回文数
        return false;
      }
      int half = 0;           //记录x从个位开始翻转生成的数字
      while(x>half){          //当half位数增长为x位数的一半以前
        half = half*10 + x%10 ; 
        x /= 10;
      }
      return (x == half) || (x == half/10);     //若x共有偶数位，则x==half;若x有奇数位，则x = half%10

    }
}
// @lc code=end

