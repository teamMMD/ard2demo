package com.mmd.graphics.util;

import asciiPanel.AsciiPanel;

import java.awt.Color;

public enum Tile {
    WALL((char)250, AsciiPanel.green),          // "."
    GROUND((char)255, AsciiPanel.brightBlack);  // " "

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