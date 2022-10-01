package com.learning.sde.dsa.generic.slidingwindow;

import java.util.HashSet;
import java.util.Set;

public class LongestSubStrWithoutRepeatingChars {

    /**
     * Longest substring without repeating characters.
     */
    int subStrLen(String str) {
        int len = str.length();
        Set<Character> set = new HashSet<>();
        int end = 0;
        int start = 0;
        int max = Integer.MIN_VALUE;
        for (; end<len; end++) {

            while(set.contains(str.charAt(end))) {
                set.remove(str.charAt(start));
                start++;
            }

            set.add(str.charAt(end));
            max = Math.max(max, end-start+1);
        }
        return max;
    }

    public static void main(String[] args) {
        LongestSubStrWithoutRepeatingChars minWindowSizeWithGivenSum = new LongestSubStrWithoutRepeatingChars();
        System.out.println("\n Sub str len non-repeating chars: " + minWindowSizeWithGivenSum.subStrLen("aabacda"));
    }
}
