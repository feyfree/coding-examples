package com.feyfree.basic.exception;

import java.io.IOException;

public class RuntimeExceptionDemo {
    private void process() throws RuntimeException {
        throw new RuntimeException();
    }

    private void save() throws IOException {
        throw new IOException();
    }

    public static void main(String[] args) {
        RuntimeExceptionDemo demo = new RuntimeExceptionDemo();
        demo.process();

        try {
            demo.save();
        } catch (IOException e) {
            System.out.println("普通的");
        }
    }
}
