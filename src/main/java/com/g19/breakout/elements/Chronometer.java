package com.g19.breakout.elements;

public class Chronometer {
    long lastTime;

    public void start() {
        lastTime = System.currentTimeMillis();
    }

    public long end() {
        return System.currentTimeMillis() - lastTime;
    }
}
