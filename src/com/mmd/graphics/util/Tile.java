package com.mmd.graphics.util;

import asciiPanel.AsciiPanel;

import java.awt.Color;

public enum Tile {
    WALL('♈', Color.green),
    GROUND((char)250, AsciiPanel.brightBlack);

    private Color color;
    char glyph;

    Tile(char glyph, Color color) {
        this.glyph = glyph;
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public char getCharacter() {
        return glyph;
    }
}