package com.feyfree.design.proxy.web;

public class Client {
    public static void main(String[] args) {
        Surfing surfing = new ProxySurfing();
        surfing.surfTheInternet("www.google.com");
    }
}
