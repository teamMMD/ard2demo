package com.mmd.graphics.screens;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.Assert.*;

public class ScoreScreenTest {

    @Test
    public void readFileRelativePath() {
        File file = new File("resources/scores/final_scores.txt");
        assertTrue(file.exists());
    }

}