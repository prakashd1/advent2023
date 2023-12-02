package com.pd.advent;

import java.io.BufferedReader;
import java.nio.file.Files;
import java.nio.file.Paths;

public class InputUtil {

    public static BufferedReader readInput(String path) throws Exception{
        return Files.newBufferedReader(Paths.get(path));
    }
}
