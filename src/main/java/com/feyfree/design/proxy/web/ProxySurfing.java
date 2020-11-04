package com.feyfree.design.proxy.web;

public class ProxySurfing implements Surfing {

    private RemoteMachine machine;

    public ProxySurfing() {
        this.machine = new RemoteMachine();
    }

    @Override
    public void surfTheInternet(String url) {
        machine.surfTheInternet(url);
    }
}
