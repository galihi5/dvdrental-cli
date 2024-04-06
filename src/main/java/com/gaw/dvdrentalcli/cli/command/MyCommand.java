package com.gaw.dvdrentalcli.cli.command;

import com.gaw.dvdrentalcli.service.MyCommandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import picocli.CommandLine;

import java.util.List;
import java.util.concurrent.Callable;

@Component
@CommandLine.Command(name = "mycommand", version = "mycommand-1.0", description = "awesome mycommand-cli stuff",
        mixinStandardHelpOptions = true, subcommands = MyCommand.Sub.class)
public class MyCommand implements Callable<Integer> {

    @CommandLine.Option(names = "-x", description = "optional option")
    public String x;

    @CommandLine.Option(names = {"-m", "--message"}, description = "message")
    public String message;

    @CommandLine.Parameters(description = "positional params")
    public List<String> positionals;

    @Override
    public Integer call() {
        System.out.printf("mycommand was called with -x=%s, -m=%s and positionals: %s%n", x, message, positionals);
        return 23;
    }


    @Component
    @CommandLine.Command(name = "sub", mixinStandardHelpOptions = true, subcommands = MyCommand.SubSub.class,
            exitCodeOnExecutionException = 34)
    public static class Sub implements Callable<Integer> {

        @CommandLine.Option(names = "-y", description = "optional option")
        public String y;

        @CommandLine.Parameters(description = "positional params")
        public List<String> positionals;

        @Override
        public Integer call() {
            System.out.printf("mycommand sub was called with -y=%s and positionals: %s%n", y, positionals);
//            throw new RuntimeException("mycommand sub failing on purpose");
            return 33;
        }
    }

    @Component
    @CommandLine.Command(name = "subsub", mixinStandardHelpOptions = true,
            exitCodeOnExecutionException = 44)
    public static class SubSub implements Callable<Integer> {

        @CommandLine.Option(names = "-z", description = "optional option")
        public String z;

        @Autowired
        public MyCommandService service;

        @Override
        public Integer call(){
            System.out.printf("mycommand sub subsub was called with -z=%s. Service says: '%s'%n", z, service.service());
//            throw new RuntimeException("mycommand sub subsub failing on purpose");
            return 43;
        }
    }
}
