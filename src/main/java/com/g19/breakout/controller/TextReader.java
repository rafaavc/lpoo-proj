package com.g19.breakout.controller;

public class TextReader {
    private StringBuilder stringBuilder;
    private boolean readingText;

    public TextReader() {
        readingText = false;
    }

    public void startReadingText() {
        readingText = true;
        stringBuilder = new StringBuilder();
    }

    public String stopReadingText() {
        readingText = false;
        return stringBuilder == null ? "" : stringBuilder.toString();
    }

    public StringBuilder getStringBuilder() {
        if (!readingText) startReadingText();
        return stringBuilder;
    }

    public boolean isReadingText() {
        return readingText;
    }
}
