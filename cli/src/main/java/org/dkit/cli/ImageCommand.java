package org.dkit.cli;

import picocli.CommandLine;

import java.util.concurrent.Callable;

@CommandLine.Command(name = "image", description = "the description of the image command")
public class ImageCommand implements Callable<Integer> {

    @CommandLine.Option(names = {"-l", "--long"}, description = "the description of the long option")
    private String longOption = "long";

    @Override
    public Integer call() throws Exception {
        System.out.println("comes from the image command");
        return 0;
    }
}
