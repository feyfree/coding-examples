package com.feyfree.others.pipe;

import java.io.PipedInputStream;
import java.io.PipedOutputStream;

/**
 * @author feyfree
 */
public class Main {
    public static void main(String[] args) throws Exception {
        PipedInputStream pis = new PipedInputStream();
        PipedOutputStream pos = new PipedOutputStream();
        pos.connect(pis);

        Runnable producer = () -> produceData(pos);
        Runnable consumer = () -> consumeData(pis);
        new Thread(producer).start();
        new Thread(consumer).start();
    }

    public static void produceData(PipedOutputStream pos) {
        try {
            for (int i = 1; i <= 50; i++) {
                pos.write((byte) i);
                pos.flush();
                System.out.println("Writing: " + i);
                Thread.sleep(500);
            }
            pos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void consumeData(PipedInputStream pis) {
        try {
            int num;
            while ((num = pis.read()) != -1) {
                System.out.println("Reading: " + num);
            }
            pis.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

