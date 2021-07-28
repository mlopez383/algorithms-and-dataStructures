package com.avantica.tutorial.algorithmsdatastructures.queue;

import java.io.InputStream;
import java.util.Scanner;


public class ConsoleReader {
    private final Scanner scanner;

    public ConsoleReader(InputStream in) {
        scanner = new Scanner(in);
    }

    public String read() {
        return scanner.next();
    }
}
