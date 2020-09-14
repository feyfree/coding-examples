package com.feyfree.others.nio;

import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileChannel.MapMode;

/**
 * 读进程
 *
 * @author leilei
 */
public class NIORead {
    private static RandomAccessFile raf;

    public static void main(String[] args) throws Exception {

        raf = new RandomAccessFile("src/main/resources/data/data.txt", "rw");
        FileChannel fc = raf.getChannel();
        MappedByteBuffer mbb = fc.map(MapMode.READ_WRITE, 0, 1024);
        int lastIndex = 0;

        for (int i = 1; i < 27; i++) {
            //取读写数据的标志
            int flag = mbb.get(0);
            //读取数据的位置,2为可读
            int index = mbb.get(1);
            //假如不可读，或未写入新数据时重复循环
            if (flag != 2 || index == lastIndex) {
                i--;
                continue;
            }

            lastIndex = index;
            System.out.println(System.currentTimeMillis() + ":position:" + index + "read:" + (char) mbb.get(index));

            //置第一个字节为可读标志为 0
            mbb.put(0, (byte) 0);

            //读完数据后退出
            if (index == 27) {
                break;
            }
        }
    }
}