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

    int subStringLenJuly2023(String string) {
        int end = 0;
        int start = 0;
        int max = Integer.MIN_VALUE;
        Set<Character> set = new HashSet<>();
        for (; end < string.length(); end++) {
            if (set.contains(string.charAt(end))) {
                set.remove(string.charAt(end));
                start++;
            }
            set.add(string.charAt(end));
            max = Math.max(max, end-start+1);
        }
        return max;
    }

    public static void main(String[] args) {
        LongestSubStrWithoutRepeatingChars minWindowSizeWithGivenSum = new LongestSubStrWithoutRepeatingChars();
        System.out.println("\n Sub str len non-repeating chars: " + minWindowSizeWithGivenSum.subStrLen("aabacda"));
        System.out.println("\n Sub str len non-repeating chars July 2023: " + minWindowSizeWithGivenSum.subStringLenJuly2023("abcacbda"));
    }
}
