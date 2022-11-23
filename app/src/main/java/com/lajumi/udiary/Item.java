package com.lajumi.udiary;

public class Item {
    public static final int COLOR_DEFAULT = 0xFF000000;
    public static final int COLOR1 = 0xFF9F0000;
    public static final int COLOR2 = 0xFF009F00;
    public static final int COLOR3 = 0xFF00009F;
    public static final int COLOR4 = 0xFF9F9F00;
    public static final int COLOR5 = 0xFF009F9F;
    public static final int COLOR6 = 0xFF9F009F;

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
