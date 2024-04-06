package com.gaw.dvdrentalcli.cli.runner;

import com.gaw.dvdrentalcli.cli.command.MyCommand;
import com.gaw.dvdrentalcli.service.MyCommandService;
import com.gaw.dvdrentalcli.service.MyCommandServiceDependency;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.ExitCodeGenerator;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import picocli.CommandLine;

@Configuration
@ComponentScan
@EnableAutoConfiguration
public class CLIRunner implements CommandLineRunner, ExitCodeGenerator {
    private int exitCode;

    @Autowired
    CommandLine.IFactory factory;

    @Autowired
    MyCommand myCommand;

    @Bean
    MyCommandServiceDependency dependency(){
        return new MyCommandServiceDependency();
    }

    @Bean
    MyCommandService myCommandService(MyCommandServiceDependency dependency){
        return new MyCommandService(dependency);
    }


    public CLIRunner(CommandLine.IFactory factory, MyCommand myCommand) {
        this.factory = factory;
        this.myCommand = myCommand;
    }

    @Override
    public void run(String... args) throws Exception {
        exitCode = new CommandLine(this.myCommand, this.factory).execute(args);
    }

    @Override
    public int getExitCode() {
//        return exitCode;
        return 0;
    }
}
