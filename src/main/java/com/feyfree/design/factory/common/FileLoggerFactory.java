package com.feyfree.design.factory.common;

public class FileLoggerFactory implements ILoggerFactory {
    /**
     * 创建logger
     *
     * @return 增加logger 接口
     */
    @Override
    public ILogger createLogger() {
        return new FileLogger();
    }
}
