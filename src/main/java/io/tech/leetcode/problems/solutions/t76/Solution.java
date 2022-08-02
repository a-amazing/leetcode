package io.tech.leetcode.problems.solutions.t76;

import java.util.HashMap;
import java.util.Map;

/**
 * @author:wangyi
 * @Date:2022/7/14
 */
public class Solution {
    public String minWindow(String s, String t) {
        int len1 = s.length();
        int len2 = t.length();
        if (len1 < len2) {
            return "";
        }

        char[] tchars = t.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();
        for (char c : tchars) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int left = 0;
        int right = 0;
        int valid = 0;
        int min = 0;
        char[] cchars = s.toCharArray();
        while (right < len1) {
            Character c = cchars[right];
            right++;
            if (map.containsKey(c)) {
                if (map.get(c) > map2.getOrDefault(c, 0)) {
                    valid++;
                }
                map2.put(c, map.getOrDefault(c, 0) + 1);
                while (valid == len2) {
                    char cchar = cchars[left];
                    min = Math.min(right - left, min);
                    if (map.containsKey(cchar) && map2.getOrDefault(cchar, 0) - 1 < map.get(cchar)) {
                        valid--;
                        break;
                    }
                    left++;
                }
            }


        }

        return null;
    }
}
