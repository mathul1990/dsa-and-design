package com.learning.sde.dsa.generic.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class LongestSubStrLenWithKDistinctChars {

    /**
     * Longest substring length with k distinct characters.
     */
    int subStrLen(String s, int k) {
        int len = s.length();
        Map<Character, Integer> mp = new HashMap<>();
        int end = 0;
        int start = 0;
        int max = Integer.MIN_VALUE;
        for (; end<len; end++) {
            int c = mp.getOrDefault(s.charAt(end), 0);
            mp.put(s.charAt(end), c+1);

            while (mp.size() > k) {
                mp.remove(s.charAt(start));
                start++;
            }
            max = Math.max(max, end-start+1);
        }
        return max;
    }

    public int longestkSubstr(String s, int k) {
        int n = s.length();
        int end = 0;
        int start = 0;
        int max = Integer.MIN_VALUE;
        Map<Character, Integer> map = new HashMap<>();
        for (; end < n; end++) {
            char ch = s.charAt(end);
            int c = map.getOrDefault(ch, 0);
            map.put(ch, c + 1);
            if (map.size() == k) {
                max = Math.max(max, end - start + 1);
                //end++;
            } else if (map.size() > k) {
                while (map.size() > k && start < end) {
                    int d = map.getOrDefault(s.charAt(start), 0);
                    if (d <= 0) {
                        map.remove(s.charAt(start));
                    } else {
                        map.put(s.charAt(start), d - 1);
                    }
                    start++;
                }
            }
        }
        return max > 0 ? max : -1;
    }

    public static void main(String[] args) {
        LongestSubStrLenWithKDistinctChars minWindowSizeWithGivenSum = new LongestSubStrLenWithKDistinctChars();
        System.out.println("\n Sub str len: " + minWindowSizeWithGivenSum.subStrLen("aahhibc", 2));
    }
}
