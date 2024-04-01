package com.gaw.dvdrentalcli.cli.command;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import picocli.CommandLine;

import java.util.concurrent.Callable;

@Component
@CommandLine.Command(name = "pico-cli", version = "pico-cli-1.0", description = "awesome cli stuff")
public class MyCommand implements Callable<Integer> {
    @CommandLine.Option(names = {"-a", "--address"})
    private String endpoint;

    private WebClient webClient = WebClient.create();

    private int getDogPhoto() {
        webClient.get().uri(endpoint).retrieve().bodyToFlux(String.class).subscribe(System.out::println);
        return 0;
    }


    @Override
    public Integer call() throws Exception {
        return getDogPhoto();
    }
}
