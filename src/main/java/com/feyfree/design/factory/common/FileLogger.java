package com.feyfree.design.factory.common;

/**
 * 文件日志
 *
 * @author leilei
 */
public class FileLogger implements ILogger {
    /**
     * 写日志接口
     */
    @Override
    public void writeLog() {
        System.out.println("Write a file log!");
    }
}
