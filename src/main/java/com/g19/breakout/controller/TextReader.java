package com.g19.breakout.controller;

public class TextReader {
    private StringBuilder stringBuilder;
    private boolean readingText;
    private int charLimit;

    public TextReader() {
        readingText = false;
    }

    public void startReadingText(int charLimit) {
        readingText = true;
        stringBuilder = new StringBuilder();
        this.charLimit = charLimit;
    }

    private void applyLimit() {
        if (stringBuilder.length() > charLimit) {
            stringBuilder.delete(charLimit, stringBuilder.length());
        }
    }

    public String stopReadingText() {
        applyLimit();
        readingText = false;
        return stringBuilder == null ? "" : stringBuilder.toString();
    }

    public StringBuilder getStringBuilder() {
        if (!readingText) startReadingText(30);
        applyLimit();
        return stringBuilder;
    }

    public boolean isReadingText() {
        return readingText;
    }
}
