package com.g19.breakout.elements;

public class Chronometer {
    long lastTime;

    public Chronometer() {
        lastTime = System.currentTimeMillis();
    }

    public long getElapsedTime() {
        long currentTime = System.currentTimeMillis();
        long elapsedTime = currentTime - lastTime;
        lastTime = currentTime;
        return elapsedTime;
    }
}
