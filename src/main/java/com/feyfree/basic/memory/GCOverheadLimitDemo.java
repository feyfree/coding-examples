package com.feyfree.basic.memory;

import java.util.ArrayList;
import java.util.List;

/**
 * gc overhead limit demo
 * <p>
 * -Xmx10m -Xms10m +PrintGCDetails
 * <p>
 * 回收不管用, 回收占据很长时间， 但是回收不到空间
 *
 * ----------result----------
 * Heap
 *  PSYoungGen      total 2560K, used 179K [0x00000000ffd00000, 0x0000000100000000, 0x0000000100000000)
 *   eden space 2048K, 8% used [0x00000000ffd00000,0x00000000ffd2cc98,0x00000000fff00000)
 *   from space 512K, 0% used [0x00000000fff80000,0x00000000fff80000,0x0000000100000000)
 *   to   space 512K, 0% used [0x00000000fff00000,0x00000000fff00000,0x00000000fff80000)
 *  ParOldGen       total 7168K, used 705K [0x00000000ff600000, 0x00000000ffd00000, 0x00000000ffd00000)
 *   object space 7168K, 9% used [0x00000000ff600000,0x00000000ff6b0570,0x00000000ffd00000)
 *  Metaspace       used 3391K, capacity 4500K, committed 4864K, reserved 1056768K
 *   class space    used 362K, capacity 388K, committed 512K, reserved 1048576K
 * Exception in thread "main" java.lang.OutOfMemoryError: GC overhead limit exceeded
 * 	at java.lang.Integer.toString(Integer.java:403)
 * 	at java.lang.String.valueOf(String.java:3099)
 * 	at com.feyfree.basic.memory.GCOverheadLimitDemo.main(GCOverheadLimitDemo.java:19)
 *
 * @author leilei
 */
public class GCOverheadLimitDemo {
    public static void main(String[] args) {
        int i = 0;
        List<String> data = new ArrayList<>();
        try {
            while (true) {
                data.add(String.valueOf(++i).intern());
            }
        } catch (Throwable e) {
            System.out.println("----------i:" + i);
            throw e;
        }
    }
}
