import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=13 lang=java
 *
 * [13] 罗马数字转整数
 */
// @lc code=start
class Solution {
    public int romanToInt(String s) {
      Map<Character,Integer> hashtable = new HashMap<Character,Integer>(){{
        put('I', 1);
        put('V', 5);
        put('X', 10);
        put('L', 50);
        put('C', 100);
        put('D', 500);
        put('M', 1000);
      }};                             //建立哈希表，表示罗马数字与阿拉伯数字的对应关系

      int n = s.length();           //罗马数字符串的长度
      int sum = 0;                  //总数值
      int value = 0;                //当前位的数值
      for(int i = n-1; i>=0; i--){            //从右往左遍历
        value = hashtable.get(s.charAt(i));   //获取当前位对应的阿拉伯数字
        if((i<n-1) && (value < hashtable.get(s.charAt(i+1))) ){
          sum -= value;                       //当当前位的值小于右边一位的值时，表示应减去该位的数值
        }
        else{                                 //否则应加上该位的数值
          sum += value;
        }
      }
      return sum;
    }
}
// @lc code=end

