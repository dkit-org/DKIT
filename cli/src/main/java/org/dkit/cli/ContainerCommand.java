package org.dkit.cli;

import picocli.CommandLine;

import java.util.concurrent.Callable;

@CommandLine.Command(
        name = "container",
        description = "the description of the container command"
)
public class ContainerCommand implements Callable<Integer> {


    @Override
    public Integer call() throws Exception {
        System.out.println("this comes from the container command");
        return 0;
    }
}
