package com.gaw.dvdrentalcli.service;

public class MyCommandService {
    private final MyCommandServiceDependency dependency;

    public MyCommandService(MyCommandServiceDependency dependency) {
        this.dependency = dependency;
    }

    public String service(){
        return dependency.provideSomething();
    }
}
