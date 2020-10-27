package com.feyfree.design.factory.common;

/**
 * 数据库日志
 *
 * @author leilei
 */
public class DatabaseLogger implements ILogger {
    /**
     * 写日志接口
     */
    @Override
    public void writeLog() {
        System.out.println("Write a database log!");
    }
}
