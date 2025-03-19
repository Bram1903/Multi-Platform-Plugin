package com.deathmotion.templateplugin.common;

public class Wolf {
    private final String name;

    public Wolf(String name) {
        this.name = name;
    }

    public void bark() {
        CommonLogger.LOGGER.info(String.format("Wolf %s barking", name));
    }
}