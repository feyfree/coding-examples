package com.feyfree.leetcode.p76;

/**
 * 最小覆盖子串
 * 尝试用 O(n) 解决此问题
 *
 * @author leilei
 */
class Solution {
    public static String minWindow(String s, String t) {
        int[] cnt = new int[128];
        //首先先把每個t的字母存起來,消耗完畢表示找到了
        for (char c : t.toCharArray()) {
            cnt[c]++;
        }
        // 起点
        int from = 0;
        //
        int total = t.length();
        int min = Integer.MAX_VALUE;//最小間格,第二個指針
        for (int i = 0, j = 0; i < s.length(); i++) {
            if (cnt[s.charAt(i)]-- > 0) {
                total--;
            }//找到就扣掉數量
            while (total == 0) { //此時表示消化完畢了,表示我找到載s中包含t所有字串時的"狀態"
                //記錄狀態,目前是第i次,j從來沒變過,記住i迴圈可能還沒跑完
                if (i - j + 1 < min) {
                    min = i - j + 1;//i-j是為了下次做準備,
                    from = j;//最小間格
                }
                if (++cnt[s.charAt(j++)] > 0) {
                    total++;
                }
                /**A D O B E C O D E B A N C    A B C
                 第一次 1     1   1                  1 1 1
                 找到答案ADOBEC
                 此時在18行這邊,要幫每一個都++,直到大於0,原因是ABC三個數字已經變成0,但是那是原本有的狀態下去扣的,所以其他人都是-1
                 為什麼要做這件事情,是因為假設我在s字串裡面有符合t字串的字,那我被扣除以後就會歸零,可是當我下一個出現的時候我++他就會超過
                 他會像這樣爬
                 ADOBEC
                 DOBECODEBA  -->為了找到下個A身體先變長,之後再去瘦身
                 OBECODEBA
                 BECODEBA
                 ECODEBA
                 CODEBA  -->瘦身完畢
                 ODEBANC -->找到下一個C,然後沒有C了,開始瘦身
                 DEBANC
                 EBANC
                 BANC
                 **/
            }
        }
        return (min == Integer.MAX_VALUE) ? "" : s.substring(from, from + min);
    }
}
