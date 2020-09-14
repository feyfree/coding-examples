package com.feyfree.others.nio;


import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileChannel.MapMode;

/**
 * 写进程
 *
 * @author leilei
 */
public class NIOWrite {

    public static void main(String[] args) throws Exception {
        //建立文件和内存的映射，即时双向同步
        RandomAccessFile raf = new RandomAccessFile("src/main/resources/data/data.txt", "rw");
        FileChannel fc = raf.getChannel();
        MappedByteBuffer mbb = fc.map(MapMode.READ_WRITE, 0, 1024);

        //清除文件内容 ，对 MappedByteBuffer 的操作就是对文件的操作
        for (int i = 0; i < 1024; i++) {
            mbb.put(i, (byte) 0);
        }

        //从文件的第二个字节开始，依次写入 A-Z 字母，第一个字节指明当前操作的位置
        for (int i = 65; i < 91; i++) {
            int index = i - 63;
            //可读标置第一个字节为 0
            int flag = mbb.get(0);
            //不是可写标示 0，则重复循环，等待
            if (flag != 0) {
                i--;
                continue;
            }
            //正在写数据，标志第一个字节为 1
            mbb.put(0, (byte) 1);
            //文件第二个字节说明，写数据的位置
            mbb.put(1, (byte) (index));

            System.out.println(System.currentTimeMillis() + ":position:" + index + "write:" + (char) i);
            //index 位置写入数据
            mbb.put(index, (byte) i);
            //置可读数据标志第一个字节为 2
            mbb.put(0, (byte) 2);

            Thread.sleep(3000);
        }
    }
}