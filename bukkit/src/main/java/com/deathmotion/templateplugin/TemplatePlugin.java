package com.deathmotion.templateplugin;

import com.deathmotion.templateplugin.common.Wolf;
import lombok.Getter;
import org.bukkit.plugin.java.JavaPlugin;

@Getter
public class TemplatePlugin extends JavaPlugin {
    private static TemplatePlugin instance;

    public TemplatePlugin() {
        instance = this;
    }

    @Override
    public void onEnable() {
        new Wolf("Bram", "Bukkit").howl();
    }

    @Override
    public void onDisable() {

    }
}