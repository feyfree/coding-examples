package com.feyfree.jvm.proxy.jdk;

public class UserServiceImpl implements UserService {

    @Override
    public int insert() {
        System.out.println("insert");
        query();
        return 0;
    }

    @Override
    public String query() {
        System.out.println("query");
        return null;
    }
}