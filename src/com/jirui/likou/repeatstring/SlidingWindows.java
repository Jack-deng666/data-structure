package com.jirui.likou.repeatstring;


import java.util.HashMap;

/**
 * @author jack Deng
 * @version 1.0
 * @date 2022/3/22 10:22
 */
public class SlidingWindows {
    public static void main(String[] args) {
        int[] freq = {0, 1};
        String a = "AAAAABBBBBBAABBBBBBBBB";
        System.out.println(winnerOfGame(a)[0]);
        System.out.println(winnerOfGame(a)[1]);
    }
        public int lengthOfLongestSubstring(String s) {
            if (s.length()==0) return 0;
            HashMap<Character, Integer> map = new HashMap<>();
            int max = 0;
            int left = 0;
            for(int   i = 0; i < s.length(); i ++){
                if(map.containsKey(s.charAt(i))){
                    left = Math.max(left,map.get(s.charAt(i)) + 1);
                }
                map.put(s.charAt(i),i);
                max = Math.max(max,i-left+1);
            }
            return max;
        }


    public static int[] winnerOfGame(String colors) {
        int[] freq = {0, 0};
        char cur = 'C';
        int cnt = 0;
        for (int i = 0; i < colors.length(); i++) {
            char c = colors.charAt(i);
            if (c != cur) {
                cur = c;
                cnt = 1;
            } else {
                cnt += 1;
                if (cnt >= 3) {
                    freq[cur - 'A'] += 1;
                }
            }
        }
        return freq;
    }
}