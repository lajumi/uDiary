package com.lajumi.udiary;

public class Item {
    public static final int COLOR_DEFAULT = 0xFFFFFFFF;
    public static final int COLOR1 = 0xFFFF9999;
    public static final int COLOR2 = 0xFF99FF99;
    public static final int COLOR3 = 0xFF9999FF;
    public static final int COLOR4 = 0xFFFFFF99;
    public static final int COLOR5 = 0xFF99FFFF;
    public static final int COLOR6 = 0xFFFF99FF;

    private final String _text;
    private final int _color;

    public Item(String text, int color) {
        _text = text;
        _color = color;
    }

    public String getText() {
        return _text;
    }

    public int getColor() {
        return _color;
    }
}
