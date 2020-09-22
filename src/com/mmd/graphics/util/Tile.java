package com.mmd.graphics.util;

import asciiPanel.AsciiPanel;

import java.awt.Color;

public enum Tile {
    WALL((char)250, AsciiPanel.green),          // "."
    GROUND((char)255, AsciiPanel.brightBlack),  // " "
    LDOOR((char)192, Color.CYAN),               // "└"
    MDOOR((char)196, Color.CYAN),               // "─"
    RDOOR((char)217, Color.CYAN),               // "┘"
    // doors are three part: left+mid+right -->   "└─┘"
    MONSTER((char)123, Color.RED);

    private Color color;
    char glyph;

    Tile(char glyph, Color color) {
        this.glyph = glyph;
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public char getGlyph() {
        return glyph;
    }

    public char glyph() {
        return glyph;
    }

    public Color color() {
        return color;
    }
}