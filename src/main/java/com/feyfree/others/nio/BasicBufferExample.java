package com.feyfree.others.nio;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Buffer example
 *
 * @author leilei
 */
public class BasicBufferExample {
    public static void main(String[] args) throws IOException {
        RandomAccessFile aFile = new RandomAccessFile("src/main/resources/data/nio-data.txt", "rw");
        FileChannel inChannel = aFile.getChannel();
        //create buffer with capacity of 48 bytes
        ByteBuffer buf = ByteBuffer.allocate(48);
        //read into buffer.
        int bytesRead = inChannel.read(buf);
        while (bytesRead != -1) {
            //make buffer ready for read
            buf.flip();
            while (buf.hasRemaining()) {
                // read 1 byte at a time
                System.out.print((char) buf.get());
            }
            //make buffer ready for writing
            buf.clear();
            bytesRead = inChannel.read(buf);
        }
        aFile.close();
    }
}
