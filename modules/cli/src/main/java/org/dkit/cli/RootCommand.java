package org.dkit.cli;

import picocli.CommandLine;

import java.util.concurrent.Callable;


/**
 * RootCommand
 */
@CommandLine.Command(
        name = "dkit",
        description = "the description of the dkit command",
        subcommands = {
                ImageCommand.class,
                ContainerCommand.class
        },
        version = "1.0",
        helpCommand = true
)
public class RootCommand{
}
