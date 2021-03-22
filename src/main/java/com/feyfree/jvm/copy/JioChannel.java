package com.feyfree.jvm.copy;

import java.io.*;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/**
 * 几种拷贝示例
 *
 * @author from network
 */
public class JioChannel {
    public static void main(String[] args) {
        JioChannel channel = new JioChannel();
        try {
            if (args.length < 3) {
                System.out.println("usage: JioChannel  " +
                        " \n");
                return;
            }
            //传统方式的复制
            if ("1".equals(args[2])) {
                channel.copy(args[0], args[1]);

            } else if ("2".equals(args[2])) {
                //mmap的方式
                channel.mmap4zeroCopy(args[0], args[1]);
            } else if ("3".equals(args[2])) {
                //sendfile的方式
                channel.sendfile4zeroCopy(args[0], args[1]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 传统方式的复制
     *
     * @param from
     * @param to
     * @throws IOException
     */
    public void copy(String from, String to) throws IOException {
        byte[] data = new byte[8 * 1024];
        long bytesToCopy = new File(from).length();
        long bytesCopied = 0;
        try (FileInputStream fis = new FileInputStream(from); FileOutputStream fos = new FileOutputStream(to)) {
            while (bytesCopied < bytesToCopy) {
                fis.read(data);
                fos.write(data);
                bytesCopied += data.length;
            }
            fos.flush();
        }
    }

    /**
     * mmap的方式复制
     *
     * @param from
     * @param to
     * @throws IOException
     */
    public void mmap4zeroCopy(String from, String to) throws IOException {
        try (FileChannel source = new RandomAccessFile(from, "r").getChannel(); FileChannel destination = new RandomAccessFile(to, "rw").getChannel()) {
            MappedByteBuffer inMappedBuf =
                    source.map(FileChannel.MapMode.READ_ONLY, 0, source.size());
            destination.write(inMappedBuf);
        }
    }

    /**
     * sendfile的方式复制文件
     *
     * @param from
     * @param to
     * @throws IOException
     */
    public void sendfile4zeroCopy(String from, String to) throws IOException {
        try (FileChannel source = new FileInputStream(from).getChannel(); FileChannel destination = new FileOutputStream(to).getChannel()) {
            source.transferTo(0, source.size(), destination);
        }
    }
}