/*
 * @lc app=leetcode.cn id=14 lang=java
 *
 * [14] 最长公共前缀
 */

// @lc code=start
class Solution {
    public String longestCommonPrefix(String[] strs) {
      String shorest = strs[0];               
      for(String str:strs){
        if(str.length()<shorest.length()){        //遍历字符串数组，找到长度最短的字符串
          shorest = str;
        }
      }

      for(int i=shorest.length(); i>=0; i--){     //以最短字符串的长度为起始，每次循环减一
        int before = shorest.length();
        for(String str : strs){                   //遍历字符串数组，检验各字符串是否以‘最短字符串’为开头
          if(!str.startsWith(shorest)){           //若不是，则将最短字符串减去最后一个字符，并终止本次循环
            shorest = shorest.substring(0, i-1);
            break;
          }
        }
        int after = shorest.length();
        if(before==after){                    //若最短字符串的长度没有变小，则说明当前shortest就是最长公共前缀，终止循环
          break;
        }
      }
      return shorest;
    }
}
// @lc code=end

