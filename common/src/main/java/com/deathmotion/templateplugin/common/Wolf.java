package com.deathmotion.templateplugin.common;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Wolf {
    private final String name;
    private final String environment;

    public void howl() {
        System.out.println("The wolf " + name + " is howling in " + environment);
    }
}