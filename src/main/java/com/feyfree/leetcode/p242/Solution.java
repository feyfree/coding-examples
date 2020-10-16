package com.feyfree.leetcode.p242;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 * <p>
 * 示例 1:
 * <p>
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: s = "rat", t = "car"
 * 输出: false
 * 说明:
 * 你可以假设字符串只包含小写字母。
 * <p>
 * 进阶:
 * 如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-anagram
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author leilei
 */
public class Solution {

    private final int CHAR_NUMS = 256;

    public boolean isAnagram(String s, String t) {
        if (s.length() == t.length()) {
            if (s.length() == 0) {
                return true;
            }
            Map<Character, Integer> charMap = new HashMap<>(CHAR_NUMS);
            for (char m : s.toCharArray()) {
                Integer num = charMap.get(m);
                if (num != null) {
                    charMap.put(m, ++num);
                } else {
                    charMap.put(m, 1);
                }
            }
            for (char n : t.toCharArray()) {
                Integer num = charMap.get(n);
                if (num == null) {
                    return false;
                }
                --num;
                if (num == 0) {
                    charMap.remove(n);
                } else {
                    charMap.put(n, num);
                }
            }
            return charMap.entrySet().size() <= 0;
        }
        return false;

    }
}