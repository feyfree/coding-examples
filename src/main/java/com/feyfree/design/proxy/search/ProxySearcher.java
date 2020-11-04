package com.feyfree.design.proxy.search;

public class ProxySearcher implements Searcher {

    private RealSearcher searcher = new RealSearcher();

    private AccessValidator validator;

    private Logger logger;

    @Override
    public String doSearch(String userId, String keyword) {
        if (validate(userId)) {
            log(userId);
            return searcher.doSearch(userId, keyword);
        }
        return null;
    }

    public boolean validate(String userId) {
        validator = new AccessValidator();
        return validator.validate(userId);
    }

    public void log(String userId) {
        logger = new Logger();
        logger.log(userId);
    }
}
