package com.mmd.graphics.util;

import java.awt.*;

public class Door extends Feature {

    public Door(int dx, int dy) {
        super(dx, dy);
        setGlyph((char)43);
        setColor(Color.CYAN);
    }

}
