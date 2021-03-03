package com.feyfree.leetcode.p0068;

import java.util.ArrayList;
import java.util.List;

public class RoundRobinSolution {

    private static final String EMPTY_SPACE = " ";

    public List<String> fullJustify(String[] words, int maxWidth) {

        List<String> result = new ArrayList<>();
        if (words == null || words.length == 0) {
            return result;
        }

        // 保留当前 一行
        List<String> current = new ArrayList<>();
        int currentLen = 0;

        int index = 0;
        while (index < words.length) {
            int currentWordLength = words[index].length();
            if (current.isEmpty() || currentLen + currentWordLength < maxWidth) {
                current.add(words[index]);
                currentLen += current.size() == 1 ? currentWordLength : currentWordLength + 1;
                index++;
            } else {
                // Append spaces to words in the current line (except the last word) in a round robin manner
                int idx = 0;
                while (currentLen < maxWidth) {

                    // Append one space to the word at the current index
                    current.set(idx, current.get(idx) + EMPTY_SPACE);
                    currentLen++;
                    idx++;

                    // Reset our round-robin index after adding a space to each word in the line
                    if (idx >= current.size() - 1) {
                        idx = 0;
                    }
                }

                // Join the current line words. String.join uses StringBuilder internally
                result.add(String.join(EMPTY_SPACE, current));

                // Reset the current line and length.
                // This is a O(N) op. Either that or 'current = new ArrayList<>()' which consumes space
                current.clear();
                currentLen = 0;
            }
        }

        // Right-padding the last line
        if (!current.isEmpty()) {
            StringBuilder lastLine = new StringBuilder(String.join(EMPTY_SPACE, current));

            // Pad the line
            while (currentLen++ < maxWidth) {
                lastLine.append(EMPTY_SPACE);
            }
            result.add(lastLine.toString());
        }

        return result;
    }
}