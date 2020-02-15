package com.polloenpelotas.language;



public class FileLocation {
    private final String file;
    private final int x;
    private final int y;

    public FileLocation(String file, int x, int y) {
        this.file = file;
        this.x = x;
        this.y = y;
    }

    public String getFile() {
        return file;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
