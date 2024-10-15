package com.leetcode.practise;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

// https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
public class LongestSubstringWithoutRepeatingCharacters {


    /*
     * Brute Force : Check all substring and find the largest substring without repeating character
     * */

    public int lengthOfLongestSubstringN3(String s) {
        if (s == null || s.isEmpty()) return 0;
        int maxLength = 1;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j < s.length(); j++) {
                HashSet<Character> characterHashSet = new HashSet<Character>();
                for (int k = i; k <= j; k++) {
                    if (characterHashSet.contains(s.charAt(k))) {
                        break;
                    }
                    characterHashSet.add(s.charAt(k));
                }
                maxLength = Math.max(maxLength, characterHashSet.size());
            }
        }
        return maxLength;
    }

    /*
     * Use map to store last character index and once it found again then increase the start index by last found index + 1
     * */
    public int lengthOfLongestSubstring(String s) {
        int maxLength = 1, start = 0, end = 0;
        Map<Character, Integer> valIndexMap = new HashMap<>();
        while (end < s.length()) {
            char c = s.charAt(end);
            if (valIndexMap.containsKey(c)) {
                start = Math.max(start, valIndexMap.get(c) + 1);
            }
            valIndexMap.put(c, end);
            maxLength = Math.max(maxLength, end - start + 1);
            end++;
        }
        return maxLength;
    }

    public int lengthOfLongestSubstringArray(String s) {
        int maxLength = 1, start = 0;
        int[] charIndex = new int[256];
        // Iterate through the string
        for (int end = 0; end < s.length(); end++) {
            char c = s.charAt(end);

            // Update start position if the character was seen before
            start = Math.max(start, charIndex[c]);

            // Update the character's last seen index (+1 to avoid overlap)
            charIndex[c] = end + 1;

            // Calculate the maximum length so far
            maxLength = Math.max(maxLength, end - start + 1);
        }
        return maxLength;
    }


}
