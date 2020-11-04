package com.feyfree.design.proxy.web;

public class RemoteMachine implements Surfing {
    @Override
    public void surfTheInternet(String url) {
        System.out.println("Enjoy surfing:" + url);
    }
}
