package com.feyfree.basic.exception;

/**
 * @author feyfree
 */
public class ExceptionSample {

    public void makeException() throws Exception {
        throw new Exception();
    }


    public static void main(String[] args) throws Exception {
        ExceptionSample sample = new ExceptionSample();
        sample.makeException();
    }
}
