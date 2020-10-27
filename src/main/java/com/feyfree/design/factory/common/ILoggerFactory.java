package com.feyfree.design.factory.common;

/**
 * logger factory 抽象工厂
 *
 * @author leilei
 */
public interface ILoggerFactory {
    /**
     * 创建logger
     *
     * @return 增加logger 接口
     */
    ILogger createLogger();
}
