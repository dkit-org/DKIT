package org.dkit.cli;

import picocli.CommandLine;

import java.util.concurrent.Callable;

@CommandLine.Command(name = "greet", description = "the description of the greet command")
public class Greet implements Callable<Integer> {

    @CommandLine.Parameters(index = "0", description = "the description of the parameter name")
    private String name;

    @CommandLine.Option(names = {"-l", "--long"}, description = "the description of the long option")
    private String longOption = "long";

    @Override
    public Integer call() throws Exception {
        System.out.printf("Hello %s, how are you today ? \nOption: %s", name, longOption);
        return 0;
    }
}
