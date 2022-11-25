package com.lajumi.udiary;

import java.util.Calendar;
import java.util.Date;

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
    private final Date _creationTime;

    public Item(String text, int color) {
        _text = text;
        _color = color;
        _creationTime = Calendar.getInstance().getTime();
    }

    public String getText() {
        return _text;
    }

    public int getColor() {
        return _color;
    }

    public String getTime() {
        return String.format("%02d:%02d", _creationTime.getHours(), _creationTime.getMinutes());
    }

    public String getDate() {
        return String.format("%02d.%02d.%04d", _creationTime.getDay(), _creationTime.getMonth(), _creationTime.getYear() + 1900);
    }
}
