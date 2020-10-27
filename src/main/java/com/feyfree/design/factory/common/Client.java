package com.feyfree.design.factory.common;

public class Client {
    public static void main(String[] args) {
        FileLoggerFactory loggerFactory = new FileLoggerFactory();
        ILogger logger = loggerFactory.createLogger();
        logger.writeLog();
    }
}
