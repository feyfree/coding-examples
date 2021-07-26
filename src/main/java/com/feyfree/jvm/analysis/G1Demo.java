package com.feyfree.jvm.analysis;

/**
 * g1 回收
 * <p>
 * -Xms4m -Xmx4m -XX:+PrintCommandLineFlags -XX:+PrintGCDetails -XX:+UseG1GC
 *
 * @author leilei
 */
public class G1Demo {
    public static void main(String[] args) {
        while (true) {
            byte[] data = new byte[5 * 1024 * 1024];
        }
    }
}
