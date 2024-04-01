package com.gaw.dvdrentalcli.cli.runner;

import com.gaw.dvdrentalcli.cli.command.MyCommand;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.ExitCodeGenerator;
import org.springframework.stereotype.Component;
import picocli.CommandLine;

@Component
public class CLIRunner implements CommandLineRunner, ExitCodeGenerator {

    private final CommandLine.IFactory factory;
    private final MyCommand myCommand;
    private int exitCode;

    public CLIRunner(CommandLine.IFactory factory, MyCommand myCommand) {
        this.factory = factory;
        this.myCommand = myCommand;
    }

    @Override
    public void run(String... args) throws Exception {

    }

    @Override
    public int getExitCode() {
        return 0;
    }
}
