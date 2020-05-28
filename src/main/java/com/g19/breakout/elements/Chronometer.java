package com.g19.breakout.elements;

public class Chronometer {
    private long lastTime = -1;

    public long getLastTime() {
        return lastTime;
    }

    public void start() {
        lastTime = System.currentTimeMillis();
    }

    public long end() {
        return System.currentTimeMillis() - lastTime;
    }
}
