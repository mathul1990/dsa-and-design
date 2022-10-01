package com.learning.sde.dsa.generic.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class LongestSubStrLenWithKDistinctChars {

    /**
     * Longest substring length with k distinct characters.
     */
    int subStrLen(String str, int k) {
        int len = str.length();
        Map<Character, Integer> mp = new HashMap<>();
        int end = 0;
        int start = 0;
        int max = Integer.MIN_VALUE;
        for (; end<len; end++) {
            int c = mp.getOrDefault(str.charAt(end), 0);
            mp.put(str.charAt(end), c+1);

            while (mp.size() > k) {
                mp.remove(str.charAt(start));
                start++;
            }
            max = Math.max(max, end-start+1);
        }
        return max;
    }

    public static void main(String[] args) {
        LongestSubStrLenWithKDistinctChars minWindowSizeWithGivenSum = new LongestSubStrLenWithKDistinctChars();
        System.out.println("\n Sub str len: " + minWindowSizeWithGivenSum.subStrLen("aahhibc", 2));
    }
}
