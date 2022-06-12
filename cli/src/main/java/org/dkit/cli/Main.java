package org.dkit.cli;

import picocli.CommandLine;

public class Main {
    public static void main(String[] args) {
        int exitCode = new CommandLine(new Greet()).execute(args);
        System.exit(exitCode);
    }
}
