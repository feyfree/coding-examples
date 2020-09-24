package com.feyfree.others.nio;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.Pipe;

public class PipeExample {
    public static void main(String[] args) throws IOException {
        Pipe pipe = Pipe.open();
        Pipe.SinkChannel sinkChannel = pipe.sink();
        String newData = "New String to write to file..." + System.currentTimeMillis();
        ByteBuffer buf = ByteBuffer.allocate(48);
        buf.clear();
        buf.put(newData.getBytes());
        buf.flip();
        while (buf.hasRemaining()) {
            sinkChannel.write(buf);
        }
        buf.flip();
        Pipe.SourceChannel sourceChannel = pipe.source();
        int bytesRead = sourceChannel.read(buf);
        System.out.println(bytesRead);
    }
}
